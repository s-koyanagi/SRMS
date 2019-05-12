package com.example.srms.domain.entity;

import lombok.Getter;
import lombok.Setter;
import org.seasar.doma.*;

import java.util.Date;

@Setter
@Getter
@Entity
@Table(name="seminars")
public class Seminar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seminar_id")
    private int seminarId;
    @Column(name = "title")
    private String title;
    @Column(name = "overview")
    private String overview;
    @Column(name = "started_at")
    private Date startedTime;
    @Column(name = "closed_at")
    private Date closedTime;
    @Column(name = "created_at")
    private Date createdDateTime;
    @Column(name = "updated_at")
    private Date updatedDateTime;
    @Column(name = "deleted_at")
    private Date deletedDateTime;
    @Column(name = "accepting_flag")
    private int acceptingFlag;
    @Version
    @Column(name = "version")
    private Integer version;

}
