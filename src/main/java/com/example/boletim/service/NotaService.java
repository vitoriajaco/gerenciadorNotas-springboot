package com.example.boletim.service;

import com.example.boletim.DTO.NotaRequestDTO;
import com.example.boletim.DTO.NotaResponseDTO;
import com.example.boletim.exceptions.NotaNotFoundException;
import com.example.boletim.mapper.impl.NotaRequestMapper;
import com.example.boletim.mapper.impl.NotaResponseMapper;
import com.example.boletim.model.NotaModel;
import com.example.boletim.repository.NotaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class NotaService {

    private final NotaRepository notaRepository;
    private final NotaRequestMapper notaRequestMapper;
    private final NotaResponseMapper notaResponseMapper;


    public NotaResponseDTO cadastrarNota(NotaRequestDTO notaRequestDTO){
        NotaModel notaModel = notaRepository.save(notaRequestMapper.convert(notaRequestDTO));
        return notaResponseMapper.convert(notaModel);
    }

    private NotaModel validaSeNotaExiste(Long id){

        Optional<NotaModel> isPresentNotaModel = notaRepository.findById(id);
        return isPresentNotaModel.orElseThrow(()-> new NotaNotFoundException("nota não encontrada!"));

    }
}
