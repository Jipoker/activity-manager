package cn.graydove.activity.model.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity
public class Message {

    @Id
    private Integer id;

    private Integer user;

    private String message;

    private Date createTime;

    private Boolean isRead;
}
