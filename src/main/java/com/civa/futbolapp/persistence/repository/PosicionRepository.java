package com.civa.futbolapp.persistence.repository;

import com.civa.futbolapp.persistence.entity.PosicionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PosicionRepository extends JpaRepository<PosicionEntity, Integer> {
}
