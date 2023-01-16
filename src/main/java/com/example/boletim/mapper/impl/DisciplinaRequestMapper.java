package com.example.boletim.mapper.impl;

import com.example.boletim.DTO.DisciplinaRequestDTO;
import com.example.boletim.mapper.Mapper;
import com.example.boletim.model.DisciplinaModel;
import org.springframework.stereotype.Component;

@Component
public class DisciplinaRequestMapper implements Mapper<DisciplinaRequestDTO, DisciplinaModel> {
    @Override
    public DisciplinaModel convert(DisciplinaRequestDTO disciplinaRequestDTO) {
        return DisciplinaModel.builder()
                .id(disciplinaRequestDTO.getId()!=null ? disciplinaRequestDTO.getId() : null)
                .nomeDisciplina(disciplinaRequestDTO.getNomeDisciplina())
                .build();
    }
}
