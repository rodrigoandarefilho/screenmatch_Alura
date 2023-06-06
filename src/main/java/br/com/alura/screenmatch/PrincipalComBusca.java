package br.com.alura.screenmatch;

import br.com.alura.screenmatch.modelos.Categoria;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class PrincipalComBusca {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner input = new Scanner(System.in);
        System.out.print("Digite o nome de um filme: ");
        var busca = input.nextLine();
        String endereco = "https://www.omdbapi.com/?t="+busca+"&apikey=f85a7bd0";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco)).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String json = response.body();

        Gson gson = new Gson();
        Categoria categoria = gson.fromJson(json, Categoria.class);
        System.out.println(categoria.toString());
        input.close();
    }
}
