package br.com.alura.screenmatch;

import br.com.alura.screenmatch.modelos.Categoria;
import br.com.alura.screenmatch.modelos.Filme;
import br.com.alura.screenmatch.modelos.Serie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PrincipalComListas {
    public static void main(String[] args) {
        var vingadores = new Filme("Os Vingadores", 2014);
        vingadores.avalia(8);
        var lost = new Serie("Lost", 2000);
        lost.avalia(8);
        var filmeDoPaulo = new Filme("Dogville", 2003);
        filmeDoPaulo.avalia(10);
        var filmeAvatar = new Filme("Avatar", 2003);
        filmeDoPaulo.avalia(10);

        List<Categoria> listaDeFilmes = new ArrayList<>();
        listaDeFilmes.add(filmeDoPaulo);
        listaDeFilmes.add(vingadores);
        listaDeFilmes.add(filmeAvatar);
        listaDeFilmes.add(lost);

        for (Categoria item: listaDeFilmes) {
            System.out.println(item.getNome());
            if (item instanceof Filme filme && filme.getClassificacao() > 2) {
                System.out.println("Classificação: " + filme.getClassificacao());
            }
        }

        Collections.sort(listaDeFilmes);
        System.out.println(listaDeFilmes);

        listaDeFilmes.sort(Comparator.comparing(Categoria::getAnoDeLancamento));
        System.out.println(listaDeFilmes);
    }
}
