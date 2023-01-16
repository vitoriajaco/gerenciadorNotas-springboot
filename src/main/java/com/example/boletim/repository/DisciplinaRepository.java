package com.example.boletim.repository;

import com.example.boletim.model.AlunoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DisciplinaRepository extends JpaRepository<AlunoModel, Long> {
}
