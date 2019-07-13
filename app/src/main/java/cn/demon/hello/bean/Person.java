package cn.demon.hello.bean;

import java.io.Serializable;

/**
 *
 *用户对象实体类
 * @author Gn.w
 * @date 19.7.13
 */
public class Person implements Serializable {

    private String name;
    private int imgId;
    private String pinYin;
    private int TYPE;

    public Person() {
    }

    public Person(String name, int imgId) {
        this.name = name;
        this.imgId = imgId;
    }

    public Person(String name, int imgId, String pinYin) {
        this.name = name;
        this.imgId = imgId;
        this.pinYin = pinYin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    public String getPinYin() {
        return pinYin;
    }

    public Person setPinYin(String pinYin) {
        this.pinYin = pinYin;
        return this;
    }

    public int getTYPE() {
        return TYPE;
    }

    public Person setTYPE(int TYPE) {
        this.TYPE = TYPE;
        return this;
    }
}
