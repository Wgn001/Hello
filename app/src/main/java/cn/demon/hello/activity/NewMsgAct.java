package cn.demon.hello.activity;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import cn.demon.hello.R;
/**
 *
 *接收新消息Activity
 * @author Gn.w
 * @date 19.7.13
 */
public class NewMsgAct extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "NewMsgAct";
    private ImageView ig_return_title;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.KITKAT){
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
        setContentView(R.layout.activity_new_msg);
        initView();
    }

    private void initView() {
        ig_return_title=findViewById(R.id.ig_return_title);
        ig_return_title.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ig_return_title:
                finish();
                Log.e(TAG,"finish");
                break;
        }
    }
}
