package cn.demon.hello.activity;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import cn.demon.hello.R;

public class AboutAct extends AppCompatActivity implements View.OnClickListener {

    private TextView tv_save,tv_title_name;
    private ImageView ig_return_title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.KITKAT) {
            //透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//            //透明导航栏
//            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
        setContentView(R.layout.activity_about);
        initView();
    }

    private void initView() {
        tv_save=findViewById(R.id.tv_save);
        tv_title_name=findViewById(R.id.tv_title_name);
        ig_return_title=findViewById(R.id.ig_return_title);


        ig_return_title.setOnClickListener(this);

        tv_save.setVisibility(View.INVISIBLE);
        tv_title_name.setText("关于本港台");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ig_return_title:
                finish();
                break;

            default:
                break;
        }
    }
}
