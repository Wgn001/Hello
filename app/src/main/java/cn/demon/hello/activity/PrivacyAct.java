package cn.demon.hello.activity;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import cn.demon.hello.R;

public class PrivacyAct extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "PrivacyAct";
    private TextView tv_save,tv_title_name;
    private ImageView ig_return_title;
    private RelativeLayout rl_blacklist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.KITKAT) {
            //透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//            //透明导航栏
//            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
        setContentView(R.layout.activity_privacy);

        initView();

    }

    private void initView() {
        tv_save=findViewById(R.id.tv_save);
        tv_title_name=findViewById(R.id.tv_title_name);
        ig_return_title=findViewById(R.id.ig_return_title);
        rl_blacklist=findViewById(R.id.rl_blacklist);

        rl_blacklist.setOnClickListener(this);
        ig_return_title.setOnClickListener(this);

        tv_save.setVisibility(View.INVISIBLE);
        tv_title_name.setText("隐私");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ig_return_title:
                finish();
                Log.e(TAG,"finish");
                break;
            case R.id.rl_blacklist:
                Intent intent=new Intent(PrivacyAct.this,BlackListAct.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}
