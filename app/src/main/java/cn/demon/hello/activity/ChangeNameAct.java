package cn.demon.hello.activity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import cn.demon.hello.R;

public class ChangeNameAct extends AppCompatActivity implements TextWatcher, View.OnClickListener {

    private TextView tv_save;
    private EditText edt_change_username;
    private ImageView ig_change_username,ig_return_title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_name);
        initView();
    }

    private void initView() {
        tv_save=findViewById(R.id.tv_save);
        edt_change_username=findViewById(R.id.edt_change_username);
        ig_change_username=findViewById(R.id.ig_change_username);
        ig_return_title=findViewById(R.id.ig_return_title);

        tv_save.setOnClickListener(this);
        edt_change_username.setOnClickListener(this);
        ig_change_username.setOnClickListener(this);
        edt_change_username.addTextChangedListener(this);
        ig_return_title.setOnClickListener(this);
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
            String name=edt_change_username.getText().toString().trim();
            if(!name.isEmpty()){
                ig_change_username.setVisibility(View.VISIBLE);
                tv_save.setEnabled(true);
                tv_save.setTextColor(getResources().getColor(R.color.colorWhite));
            }else {
                ig_change_username.setVisibility(View.INVISIBLE);
            }


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.edt_change_username:
                edt_change_username.setFocusable(true);
                break;
            case R.id.ig_change_username:
                edt_change_username.setText("");
                break;
            case R.id.tv_save:
                edt_change_username.setEnabled(false);
                tv_save.setEnabled(false);
                ig_change_username.setVisibility(View.INVISIBLE);
                getSystemService(Context.INPUT_METHOD_SERVICE);
                tv_save.setTextColor(getResources().getColor(R.color.color999999));
                break;
            case R.id.ig_return_title:
                finish();
                break;
        }
    }
}
