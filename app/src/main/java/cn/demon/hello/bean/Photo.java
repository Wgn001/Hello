package cn.demon.hello.bean;

public class Photo {

    private String date;
    private String content;
    private int img;
    private int dz_data;
    private int comment_data;

    public Photo() {
    }

    public Photo(String date, String content, int img, int dz_data, int comment_data) {
        this.date = date;
        this.content = content;
        this.img = img;
        this.dz_data = dz_data;
        this.comment_data = comment_data;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public int getDz_data() {
        return dz_data;
    }

    public void setDz_data(int dz_data) {
        this.dz_data = dz_data;
    }

    public int getComment_data() {
        return comment_data;
    }

    public void setComment_data(int comment_data) {
        this.comment_data = comment_data;
    }
}
