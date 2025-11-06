package com.zakaria.confernce.repositories;

import com.zakaria.confernce.entities.Conference;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ConferenceRepository extends JpaRepository<Conference,Long> {
}
