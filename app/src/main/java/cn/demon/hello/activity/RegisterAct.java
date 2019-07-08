package cn.demon.hello.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import cn.demon.hello.R;

/**
 *
 *注册
 * @author Gn W
 * @date 19.7.2
 */
public class RegisterAct extends AppCompatActivity implements View.OnClickListener, TextWatcher {

    private Button btn_ret_password_register,btn_login_register,btn_register;
    private EditText edt_username_register,edt_phone_register,edt_verification_regsiter,edt_password_register;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.KITKAT) {
            //透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//            //透明导航栏
//            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
        setContentView(R.layout.layout_register);
        initView();
    }

    /**
     * 初始化
     */
    private void initView() {

        btn_ret_password_register=findViewById(R.id.btn_ret_password_register);
        btn_login_register=findViewById(R.id.btn_login_register);
        btn_register=findViewById(R.id.btn_register);
        edt_username_register=findViewById(R.id.edt_username_register);
        edt_password_register=findViewById(R.id.edt_password_register);
        edt_phone_register=findViewById(R.id.edt_phone_register);
        edt_verification_regsiter=findViewById(R.id.edt_verification_regsiter);

        edt_username_register.addTextChangedListener(this);
        edt_password_register.addTextChangedListener(this);
        edt_phone_register.addTextChangedListener(this);
        edt_verification_regsiter.addTextChangedListener(this);
        btn_ret_password_register.setOnClickListener(this);
        btn_login_register.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_ret_password_register:
                Intent intent=new Intent(RegisterAct.this, RetPasswordAct.class);
                startActivity(intent);
                break;
            case R.id.btn_login_register:
                Intent intent1=new Intent(RegisterAct.this,LoginAct.class);
                startActivity(intent1);
                break;
            case R.id.btn_register:
                break;
        }
    }


    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {

        String username=edt_username_register.getText().toString().trim();
        String password=edt_password_register.getText().toString().trim();
        String phone=edt_phone_register.getText().toString().trim();
        String verification=edt_verification_regsiter.getText().toString().trim();
        if(!username.isEmpty() && !password.isEmpty() && !phone.isEmpty() && !verification.isEmpty()){
            btn_register.setEnabled(true);
            btn_register.setBackgroundResource(R.drawable.circular_5_fe5455);
        }else {
            btn_register.setEnabled(false);
            btn_register.setBackgroundResource(R.drawable.circular_5_ccccc);
        }

    }
}
