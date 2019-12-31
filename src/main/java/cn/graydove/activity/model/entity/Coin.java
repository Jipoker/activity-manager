package cn.graydove.activity.model.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Coin {

    @Id
    private Integer id;

    private Long number;

}
