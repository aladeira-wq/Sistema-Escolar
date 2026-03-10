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

import br.com.senai.sistema_escolar.entity.Professor;
import br.com.senai.sistema_escolar.exception.Response;
import br.com.senai.sistema_escolar.repository.ProfessorRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/professor")
public class ProfessorController {

  @Autowired
  private ProfessorRepository repository;

  @PostMapping
  public Response cadastrarProfessor(@Valid @RequestBody Professor professor) {
    repository.save(professor);
    return new Response(201, "Professor cadastrado com sucesso!");// Recurso criado com sucesso
  }

  @GetMapping
  public List<Professor> returnTodos() {
    return repository.findAll();
  }

  @PutMapping("/{id}")
  public Response Atualizar(@PathVariable Long id, @RequestBody Professor entity) {

    if (!repository.existsById(id)) {
      return new Response(404, "Professor não encontrado");// Quando tentar realiza por exemplo a atualização de um
                                                           // animal que não existe
    }

    Professor professorAntigo = repository.findById(id).get();
    {

      if (entity.getNome() != null) {
        professorAntigo.setNome(entity.getNome());
      }

      if (entity.getEmail() != null) {
        professorAntigo.setEmail(entity.getEmail());
      }

      if (entity.getTitulacao() != null) {
        professorAntigo.setTitulacao(entity.getTitulacao());
      }

      repository.save(professorAntigo);

      return new Response(200, "professor atualizado!");// O professor foi encontrado e atualizado

    }

  }

@DeleteMapping("/{id}")
  public Response deleteProfessor(@PathVariable Long id) {

    if (!repository.existsById(id)) {
      return new Response(404, "Professor não encontrado");//Quando tentar deletar um professor que não existe
    }

    repository.deleteById(id);

    return new Response(204, "Professor deletado com sucesso");// O professor foi deletado com sucesso ma tal ato não tem um retorno portanto recebe como se fosse um "erro"
  }






}
