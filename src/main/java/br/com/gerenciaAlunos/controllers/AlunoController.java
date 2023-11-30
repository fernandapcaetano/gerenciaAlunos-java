package br.com.gerenciaAlunos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.gerenciaAlunos.models.Aluno;

@Controller
public class AlunoController {

    @Autowired
    private AlunoDAO alunoRepositorio;

    @GetMapping("/InserirAluno")
    public ModelAndView inserirAlunos(Aluno aluno){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("Aluno/inserirAluno");
        mv.addObject("aluno", new Aluno());
        return mv;
    }

    @PostMapping("AddAluno")
    public ModelAndView addAluno(Aluno aluno){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("redirect:/listAlunos");
        alunoRepositorio.save(aluno);
        return mv;
    }

    @GetMapping("listAlunos")
    public ModelAndView listAlunos(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("Aluno/listAlunos");
        mv.addObject("listaDeAlunos", alunoRepositorio.findAll());
        return mv;
    }
    
    @GetMapping("/alterar/{id}")
    public ModelAndView alterar(@PathVariable("id") Integer id){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("Aluno/alterar");
        Aluno aluno = alunoRepositorio.getReferenceById(id);
        mv.addObject("aluno", aluno);
        return mv;
    }

    @PostMapping("/alterar")
    public ModelAndView alterar(Aluno aluno){
        ModelAndView mv = new ModelAndView();
        alunoRepositorio.save(aluno);
        mv.setViewName("redirect:/listAlunos");
        return mv;
    }

    @GetMapping("/excluir/{id}")
    public String excluirAluno(@PathVariable("id") Integer id){
        alunoRepositorio.deleteById(id);
        return "redirect:/listAlunos";
    }
}
