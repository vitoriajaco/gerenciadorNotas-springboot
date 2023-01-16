package com.example.boletim.mapper.impl;

import com.example.boletim.DTO.AlunoResponseDTO;
import com.example.boletim.mapper.Mapper;
import com.example.boletim.model.AlunoModel;
import org.springframework.stereotype.Component;

@Component
public class AlunoResponseMapper implements Mapper<AlunoModel, AlunoResponseDTO> {
    @Override
    public AlunoResponseDTO convert(AlunoModel alunoModel) {
        return AlunoResponseDTO.builder()
                .email(alunoModel.getEmail())
                .nome(alunoModel.getNome())
                .id(alunoModel.getId())
                .build();
    }
}
