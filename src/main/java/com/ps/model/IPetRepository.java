package com.ps.model;

import com.ps.model.entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

/**
 * JPA Repository.
 */
@Transactional
public interface IPetRepository extends JpaRepository<Pet, Integer> {

}