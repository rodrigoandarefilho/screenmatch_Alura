package br.com.alura.screenmatch;

import br.com.alura.screenmatch.exceptions.ErroAnoDeLancamento;
import br.com.alura.screenmatch.modelos.Categoria;
import br.com.alura.screenmatch.modelos.CategoriaApi;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class PrincipalComBusca {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner input = new Scanner(System.in);
        System.out.print("Digite o nome de um filme: ");
        var busca = URLEncoder.encode(input.nextLine(), StandardCharsets.UTF_8);
        String endereco = "https://www.omdbapi.com/?t="+busca+"&apikey=f85a7bd0";

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(endereco)).build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String json = response.body();

            Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).create();
            CategoriaApi categoriaApi = gson.fromJson(json, CategoriaApi.class);
            Categoria categoria = new Categoria(categoriaApi);
            System.out.println(categoria);
        } catch (NumberFormatException e) {
            System.out.println("Deu algum problema nos parametros recebidos da API");
            System.out.println(e.getMessage());
        } catch (ErroAnoDeLancamento e) {
            System.out.println(e.getMessage());
        }
        input.close();
    }
}
