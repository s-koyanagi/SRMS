package com.example.srms.domain.model;

import lombok.Getter;
import lombok.Setter;
import org.seasar.doma.*;

import java.util.Date;

@Setter
@Getter
@Entity
@Table(name="speakers")
public class SpeakerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int speaker_id;
    private int seminar_id;
    private String name;
    private String theme;
    private Date started_at;
    private Date closed_at;
    private Date created_at;
    private Date updated_at;
    private Date deleted_at;
    @Version
    private Integer version;

}
