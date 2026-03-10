package br.com.senai.sistema_escolar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.senai.sistema_escolar.entity.Aula;
import br.com.senai.sistema_escolar.exception.Response;
import br.com.senai.sistema_escolar.repository.AulaRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/aula")
public class AulaController {

    @Autowired
    private AulaRepository repository;

    @PostMapping
    public Response cadastrarAula(@Valid @RequestBody Aula aula) {
        repository.save(aula);
        return new Response(201, "Aula cadastrada com sucesso!");// Recurso criado com sucesso
    }

    @GetMapping
    public List<Aula> listarTodos() {
        return repository.findAll();
    }

    @PutMapping("/{id}")
    public Response atualizar(@PathVariable Long id, @RequestBody Aula entity) {

        if (!repository.existsById(id)) {
            return new Response(404, "Aula não encontrado");
        }

        Aula aulaAntigo = repository.findById(id).get();

        if (entity.getDataHora() != null) {
            aulaAntigo.setDataHora(entity.getDataHora());
        }
        
        if (entity.getDisciplina() != null) {
            aulaAntigo.setDisciplina(entity.getDisciplina());
        }

         if (entity.getConteudo_programatico() != null) {
            aulaAntigo.setConteudo_programatico(entity.getConteudo_programatico());
        }

        repository.save(aulaAntigo);

        return new Response(200, "Aula atualizado!");
    
    }

        @DeleteMapping("/{id}")
    public Response deleteAula(@PathVariable Long id) {
        if (!repository.existsById(id)) {
            return new Response(404, "Aula não encontrado");
        }
        repository.deleteById(id);
        return new Response(204, "Aula deletado com sucesso");
    



                     
    }

}
