package front.all.pojo;

public class Knowledge {
    private int kno;
    private String content_title;
    private String content;

    public int getKno() {
        return kno;
    }

    public void setKno(int kno) {
        this.kno = kno;
    }

    public String getContent_title() {
        return content_title;
    }

    public void setContent_title(String content_title) {
        this.content_title = content_title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Knowlege{" +
                "kno='" + kno + '\'' +
                ", content_title='" + content_title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
