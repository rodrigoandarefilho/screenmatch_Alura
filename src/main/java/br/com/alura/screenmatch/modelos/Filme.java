package br.com.alura.screenmatch.modelos;

import br.com.alura.screenmatch.utils.Classificavel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Filme extends Categoria  implements Classificavel {
    private String diretor;

    public Filme(String nome, int anoDeLancamento) {
        super(nome, anoDeLancamento);
    }

    @Override
    public int getClassificacao() {
        return (int) pegaMedia() / 2;
    }
}
