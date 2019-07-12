package cn.demon.hello.Util;

import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

public class okHttpUtil {

    /**
     * 登录
     *
     * @param url
     * @param phone    手机号
     * @param Pwd      密码
     * @param callback
     */
    public static void login(String url, String phone, String Pwd, Callback callback) {
        OkHttpClient client = new OkHttpClient();
        RequestBody body = new FormBody.Builder()
                .add("mobile", phone)
                .add("password", Pwd)
                .build();
        Request request = new Request.Builder().url(url).post(body).build();
        client.newCall(request).enqueue(callback);
    }

    /**
     * 注册
     *
     * @param url
     * @param mobile   手机号
     * @param password 密码
     * @param code     验证码
     * @param nick     昵称
     * @param callback
     */
    public static void register(String url, String mobile, String password, String code, String nick, Callback callback) {
        OkHttpClient client = new OkHttpClient();
        RequestBody body = new FormBody.Builder()
                .add("mobile", mobile)
                .add("password", password)
                .add("code", code)
                .add("nick", nick)
                .build();
        Request request = new Request.Builder().url(url).post(body).build();
        client.newCall(request).enqueue(callback);
    }

    /**
     * 获取验证码
     *
     * @param url
     * @param mobile   手机号
     * @param callback
     */
    public static void getCode(String url, String mobile, String type, Callback callback) {
        OkHttpClient client = new OkHttpClient();
        RequestBody body = new FormBody.Builder()
                .add("mobile", mobile)
                .add("type", type)
                .build();
        Request request = new Request.Builder().post(body).url(url).build();
        client.newCall(request).enqueue(callback);
    }

    /**
     * 找回密码
     *
     * @param url
     * @param mobile   手机号
     * @param password 密码
     * @param code     验证码
     * @param callback
     */
    public static void findPwd(String url, String mobile, String password, String code, Callback callback) {
        OkHttpClient client = new OkHttpClient();
        RequestBody body = new FormBody.Builder()
                .add("mobile", mobile)
                .add("password", password)
                .add("code", code)
                .build();
        Request request = new Request.Builder().post(body).url(url).build();
        client.newCall(request).enqueue(callback);
    }

    /**
     * 退出登录
     *
     * @param url
     * @param sessionId sessiondId
     * @param callback
     */
    public static void logout(String url, String sessionId, Callback callback) {
        OkHttpClient client = new OkHttpClient();
        RequestBody body = new FormBody.Builder()
                .add("sessionId", sessionId)
                .build();
        Request request = new Request.Builder().post(body).url(url).build();
        client.newCall(request).enqueue(callback);
    }

    /**
     * 修改密码
     *
     * @param url
     * @param sessionId sessuibId
     * @param oldPwd    旧密码
     * @param newPwd    新密码
     * @param callback
     */
    public static void uodatePed(String url, String sessionId, String oldPwd, String newPwd, Callback callback) {
        OkHttpClient client = new OkHttpClient();
        RequestBody body = new FormBody.Builder()
                .add("sessionId", sessionId)
                .add("oldPwd", oldPwd)
                .add("newPwd", newPwd)
                .build();
        Request request = new Request.Builder().post(body).url(url).build();
        client.newCall(request).enqueue(callback);
    }


    /**
     * 获取系统文本信息
     *
     * @param id       1：用户协议，2：关于我们 3:本港台直播 4：彩票开奖
     * @param url
     * @param callback
     */
    public static void content(String url, String id, Callback callback) {
        OkHttpClient client = new OkHttpClient();
        RequestBody body = new FormBody.Builder()
                .add("id", id)
                .build();
        Request request = new Request.Builder().post(body).url(url).build();
        client.newCall(request).enqueue(callback);
    }
}
