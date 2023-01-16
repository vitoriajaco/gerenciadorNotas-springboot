package com.example.boletim.controller;

import com.example.boletim.DTO.NotaRequestDTO;
import com.example.boletim.DTO.NotaResponseDTO;
import com.example.boletim.service.NotaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NotaController {

    private final NotaService notaService;

    @PostMapping(path = "/nota")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<NotaResponseDTO> cadastrarNota(@RequestBody NotaRequestDTO notaRequestDTO) {
        return ResponseEntity.ok(notaService.cadastrarNota(notaRequestDTO));
    }

    @PutMapping(path = "/nota/{id}")
    public ResponseEntity<NotaResponseDTO> alterarNota(@PathVariable Long id, @RequestBody NotaRequestDTO notaRequestDTO) {
        return ResponseEntity.ok(notaService.alterarNota(notaRequestDTO, id));
    }

    @GetMapping(path = "/nota/{id}")
    public ResponseEntity<NotaResponseDTO> buscarNotaPorId(@PathVariable Long id){
        return ResponseEntity.ok(notaService.mostrarNotaPorId(id));
    }

    @GetMapping(path = "/notas")
    public ResponseEntity<List<NotaResponseDTO>> mostrarTodasAsNotas(){
        return ResponseEntity.ok(notaService.listarTodasAsNotas());
    }

    @DeleteMapping(path = "/nota/{id}")
    public ResponseEntity<Boolean>deletarNota(@PathVariable Long id){
        notaService.deletarNota(id);
        return ResponseEntity.ok(true);
    }


}
