package br.com.alura.screenmatch.modelos;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Categoria implements Comparable<Categoria> {
    @SerializedName("Title")
    private String nome;
    @SerializedName("Year")
    private int anoDeLancamento;
    private boolean incluidoNoPlano;
    private double somaDasAvaliacoes;
    private int totalDeAvaliacoes;
    private int duracaoMinutos;

    public Categoria(String nome, int anoDeLancamento) {
        this.nome = nome;
        this.anoDeLancamento = anoDeLancamento;
    }

    public void exibeFichaTecnica() {
        System.out.println("Nome do filme: " + this.nome);
        System.out.println("Ano de lançamento: " + this.anoDeLancamento);
        System.out.println("Total de avaliações: " + this.totalDeAvaliacoes);
        System.out.println("Duração em minutos: " + this.duracaoMinutos);
    }

    public void avalia(double nota) {
        this.somaDasAvaliacoes += nota;
        this.totalDeAvaliacoes++;
    }

    public double pegaMedia() {
        return this.somaDasAvaliacoes / this.totalDeAvaliacoes;
    }

    @Override
    public String toString() {
        return "Titulo: " + this.getNome() + " Ano de lançamento: " +"( " + this.getAnoDeLancamento() + " )";
    }

    @Override
    public int compareTo(Categoria categoria) {
        return this.getNome().compareTo(categoria.getNome());
    }
}
