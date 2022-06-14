package exemplo.teste.spring.projeto.service;

import exemplo.teste.spring.projeto.domain.Chamada;
import exemplo.teste.spring.projeto.exceptions.ValidacaoException;
import exemplo.teste.spring.projeto.repository.ChamadaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResponderChamadaService {

    @Autowired
    private ChamadaRepository chamadaRepository;

    public Chamada apply(Chamada chamada) throws ValidacaoException {
        chamada.getAluno().verificaAlunoMatriculado();
        chamada.validaDataFutura();

        return chamadaRepository.save(chamada);
    }

}
