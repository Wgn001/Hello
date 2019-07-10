package cn.demon.hello.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import cn.demon.hello.R;
import cn.demon.hello.Util.ChineseToPinyinUtil;
import cn.demon.hello.Util.ContactComparator;
import cn.demon.hello.bean.Person;
import cn.demon.hello.fragment.MyFragment;

public class LinkAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;
    private List<Person> mPersonlist;       //联系人列表
    private List<Person> mPinyinList;      //联系人列表（拼音）
    private List<String> characterList;      //字母列表
    private List<Person> resultList;           //最终联系人列表

    public static final int ITEM_TYPE_HEADER = 0;   //头部分组
    public static final int ITEM_TYPE_CONTACT = 1;  //联系人条目
    public static final int ITEM_TYPE_CHARACTER = 2;    //字母条目


    public LinkAdapter(Context mContext, List<Person> mPersonlist) {
        this.mContext = mContext;
        this.mPersonlist = mPersonlist;
        initContact();
    }

    private void initContact() {

        mPinyinList = new ArrayList<>();
        characterList = new ArrayList<>();
        resultList = new ArrayList<>();

        //将中文名字转换成拼音
        for(int i=0;i<mPersonlist.size();i++){
            mPinyinList.add(ChineseToPinyinUtil.getPingyin(mPersonlist.get(i)));
        }

        if(mPinyinList!=null){
            for (int i=0;i<mPinyinList.size();i++){
                Collections.sort(mPinyinList,new ContactComparator());
            }
        }

        for(int i=0;i<mPinyinList.size();i++){
                String Pingyin=mPinyinList.get(i).getPinYin();
                String character=(Pingyin.charAt(0)+"").toUpperCase();
            if(!characterList.contains(character)){
                if(character.hashCode()>="A".hashCode() && character.hashCode()<="Z".hashCode()){
                    Person person=new Person();
                    person.setPinYin(character);
                    person.setTYPE(ITEM_TYPE_CHARACTER);
                    resultList.add(person);
                    characterList.add(character);
                }else{
                    if(!characterList.contains("#")){
                        Person person=new Person();
                        person.setPinYin("#");
                        person.setTYPE(ITEM_TYPE_CHARACTER);
                        characterList.add("#");
                        resultList.add(person);
                    }
                }
            }
            Person person =mPinyinList.get(i).setTYPE(ITEM_TYPE_CONTACT);
            resultList.add(person);
        }

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new PhotoAdapter.ViewHolder(viewGroup);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {


    }

    @Override
    public int getItemCount() {
        return resultList == null ? 0 : resultList.size();
    }



}
