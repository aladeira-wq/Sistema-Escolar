package br.com.senai.sistema_escolar.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Nota {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull(message = "É necessário informar o valor da nota")
    private double valor_nota;
    @NotBlank(message = "É necessário informar o bimestre")
    private String id_bimestre;

    @ManyToOne
    @JoinColumn(name = "aula")
    private Aula aula;
    
    @ManyToOne
    @JoinColumn(name = "aluno")
    private Aluno aluno;

    @ManyToOne
    @JoinColumn(name = "fk_disciplina")
    private Disciplina disciplina;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getValor_nota() {
        return valor_nota;
    }

    public void setValor_nota(double valor_nota) {
        this.valor_nota = valor_nota;
    }

    public String getId_bimestre() {
        return id_bimestre;
    }

    public void setId_bimestre(String id_bimestre) {
        this.id_bimestre = id_bimestre;
    }
}
