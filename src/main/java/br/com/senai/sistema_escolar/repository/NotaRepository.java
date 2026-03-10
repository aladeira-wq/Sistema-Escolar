package br.com.senai.sistema_escolar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.senai.sistema_escolar.entity.Nota;

public interface NotaRepository extends JpaRepository <Nota, Long> {
    
}
