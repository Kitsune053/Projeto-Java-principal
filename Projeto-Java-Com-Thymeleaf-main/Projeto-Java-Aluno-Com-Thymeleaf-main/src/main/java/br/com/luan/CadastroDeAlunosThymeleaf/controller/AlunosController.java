package br.com.luan.CadastroDeAlunosThymeleaf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.luan.CadastroDeAlunosThymeleaf.entity.Alunos;
import br.com.luan.CadastroDeAlunosThymeleaf.service.AlunosServiceImplements;

@Controller
public class AlunosController {

	@Autowired
	private AlunosServiceImplements alunosService;

	@GetMapping("/")
	public String viewHomePage() {
		return "index";
	}
	
	@GetMapping("/listarAlunos")
	public String listarAlunos(Model model) {
		model.addAttribute("allList", alunosService.getAllAlunos());
		return "listarAlunos";
	}
	
	@GetMapping("salvaralunos")
	public String addNewAlunos(Model model) {
		Alunos alunos = new Alunos();
		model.addAttribute("alunos", alunos);
		return "salvaralunos";
	}

	@PostMapping("/save")
	public String saveAlunos(@ModelAttribute("alunos") Alunos alunos) {
		alunosService.save(alunos);
		return "redirect:/";
	}

	@GetMapping("/showFormForUpdate/{id}")
	public String updateForm(@PathVariable(value = "id") Long id, Model model){
		Alunos alunos = alunosService.getById(id);
		model.addAttribute("alunos", alunos);
		return "atualizar";
	}

	@GetMapping("/deleteAlunos/{id}")
	public String deleteThroughId(@PathVariable(value = "id") Long id) {
		alunosService.deleteViaId(id);
		return "redirect:/";
	}

}
