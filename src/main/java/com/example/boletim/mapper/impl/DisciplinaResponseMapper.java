package com.example.boletim.mapper.impl;

import com.example.boletim.DTO.DisciplinaResponseDTO;
import com.example.boletim.mapper.Mapper;
import com.example.boletim.model.DisciplinaModel;
import org.springframework.stereotype.Component;

@Component
public class DisciplinaResponseMapper implements Mapper<DisciplinaModel, DisciplinaResponseDTO> {
    @Override
    public DisciplinaResponseDTO convert(DisciplinaModel disciplinaModel) {
        return DisciplinaResponseDTO.builder()
                .id(disciplinaModel.getId())
                .nomeDisciplina(disciplinaModel.getNomeDisciplina())
                .build();
    }
}
