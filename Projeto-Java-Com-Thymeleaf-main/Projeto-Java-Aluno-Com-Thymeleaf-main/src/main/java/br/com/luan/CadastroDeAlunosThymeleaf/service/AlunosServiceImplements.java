package br.com.luan.CadastroDeAlunosThymeleaf.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.luan.CadastroDeAlunosThymeleaf.entity.Alunos;
import br.com.luan.CadastroDeAlunosThymeleaf.repository.AlunosRepository;

@Service
public class AlunosServiceImplements implements AlunosService {

	@Autowired
	private AlunosRepository repository;

	@Override
	public List<Alunos> getAllAlunos(){
		return repository.findAll();
	}

	@Override
	public void save(Alunos alunos) {
		repository.save(alunos);

	}

	@Override
	public Alunos getById(Long id) {
		Optional<Alunos> optional = repository.findById(id);
		Alunos alunos = null;
		if(optional.isPresent()) {
			alunos = optional.get();
		}else {
			throw new RuntimeException("Aluno não encontrado com o id: " +id);
		}
		return alunos;
	}
	@Override
	public void deleteViaId(Long id) {
		repository.deleteById(id);
	}

}
