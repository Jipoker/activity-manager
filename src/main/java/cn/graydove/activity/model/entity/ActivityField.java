package cn.graydove.activity.model.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class ActivityField {

    @Id
    private Integer id;

    private String name;
}
