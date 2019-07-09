package cn.demon.hello.Util;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferencesUtil {

    public SharedPreferences sharedPreferences;
    public SharedPreferences.Editor editor;

    public  void saveSessionId(String key,String sessionId, Context context){
        editor=context.getSharedPreferences("data" ,Context.MODE_PRIVATE).edit();
        editor.putString(key,sessionId);
        editor.apply();
    }

    public String readSessionId(String key,Context context){
        sharedPreferences=context.getSharedPreferences("data",Context.MODE_PRIVATE);
        return sharedPreferences.getString(key,"");
    }
}
