package com.shane.alumni.Controller;


import com.shane.alumni.Dto.AlumniDto;
import com.shane.alumni.Entity.Alumni;
import com.shane.alumni.Service.AlumniService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/alumni")
public class AlumniController {
    private AlumniService alumniService;

    //Add alumni API
    @PostMapping
    public ResponseEntity<AlumniDto> createAlumni(@RequestBody AlumniDto alumniDto) {
        AlumniDto savedAlumni = alumniService.createAlumni(alumniDto);
        return new ResponseEntity<>(savedAlumni, HttpStatus.CREATED);
    }

}
