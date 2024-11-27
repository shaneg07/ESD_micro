package com.shane.alumni.Service.impl;

import com.shane.alumni.Dto.AlumniDto;
import com.shane.alumni.Entity.Alumni;
import com.shane.alumni.Mapper.AlumniMapper;
import com.shane.alumni.Repository.AlumniRepository;
import com.shane.alumni.Service.AlumniService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AlumniServiceImpl implements AlumniService {

    private AlumniRepository alumniRepository;
    @Override
    public AlumniDto createAlumni(AlumniDto alumniDto) {

        Alumni alumni = AlumniMapper.mapToAlumni(alumniDto);
        Alumni savedAlumni = alumniRepository.save(alumni);

        return AlumniMapper.mapToAlumniDto(savedAlumni);
    }

    @Override
    public AlumniDto getAlumniById(Long alumniId) {
        return null;
    }
}
