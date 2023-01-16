package com.example.boletim.mapper.impl;

import com.example.boletim.DTO.DisciplinaResponseDTO;
import com.example.boletim.model.DisciplinaModel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = {DisciplinaResponseMapper.class})
class DisciplinaResponseMapperTest {

    @Autowired
    DisciplinaResponseMapper disciplinaResponseMapper; // <DisciplinaModel, DisciplinaResponseDTO>

    @Test
    void convert() {

        DisciplinaModel disciplinaModel = DisciplinaModel.builder()
                .nomeDisciplina("Algoritmos")
                .id(1L)
                .build();

        assertInstanceOf(DisciplinaResponseDTO.class, disciplinaResponseMapper.convert(disciplinaModel));
    }
}