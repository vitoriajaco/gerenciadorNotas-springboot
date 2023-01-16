package com.example.boletim.mapper.impl;

import com.example.boletim.DTO.NotaRequestDTO;
import com.example.boletim.mapper.Mapper;
import com.example.boletim.model.NotaModel;
import org.springframework.stereotype.Component;

@Component
public class NotaRequestMapper implements Mapper<NotaRequestDTO, NotaModel> {
    @Override
    public NotaModel convert(NotaRequestDTO notaRequestDTO) {
        return NotaModel.builder()
                .id(notaRequestDTO.getId()!= null ? notaRequestDTO.getId() : null)
                .nota(notaRequestDTO.getNota())
                .disciplina(notaRequestDTO.getDisciplina())
                .bimestre(notaRequestDTO.getBimeste())
                .aluno(notaRequestDTO.getAluno())
                .build();
    }
}
