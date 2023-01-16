package com.example.boletim.service;

import com.example.boletim.DTO.DisciplinaRequestDTO;
import com.example.boletim.DTO.DisciplinaResponseDTO;
import com.example.boletim.exceptions.DisciplinaNotFoundException;
import com.example.boletim.exceptions.DisciplinaSameIdException;
import com.example.boletim.mapper.impl.DisciplinaRequestMapper;
import com.example.boletim.mapper.impl.DisciplinaResponseMapper;
import com.example.boletim.model.DisciplinaModel;
import com.example.boletim.repository.DisciplinaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DisciplinaService {

    private final DisciplinaRepository disciplinaRepository;

    private final DisciplinaRequestMapper disciplinaRequestMapper;

    private final DisciplinaResponseMapper disciplinaResponseMapper;

    public DisciplinaResponseDTO cadastrarDisciplina(DisciplinaRequestDTO disciplinaRequestDTO){
        DisciplinaModel disciplinaModel = disciplinaRepository.save(disciplinaRequestMapper.convert(disciplinaRequestDTO));
        return disciplinaResponseMapper.convert(disciplinaModel);
    }

    public DisciplinaResponseDTO alterarDisciplina(DisciplinaRequestDTO disciplinaRequestDTO, Long id){
        if (!(disciplinaRequestDTO.getId() == id)){
            throw new DisciplinaSameIdException("ID de disciplina não são iguais");
        }
        DisciplinaModel disciplinaModel = validaSeDisciplinaExiste(id);
        disciplinaModel = disciplinaRepository.save(disciplinaRequestMapper.convert(disciplinaRequestDTO));
        return disciplinaResponseMapper.convert(disciplinaModel);
    }

    public List<DisciplinaResponseDTO> listarTodasAsDisciplinas(){
        List<DisciplinaResponseDTO> listaDeDisciplinas = new ArrayList<>();
        listaDeDisciplinas = disciplinaRepository.findAll().stream().map(disciplinaResponseMapper::convert).collect(Collectors.toList());
        return listaDeDisciplinas;
    }

    public DisciplinaResponseDTO mostrarDisciplinaPorId(Long id){
        DisciplinaResponseDTO disciplinaResponseDTO = null;
        DisciplinaModel disciplinaModel = validaSeDisciplinaExiste(id);
        disciplinaResponseDTO = disciplinaResponseMapper.convert(disciplinaModel);
        return disciplinaResponseDTO;
    }

    public void deletarDisciplina (Long id ){
        validaSeDisciplinaExiste(id);
        disciplinaRepository.deleteById(id);
    }


    private DisciplinaModel validaSeDisciplinaExiste(Long id){
        Optional<DisciplinaModel> isPresentDisciplinaModel = disciplinaRepository.findById(id);
        return isPresentDisciplinaModel.orElseThrow(()-> new DisciplinaNotFoundException("Disciplina não encontrada!"));
    }
}
