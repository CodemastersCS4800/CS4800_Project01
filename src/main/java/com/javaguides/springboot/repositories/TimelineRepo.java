package com.javaguides.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.javaguides.springboot.domains.Timeline;

public interface TimelineRepo extends JpaRepository<Timeline, Integer>{
}
