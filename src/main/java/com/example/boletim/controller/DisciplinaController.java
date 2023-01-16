package com.example.boletim.controller;

import com.example.boletim.DTO.AlunoRequestDTO;
import com.example.boletim.DTO.AlunoResponseDTO;
import com.example.boletim.DTO.DisciplinaRequestDTO;
import com.example.boletim.DTO.DisciplinaResponseDTO;
import com.example.boletim.service.AlunoService;
import com.example.boletim.service.DisciplinaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class DisciplinaController {

    private final DisciplinaService disciplinaService;

    @PostMapping(path = "/disciplina")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<DisciplinaResponseDTO> cadastrarDisciplina (@RequestBody DisciplinaRequestDTO disciplinaRequestDTO){
        return ResponseEntity.ok(disciplinaService.cadastrarDisciplina(disciplinaRequestDTO));
    }

    @PutMapping(path = "/disciplina/{id}")
    public ResponseEntity<DisciplinaResponseDTO> alterarDisciplina(@PathVariable Long id, @RequestBody DisciplinaRequestDTO disciplinaRequestDTO){
        return ResponseEntity.ok(disciplinaService.alterarDisciplina(disciplinaRequestDTO, id));
    }

    @GetMapping(path = "/disciplina/{id}")
    public ResponseEntity<DisciplinaResponseDTO> buscarDisciplinaPorID(@PathVariable Long id){
        return ResponseEntity.ok(disciplinaService.mostrarDisciplinaPorId(id));
    }

    @GetMapping(path = "/Disciplinas")
    public ResponseEntity<List<DisciplinaResponseDTO>> mostrarTodosAsDisciplinas(){
        return ResponseEntity.ok(disciplinaService.listarTodasAsDisciplinas());
    }

    @DeleteMapping(path = "/disciplina/{id}")
    public ResponseEntity<Boolean> deletarDisciplina(@PathVariable Long id){
        disciplinaService.deletarDisciplina(id);
        return ResponseEntity.ok(true);
    }
}
