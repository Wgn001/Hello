package cn.demon.hello.activity;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import cn.demon.hello.R;

public class FriendMesAct extends AppCompatActivity implements View.OnClickListener {
    private ImageView ig_icon, ig_return_title;
    private TextView tv_nick, tv_phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
        setContentView(R.layout.activity_friend_mes);
        Bundle bundle = getIntent().getExtras();
        initView(bundle);
    }

    private void initView(Bundle bundle) {

        ig_icon = findViewById(R.id.ig_icon);
        ig_return_title = findViewById(R.id.ig_return_title);
        tv_nick = findViewById(R.id.tv_nick);
        tv_phone = findViewById(R.id.tv_phone);

        ig_icon.setImageResource(bundle.getInt("icon"));
        tv_nick.setText(bundle.getString("nick"));

        ig_return_title.setOnClickListener(this);

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
