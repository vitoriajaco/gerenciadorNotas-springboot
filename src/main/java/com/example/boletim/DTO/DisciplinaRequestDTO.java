package com.example.boletim.DTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DisciplinaRequestDTO {

    private Long id;
    private String nomeDisciplina;

}
