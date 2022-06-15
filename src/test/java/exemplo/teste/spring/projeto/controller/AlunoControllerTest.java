package exemplo.teste.spring.projeto.controller;

import exemplo.teste.spring.projeto.domain.Aluno;
import exemplo.teste.spring.projeto.repository.AlunoRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
 class AlunoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    AlunoRepository alunoRepository;

    @Test
     void buscarAlunos() throws Exception {
        var aluno = new Aluno();
        aluno.setNome("Nataniel Paiva");
        Mockito.when(alunoRepository.findAll()).thenReturn(List.of(aluno));
        this.mockMvc.perform(get("/aluno"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json("[{'id':null,nome:'Nataniel Paiva',statusMatricula:false}]"));
    }

   @Test
   void salvarAluno() throws Exception {
      var aluno = new Aluno();
      aluno.setNome("Nataniel Paiva");
      Mockito.when(alunoRepository.save(Mockito.any())).thenReturn(aluno);
      this.mockMvc.perform(post("/aluno")
                      .contentType(MediaType.APPLICATION_JSON)
                      .content("{\"id\":null,\"nome\":\"Nataniel Paiva\",\"statusMatricula\":false}")
                      .accept(MediaType.APPLICATION_JSON)
              )
              .andDo(print())
              .andExpect(status().isOk())
              .andExpect(jsonPath("$.nome").value("Nataniel Paiva"))
              .andExpect(content().json("{'id':null,nome:'Nataniel Paiva',statusMatricula:false}"));
   }


}
