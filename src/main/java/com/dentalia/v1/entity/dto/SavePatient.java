package com.dentalia.v1.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class SavePatient {

    private String name;
    
    private String lastname;

    private String email;

    private String phone;

    private String emergency_phone;

}
