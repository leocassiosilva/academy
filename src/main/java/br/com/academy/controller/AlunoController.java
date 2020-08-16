package br.com.academy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.academy.dao.AlunoDao;
import br.com.academy.model.Aluno;

@Controller
public class AlunoController {

	@Autowired
	private AlunoDao alunorepository;
	
	@GetMapping("/cadastrarAlunos")
	public ModelAndView cadastrarAlunos(Aluno aluno) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Aluno/cadastrar");
		mv.addObject("aluno", new Aluno());
		return mv;
	}
	
	@PostMapping("cadastrarAlunos")
	public ModelAndView inserirAluno(Aluno aluno) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/Aluno/lista");
		alunorepository.save(aluno);
		return mv;
	
	}
}