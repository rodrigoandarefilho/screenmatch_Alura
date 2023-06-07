package br.com.alura.screenmatch.exceptions;

public class ErroAnoDeLancamento extends RuntimeException {
    private final String mensagem;
    public ErroAnoDeLancamento(String mensagem) {
        this.mensagem = mensagem;
    }

    @Override
    public String getMessage() {
        return this.mensagem;
    }
}
