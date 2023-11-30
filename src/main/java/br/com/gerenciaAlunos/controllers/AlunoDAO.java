package br.com.gerenciaAlunos.controllers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.gerenciaAlunos.models.Aluno;

@Repository
public interface AlunoDAO extends JpaRepository<Aluno, Integer>{


    
}
