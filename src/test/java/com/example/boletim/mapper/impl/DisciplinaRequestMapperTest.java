package com.example.boletim.mapper.impl;

import com.example.boletim.DTO.DisciplinaRequestDTO;
import com.example.boletim.model.DisciplinaModel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = DisciplinaRequestMapper.class)
class DisciplinaRequestMapperTest {

    @Autowired
    DisciplinaRequestMapper disciplinaRequestMapper; //<DisciplinaRequestDTO, DisciplinaModel>



    @Test
    void convert() {

        DisciplinaRequestDTO disciplinaRequestDTO = DisciplinaRequestDTO.builder()
                .id(1L)
                .nomeDisciplina("Algoritmo")
                .build();

        assertInstanceOf(DisciplinaModel.class, disciplinaRequestMapper.convert(disciplinaRequestDTO));
    }
}