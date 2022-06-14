package exemplo.teste.spring.projeto.domain;

import exemplo.teste.spring.projeto.exceptions.ValidacaoException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;

    private boolean statusMatricula;


    public void verificaAlunoMatriculado() throws ValidacaoException {
        if(!this.statusMatricula){
            throw new ValidacaoException(Mensagens.ALUNO_NAO_MATRICULADO.getMensagem());
        }
    }

}
