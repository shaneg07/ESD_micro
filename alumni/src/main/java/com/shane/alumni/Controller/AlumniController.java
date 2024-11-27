package com.shane.alumni.Controller;


import com.shane.alumni.Dto.AlumniDto;
import com.shane.alumni.Entity.Alumni;
import com.shane.alumni.Service.AlumniService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/alumni")
public class AlumniController {
    private AlumniService alumniService;

    //Add alumni post API
    @PostMapping
    public ResponseEntity<AlumniDto> createAlumni(@RequestBody AlumniDto alumniDto) {
        AlumniDto savedAlumni = alumniService.createAlumni(alumniDto);
        return new ResponseEntity<>(savedAlumni, HttpStatus.CREATED);
    }

    //Add alumni get API
    @GetMapping("{id}")
    public ResponseEntity<AlumniDto> getAlumniById(@PathVariable("id") Long alumniId) {
        AlumniDto alumniDto = alumniService.getAlumniById(alumniId);
        return ResponseEntity.ok(alumniDto);
    }

    //Add alumni get All API
    @GetMapping
    public ResponseEntity<List<AlumniDto>> getAllAlumni(){
        List<AlumniDto> alumniList = alumniService.getAllAlumni();
        return ResponseEntity.ok(alumniList);
    }
}
