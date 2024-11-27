package com.shane.alumni.Repository;

import com.shane.alumni.Entity.Alumni;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlumniRepository extends JpaRepository<Alumni, Long> {



}
