package com.civa.futbolapp.service;

import com.civa.futbolapp.persistence.entity.FutbolistaEntity;
import com.civa.futbolapp.persistence.repository.FutbolistaPaginSortRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class FutbolistaService{

    private final FutbolistaPaginSortRepository futbolistaRepository;

    @Autowired
    public FutbolistaService(FutbolistaPaginSortRepository futbolistaRepository) {
        this.futbolistaRepository = futbolistaRepository;
    }



    public boolean exists(Integer id){
        return futbolistaRepository.existsById(id);
    }

    public FutbolistaEntity getByID(Integer id) {
        return futbolistaRepository.findById(id).orElse(null);
    }

    public Page<FutbolistaEntity> getAll(int page, int size){
        PageRequest pageRequest = PageRequest.of(page, size, Sort.by("id").descending());
        return futbolistaRepository.findAll(pageRequest);
    }



    public FutbolistaEntity save(FutbolistaEntity futbolista){
        return futbolistaRepository.save(futbolista);
    }

    public FutbolistaEntity update(Integer id, FutbolistaEntity futbolista){
        if(futbolistaRepository.existsById(id)){
            return futbolistaRepository.save(futbolista);
        }
        return null;
    }

    public FutbolistaEntity delete(Integer id){
        if(futbolistaRepository.existsById(id)){
            FutbolistaEntity futbolista = futbolistaRepository.findById(id).get();
            futbolistaRepository.deleteById(id);
            return futbolista;
        }
        return null;
    }
}
