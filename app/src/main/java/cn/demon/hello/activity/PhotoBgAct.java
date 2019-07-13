package cn.demon.hello.activity;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import cn.demon.hello.R;
/**
 *
 *选择更改个人相册背景Activity
 * @author Gn.w
 * @date 19.7.13
 */
public class PhotoBgAct extends AppCompatActivity implements View.OnClickListener {

    private ImageView ig_photo_bg,ig_return_title;
    private TextView tv_save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.KITKAT){
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
        setContentView(R.layout.activity_photo_bg);
        initView();
    }

    private void initView() {

        ig_photo_bg=findViewById(R.id.ig_photo_bg);
        tv_save=findViewById(R.id.tv_save);
        ig_return_title=findViewById(R.id.ig_return_title);

        ig_return_title.setOnClickListener(this);
        tv_save.setOnClickListener(this);
        ig_photo_bg.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ig_photo_bg:
                    show(this);
                    tv_save.setTextColor(Color.WHITE);
                break;
            case R.id.tv_save:
                tv_save.setTextColor(ContextCompat.getColor(this,R.color.color999999));
                break;
            case R.id.ig_return_title:
                finish();
                break;
        }
    }

    public void show(Context context){
        Dialog dialog=new Dialog(context,R.style.ActionSheetDialogStyle);
        View view= LayoutInflater.from(context).inflate(R.layout.dialog_photo_bg,null);
        dialog.setContentView(view);
        Window window=dialog.getWindow();
        window.setGravity(Gravity.BOTTOM);
        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        dialog.show();
    }
}
