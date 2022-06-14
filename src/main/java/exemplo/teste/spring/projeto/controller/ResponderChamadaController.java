package exemplo.teste.spring.projeto.controller;

import exemplo.teste.spring.projeto.domain.Chamada;
import exemplo.teste.spring.projeto.exceptions.ValidacaoException;
import exemplo.teste.spring.projeto.service.ResponderChamadaService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResponderChamadaController {

    @Autowired
    ResponderChamadaService responderChamadaService;

    @PostMapping
    public Chamada chamadas(@RequestBody ResponderChamadaRequest request) throws ValidacaoException {
        var chamada = new Chamada();
        BeanUtils.copyProperties(request, chamada);
        return responderChamadaService.apply(chamada);
    }

}
