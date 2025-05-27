package com.ygor.ApelidoRomes.services;

import com.ygor.ApelidoRomes.models.ApelidoModels;
import com.ygor.ApelidoRomes.repository.ApelidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class ApelidoService {

    @Autowired
    private ApelidoRepository apelidoRepository;

    public ApelidoModels salvar(ApelidoModels apelido) {
        return apelidoRepository.save(apelido);
    }

    // Listar todos os apelidos
    public List<ApelidoModels> listarTodos() {
        return apelidoRepository.findAll();
    }

    // Buscar por ID
    public Optional<ApelidoModels> buscarPorId(Long id) {
        return apelidoRepository.findById(id);
    }

    // Deletar por ID
    public void deletar(Long id) {
        apelidoRepository.deleteById(id);
    }

    // Atualizar apelido existente
    public Optional<ApelidoModels> atualizar(Long id, ApelidoModels novoApelido) {
        return apelidoRepository.findById(id).map(apelido -> {
            apelido.setApelido(novoApelido.getApelido());
            apelido.setAutor(novoApelido.getAutor());
            return apelidoRepository.save(apelido);
        });
    }
}