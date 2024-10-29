package com.wsu.workorderproservice.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class CustomerDTO {

    private Integer id;
    @NotBlank(message = "First Name must not be null or blank")
    @Size(max = 20)
    private String firstName;
    @NotBlank(message = "Last Name must not be null or blank")
    @Size(max = 25)
    private String lastName;
    @NotBlank(message = "Address Line1 must not be null or blank")
    @Size(max = 50)
    private String addressLine1;
    @Size(max = 50)
    private String addressLine2;
    @NotBlank(message = "City must not be null or blank")
    @Size(max = 25)
    private String city;
    @NotBlank(message = "State must not be null or blank")
    @Size(max = 2)
    private String state;
    @NotBlank(message = "Zip must not be null or blank")
    @Size(max = 5)
    private String zip;
    @NotBlank(message = "Phone number must not be null or blank")
    @Size(max = 10)
    private String phone;
    @NotBlank(message = "Email must not be null or blank")
    @Size(max = 100)
    private String email;
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss a")
    private Date dateAdded;
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss a")
    private Date dateLastUpdated;
    private String latestWorkOrderStatus;
}
