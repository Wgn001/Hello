package cn.demon.hello.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import cn.demon.hello.R;
import cn.demon.hello.Util.HttpUtil;
import cn.demon.hello.Util.JsonUtil;
import cn.demon.hello.Util.SharedPreferencesUtil;
import cn.demon.hello.Util.okHttpUtil;
import cn.demon.hello.bean.Login;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
/**
 *
 *修改密码Activity
 * @author Gn.w
 * @date 19.7.13
 */
public class CPasswrodAct extends AppCompatActivity implements View.OnClickListener, TextWatcher, Callback {

    private static final String TAG = "CPasswrodAct";

    private ImageView ig_return_title;
    private TextView tv_save, tv_title_name;
    private ImageView ig_cpassword;
    private EditText edt_oldPwd, edt_newPwd, edt_confirm_Pwd;
    SharedPreferencesUtil spu = new SharedPreferencesUtil();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//            //透明导航栏
//            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
        setContentView(R.layout.activity_cpasswrod);
        initView();

    }

    private void initView() {
        tv_save = findViewById(R.id.tv_save);
        tv_title_name = findViewById(R.id.tv_title_name);
        ig_return_title = findViewById(R.id.ig_return_title);
        ig_cpassword = findViewById(R.id.ig_cpassword);
        edt_oldPwd = findViewById(R.id.edt_oldPwd);
        edt_newPwd = findViewById(R.id.edt_newPwd);
        edt_confirm_Pwd = findViewById(R.id.edt_confirm_Pwd);

        ig_cpassword.setOnClickListener(this);
        tv_save.setOnClickListener(this);
        ig_return_title.setOnClickListener(this);
        edt_oldPwd.setOnClickListener(this);
        edt_confirm_Pwd.setOnClickListener(this);

        edt_oldPwd.addTextChangedListener(this);
        edt_newPwd.addTextChangedListener(this);
        edt_confirm_Pwd.addTextChangedListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ig_return_title:
                finish();
                break;
            case R.id.ig_cpassword:
                edt_oldPwd.setText("");
                break;
            case R.id.tv_save:

                String login_data = spu.read("login_data", this);
                String sessionId = "";
                String oldPwd = edt_oldPwd.getText().toString().trim();
                String newPwd = edt_newPwd.getText().toString().trim();
                String confirmPwd = edt_confirm_Pwd.getText().toString().trim();
                if (login_data != null) {
                    Login login = JsonUtil.parseJson(login_data, Login.class);
                    Log.e(TAG, login.data.sessionId);
                    sessionId = login.data.sessionId;
                    if (newPwd.equals(confirmPwd)) {
                        okHttpUtil.uodatePed(HttpUtil.URL_UpDatePwd, sessionId, oldPwd, newPwd, this);
                    } else {
                        Toast.makeText(this, "新密码不一致", Toast.LENGTH_SHORT).show();
                    }
                }
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

        String oldPwd = edt_oldPwd.getText().toString().trim();
        String newPwd = edt_newPwd.getText().toString().trim();
        String confirmPwd = edt_confirm_Pwd.getText().toString().trim();

        if (!edt_oldPwd.getText().toString().trim().isEmpty()) {
            ig_cpassword.setVisibility(View.VISIBLE);
            tv_save.setTextColor(Color.WHITE);
        } else {
            ig_cpassword.setVisibility(View.INVISIBLE);
            tv_save.setTextColor(Color.GRAY);
        }
        if (oldPwd.isEmpty() || newPwd.isEmpty() || confirmPwd.isEmpty()) {
            tv_save.setTextColor(Color.GRAY);
            tv_save.setEnabled(false);
        } else {
            tv_save.setTextColor(Color.WHITE);
            tv_save.setEnabled(true);
        }


    }

    @Override
    public void onFailure(Call call, IOException e) {

    }

    @Override
    public void onResponse(Call call, Response response) throws IOException {
        String data = response.body().string();
        Log.e(TAG, data);
        if (!data.isEmpty()) {
            Login login = JsonUtil.parseJson(data, Login.class);
            if (login.code == 1) {
                spu.save("login_data", data, this);
                Intent intent = new Intent(this, LoginAct.class);
                startActivity(intent);
            }
        }

    }
}
