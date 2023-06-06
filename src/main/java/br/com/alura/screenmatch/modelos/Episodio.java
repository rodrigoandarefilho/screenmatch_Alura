package br.com.alura.screenmatch.modelos;

import br.com.alura.screenmatch.utils.Classificavel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Episodio implements Classificavel {
    private String nome;
    private int numero;
    private Serie serie;
    private int totalVisualizacoes;

    @Override
    public int getClassificacao() {
        return totalVisualizacoes > 100 ? 4 : 2;
    }
}
