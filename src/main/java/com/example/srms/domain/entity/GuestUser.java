package com.example.srms.domain.entity;

import lombok.Getter;
import lombok.Setter;
import org.seasar.doma.Column;
import org.seasar.doma.Entity;

@Getter
@Setter
@Entity
public class GuestUser extends Guest {

    @Column(name="name")
    private String name;

}
