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

    private final PosicionService posicionService;

    @Autowired
    public PosicionController(PosicionService service) {
        this.posicionService = service;
    }

    @GetMapping
    public ResponseEntity<List<PosicionEntity>> getAll(){
        return ResponseEntity.ok(posicionService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PosicionEntity> getById(@PathVariable Integer id){
        return ResponseEntity.ok(posicionService.getByID(id));
    }

    @PostMapping
    public ResponseEntity<PosicionEntity> save(@RequestBody PosicionEntity posicion){
        return ResponseEntity.ok(posicionService.save(posicion));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PosicionEntity> update(@PathVariable Integer id, @RequestBody PosicionEntity posicion){
        return ResponseEntity.ok(posicionService.update(id, posicion));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PosicionEntity> delete(@PathVariable Integer id){
        return ResponseEntity.ok(posicionService.delete(id));
    }
}
