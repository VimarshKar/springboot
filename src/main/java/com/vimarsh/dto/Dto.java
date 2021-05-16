package com.vimarsh.dto;

import com.vimarsh.util.CustomDateAndTimeDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;

import java.util.Date;

@Data
public class Dto {
    private Long id;
    //pickup
    private String pickupName;
    private String pickupAddress;
    @JsonDeserialize(using= CustomDateAndTimeDeserialize.class)
    private Date pickupDateTime;
    private String[] pickupContactNumbers;
    private String pickupComment;
    //drop
    private String dropName;
    private String dropAddress;
    private String[] dropContactNumbers;
    private String dropComment;
}
