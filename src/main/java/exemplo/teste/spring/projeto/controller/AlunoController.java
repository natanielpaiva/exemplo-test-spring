package exemplo.teste.spring.projeto.controller;

import exemplo.teste.spring.projeto.domain.Aluno;
import exemplo.teste.spring.projeto.domain.Chamada;
import exemplo.teste.spring.projeto.exceptions.ValidacaoException;
import exemplo.teste.spring.projeto.repository.AlunoRepository;
import exemplo.teste.spring.projeto.service.ResponderChamadaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("aluno")
public class AlunoController {

    @Autowired
    AlunoRepository alunoRepository;

    @PostMapping
    public Aluno cadastrarAluno(@RequestBody Aluno aluno){
        return alunoRepository.save(aluno);
    }

    @GetMapping
    public List<Aluno> buscarTodosAlunos(){
        return alunoRepository.findAll();
    }

}
