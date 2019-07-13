package cn.demon.hello.Util;

import java.util.Comparator;
import cn.demon.hello.bean.Person;
/**
 *
 *字母排序类
 * @author Gn.w
 * @date 19.7.13
 */
public class ContactComparator implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {

        int c1 = (o1.getPinYin().charAt(0) + "").toUpperCase().hashCode();
        int c2 = (o2.getPinYin().charAt(0) + "").toUpperCase().hashCode();
        //判断是否为字母
        boolean c1Flag = (c1 < "A".hashCode() || c1 > "Z".hashCode());
        //判断是否为字母
        boolean c2Flag = (c2 < "A".hashCode() || c2 > "Z".hashCode());


        if(c1Flag && !c2Flag){
            return 1;
        }else if(!c1Flag && c2Flag){
            return -1;
        }
        return c1-c2;
    }

}
