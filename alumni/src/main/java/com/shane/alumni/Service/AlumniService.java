package com.shane.alumni.Service;

import com.shane.alumni.Dto.LoginRequest;
import com.shane.alumni.Dto.RegistrationRequest;
import com.shane.alumni.Dto.SearchRequest;
import com.shane.alumni.Entity.Alumni;
import com.shane.alumni.Entity.AlumniEducation;
import com.shane.alumni.Entity.AlumniOrganization;
import com.shane.alumni.Exception.ResourceNotFoundException;
import com.shane.alumni.Helper.JwtUtil;
import com.shane.alumni.Repository.AlumniEducationRepository;
import com.shane.alumni.Repository.AlumniOrganizationRepository;
import com.shane.alumni.Repository.AlumniRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AlumniService {

    private final AlumniRepository alumniRepository;
    private final AlumniEducationRepository alumniEducationRepository;
    private final AlumniOrganizationRepository alumniOrganizationRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public String registerAlumni(RegistrationRequest registrationRequest) {
        Alumni alumni = new Alumni();
        AlumniEducation ae = new AlumniEducation();
        AlumniOrganization ao = new AlumniOrganization();

        alumni.setFirstName(registrationRequest.firstName());
        alumni.setLastName(registrationRequest.lastName());
        alumni.setEmail(registrationRequest.email());
        alumni.setPassword(passwordEncoder.encode(registrationRequest.password()));
        alumni.setContactNo(registrationRequest.contactNo());
        alumniRepository.save(alumni);

        ae.setAlumni(alumni);
        ae.setDegree(registrationRequest.degree());
        ae.setPassingYear(registrationRequest.passingYear());
        ae.setJoiningYear(registrationRequest.joiningYear());
        ae.setCollegeName(registrationRequest.collegeName());
        ae.setAddress(registrationRequest.address());
        alumniEducationRepository.save(ae);

        ao.setAlumni(alumni);
        ao.setOrganizationName(registrationRequest.organizationName());
        ao.setPosition(registrationRequest.position());
        ao.setJoiningDate(registrationRequest.joiningDate());
        ao.setLeavingDate(registrationRequest.leavingDate());
        alumniOrganizationRepository.save(ao);

        return "Registration Successful";
    }

    public Alumni searchAlumni(SearchRequest searchRequest) {
        if(alumniRepository.findByFirstNameAndLastNameAndEmail(searchRequest.firstName(), searchRequest.lastName(), searchRequest.email()).isPresent())
        {
            Alumni alumni = alumniRepository.findByFirstNameAndLastNameAndEmail(searchRequest.firstName(), searchRequest.lastName(), searchRequest.email()).orElse(null);
            if(alumniEducationRepository.findByAlumniIdAndPassingYear(alumni.getId(), searchRequest.passingYear()).isPresent())
                return alumni;
        }
        throw new ResourceNotFoundException("Alumni not found with the provided details.");
    }

    public String loginAlumni(LoginRequest loginRequest) {
        Alumni alumni = alumniRepository.findByEmail(loginRequest.email());

        if(alumni == null)
            return null;
        else if(!passwordEncoder.matches(loginRequest.password(), alumni.getPassword()))
        {
            return null;
        }
        return jwtUtil.generateToken(loginRequest.email());
    }
}
