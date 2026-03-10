package br.com.senai.sistema_escolar.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

@Entity
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "É necessário informar seu nome")
    @Size(max = 80, min = 3, message = "Minimo 3 e máximo 50")
    private String nome;

    @NotBlank(message = "Informe sua matricula")
    @Size(min = 11, max = 11, message = "Não informe traços e pontos")
    private String matricula;

     //Armazena apenas a data 
    @NotNull
    @Past (message = "informar data de nascimento")
    private LocalDate dataNascimento;

    
    @OneToMany(mappedBy = "aluno")
    private List<Nota> nota;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }



    
 
    


}
