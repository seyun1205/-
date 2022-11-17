package front.all.pojo;

public class Knowlege {
    private String kno;
    private String content;

    public String getKno() {
        return kno;
    }

    public void setKno(String kno) {
        this.kno = kno;
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
                ", content='" + content + '\'' +
                '}';
    }
}
