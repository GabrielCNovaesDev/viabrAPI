package com.gabrielcostanovaes.aplicacao.ApiServico;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gabrielcostanovaes.aplicacao.endereco.EnderecoOBJ;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiServico{

    EnderecoOBJ enderecoOBJ = new EnderecoOBJ();

    public EnderecoOBJ getEndereco(String cep) throws IOException, InterruptedException {
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("http://viacep.com.br/ws/"+ cep +"/json/"))
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            ObjectMapper mapper = new ObjectMapper();
            enderecoOBJ = mapper.readValue(response.body(), EnderecoOBJ.class);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        return enderecoOBJ;
    }
}
