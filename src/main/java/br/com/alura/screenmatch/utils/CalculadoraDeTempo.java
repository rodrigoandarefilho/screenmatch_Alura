package br.com.alura.screenmatch.utils;

import br.com.alura.screenmatch.modelos.Categoria;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CalculadoraDeTempo  {
    private int tempoTotal;

    public void inclui(Categoria categoria) {
        this.tempoTotal += categoria.getDuracaoMinutos();
    }
}
