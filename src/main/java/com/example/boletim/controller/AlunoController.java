package com.example.boletim.controller;

import com.example.boletim.DTO.AlunoRequestDTO;
import com.example.boletim.DTO.AlunoResponseDTO;
import com.example.boletim.service.AlunoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AlunoController {

    private final AlunoService alunoService;

    @PostMapping(path = "/aluno")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<AlunoResponseDTO> cadastrarAluno (@RequestBody AlunoRequestDTO alunoRequestDTO){
        return ResponseEntity.ok(alunoService.cadastrarAluno(alunoRequestDTO));
    }

    @PutMapping(path = "/aluno/{id}")
    public ResponseEntity<AlunoResponseDTO> alterarAluno(@PathVariable Long id, @RequestBody AlunoRequestDTO alunoRequestDTO){
        return ResponseEntity.ok(alunoService.alterarAluno(alunoRequestDTO, id));
    }

    @GetMapping(path = "/aluno/{id}")
    public ResponseEntity<AlunoResponseDTO> buscarAlunoPorID(@PathVariable Long id){
        return ResponseEntity.ok(alunoService.mostrarAlunoPorId(id));
    }

    @GetMapping(path = "/alunos")
    public ResponseEntity<List<AlunoResponseDTO>> mostrarTodosOsAlunos(){
        return ResponseEntity.ok(alunoService.listarTodosOsAlunos());
    }

    @DeleteMapping(path = "/alunos/{id}")
    public ResponseEntity<Boolean> deletarAluno(@PathVariable Long id){
        alunoService.deletarAluno(id);
        return ResponseEntity.ok(true);
    }


}
