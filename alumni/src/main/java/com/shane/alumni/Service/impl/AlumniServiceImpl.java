package com.shane.alumni.Service.impl;

import com.shane.alumni.Dto.AlumniDto;
import com.shane.alumni.Entity.Alumni;
import com.shane.alumni.Exception.ResourceNotFound;
import com.shane.alumni.Mapper.AlumniMapper;
import com.shane.alumni.Repository.AlumniRepository;
import com.shane.alumni.Service.AlumniService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

        Alumni alumni = alumniRepository.findById(alumniId)
                .orElseThrow(() -> new ResourceNotFound("Alumni with given ID does not exist - " + alumniId));

        return AlumniMapper.mapToAlumniDto(alumni);
    }

    @Override
    public List<AlumniDto> getAllAlumni() {
        List<Alumni> alumniList = alumniRepository.findAll();
        return alumniList.stream().map((alumni) -> AlumniMapper.mapToAlumniDto(alumni))
                .collect(Collectors.toList());
    }

    @Override
    public AlumniDto updateAlumni(Long alumniId, AlumniDto updatedAlumni) {

        Alumni alumni = alumniRepository.findById(alumniId).orElseThrow(
                () -> new ResourceNotFound("Alumni Id does not exist - " + alumniId)
        );

        alumni.setFirstName(updatedAlumni.getFirstName());
        alumni.setLastName(updatedAlumni.getLastName());
        alumni.setEmail(updatedAlumni.getEmail());

        Alumni updatedAlumniObj = alumniRepository.save(alumni);

        return AlumniMapper.mapToAlumniDto(updatedAlumniObj);
    }
}
