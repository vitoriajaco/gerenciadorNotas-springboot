package com.example.boletim.service;

import com.example.boletim.DTO.NotaRequestDTO;
import com.example.boletim.DTO.NotaResponseDTO;
import com.example.boletim.exceptions.NotaNotFoundException;
import com.example.boletim.exceptions.NotaSameIdException;
import com.example.boletim.mapper.impl.NotaRequestMapper;
import com.example.boletim.mapper.impl.NotaResponseMapper;
import com.example.boletim.model.NotaModel;
import com.example.boletim.repository.NotaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class NotaService {

    private final NotaRepository notaRepository;
    private final NotaRequestMapper notaRequestMapper;
    private final NotaResponseMapper notaResponseMapper;


    public NotaResponseDTO cadastrarNota(NotaRequestDTO notaRequestDTO) {
        NotaModel notaModel = notaRepository.save(notaRequestMapper.convert(notaRequestDTO));
        return notaResponseMapper.convert(notaModel);
    }

    public NotaResponseDTO alterarNota(NotaRequestDTO notaRequestDTO, Long id) {
        if (!(notaRequestDTO.getId() == id)) {
            throw new NotaSameIdException("id de notas não sao iguais");
        }
        NotaModel notaModel = validaSeNotaExiste(id);
        notaModel = notaRepository.save(notaRequestMapper.convert(notaRequestDTO));
        return notaResponseMapper.convert(notaModel);
    }

    public NotaResponseDTO mostrarNotaPorId(Long id) {
        NotaResponseDTO notaResponseDTO = null;
        NotaModel notaModel = validaSeNotaExiste(id);
        notaResponseDTO = notaResponseMapper.convert(notaModel);
        return notaResponseDTO;
    }

    public List<NotaResponseDTO> listarTodasAsNotas() {
        List<NotaResponseDTO> listaDeNotas = new ArrayList<>();
        listaDeNotas = notaRepository.findAll().stream().map(notaResponseMapper::convert).collect(Collectors.toList());
        return listaDeNotas;
    }

    public void deletarNota(Long id) {
        Optional<NotaModel> isPresentNotaModel = notaRepository.findById(id);
        if (isPresentNotaModel.isPresent()) {
            notaRepository.deleteById(id);
        }
    }

    private NotaModel validaSeNotaExiste(Long id) {

        Optional<NotaModel> isPresentNotaModel = notaRepository.findById(id);
        return isPresentNotaModel.orElseThrow(() -> new NotaNotFoundException("nota não encontrada!"));

    }
}
