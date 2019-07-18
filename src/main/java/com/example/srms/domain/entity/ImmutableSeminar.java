package com.example.srms.domain.entity;

import lombok.Value;
import org.seasar.doma.*;

import java.util.Date;

@Entity(immutable = true)
@Table(name="seminars")
@Value
public class ImmutableSeminar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="title")
    private String title;
    @Column(name = "overview")
    private String overview;
    @Column(name = "started_at")
    private String startedTime;
    @Column(name = "closed_at")
    private String closedTime;
    @Column(name = "created_at")
    private Date createdDateTime;
    @Column(name = "updated_at")
    private Date updatedDateTime;
    @Column(name = "deleted_at")
    private Date deletedDateTime;
    @Column(name = "accepting_flag")
    private Integer acceptingFlag;
    @Version
    @Column(name = "version")
    private Integer version;



}
