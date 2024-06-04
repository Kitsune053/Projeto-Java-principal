package br.com.luan.CadastroDeProdutosThymeleaf.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.luan.CadastroDeProdutosThymeleaf.entity.Produto;
import br.com.luan.CadastroDeProdutosThymeleaf.repository.ProdutoRepository;

@Service
public class ProdutoServiceImplements implements ProdutoService {

	@Autowired
	private ProdutoRepository repository;

	@Override
	public List<Produto> getAllProduct(){
		return repository.findAll();
	}

	@Override
	public void save(Produto produto) {
		repository.save(produto);

	}

	@Override
	public Produto getById(Long id) {
		Optional<Produto> optional = repository.findById(id);
		Produto produto = null;
		if(optional.isPresent()) {
			produto = optional.get();
		}else {
			throw new RuntimeException("Produto não encontrado com o id: " +id);
		}
		return produto;
	}
	@Override
	public void deleteViaId(Long id) {
		repository.deleteById(id);
	}

}
