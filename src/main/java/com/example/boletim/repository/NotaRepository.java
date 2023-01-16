package com.example.boletim.repository;

import com.example.boletim.model.NotaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotaRepository extends JpaRepository<NotaModel, Long> {
}
