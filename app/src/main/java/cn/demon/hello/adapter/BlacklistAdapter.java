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

public class BlacklistAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final String TAG = "BlacklistAdpter";

    private Context mContext;
    private List<Person> personList; //联系人列表
    private List<Person> pingyingList; //联系人列表（转成拼音）
    private List<Person> resultList;    //最终列表
    private List<String> characterList;  //字母列表

    private static int ITEM_TYPE_CONTACT = 1; //联系人条目
    private static int ITEM_TYPE_CHARACTER = 2;   //字母条目

    public BlacklistAdapter(Context mContext, List<Person> personList) {
        this.mContext = mContext;
        this.personList = personList;
        handleContact();
    }

    private void handleContact() {
        pingyingList=new ArrayList<>();
        resultList=new ArrayList<>();
        characterList =new ArrayList<>();
//      将联系人中文名字转换成拼音
        for(int i=0;i<personList.size();i++){
            pingyingList.add(ChineseToPinyinUtil.getPingyin(personList.get(i)));
            System.out.println(TAG +"  "+pingyingList.get(i).getPinYin());
        }

        if(pingyingList!=null){
            Collections.sort(pingyingList,new ContactComparator());
            for(int i=0;i<pingyingList.size();i++){
                System.out.println(TAG +"  "+pingyingList.get(i).getPinYin());
            }
        }

        for (int i=0;i<pingyingList.size();i++){
            String name=pingyingList.get(i).getPinYin();
            String character =(name.charAt(0)+"").toUpperCase();
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
            Person person =pingyingList.get(i).setTYPE(ITEM_TYPE_CONTACT);
            resultList.add(person);
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if(i==ITEM_TYPE_CHARACTER){
            return new CharacterHolder(LayoutInflater.from(mContext).inflate(R.layout.rv_item_character,viewGroup,false));
        }else{
            return new ContcatHolder(LayoutInflater.from(mContext).inflate(R.layout.rv_item,viewGroup,false));
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        Person person=resultList.get(i);
        if(viewHolder instanceof ContcatHolder){
            ContcatHolder contcatHolder=(ContcatHolder) viewHolder;
            contcatHolder.iv_icon.setImageResource(person.getImgId());
            contcatHolder.tv_name.setText(person.getName());
        }else if(viewHolder instanceof CharacterHolder){
            CharacterHolder characterHolder= (CharacterHolder) viewHolder;
            characterHolder.tv_character.setText(person.getPinYin());
        }
    }

    @Override
    public int getItemCount() {
        return resultList==null ? 0: resultList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return resultList.get(position).getTYPE();
    }

    public class CharacterHolder extends RecyclerView.ViewHolder {
        TextView tv_character;

        public CharacterHolder(@NonNull View itemView) {
            super(itemView);
            tv_character = itemView.findViewById(R.id.tv_character);
        }
    }

    public class ContcatHolder extends RecyclerView.ViewHolder {
        ImageView iv_icon;
        TextView tv_name;
        public ContcatHolder(@NonNull View itemView) {
            super(itemView);
            iv_icon = itemView.findViewById(R.id.iv_icon);
            tv_name = itemView.findViewById(R.id.tv_name);
        }
    }

    public int getScrollPosition(String character){
        if(characterList.contains(character)){
            for(int i=0;i<resultList.size();i++){
                if(resultList.get(i).getPinYin().equals(character)){
                    return i;
                }
            }
        }
        return -1;
    }


}
