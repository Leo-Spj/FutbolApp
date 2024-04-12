package com.civa.futbolapp.web.controller;

import com.civa.futbolapp.persistence.entity.FutbolistaEntity;
import com.civa.futbolapp.service.FutbolistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/futbolista")
public class FutbolistaController {

    private final FutbolistaService futbolistaService;

    @Autowired
    public FutbolistaController(FutbolistaService futbolistaService) {
        this.futbolistaService = futbolistaService;
    }

    @GetMapping
    public ResponseEntity<Page<FutbolistaEntity>> getAll(@RequestParam(defaultValue = "0") int page,
                                                         @RequestParam(defaultValue = "3") int size){
        return ResponseEntity.ok(futbolistaService.getAll(page, size));
    }

    @GetMapping("/{id}")
    public ResponseEntity<FutbolistaEntity> getById(@PathVariable Integer id){
        return ResponseEntity.ok(futbolistaService.getByID(id));
    }

    @PostMapping
    public ResponseEntity<FutbolistaEntity> save(@RequestBody FutbolistaEntity futbolista){
        return ResponseEntity.ok(futbolistaService.save(futbolista));
    }

    @PutMapping("/{id}")
    public ResponseEntity<FutbolistaEntity> update(@PathVariable Integer id, @RequestBody FutbolistaEntity futbolista){
        return ResponseEntity.ok(futbolistaService.update(id, futbolista));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<FutbolistaEntity> delete(@PathVariable Integer id){
        return ResponseEntity.ok(futbolistaService.delete(id));
    }


}
