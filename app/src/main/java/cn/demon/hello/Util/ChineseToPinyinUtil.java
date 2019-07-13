package cn.demon.hello.Util;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

import cn.demon.hello.bean.Person;
/**
 *
 *中文转拼音工具类
 * @author Gn.w
 * @date 19.7.13
 */
public class ChineseToPinyinUtil {

    public static Person getPingyin(Person person){
        HanyuPinyinOutputFormat format =new HanyuPinyinOutputFormat();
        format.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        format.setVCharType(HanyuPinyinVCharType.WITH_V);
        char[] input= person.getName().trim().toCharArray();
        String output="";
        try{
            for (char curchar:input){
                if(java.lang.Character.toString(curchar).matches("[\\u4E00-\\u9FA5]+")){
                    String[] temp= PinyinHelper.toHanyuPinyinStringArray(curchar,format);
                    output+=temp[0];
                }else{
                    output+=java.lang.Character.toString(curchar);
                }
            }
        }catch (BadHanyuPinyinOutputFormatCombination e){
            e.printStackTrace();
        }
        return person.setPinYin(output);
    }


}
