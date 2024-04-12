package com.civa.futbolapp.persistence.repository;

import com.civa.futbolapp.persistence.entity.FutbolistaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.ListPagingAndSortingRepository;

public interface FutbolistaPaginSortRepository extends ListPagingAndSortingRepository<FutbolistaEntity, Integer>,
                                                        JpaRepository<FutbolistaEntity, Integer> {
}
