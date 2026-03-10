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

import br.com.senai.sistema_escolar.entity.Disciplina;
import br.com.senai.sistema_escolar.exception.Response;
import br.com.senai.sistema_escolar.repository.DisciplinaRepository;


@RestController
@RequestMapping("/disciplina")
public class DisciplinaController {

  @Autowired
  private DisciplinaRepository repository;

  @PostMapping //
  public Response criaDisciplina(@RequestBody Disciplina entity) {
    repository.save(entity);
    return new Response(201, "Disciplina criada com sucesso");
  }

  @GetMapping
  public List<Disciplina> retornaTodos() {
    return repository.findAll();
  }

  @PutMapping("/{id}")
  public Response Atualizar(@PathVariable Long id, @RequestBody Disciplina entity) {

    if (!repository.existsById(id)) {
      return new Response(200, "Disciplina atualizada ");
    }

    Disciplina DisciplinaAntigo = repository.findById(id).get();

    if (entity.getNome() != null) {
      DisciplinaAntigo.setNome(entity.getNome());
    }

    if (entity.getCarga_horaria() != null) {
      DisciplinaAntigo.setCarga_horaria(entity.getCarga_horaria());
    }

    repository.save(DisciplinaAntigo);
    return new Response(200, "disciplina atualizada com sucesso");

  }

  @DeleteMapping("/{id}")
  public Response deleteDisciplina(@PathVariable long id) {
    if (!repository.existsById(id)) {
      return new Response(204, "Disciplina não encontrada");
    }

    return new Response(204, "Disciplina deletada com sucesso");// A disciplina foi deletado com sucesso ma tal ato não
                                                                // tem um retorno portanto recebe como se fosse um
                                                                // "erro"

  }
}