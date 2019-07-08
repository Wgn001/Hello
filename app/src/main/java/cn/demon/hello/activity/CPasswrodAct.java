package cn.demon.hello.activity;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import cn.demon.hello.R;

public class CPasswrodAct extends AppCompatActivity implements View.OnClickListener, TextWatcher {

    private ImageView ig_return_title;
    private TextView tv_save, tv_title_name;
    private ImageView ig_cpassword;
    private EditText edt_oldpassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.KITKAT) {
            //透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//            //透明导航栏
//            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
        setContentView(R.layout.activity_cpasswrod);
        initView();
        tv_save.setText("完成");
        tv_title_name.setText("密码修改");
    }

    private void initView() {
        tv_save=findViewById(R.id.tv_save);
        tv_title_name=findViewById(R.id.tv_title_name);
        ig_return_title=findViewById(R.id.ig_return_title);
        ig_cpassword=findViewById(R.id.ig_cpassword);
        edt_oldpassword=findViewById(R.id.edt_oldpassword);

        ig_cpassword.setOnClickListener(this);
        tv_save.setOnClickListener(this);
        ig_return_title.setOnClickListener(this);
        edt_oldpassword.setOnClickListener(this);
        edt_oldpassword.addTextChangedListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ig_return_title:
                finish();
                break;
            case R.id.ig_cpassword:
                edt_oldpassword.setText("");
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

        if (!edt_oldpassword.getText().toString().trim().isEmpty()){
            ig_cpassword.setVisibility(View.VISIBLE);
        }else {
            ig_cpassword.setVisibility(View.INVISIBLE);
        }
    }
}
