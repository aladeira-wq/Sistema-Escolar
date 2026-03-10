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

import br.com.senai.sistema_escolar.entity.Nota;
import br.com.senai.sistema_escolar.exception.Response;
import br.com.senai.sistema_escolar.repository.NotaRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/nota")
public class NotaController {

    @Autowired
    private NotaRepository repository;

    @PostMapping
    public Response cadastrarNota(@Valid @RequestBody Nota nota) {
        repository.save(nota);
        return new Response(201, "Nota cadastrado com sucesso!");

    }

    @GetMapping
    public List<Nota> listarTodos() {
        return repository.findAll();
    }

    @PutMapping("/{id}")
    public Response atualizar(@PathVariable Long id, @RequestBody Nota entity) {

        if (!repository.existsById(id)) {
            return new Response(404, "Nota não encontrado");
        }

        Nota notaAntigo = repository.findById(id).get();

        repository.save(notaAntigo);

        return new Response(200, "nota atualizada");
    }
    // notaAntigo = repository.findById(id).get();

    @DeleteMapping("/{id}")
    public Response deletar(@PathVariable Long id) {

        if (!repository.existsById(id)) {
            return new Response(404, "Nota não encontrado");
        }

        repository.deleteById(id);

        return new Response(204, "Nota deletado com sucesso");
    }

}
