package cn.demon.hello.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import cn.demon.hello.R;
import cn.demon.hello.adapter.LinkAdapter;
import cn.demon.hello.bean.Person;


public class LinkFragment extends Fragment {

    private LinkAdapter linkAdapter;
    private RecyclerView rv_link;
    private List<Person> personList=new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.linkman_fragment,container,false);
        getData();
        rv_link=view.findViewById(R.id.rv_linkman);
        LinearLayoutManager layoutManager = new LinearLayoutManager(container.getContext());
        rv_link.setLayoutManager(layoutManager);
        linkAdapter=new LinkAdapter(personList);
        rv_link.setAdapter(linkAdapter);
        return view;
    }

    public void getData(){
        for(int i=1; i<20; i++){
            if(i%2==1){
                personList.add(new Person("阿里"+i,R.drawable.new_user_pic));
            }else{
                personList.add(new Person("正在"+i,R.drawable.ql_mr));
            }
        }
    }

}
