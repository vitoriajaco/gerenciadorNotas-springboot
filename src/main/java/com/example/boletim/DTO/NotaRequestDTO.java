package com.example.boletim.DTO;

import com.example.boletim.model.AlunoModel;
import com.example.boletim.model.DisciplinaModel;
import lombok.Data;

@Data

public class NotaRequestDTO {
    private Long id;
    private int bimeste;
    private double nota;
    private AlunoModel aluno;
    private DisciplinaModel disciplina;


}
