package br.com.senai.sistema_escolar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.senai.sistema_escolar.entity.Aluno;

public interface AlunoRepository extends JpaRepository <Aluno, Long> {

    
}

