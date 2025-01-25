package com.gabrielcostanovaes.aplicacao.main;

import com.gabrielcostanovaes.aplicacao.ApiServico.ApiServico;

import java.io.IOException;

public class main {
    public static void main(String[] args) throws IOException, InterruptedException {

        ApiServico servico = new ApiServico();
        System.out.println(servico.getEndereco("49040320"));
    }
}
