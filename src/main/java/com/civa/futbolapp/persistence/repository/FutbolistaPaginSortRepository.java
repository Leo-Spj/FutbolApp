package com.civa.futbolapp.persistence.repository;

import com.civa.futbolapp.persistence.entity.FutbolistaEntity;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.ListPagingAndSortingRepository;

public interface FutbolistaPaginSortRepository extends ListPagingAndSortingRepository<FutbolistaEntity, Integer>,
                                                        ListCrudRepository<FutbolistaEntity, Integer> {
}
