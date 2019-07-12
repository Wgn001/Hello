package cn.demon.hello.bean;

public class Content {

    public  int code;
    public  Data data;
    public  String desc;


    public  class Data{

        public  String createTime;
        public  String name;
        public  int id;
        public  int type;
        public  String content;

        @Override
        public String toString() {
            return "Data{" +
                    "createTime='" + createTime + '\'' +
                    ", name='" + name + '\'' +
                    ", id=" + id +
                    ", type=" + type +
                    ", content='" + content + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "Content{" +
                "code=" + code +
                ", data=" + data +
                ", desc='" + desc + '\'' +
                '}';
    }
}
