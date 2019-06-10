package com.example.srms.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DashboardDTO {

    private int numberOfGuest;
    private int numberOfTotalGuest;
    private int numberOfHighestGuest;
    private int numberOfAverageGuest;

}
