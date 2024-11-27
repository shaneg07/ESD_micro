package com.shane.alumni.Service;

import com.shane.alumni.Dto.AlumniDto;

public interface AlumniService {
    AlumniDto createAlumni(AlumniDto alumniDto);

    AlumniDto getAlumniById(Long alumniId);
}
