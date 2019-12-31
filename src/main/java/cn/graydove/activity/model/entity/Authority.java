package cn.graydove.activity.model.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Authority {

    @Id
    private Integer id;

    private String name;
}
