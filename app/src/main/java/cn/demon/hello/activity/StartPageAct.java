package cn.demon.hello.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.WindowManager;

import cn.demon.hello.MainActivity;
import cn.demon.hello.R;
import cn.demon.hello.Util.SharedPreferencesUtil;
/**
 *
 *起始页Activity
 * @author Gn.w
 * @date 19.7.13
 */
public class StartPageAct extends AppCompatActivity {
    private static final String TAG = "StartPageAct";

    SharedPreferencesUtil spu=new SharedPreferencesUtil();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.KITKAT) {
            //透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//            //透明导航栏
//            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
        setContentView(R.layout.layout_startpager);
        Thread mThread =new Thread(){
            @Override
            public void run() {
                try {
                    sleep(1000);
                    String loginData = spu.read("login_data", getApplication());
                    Log.e(TAG,loginData.toString());
                    if (loginData.trim() == "") {
                        Intent intent = new Intent(StartPageAct.this, LoginAct.class);
                        startActivity(intent);
                    } else {
                        Intent intent = new Intent(StartPageAct.this, MainActivity.class);
                        startActivity(intent);
                    }
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        };
        mThread.start();
    }
}
