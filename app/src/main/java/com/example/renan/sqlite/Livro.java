package com.example.renan.sqlite;

/**
 * Created by renan on 14/07/2016.
 */
public class Livro {

    private static final String ID = "_id";
    private static final String NOME_TABELA = "livros";
    private static final String TITULO = "titulo";
    private static final String AUTOR = "autor";
    private static final String EDITORA = "editora";

    /* Getters ans setters */
    public static String getID() {
        return Livro.ID;
    }

    public static String getNomeTabela() {
        return Livro.NOME_TABELA;
    }

    public static String getTitulo() {
        return Livro.TITULO;
    }

    public static String getAutor() {
        return Livro.AUTOR;
    }

    public static String getEditora() {
        return Livro.EDITORA;
    }
}
