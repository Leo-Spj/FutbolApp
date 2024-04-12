package com.civa.futbolapp.service;

import com.civa.futbolapp.persistence.entity.PosicionEntity;
import com.civa.futbolapp.persistence.repository.PosicionRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PosicionService {

    private final PosicionRepository posicionRepository;

    public PosicionService(PosicionRepository posicionRepository) {
        this.posicionRepository = posicionRepository;
    }



    public boolean exists(Integer id){
        return posicionRepository.existsById(id);
    }

    public PosicionEntity getByID(Integer id) {
        return posicionRepository.findById(id).orElse(null);
    }

    public List<PosicionEntity> getAll(){
        return posicionRepository.findAll();
    }



    public PosicionEntity save(PosicionEntity posicion){
        return posicionRepository.save(posicion);
    }

    public PosicionEntity update(Integer id, PosicionEntity posicion){
        if(posicionRepository.existsById(id)){
            return posicionRepository.save(posicion);
        }
        return null;
    }

    public PosicionEntity delete(Integer id){
        if(posicionRepository.existsById(id)){
            PosicionEntity posicion = posicionRepository.findById(id).get();
            posicionRepository.deleteById(id);
            return posicion;
        }
        return null;
    }
}
