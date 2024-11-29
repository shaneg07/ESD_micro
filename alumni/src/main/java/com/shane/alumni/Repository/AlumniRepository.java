package com.shane.alumni.Repository;

import com.shane.alumni.Entity.Alumni;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AlumniRepository extends JpaRepository<Alumni, Long> {


    Optional<Alumni> findByFirstNameAndLastNameAndEmail(String firstName, String lastName, String email);

    Alumni findByEmail(String email);
}
