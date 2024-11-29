package com.shane.alumni.Repository;

import com.shane.alumni.Entity.AlumniEducation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AlumniEducationRepository extends JpaRepository<AlumniEducation, Long> {
    Optional<AlumniEducation> findByAlumniIdAndPassingYear(Long id, int i);
}
