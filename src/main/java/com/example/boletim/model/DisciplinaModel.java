package com.example.boletim.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@Entity
@Builder
public class DisciplinaModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nomeDisciplina", nullable = false, unique = true)
    private String nomeDisciplina;

    @OneToMany(mappedBy = "disciplina")
    private List<NotaModel> notas = new ArrayList<>();
}
