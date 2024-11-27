package com.shane.alumni.Service;

import com.shane.alumni.Dto.AlumniDto;

import java.util.List;

public interface AlumniService {

    AlumniDto createAlumni(AlumniDto alumniDto);

    AlumniDto getAlumniById(Long alumniId);

    List<AlumniDto> getAllAlumni();

    AlumniDto updateAlumni(Long alumniId, AlumniDto updatedAlumni);

    void deleteAlumni(Long alumniId);

}
