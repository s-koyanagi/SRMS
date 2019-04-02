package com.example.srms.domain.entity;

import lombok.Getter;
import lombok.Setter;
import org.seasar.doma.*;

import java.util.Date;

@Setter
@Getter
@Entity
@Table(name="guests")
public class Guest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int guest_id;
    private int seminar_id;
    private String user_id;
    private Date created_at;
    private Date updated_at;
    private Date deleted_at;
    @Version
    private Integer version;

}
