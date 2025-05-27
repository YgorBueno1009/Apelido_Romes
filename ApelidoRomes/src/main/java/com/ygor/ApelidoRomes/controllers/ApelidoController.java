package com.ygor.ApelidoRomes.controllers;

import com.ygor.ApelidoRomes.models.ApelidoModels;
import com.ygor.ApelidoRomes.services.ApelidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/apelidos")
public class ApelidoController {

    @Autowired
    private ApelidoService apelidoService;

    public ApelidoController(ApelidoService apelidoService) {
        this.apelidoService = apelidoService;
    }

    @GetMapping
    public List<ApelidoModels> listarApelidos() {
        return apelidoService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApelidoModels> buscarApelido(@PathVariable Long id) {
        return apelidoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/criarApelido")
    public ResponseEntity<ApelidoModels> criarApelido(@RequestBody ApelidoModels apelido) {
        ApelidoModels salvo = apelidoService.salvar(apelido); // Agora sim
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApelidoModels> atualizarApelido(@PathVariable Long id, @RequestBody ApelidoModels apelidoModels) {
        return apelidoService.atualizar(id, apelidoModels)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarApelido(@PathVariable Long id) {
        apelidoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}