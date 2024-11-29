package com.shane.alumni.Repository;

import com.shane.alumni.Entity.AlumniOrganization;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlumniOrganizationRepository extends JpaRepository<AlumniOrganization, Long> {
}