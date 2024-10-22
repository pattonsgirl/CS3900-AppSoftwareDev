package com.wsu.workorderproservice.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.wsu.workorderproservice.model.State;
import java.util.Set;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TechnicianDTO {

    private String code;
    @NotBlank(message = "First Name must not be null or blank")
    private String firstName;
    @NotBlank(message = "Last Name must not be null or blank")
    private String lastName;
    @NotBlank(message = "Technician Type must not be null or blank")
    private String type;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String latestWorkOrderStatus;
    private Set<State> workPermits;
}
