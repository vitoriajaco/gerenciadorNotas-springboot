package com.example.boletim.service;

import com.example.boletim.DTO.AlunoRequestDTO;
import com.example.boletim.DTO.AlunoResponseDTO;
import com.example.boletim.exceptions.AlunoNotFoundException;
import com.example.boletim.exceptions.AlunoSameIdException;
import com.example.boletim.mapper.impl.AlunoRequestMapper;
import com.example.boletim.mapper.impl.AlunoResponseMapper;
import com.example.boletim.model.AlunoModel;
import com.example.boletim.repository.AlunoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AlunoService {

    //Ao fazer dessa forma não é necessario usar o @AutoWired

    private final AlunoRepository alunoRepository;

    private final AlunoResponseMapper alunoResponseMapper;

    private final AlunoRequestMapper alunoRequestMapper;

    public AlunoResponseDTO cadastrarAluno (AlunoRequestDTO alunoRequestDTO){
        AlunoModel alunoModel = alunoRepository.save(alunoRequestMapper.convert(alunoRequestDTO));
        return alunoResponseMapper.convert(alunoModel);
    }

    public AlunoResponseDTO alterarAluno (AlunoRequestDTO alunoRequestDTO, Long id){
        if (!(alunoRequestDTO.getId() == id)){
            throw new AlunoSameIdException("ID de aluno não são iguais");
        }
        AlunoModel alunoModel = validaAlunoExiste(id);
        alunoModel = alunoRepository.save(alunoRequestMapper.convert(alunoRequestDTO));
        return alunoResponseMapper.convert(alunoModel);
    }

    public AlunoResponseDTO mostrarAlunoPorId(Long id){
        AlunoResponseDTO alunoResponseDTO = null;
        AlunoModel alunoModel = validaAlunoExiste(id);
        alunoResponseDTO = alunoResponseMapper.convert(alunoModel);
        return alunoResponseDTO;
    }

    public List<AlunoResponseDTO> listarTodosOsAlunos(){
        List<AlunoResponseDTO> listaDeAlunos = new ArrayList<>();
        listaDeAlunos = alunoRepository.findAll().stream().map(alunoResponseMapper::convert).collect(Collectors.toList());
        return listaDeAlunos;
    }

    public void deletarAluno(Long id){
        validaAlunoExiste(id);
        alunoRepository.deleteById(id);
    }


    private AlunoModel validaAlunoExiste(Long id) {
        Optional<AlunoModel> isPresentAlunoModel = alunoRepository.findById(id);
        // () -> é um suplier que nao recebe nada; E retorna uma exceção
        return isPresentAlunoModel.orElseThrow(() -> new AlunoNotFoundException("Aluno não encontrado!")); //OrElseThrow - pega o get do optional ou lança a exceção se for nulo.
    }

}
