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
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(sequence = "GUESTS_GUEST_ID_SEQ")
    private int guestId;
    @Column(name="seminar_id")
    private int seminarId;
    @Column(name="esq_id")
    private String esqId;
    @Column(name="prior_question")
    private String priorQuestion;
    @Column(name="created_at")
    private Date createdDateTime;
    @Column(name="updated_at")
    private Date updatedDateTime;
    @Column(name="deleted_at")
    private Date deletedDateTime;
    @Version
    @Column(name="version")
    private Integer version;

}
