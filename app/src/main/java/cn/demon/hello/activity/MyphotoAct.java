package cn.demon.hello.activity;

import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.SimpleFormatter;

import cn.demon.hello.R;
import cn.demon.hello.adapter.PhotoAdapter;
import cn.demon.hello.bean.Photo;
/**
 *
 *我的相册Activity
 * @author Gn.w
 * @date 19.7.13
 */
public class MyphotoAct extends AppCompatActivity implements View.OnClickListener {
    private ImageView ig_return_title;
    private RecyclerView recyclerView;
    private List<Photo> photoList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.KITKAT) {
            //透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//            //透明导航栏
//            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
        setContentView(R.layout.activity_myphoto);
        initView();
        initData();
        PhotoAdapter photoAdapter=new PhotoAdapter(photoList,this);
        LinearLayoutManager manager =new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(photoAdapter);
    }

    private void initData() {
        photoList=new ArrayList<>();
        for(int i=1;i<10;i++){
            Photo photo=new Photo();
            photo.setDate(getDate());
            photo.setContent(getContent(i));
            photo.setComment_data(i);
            photo.setDz_data(i);
            photo.setImg(R.drawable.pyq_con_pic);
            photoList.add(photo);
        }
    }
    public String getContent(int i){
        String content="";
        for (int j=0;j<i;j++){
             content =content + "日本是净化心灵，感受人文的地方。日本是净化心灵，感受人文的地方";
        }
        return content;
    }

    public String  getDate(){
        SimpleDateFormat simpleDateFormat= new SimpleDateFormat("yyyy-MM-dd  HH:mm");
        Date date=new Date();
       return simpleDateFormat.format(date);
    }

    private void initView() {
        ig_return_title=findViewById(R.id.ig_return_title);
        recyclerView=findViewById(R.id.recyclerView);
        ig_return_title.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ig_return_title:
                finish();
                break;
        }
    }
}
