package cn.demon.hello.activity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Set;

import cn.demon.hello.R;

public class SettingAct extends AppCompatActivity implements View.OnClickListener {

    private Button btn_logout;
    private TextView tv_save, tv_title_name;
    private RelativeLayout rl_change_password, rl_privacy, rl_clear_buffer,rl_new_message;
    private ImageView ig_return_title;
    private Dialog dialog;

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
                dialog=show("是否退出登录？",R.layout.dialog_layout_login);
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
                dialog.dismiss();
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

}
