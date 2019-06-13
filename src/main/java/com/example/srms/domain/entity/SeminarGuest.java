package com.example.srms.domain.entity;

import lombok.Getter;
import lombok.Setter;
import org.seasar.doma.*;

@Entity
@Setter
@Getter
public class SeminarGuest extends Seminar{

    @Column(name="NUMBER_OF_GUEST")
    private int numberOfGuest;

}
