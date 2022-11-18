package front.all.pojo;

import java.util.Date;

public class Comment {
    private String username;
    private String nickname;
    private String content;
    private Date ctime;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "username='" + username + '\'' +
                ", nickname='" + nickname + '\'' +
                ", content='" + content + '\'' +
                ", ctime=" + ctime +
                '}';
    }
}
