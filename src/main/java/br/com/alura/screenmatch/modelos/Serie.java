package br.com.alura.screenmatch.modelos;

import br.com.alura.screenmatch.utils.Classificavel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Serie extends Categoria implements Classificavel {
    private int temporadas;
    private boolean ativa;
    private int episodiosPorTemporada;
    private int minutosPorEpisodio;

    public Serie(String nome, int anoDeLancamento) {
        super(nome, anoDeLancamento);
    }

    @Override
    public int getDuracaoMinutos() {
        return this.temporadas * this.episodiosPorTemporada * this.minutosPorEpisodio;
    }

    @Override
    public int getClassificacao() {
        return 0;
    }


}
