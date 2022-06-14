package exemplo.teste.spring.projeto.service;

import exemplo.teste.spring.projeto.domain.Aluno;
import exemplo.teste.spring.projeto.domain.Chamada;
import exemplo.teste.spring.projeto.domain.Mensagens;
import exemplo.teste.spring.projeto.exceptions.ValidacaoException;
import exemplo.teste.spring.projeto.repository.ChamadaRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
class ResponderChamadaServiceTest {

    Chamada chamada;

    Aluno aluno;

    @Mock
    ChamadaRepository chamadaRepository;

    @InjectMocks
    ResponderChamadaService responderChamadaService;

    @BeforeEach
    public void setUp(){
        aluno = new Aluno();
        aluno.setNome("Nataniel Paiva");
        aluno.setStatusMatricula(false);
        chamada = new Chamada();
        chamada.setAluno(aluno);
        chamada.setData(LocalDate.now());
    }

    @Test()
    void verificaAlunoNaoMatriculado(){
        var validacao = Assertions.assertThrows(
                ValidacaoException.class,
                ()-> responderChamadaService.apply(chamada)
        );

        Assertions.assertEquals(Mensagens.ALUNO_NAO_MATRICULADO.getMensagem(), validacao.getMessage());
    }

    @Test
    void verificaDataChamadaInvalida(){
        aluno.setStatusMatricula(true);
        chamada.setAluno(aluno);
        chamada.setData(LocalDate.now().plusDays(1));
        var validacao = Assertions.assertThrows(
                ValidacaoException.class,
                ()-> responderChamadaService.apply(chamada)
        );

        Assertions.assertEquals(Mensagens.REGISTRO_EM_DATA_FUTURA.getMensagem(), validacao.getMessage());

    }

    @Test
    void alunoSalvoComSucesso() throws ValidacaoException {
        aluno.setStatusMatricula(true);
        chamada.setAluno(aluno);
        Mockito.when(chamadaRepository.save(chamada)).thenReturn(chamada);
        var result = responderChamadaService.apply(chamada);

        Assertions.assertEquals(chamada.getData(), result.getData());
    }


}
