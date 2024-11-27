package com.shane.alumni.Dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AlumniDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;

}
