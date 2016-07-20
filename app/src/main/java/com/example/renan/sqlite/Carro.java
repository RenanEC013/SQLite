package com.example.renan.sqlite;

/**
 * Created by renan on 14/07/2016.
 */
public class Carro {
    private static final String ID = "_id";
    private static final String NOME_TABELA = "carros";
    private static final String MODELO = "modelo";
    private static final String MARCA = "marca";
    private static final String ANO = "ano";

    /* Getters ans setters */
    public static String getID() {
        return Carro.ID;
    }

    public static String getNomeTabela() {
        return Carro.NOME_TABELA;
    }

    public static String getModelo() {
        return Carro.MODELO;
    }

    public static String getMarca() {
        return Carro.MARCA;
    }

    public static String getAno() {
        return Carro.ANO;
    }

}
