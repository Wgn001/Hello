package cn.demon.hello.Util;

import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

public  class okHttpUtil {

    public static void Login(String url,String phone,String Pwd ,Callback callback){
        OkHttpClient client=new OkHttpClient();
        RequestBody body=new FormBody.Builder().add("mobile",phone).add("password",Pwd).build();
        Request request=new Request.Builder().url(HttpUtil.URL_LOGIN).post(body).build();
        client.newCall(request).enqueue(callback);
    }
}
