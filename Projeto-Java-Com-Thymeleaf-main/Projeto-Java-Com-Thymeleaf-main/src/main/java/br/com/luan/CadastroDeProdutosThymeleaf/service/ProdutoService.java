package br.com.luan.CadastroDeProdutosThymeleaf.service;

import java.util.List;

import br.com.luan.CadastroDeProdutosThymeleaf.entity.Produto;

public interface ProdutoService {
	List<Produto> getAllProduct();
	void save(Produto produto);
	Produto getById(Long id);
	void deleteViaId(Long id);
}
