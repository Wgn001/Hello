package cn.demon.hello.bean;

import java.io.Serializable;

public  class Login implements Serializable {

    public int code;
    public Data data;
    public String desc;

    public class Data implements Serializable{
        public String xcxId;
        public String registerIp;
        public String salt;
        public String weichatId;
        public String registerTime;
        public String ryToken;
        public String mobile;
        public String updateTime;
        public String sessionId;
        public String avatar;
        public int type;
        public String qqId;
        public String nick;
        public String topicWallImg;
        public String createTime;
        public String otherIds;
        public long id;
        public int state;
        public String sinaId;
        public int topicOpen;
        public String account;
        public String email;

        @Override
        public String toString() {
            return "Data{" +
                    "xcxId='" + xcxId + '\'' +
                    ", registerIp='" + registerIp + '\'' +
                    ", salt='" + salt + '\'' +
                    ", weichatId='" + weichatId + '\'' +
                    ", registerTime='" + registerTime + '\'' +
                    ", ryToken='" + ryToken + '\'' +
                    ", mobile=" + mobile +
                    ", updateTime='" + updateTime + '\'' +
                    ", sessionId='" + sessionId + '\'' +
                    ", avatar='" + avatar + '\'' +
                    ", type=" + type +
                    ", qqId='" + qqId + '\'' +
                    ", nick='" + nick + '\'' +
                    ", topicWallImg='" + topicWallImg + '\'' +
                    ", createTime='" + createTime + '\'' +
                    ", otherIds='" + otherIds + '\'' +
                    ", id=" + id +
                    ", state=" + state +
                    ", sinaId='" + sinaId + '\'' +
                    ", topicOpen=" + topicOpen +
                    ", account='" + account + '\'' +
                    ", email='" + email + '\'' +
                    '}';
        }
    }


    @Override
    public String toString() {
        return "Login{" +
                "code=" + code +
                ", data=" + data +
                ", desc='" + desc + '\'' +
                '}';
    }
}
