package com.javaguides.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.javaguides.springboot.domains.Locations;

public interface LocationsRepo extends JpaRepository<Locations, Integer>{
}
