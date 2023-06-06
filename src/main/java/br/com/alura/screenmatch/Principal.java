package br.com.alura.screenmatch;

import br.com.alura.screenmatch.utils.CalculadoraDeTempo;
import br.com.alura.screenmatch.modelos.Filme;
import br.com.alura.screenmatch.modelos.Serie;
import br.com.alura.screenmatch.utils.FiltroRecomendacao;

import java.util.ArrayList;
import java.util.List;

public class Principal {
    public static void main(String[] args) {
        Filme vingadores = new Filme("Os Vingadores", 2014);
        vingadores.setDuracaoMinutos(380);
        vingadores.avalia(8);
        vingadores.avalia(5);
        vingadores.avalia(500);
        vingadores.exibeFichaTecnica();

        System.out.println("""
                ***************************
                """);

        Serie lost = new Serie("Lost", 2000);
        lost.exibeFichaTecnica();
        lost.setTemporadas(10);
        lost.setEpisodiosPorTemporada(10);
        lost.setMinutosPorEpisodio(50);

        lost.exibeFichaTecnica();

        CalculadoraDeTempo calculadora = new CalculadoraDeTempo();
        calculadora.inclui(vingadores);
        calculadora.inclui(lost);
        System.out.println("Tempo total: " + calculadora.getTempoTotal());

        FiltroRecomendacao filtroRecomendacao = new FiltroRecomendacao();
        filtroRecomendacao.filtra(vingadores);

        var filmeDoPaulo = new Filme("Dogville", 2003);
        filmeDoPaulo.setDuracaoMinutos(200);
        filmeDoPaulo.avalia(10);
    }
}
