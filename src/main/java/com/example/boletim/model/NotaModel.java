package com.example.boletim.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Data
@Entity
@Builder
public class NotaModel {

    @Id
    private Long id;
    @Column(name = "nota", nullable = false)
    private double nota;
    
    @Column(name = "bimestre", nullable = false)
    private int bimestre;

    @ManyToOne
    private AlunoModel aluno;

    @ManyToOne
    private DisciplinaModel disciplina;
}
