package com.example.boletim.mapper.impl;

import com.example.boletim.DTO.AlunoResponseDTO;
import com.example.boletim.model.AlunoModel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = {AlunoResponseMapper.class})
class AlunoResponseMapperTest {

    @Autowired
    AlunoResponseMapper alunoResponseMapper; //Converte um Aluno model em AlunoResponseDTO

    @Test
    void convert() {

        AlunoModel alunoModel = AlunoModel.builder()
                .id(1L)
                .nome("João")
                .email("joao@email.com")
                .build();

        assertInstanceOf(AlunoResponseDTO.class, alunoResponseMapper.convert(alunoModel));
    }
}