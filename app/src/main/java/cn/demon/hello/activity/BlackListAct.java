package cn.demon.hello.activity;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import cn.demon.hello.R;
import cn.demon.hello.adapter.BlacklistAdapter;
import cn.demon.hello.bean.Person;
import cn.demon.hello.view.LetterView;
/**
 *
 *黑名单列表Activity
 * @author Gn.w
 * @date 19.7.13
 */
public class BlackListAct extends AppCompatActivity implements View.OnClickListener {

    private ImageView ig_return_title;
    private RecyclerView rv_blacklist;
    private LetterView ll_letterview;
    private List<Person> personList;
    private LinearLayoutManager manager;
    private BlacklistAdapter adpter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.KITKAT){
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
        setContentView(R.layout.activity_black_list);
        initView();
        adpter=new BlacklistAdapter(this,personList);
        manager=new LinearLayoutManager(this);
        rv_blacklist.setLayoutManager(manager);
        rv_blacklist.setAdapter(adpter);
    }
    private void initView() {
        ig_return_title=findViewById(R.id.ig_return_title);
        rv_blacklist=findViewById(R.id.rv_blacklist);
        ll_letterview=findViewById(R.id.ll_letterview);
        ig_return_title.setOnClickListener(this);

        ll_letterview.setCharacterClickListener(new LetterView.CharacterClickListener() {
            @Override
            public void clickCharacter(String character) {
                manager.scrollToPositionWithOffset(adpter.getScrollPosition(character),0);
            }
        });

        getData();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ig_return_title:
                finish();
                break;
        }
    }
    public void getData() {
        personList = new ArrayList<>();
        personList.add(new Person("白萝卜",R.drawable.new_user_pic));
        personList.add(new Person("阿拉伯",R.drawable.my_user_pic));
        personList.add(new Person("正当的",R.drawable.new_user_pic));
        personList.add(new Person("白萝卜",R.drawable.new_user_pic));
        personList.add(new Person("财付通",R.drawable.new_user_pic));
        personList.add(new Person("巴迪",R.drawable.new_user_pic));
        personList.add(new Person("@@",R.drawable.new_user_pic));
        personList.add(new Person("阿拉伯",R.drawable.new_user_pic));
        personList.add(new Person("阿勒",R.drawable.new_user_pic));
        personList.add(new Person("德鲁巴",R.drawable.new_user_pic));
        personList.add(new Person("正当的",R.drawable.new_user_pic));
        personList.add(new Person("阿勒",R.drawable.new_user_pic));
        personList.add(new Person("正当的",R.drawable.new_user_pic));
        personList.add(new Person("23",R.drawable.new_user_pic));
    }

}


