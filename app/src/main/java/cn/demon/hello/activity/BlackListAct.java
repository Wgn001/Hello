package cn.demon.hello.activity;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import cn.demon.hello.R;
import cn.demon.hello.adapter.LinkAdapter;
import cn.demon.hello.bean.Person;

public class BlackListAct extends AppCompatActivity implements View.OnClickListener {
    private ImageView ig_return_title;
    private RecyclerView rv_blacklist;
    private List<Person> personList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.KITKAT){
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
        setContentView(R.layout.activity_black_list);
        initView();



    }
    private void initView() {
        ig_return_title=findViewById(R.id.ig_return_title);
        rv_blacklist=findViewById(R.id.rv_blacklist);
        ig_return_title.setOnClickListener(this);
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
        for (int i = 1; i < 20; i++) {
            if (i % 2 == 1) {
                personList.add(new Person("阿里" + i, R.drawable.new_user_pic));
            } else {
                personList.add(new Person("正在" + i, R.drawable.ql_mr));
            }
        }
    }

}


