package cn.demon.hello.bean;

/**
 * Created by zhangxutong .
 * Date: 16/08/28
 */

public class CityBean extends BaseIndexPinyinBean {

    private String city;//城市名字
    private int img;    //头像
    private boolean isTop;//是否是最上面的 不需要被转化成拼音的

    public CityBean() {
    }

    public CityBean(String city, int img) {
        this.city = city;
        this.img = img;
    }

    public CityBean(String city) {
        this.city = city;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getCity() {
        return city;
    }

    public CityBean setCity(String city) {
        this.city = city;
        return this;
    }

    public boolean isTop() {
        return isTop;
    }

    public CityBean setTop(boolean top) {
        isTop = top;
        return this;
    }

    @Override
    public String getTarget() {
        return city;
    }

    @Override
    public boolean isNeedToPinyin() {
        return !isTop;
    }


    @Override
    public boolean isShowSuspension() {
        return !isTop;
    }
}
