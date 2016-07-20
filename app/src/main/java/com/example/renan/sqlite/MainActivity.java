package com.example.renan.sqlite;

import android.app.Activity;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Renan Paes Leme de Souza on 10/07/2016 (DD/MM/YYYY).
 */
public class MainActivity extends SQLiteOpenHelper {

    /* Construtor */
    public MainActivity (Context context) {
        super(context, NOME_BANCO, null, VERSAO);
    }

    /* Informações do banco de dados a ser criado */
    private static final String NOME_BANCO = "banco.db";
    private static final int VERSAO = 5;

    @Override
    public void onCreate(SQLiteDatabase db) {
        /* Montar o banco de dados
         * A string slivro representa a criação de uma tabela "livros"
         * e a string carro representa a criação de uma tabela para "carros" */
        String livro = "CREATE TABLE "+Livro.getNomeTabela()+"("
                + Livro.getID() + " integer primary key autoincrement, "
                + Livro.getTitulo() + " text, "
                + Livro.getAutor() + " text, "
                + Livro.getEditora() + " text )";
        db.execSQL(livro);

        String carro = "CREATE TABLE "+Carro.getNomeTabela()+"("
                + Carro.getID() + " integer primary key autoincrement, "
                + Carro.getModelo() + " text, "
                + Carro.getMarca() + " text, "
                + Carro.getAno() + " text )";
        db.execSQL(carro);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        /* Verifica se o banco de dados existe e, em caso afirmativo, realiza a operação
        de remoção e chama o método onCreate para montar um novo banco de dados */
        db.execSQL("DROP TABLE IF EXISTS " + Livro.getNomeTabela());
        db.execSQL("DROP TABLE IF EXISTS " + Carro.getNomeTabela());
        onCreate(db);

    }

}