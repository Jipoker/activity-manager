package cn.graydove.activity.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Data
@Entity
public class User {

    @Id
    private Integer id;

    private String name;

    private Long phoneNumber;

    private String nickname;

    private String password;

    private Integer role;

    private Boolean sex;

    private Date birth;

    private String introduce;

    private Boolean isEnable;

    @OneToMany(targetEntity = Authority.class, fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_authorities",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "authorities_id", referencedColumnName = "id")
    )
    private Set<Authority> authorities;

    @OneToOne(targetEntity = Coin.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "coin_id", referencedColumnName = "id")
    private Coin coin;
}

