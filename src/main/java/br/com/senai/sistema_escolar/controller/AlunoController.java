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

import br.com.senai.sistema_escolar.entity.Aluno;
import br.com.senai.sistema_escolar.exception.Response;
import br.com.senai.sistema_escolar.repository.*;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/aluno")
public class AlunoController {

  @Autowired
  private AlunoRepository repository;

  @PostMapping
  public Response cadastrarTelefone(@Valid @RequestBody Aluno aluno) {
    repository.save(aluno);
    return new Response(201, "Aluno cadastrado com sucesso!");

  }

  @GetMapping
  public List<Aluno> listarTodos() {
    return repository.findAll();
  }

  @PutMapping("/{id}")
  public Response atualizar(@PathVariable Long id, @RequestBody Aluno entity) {

    if (!repository.existsById(id)) {
      return new Response(404, "Telefone não encontrado");
    }

    Aluno alunoAntigo = repository.findById(id).get();

    if (entity.getNome() != null) {
      alunoAntigo.setNome(entity.getNome());
    }
    if (entity.getMatricula() != null) {
      alunoAntigo.setMatricula(entity.getMatricula());
    }

    if (entity.getDataNascimento() != null) {
      alunoAntigo.setDataNascimento(entity.getDataNascimento());
    }
    repository.save(alunoAntigo);
    return new Response(200, "Aluno atualizado!");
  }

  @DeleteMapping("/{id}")
  public Response deletar(@PathVariable Long id) {

    if (!repository.existsById(id)) {
      return new Response(404, "aluno não encontrado");
    }

    repository.deleteById(id);

    return new Response(204, "Aluno deletado com sucesso");
  }

}