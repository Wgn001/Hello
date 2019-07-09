package cn.demon.hello.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import cn.demon.hello.MainActivity;
import cn.demon.hello.R;
import cn.demon.hello.activity.AboutAct;
import cn.demon.hello.activity.MenuAct;
import cn.demon.hello.activity.MyphotoAct;
import cn.demon.hello.activity.PersonalAct;
import cn.demon.hello.activity.SettingAct;
import cn.demon.hello.bean.Login;


public class MyFragment extends Fragment implements View.OnClickListener{

    private RelativeLayout rl_menu,rl_photo,rl_zh,rl_suggest,rl_about;
    private ImageView ig_change_icon;
    private TextView tv_nick,tv_id;
    Intent intent;
    MainActivity mainActivity;
    static Login login;
    Bundle args;

    public static MyFragment newInstance(Bundle args){
        MyFragment f=new MyFragment();
        f.setArguments(args);
        return f;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.myfragment, container, false);

        initView(view);
        mainActivity=(MainActivity) getActivity();
        return view;
    }



    private void initView(View view) {
        rl_menu=view.findViewById(R.id.rl_menu);
        rl_photo=view.findViewById(R.id.rl_photo);
        rl_zh=view.findViewById(R.id.rl_zh);
        rl_suggest=view.findViewById(R.id.rl_suggest);
        rl_about=view.findViewById(R.id.rl_about);
        ig_change_icon=view.findViewById(R.id.ig_change_icon);
        tv_nick=view.findViewById(R.id.tv_nick);
        tv_id=view.findViewById(R.id.tv_id);

        ig_change_icon.setOnClickListener(this);
        rl_menu.setOnClickListener(this);
        rl_photo.setOnClickListener(this);
        rl_zh.setOnClickListener(this);
        rl_suggest.setOnClickListener(this);
        rl_about.setOnClickListener(this);

        args=getArguments();
        if(args!=null){
            login =(Login)args.getSerializable("login");
            tv_nick.setText(login.data.nick);
            tv_id.setText(login.data.id+"");
        }
    }

    @Override
    public void onClick(View v) {
            switch (v.getId()){
                case R.id.rl_menu:
                    intent =new Intent(mainActivity, MenuAct.class);
                    startActivity(intent);
                    break;
                case R.id.rl_photo:
                    intent =new Intent(mainActivity, MyphotoAct.class);
                    startActivity(intent);
                    break;
                case R.id.rl_zh:
                    intent =new Intent(mainActivity, SettingAct.class);
                    startActivity(intent);
                    break;
                case R.id.rl_suggest:
                    break;
                case R.id.rl_about:
                    intent =new Intent(mainActivity, AboutAct.class);
                    startActivity(intent);
                        break;
                case R.id.ig_change_icon:
                    intent =new Intent(mainActivity, PersonalAct.class);
                    startActivity(intent);
                    break;
            }
    }

}
