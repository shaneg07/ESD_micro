package com.shane.alumni.Controller;


import com.shane.alumni.Dto.LoginRequest;
import com.shane.alumni.Dto.RegistrationRequest;
import com.shane.alumni.Dto.SearchRequest;
import com.shane.alumni.Entity.Alumni;
import com.shane.alumni.Exception.InvalidCredentialsException;
import com.shane.alumni.Service.AlumniService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api/alumni/")
@CrossOrigin(origins = "http://localhost:3000")
public class AlumniController {
    private final AlumniService alumniService;

    @PostMapping("login")
    public ResponseEntity<String> loginAlumni(@RequestBody @Valid LoginRequest loginRequest) {
        String token = alumniService.loginAlumni(loginRequest);
        if(token != null)
        {
            return ResponseEntity.ok(token);
        }
        throw new InvalidCredentialsException("Invalid credentials provided.");
    }

    @PostMapping("register")
    public ResponseEntity<String> registerAlumni(@RequestBody @Valid RegistrationRequest registrationRequest) {
        return ResponseEntity.ok(alumniService.registerAlumni(registrationRequest));
    }

    @PostMapping("search")
    public ResponseEntity<Alumni> searchAlumni(@RequestBody @Valid SearchRequest searchRequest) {
        return ResponseEntity.ok(alumniService.searchAlumni(searchRequest));
    }
}