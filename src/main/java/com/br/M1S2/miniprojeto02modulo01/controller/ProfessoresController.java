package com.br.M1S2.miniprojeto02modulo01.controller;
import com.br.M1S2.miniprojeto02modulo01.entities.ProfessoresEntity;
import com.br.M1S2.miniprojeto02modulo01.services.ProfessoresService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professores")
@RequiredArgsConstructor
public class ProfessoresController {

    private  final ProfessoresService service;

    @GetMapping("{id}")
    public ResponseEntity<ProfessoresEntity> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<ProfessoresEntity>> get() {
        var all = service.getAll();
        return ResponseEntity.ok(all);
    }

    @PutMapping("{id}")
    public ResponseEntity<ProfessoresEntity> put(@PathVariable Long id, @RequestBody ProfessoresEntity entity) {
        return ResponseEntity.ok(service.update(id, entity));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> dell (@PathVariable Long id) {
        service.dell(id);
        return ResponseEntity.noContent().build();
    }
}
