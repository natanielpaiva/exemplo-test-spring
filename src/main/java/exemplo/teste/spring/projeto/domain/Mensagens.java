package exemplo.teste.spring.projeto.domain;

public enum Mensagens {
    ALUNO_NAO_MATRICULADO("NMATRICULA"),
    REGISTRO_EM_DATA_FUTURA("DTFUTURA");

    private String mensagem;

    Mensagens(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getMensagem() {
        return mensagem;
    }
}
