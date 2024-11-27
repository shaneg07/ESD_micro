package com.shane.alumni.Mapper;

import com.shane.alumni.Dto.AlumniDto;
import com.shane.alumni.Entity.Alumni;

public class AlumniMapper {

    public static AlumniDto mapToAlumniDto(Alumni alumni){
        return new AlumniDto(
                alumni.getId(),
                alumni.getFirstName(),
                alumni.getLastName(),
                alumni.getEmail()
        );
    }

    public static Alumni mapToAlumni(AlumniDto alumniDto){
        return new Alumni(
                alumniDto.getId(),
                alumniDto.getFirstName(),
                alumniDto.getLastName(),
                alumniDto.getEmail()
        );
    }
}
