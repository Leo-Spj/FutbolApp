package com.civa.futbolapp.persistence.repository;

import com.civa.futbolapp.persistence.entity.PosicionEntity;
import org.springframework.data.repository.ListCrudRepository;

public interface PosicionRepository extends ListCrudRepository<PosicionEntity, Integer> {
}
