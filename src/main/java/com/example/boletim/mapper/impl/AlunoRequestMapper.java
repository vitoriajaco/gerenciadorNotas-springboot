package com.example.boletim.mapper.impl;


import com.example.boletim.DTO.AlunoRequestDTO;
import com.example.boletim.mapper.Mapper;
import com.example.boletim.model.AlunoModel;
import org.springframework.stereotype.Component;

@Component
public class AlunoRequestMapper implements Mapper<AlunoRequestDTO, AlunoModel> {
    @Override
    public AlunoModel convert(AlunoRequestDTO alunoRequestDTO) {
        return AlunoModel.builder()
                .id(alunoRequestDTO.getId()!= null ? alunoRequestDTO.getId() : null) //verifica se existe id diferente de null. A primeira condição antes do ":" é verdadeira, a segunda falsa.
                .email(alunoRequestDTO.getEmail())
                .nome(alunoRequestDTO.getNomeAluno())
                .build();
    }
}
