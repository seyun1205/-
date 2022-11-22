package front.all.pojo;

import java.util.Date;

public class Counselor_records {
    private Integer id;
    private Integer from_user_id;
    private Integer to_user_id;
    private String message;
    private Date create_time;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFrom_user_id() {
        return from_user_id;
    }

    public void setFrom_user_id(Integer from_user_id) {
        this.from_user_id = from_user_id;
    }

    public Integer getTo_user_id() {
        return to_user_id;
    }

    public void setTo_user_id(Integer to_user_id) {
        this.to_user_id = to_user_id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    @Override
    public String toString() {
        return "Counselor_records{" +
                "id=" + id +
                ", from_user_id=" + from_user_id +
                ", to_user_id=" + to_user_id +
                ", message='" + message + '\'' +
                ", create_time=" + create_time +
                '}';
    }
}
