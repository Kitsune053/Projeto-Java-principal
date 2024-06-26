package br.com.luan.CadastroDeAlunosThymeleaf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.luan.CadastroDeAlunosThymeleaf.entity.Alunos;

@Repository
public interface AlunosRepository extends JpaRepository<Alunos, Long> {

}
