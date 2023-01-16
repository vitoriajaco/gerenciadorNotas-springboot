package com.example.boletim.mapper.impl;

import com.example.boletim.DTO.NotaResponseDTO;
import com.example.boletim.mapper.Mapper;
import com.example.boletim.model.NotaModel;
import org.springframework.stereotype.Component;

@Component
public class NotaResponseMapper implements Mapper<NotaModel, NotaResponseDTO> {
    @Override
    public NotaResponseDTO convert(NotaModel notaModel) {
        return NotaResponseDTO.builder()
                .id(notaModel.getId())
                .nomeAluno(notaModel.getAluno().getNome())
                .bimestre(notaModel.getBimestre())
                .nomeDisciplina(notaModel.getDisciplina().getNomeDisciplina())
                .nota(notaModel.getNota())
                .build();
    }
}
