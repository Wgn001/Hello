package cn.demon.hello.Util;

import android.content.Context;
import android.content.SharedPreferences;
/**
 *
 *接口返回数据类
 * @author Gn.w
 * @date 19.7.13
 */
public class SharedPreferencesUtil {

    public SharedPreferences sharedPreferences;
    public SharedPreferences.Editor editor;

    public  void save(String key,String login__json, Context context){
        editor=context.getSharedPreferences("data" ,Context.MODE_PRIVATE).edit();
        editor.putString(key,login__json);
        editor.apply();
    }

    public String read(String key,Context context){
        sharedPreferences=context.getSharedPreferences("data",Context.MODE_PRIVATE);
        return sharedPreferences.getString(key,"");
    }
}
