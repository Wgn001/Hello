package cn.demon.hello.activity;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;

import cn.demon.hello.R;
import cn.demon.hello.Util.HttpUtil;
import cn.demon.hello.Util.JsonUtil;
import cn.demon.hello.Util.okHttpUtil;
import cn.demon.hello.bean.Content;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class AboutAct extends AppCompatActivity implements View.OnClickListener, Callback {
    private static final String TAG = "AboutAct";
    private TextView tv_save,tv_title_name;
    private ImageView ig_return_title;
    private WebView webView;
//    String data="<p>关于本港台<span style=\"white-space: normal;\">关于本港台</span><span style=\"white-space: normal;\">关于本港台</span><span style=\"white-space: normal;\">关于本港台</span><span style=\"white-space: normal;\">关于本港台</span><span style=\"white-space: normal;\">关于本港台<span style=\"white-space: normal;\">关于本港台</span><span style=\"white-space: normal;\">关于本港台</span><span style=\"white-space: normal;\">关于本港台</span><span style=\"white-space: normal;\">关于本港台</span><span style=\"white-space: normal;\">关于本港台</span><span style=\"white-space: normal;\">关于本港台关于本港台关于本港台关于本港台关于本港台关于本港台关于本港台关于本港台关于本港台关于本港台关于本港台</span></span></p>";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.KITKAT) {
            //透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//            //透明导航栏
//            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
        setContentView(R.layout.activity_about);
        initView();
    }

    private void initView() {
        tv_save=findViewById(R.id.tv_save);
        tv_title_name=findViewById(R.id.tv_title_name);
        ig_return_title=findViewById(R.id.ig_return_title);
        webView=findViewById(R.id.webView);

        ig_return_title.setOnClickListener(this);

        tv_save.setVisibility(View.INVISIBLE);
        tv_title_name.setText("关于本港台");

        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        okHttpUtil.content(HttpUtil.URL_CONTENT,"2",this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ig_return_title:
                finish();
                break;

            default:
                break;
        }
    }

    @Override
    public void onFailure(Call call, IOException e) {

    }

    @Override
    public void onResponse(Call call, Response response) throws IOException {
        String s =response.body().string();
        Log.e(TAG,s);
        if(s!=null){
            final Content content=JsonUtil.parseJson(s, Content.class);
            if(content.code==1){
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        webView.loadData(content.data.content,"text/html;charset=utf-8","utf-8");
                    }
                });
            }
        }
    }
}
