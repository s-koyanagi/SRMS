package com.example.srms.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DashboardDTO {

    private int numberOfGuest;
    private String titleOfAcceptingSeminar;
    private int numberOfTotalGuest;
    private int numberOfSeminar;
    private int numberOfMaximumGuest;
    private String titleOfMaximumGuest;
    private double numberOfAverageGuest;

}
