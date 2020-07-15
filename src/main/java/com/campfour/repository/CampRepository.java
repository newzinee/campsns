package com.campfour.repository;

import com.campfour.domain.Camp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CampRepository extends JpaRepository<Camp, Long> {
}
