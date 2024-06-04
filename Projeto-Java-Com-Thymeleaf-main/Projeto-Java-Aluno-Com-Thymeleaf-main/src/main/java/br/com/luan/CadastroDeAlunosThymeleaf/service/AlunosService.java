package br.com.luan.CadastroDeAlunosThymeleaf.service;

import java.util.List;

import br.com.luan.CadastroDeAlunosThymeleaf.entity.Alunos;

public interface AlunosService {
	List<Alunos> getAllAlunos();
	void save(Alunos alunos);
	Alunos getById(Long id);
	void deleteViaId(Long id);
}
