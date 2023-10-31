package com.javaguides.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.javaguides.springboot.domains.Keypoints;

public interface KeypointsRepo extends JpaRepository<Keypoints, Integer>{
}
