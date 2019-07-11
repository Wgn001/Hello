package cn.demon.hello.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;

import cn.demon.hello.R;
import cn.demon.hello.Util.HttpUtil;
import cn.demon.hello.Util.JsonUtil;
import cn.demon.hello.Util.okHttpUtil;
import cn.demon.hello.bean.Login;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 *
 *找回密码
 * @author Gn W
 * @date 19.7.2
 */
public class RetPasswordAct extends AppCompatActivity implements View.OnClickListener, TextWatcher, Callback {

    private static final String TAG = "RetPasswordAct";
    private Button btn_new_user_ret,btn_login_ret,btn_confirm,btn_send_code;
    private EditText edt_phone_ret,edt_verification_ret,edt_password_ret;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.KITKAT) {
            //透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//            //透明导航栏
//            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
        setContentView(R.layout.layout_retrieve_password);
        initView();
    }

    /**
     * 初始化
     */
    private void initView() {
        btn_new_user_ret=findViewById(R.id.btn_new_user_ret);
        btn_login_ret=findViewById(R.id.btn_login_ret);
        btn_confirm=findViewById(R.id.btn_confirm);
        btn_send_code=findViewById(R.id.btn_send_code);
        edt_phone_ret=findViewById(R.id.edt_phone_ret);
        edt_password_ret=findViewById(R.id.edt_password_ret);
        edt_verification_ret=findViewById(R.id.edt_verification_ret);

        btn_send_code.setOnClickListener(this);
        btn_confirm.setOnClickListener(this);
        btn_new_user_ret.setOnClickListener(this);
        btn_login_ret.setOnClickListener(this);
        edt_phone_ret.addTextChangedListener(this);
        edt_password_ret.addTextChangedListener(this);
        edt_verification_ret.addTextChangedListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.btn_new_user_ret:
                Intent intent=new Intent(RetPasswordAct.this, RegisterAct.class);
                startActivity(intent);
                break;
            case R.id.btn_login_ret:
                Intent intent1=new Intent(RetPasswordAct.this, LoginAct.class);
                startActivity(intent1);
                break;
            case R.id.btn_confirm:
                String phone=edt_phone_ret.getText().toString().trim();
                String Pwd=edt_password_ret.getText().toString().trim();
                String code=edt_verification_ret.getText().toString().trim();
                okHttpUtil.findPwd(HttpUtil.URL_FIND,phone,Pwd,code,this);
                break;
            case R.id.btn_send_code:
                phone=edt_phone_ret.getText().toString().trim();
                okHttpUtil.getCode(HttpUtil.URL_CODE,phone,"1",this);
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
        String phone=edt_phone_ret.getText().toString().trim();
        String password=edt_password_ret.getText().toString().trim();
        String verification=edt_verification_ret.getText().toString().trim();

        if(!phone.isEmpty() && !password.isEmpty() && !verification.isEmpty()){
            btn_confirm.setEnabled(true);
            btn_confirm.setBackgroundResource(R.drawable.circular_5_fe5455);
        }else{
            btn_confirm.setEnabled(false);
            btn_confirm.setBackgroundResource(R.drawable.circular_5_ccccc);
        }
    }

    @Override
    public void onFailure(Call call, IOException e) {

    }

    @Override
    public void onResponse(Call call, Response response) throws IOException {
            String result=response.body().string();
        Log.e(TAG, result);
            if(result!=null){
                Login login = JsonUtil.parseJson(result, Login.class);
                if (login.code == 1 && login.desc.equals("找回密码成功") ){
                    Intent intent = new Intent(this, LoginAct.class);
                    startActivity(intent);
                    finish();
                }
            }
    }
}
