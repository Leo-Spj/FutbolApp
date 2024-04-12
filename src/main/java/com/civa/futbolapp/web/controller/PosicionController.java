package com.civa.futbolapp.web.controller;

import com.civa.futbolapp.persistence.entity.PosicionEntity;
import com.civa.futbolapp.service.PosicionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posicion")
public class PosicionController {

    private final PosicionService service;

    @Autowired
    public PosicionController(PosicionService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<PosicionEntity>> getAll(){
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PosicionEntity> getById(Integer id){
        return ResponseEntity.ok(service.getByID(id));
    }

    @PostMapping
    public ResponseEntity<PosicionEntity> save(PosicionEntity posicion){
        return ResponseEntity.ok(service.save(posicion));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PosicionEntity> update(Integer id, PosicionEntity posicion){
        return ResponseEntity.ok(service.update(id, posicion));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PosicionEntity> delete(Integer id){
        return ResponseEntity.ok(service.delete(id));
    }
}
