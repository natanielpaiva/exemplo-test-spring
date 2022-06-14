package exemplo.teste.spring.projeto.controller;

import exemplo.teste.spring.projeto.domain.Aluno;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ResponderChamadaRequest {

    private Aluno aluno;

    private boolean presente;

    private LocalDate data;

}
