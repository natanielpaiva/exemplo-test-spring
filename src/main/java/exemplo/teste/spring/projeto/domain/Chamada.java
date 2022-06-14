package exemplo.teste.spring.projeto.domain;

import exemplo.teste.spring.projeto.exceptions.ValidacaoException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Chamada {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "aluno_id")
    private Aluno aluno;

    private boolean presente;

    private LocalDate data;

    public void validaDataFutura() throws ValidacaoException {
        if(this.data.isAfter(LocalDate.now())){
            throw new ValidacaoException(Mensagens.REGISTRO_EM_DATA_FUTURA.getMensagem());
        }
    }
}
