package cn.demon.hello.activity;

import android.content.Intent;
import android.content.SharedPreferences;
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
import android.widget.ImageButton;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.io.IOException;

import cn.demon.hello.MainActivity;
import cn.demon.hello.R;
import cn.demon.hello.Util.HttpUtil;
import cn.demon.hello.Util.JsonUtil;
import cn.demon.hello.Util.SharedPreferencesUtil;
import cn.demon.hello.Util.okHttpUtil;
import cn.demon.hello.bean.Login;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Response;

/**
 *
 *登录界面
 * @author Gn W
 * @date 19.7.2
 */
 public class LoginAct extends AppCompatActivity implements View.OnClickListener, TextWatcher, Callback {
    private static final String TAG = "LoginAct";
    private Button btn_new_user, btn_ret_password_login, btn_login;
    private EditText edt_phone, edt_password;
    private ImageButton ib_clear;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.KITKAT) {
            //透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//            //透明导航栏
//            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
        setContentView(R.layout.layout_login);

        initView();
    }

    /**
     * 初始化
     */
    private void initView() {
        btn_new_user=findViewById(R.id.btn_new_user);
        btn_ret_password_login=findViewById(R.id.btn_ret_password_login);
        btn_login=findViewById(R.id.btn_login);
        edt_phone=findViewById(R.id.edt_phone);
        edt_password=findViewById(R.id.edt_password);
        ib_clear=findViewById(R.id.ib_clear);

        btn_login.setOnClickListener(this);
        btn_ret_password_login.setOnClickListener(this);
        btn_new_user.setOnClickListener(this);
        ib_clear.setOnClickListener(this);
        edt_password.addTextChangedListener(this);
        edt_phone.addTextChangedListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_new_user:
                Intent intent = new Intent(LoginAct.this, RegisterAct.class);
                startActivity(intent);
                break;
            case R.id.btn_ret_password_login:
                Intent intent1 = new Intent(LoginAct.this, RetPasswordAct.class);
                startActivity(intent1);
                break;
            case R.id.ib_clear:
                edt_phone.setText("");
                break;
            case R.id.btn_login:

                Intent intent2=new Intent(this,MainActivity.class);
                startActivity(intent2);
//                String phone=edt_phone.getText().toString().trim();
//                String Pwd=edt_password.getText().toString().trim();
//
//                if(!phone.isEmpty()&&!Pwd.isEmpty()){
//                    okHttpUtil.login(HttpUtil.URL_LOGIN,phone,Pwd,this);
//                }
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

        String number=edt_phone.getText().toString();
        String password=edt_password.getText().toString();

        if (!number.isEmpty()) {
            ib_clear.setVisibility(View.VISIBLE);
            if (!password.isEmpty()) {
                btn_login.setEnabled(true);
                btn_login.setBackgroundResource(R.drawable.circular_5_fe5455);
            }
        } else {
            ib_clear.setVisibility(View.INVISIBLE);
            btn_login.setEnabled(false);
            btn_login.setBackgroundResource(R.drawable.circular_5_ccccc);
        }
    }

    @Override
    public void onFailure(Call call, IOException e) {
        System.out.println("LoginAct" + "Failure");
    }

    @Override
    public void onResponse(Call call, Response response) throws IOException {

//        String loginData = response.body().string();
//        Login login=JsonUtil.parseJson(loginData, Login.class);
//
//        if(login.desc.equals("登陆成功")){
//
//            Intent intent=new Intent(this,MainActivity.class);
//            Bundle bundle=new Bundle();
//
//            bundle.putSerializable("login",login);
//            intent.putExtra("intent_login",bundle);
//            SharedPreferencesUtil spu=new SharedPreferencesUtil();
//            spu.saveSessionId("sessionId",login.data.sessionId,this);
//
//            System.out.println("LoginAct"+spu.readSessionId("sessionId",this));
//            startActivity(intent);
//        }
//
//        System.out.println("LoginAct"+login.toString());
    }
}
