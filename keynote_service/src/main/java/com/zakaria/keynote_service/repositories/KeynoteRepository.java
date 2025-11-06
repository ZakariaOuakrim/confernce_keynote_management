package com.zakaria.keynote_service.repositories;

import com.zakaria.keynote_service.entities.Keynote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface KeynoteRepository extends JpaRepository<Keynote,Long> {
}
