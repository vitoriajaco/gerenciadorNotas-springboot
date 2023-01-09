package com.example.boletim.DTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NotaResponseDTO {

    private Long id;
    private double nota;
    private Long alunoId;
    private String nomeAluno;
    private String nomeDisciplina;
    private int bimestre;

}
