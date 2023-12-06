package com.javaguides.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.javaguides.springboot.domains.Events;

public interface EventsRepo extends JpaRepository<Events, Integer>{
}
