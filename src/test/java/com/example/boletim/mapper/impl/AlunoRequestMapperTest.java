package com.example.boletim.mapper.impl;

import com.example.boletim.DTO.AlunoRequestDTO;
import com.example.boletim.model.AlunoModel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = {AlunoRequestMapper.class})
class AlunoRequestMapperTest {

    @Autowired
    AlunoRequestMapper alunoRequestMapper; //Transforma um AlunoRequestDTO em AlunoModel

    @Test
    void convert() {
        AlunoRequestDTO alunoRequestDTO = AlunoRequestDTO.builder()
                .id(1L).
                nomeAluno("Maria")
                .email("maria@email.com")
                .build();

        assertInstanceOf(AlunoModel.class, alunoRequestMapper.convert(alunoRequestDTO));
    }
}