package cn.demon.hello.activity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.gson.JsonObject;

import java.io.IOException;
import java.util.Set;

import cn.demon.hello.R;
import cn.demon.hello.Util.HttpUtil;
import cn.demon.hello.Util.JsonUtil;
import cn.demon.hello.Util.SharedPreferencesUtil;
import cn.demon.hello.Util.okHttpUtil;
import cn.demon.hello.bean.Login;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class SettingAct extends AppCompatActivity implements View.OnClickListener, Callback {

    private static final String TAG = "SettingAct";

    private Button btn_logout;
    private TextView tv_save, tv_title_name;
    private RelativeLayout rl_change_password, rl_privacy, rl_clear_buffer,rl_new_message;
    private ImageView ig_return_title;
    private Dialog dialog;
    SharedPreferencesUtil spu=new SharedPreferencesUtil();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.KITKAT) {
            //透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//            //透明导航栏
//            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
        setContentView(R.layout.activity_setting);

        initView();

        tv_save.setVisibility(View.INVISIBLE);
        tv_title_name.setText("账号设置");
    }

    private void initView() {
        btn_logout=findViewById(R.id.btn_logout);
        tv_save=findViewById(R.id.tv_save);
        tv_title_name=findViewById(R.id.tv_title_name);
        rl_change_password=findViewById(R.id.rl_change_password);
        rl_privacy=findViewById(R.id.rl_privacy);
        rl_clear_buffer=findViewById(R.id.rl_clear_buffer);
        rl_new_message=findViewById(R.id.rl_new_message);
        ig_return_title=findViewById(R.id.ig_return_title);


        btn_logout.setOnClickListener(this);
        tv_save.setOnClickListener(this);
        tv_title_name.setOnClickListener(this);
        rl_change_password.setOnClickListener(this);
        rl_privacy.setOnClickListener(this);
        rl_clear_buffer.setOnClickListener(this);
        rl_new_message.setOnClickListener(this);
        ig_return_title.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_logout:
                dialog=showLogout(R.layout.dialog_logout);
                break;
            case R.id.ig_return_title:
                finish();
                break;
            case R.id.rl_change_password:
                Intent intent =new Intent(SettingAct.this,CPasswrodAct.class);
                startActivity(intent);
                break;
            case R.id.rl_privacy:
                Intent intent1=new Intent(SettingAct.this,PrivacyAct.class);
                startActivity(intent1);
                break;
            case R.id.rl_new_message:
                Intent intent2=new Intent(SettingAct.this,NewMsgAct.class);
                startActivity(intent2);
                break;
            case R.id.rl_clear_buffer:
                dialog=show("是否清除缓存？",R.layout.dialog_layout_login);
                break;
            case R.id.btn_dialog_cancel:
                dialog.dismiss();
                break;
            case R.id.btn_dialog_confirm:
                show(this);
                dialog.dismiss();
                break;
            case R.id.btn_logout_cancal:
                dialog.dismiss();
                break;
            case R.id.btn_logout_confrim:
                dialog.dismiss();
                //                  退出登录
                String login_json =spu.read("login_data",this);
                if(login_json!=null){
                    Login loginData=JsonUtil.parseJson(login_json, Login.class);
                    if(loginData.code==1){
                        okHttpUtil.logout(HttpUtil.URL_LOGOUT,loginData.data.sessionId,this);
                        finish();
                    }
                }



                break;
        }
    }

    public Dialog show(String title,int layout){
        TextView tv_dialog_title;
        Button btn_dialog_cancel,btn_dialog_confirm;
        Dialog dialog=new Dialog(this);
        View view=LayoutInflater.from(this).inflate(layout,null);
        dialog.setContentView(view);
        tv_dialog_title=view.findViewById(R.id.tv_dialog_title);
        btn_dialog_cancel=view.findViewById(R.id.btn_dialog_cancel);
        btn_dialog_confirm=view.findViewById(R.id.btn_dialog_confirm);
        btn_dialog_cancel.setOnClickListener(this);
        btn_dialog_confirm.setOnClickListener(this);
        tv_dialog_title.setText(title);
        Window window=dialog.getWindow();
        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        dialog.show();
        return dialog;
    }
    public Dialog showLogout(int layout){
        Button btn_logout_cancal,btn_logout_confrim;
        Dialog dialog=new Dialog(this);
        View view=LayoutInflater.from(this).inflate(layout,null);
        dialog.setContentView(view);
        btn_logout_cancal=view.findViewById(R.id.btn_logout_cancal);
        btn_logout_confrim=view.findViewById(R.id.btn_logout_confrim);
        btn_logout_cancal.setOnClickListener(this);
        btn_logout_confrim.setOnClickListener(this);
        Window window=dialog.getWindow();
        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        dialog.show();
        return dialog;
    }

    public void show(final Context context){
        final Dialog dialog=new Dialog(context,R.style.ActionSheetDialogStyle);
        View view=LayoutInflater.from(context).inflate(R.layout.dialog_clear_cache,null);
        Button button=view.findViewById(R.id.btn_clear_ok);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(dialog!=null){
                    dialog.dismiss();
                }
            }
        });
        dialog.setContentView(view);
        Window window = dialog.getWindow();
        window.setGravity(Gravity.BOTTOM);
        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        dialog.show();
    }



    @Override
    public void onFailure(Call call, IOException e) {

    }

    @Override
    public void onResponse(Call call, Response response) throws IOException {

        Login login=JsonUtil.parseJson(response.body().string(),Login.class);
        if(login.code==1){
            spu.save("login_data","",this);
            Intent intent=new Intent(this,LoginAct.class);
            startActivity(intent);
        }

    }
}
