package com.example.srms.domain.entity;

import lombok.Getter;
import lombok.Setter;
import org.seasar.doma.*;

import java.sql.Time;
import java.util.Date;

@Setter
@Getter
@Entity
@Table(name="speakers")
public class Speaker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "speaker_id")
    private int speakerId;
    @Column(name="seminar_id")
    private int seminarId;
    @Column(name="name")
    private String name;
    @Column(name="theme")
    private String theme;
    @Column(name="started_at")
    private Time startedTime;
    @Column(name="closed_at")
    private Time closedTime;
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
