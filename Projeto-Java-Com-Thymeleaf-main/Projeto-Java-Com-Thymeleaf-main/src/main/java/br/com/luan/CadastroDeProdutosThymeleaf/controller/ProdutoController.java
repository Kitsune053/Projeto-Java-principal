package br.com.luan.CadastroDeProdutosThymeleaf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.luan.CadastroDeProdutosThymeleaf.entity.Produto;
import br.com.luan.CadastroDeProdutosThymeleaf.service.ProdutoServiceImplements;

@Controller
public class ProdutoController {

	@Autowired
	private ProdutoServiceImplements produtoService;

	@GetMapping("/")
	public String viewHomePage(Model model) {
		model.addAttribute("allList", produtoService.getAllProduct());
		return "index";
	}

	@GetMapping("salvarproduto")
	public String addNewProduto(Model model) {
		Produto produto = new Produto();
		model.addAttribute("produto", produto);
		return "salvarproduto";
	}

	@PostMapping("/save")
	public String saveProduto(@ModelAttribute("produto") Produto produto) {
		produtoService.save(produto);
		return "redirect:/";
	}

	@GetMapping("/showFormForUpdate/{id}")
	public String updateForm(@PathVariable(value = "id") Long id, Model model){
		Produto produto = produtoService.getById(id);
		model.addAttribute("produto", produto);
		return "atualizar";
	}

	@GetMapping("/deleteProduto/{id}")
	public String deleteThroughId(@PathVariable(value = "id") Long id) {
		produtoService.deleteViaId(id);
		return "redirect:/";
	}

}
