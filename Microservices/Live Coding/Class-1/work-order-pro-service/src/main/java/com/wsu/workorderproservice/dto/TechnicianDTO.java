package com.wsu.workorderproservice.dto;

import java.lang.Thread.State;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TechnicianDTO {

    private String code;
    private String firstName;
    private String lastName;
    private String type;
    private String latestWorkOrderStatus;
    private Set<State> workPermits;

}
