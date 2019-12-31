package cn.graydove.activity.model.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity
public class CoinLog {

    @Id
    private Integer id;

    private String reason;

    private Long opera;

    private Integer target;

    private Date createTime;

}
