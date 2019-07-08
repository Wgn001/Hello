package cn.demon.hello.activity;

import android.app.Dialog;
import android.content.Intent;
import android.media.Image;
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

import org.w3c.dom.Text;

import cn.demon.hello.R;

public class PersonalAct extends AppCompatActivity implements View.OnClickListener {

    private ImageView ig_icon_personal, ig_xiugai,ig_return;
    private TextView tv_xiugai;
    private RelativeLayout rl_change_username;
    private Button btn_photo,btn_select_photo,btn_cancel;
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
        setContentView(R.layout.activity_personal);
        initView();
    }


    private void initView() {
        ig_return=findViewById(R.id.ig_return);
        ig_icon_personal=findViewById(R.id.ig_icon_personal);
        ig_xiugai=findViewById(R.id.ig_xiugai);
        tv_xiugai=findViewById(R.id.tv_xiugai);
        rl_change_username=findViewById(R.id.rl_change_username);

        ig_icon_personal.setOnClickListener(this);
        ig_return.setOnClickListener(this);
        ig_xiugai.setOnClickListener(this);
        tv_xiugai.setOnClickListener(this);
        rl_change_username.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ig_return:
                finish();
                break;
            case R.id.ig_icon_personal:
                ig_xiugai.setVisibility(View.VISIBLE);
                tv_xiugai.setVisibility(View.VISIBLE);
                show();
                break;
            case R.id.rl_change_username:
                Intent intent=new Intent(PersonalAct.this,ChangeNameAct.class);
                startActivity(intent);
                break;
            case R.id.btn_cancel:
                dialog.dismiss();
                ig_xiugai.setVisibility(View.INVISIBLE);
                tv_xiugai.setVisibility(View.INVISIBLE);
                break;
        }
    }

    public void show(){
        dialog=new Dialog(this,R.style.ActionSheetDialogStyle);
        View view=LayoutInflater.from(this).inflate(R.layout.dialog_layout,null);
        btn_photo=view.findViewById(R.id.btn_photo);
        btn_select_photo=view.findViewById(R.id.btn_select_photo);
        btn_cancel=view.findViewById(R.id.btn_cancel);
        btn_photo.setOnClickListener(this);
        btn_select_photo.setOnClickListener(this);
        btn_cancel.setOnClickListener(this);
        dialog.setContentView(view);
        Window window=dialog.getWindow();
        window.setGravity(Gravity.BOTTOM);
        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        dialog.setCancelable(false);
        dialog.show();
    }
}
