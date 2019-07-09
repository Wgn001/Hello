package cn.demon.hello.Util;

import com.google.gson.Gson;

/**
 *
 *
 * @author Gn W
 * @date 19.7.9
 */
public class JsonUtil {

    public static <T> T parseJson(String jsonData,Class<T> clazz){
        T resutle=null;
        if(!jsonData.isEmpty()){
            Gson gson=new Gson();
            resutle =gson.fromJson(jsonData,clazz);
        }
        return resutle;
    }



}
