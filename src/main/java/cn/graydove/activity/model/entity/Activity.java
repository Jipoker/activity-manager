package cn.graydove.activity.model.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Activity {

    @Id
    private Integer id;

    private String name;

    @ManyToOne(targetEntity = User.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "creator_id", referencedColumnName = "id")
    private User creator;

    private String introduce;

    private String address;

    private Date startTime;

    private Date FinishTime;

    @CreatedDate
    private Date createTime;

    private Integer maxNumber;

    private Short status;

    @OneToMany(targetEntity = ActivityField.class, fetch = FetchType.EAGER)
    @JoinTable(
            name = "activity_activity_field",
            joinColumns = @JoinColumn(name = "activity_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "field_id", referencedColumnName = "id")
    )
    private List<ActivityField> activityField;
}
