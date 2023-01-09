package com.example.boletim.DTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AlunoResponseDTO {

    private Long id;
    private String nome;
    private String email;
}
