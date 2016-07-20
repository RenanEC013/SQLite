package com.example.renan.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.lang.reflect.Field;

/**
 * Created by renan on 11/07/2016.
 * A classe é responsável por controlar as manipulações do banco
 */
public class BancoController {

    private SQLiteDatabase db;
    private MainActivity banco;

    public BancoController(Context context){
        banco = new MainActivity(context);
    }

    /* Função que insere os dados em um banco de dados */
    public String insereDado(String titulo, String autor, String editora, String modelo, String marca, String ano){
        ContentValues valores, valores2;
        long resultado, resultado2;

        /* Indica que o banco será utilizado para leitura e escrita de dados */
        db = banco.getWritableDatabase();

        valores = new ContentValues();
        valores2 = new ContentValues();

        valores.put(Carro.getModelo(), modelo);
        valores.put(Carro.getMarca(), marca);
        valores.put(Carro.getAno(), ano);

        valores2.put(Livro.getTitulo(), titulo);
        valores2.put(Livro.getAutor(), autor);
        valores2.put(Livro.getEditora(), editora);

        System.out.println(valores);

        resultado = db.insert(Carro.getNomeTabela(), null, valores);
        resultado2 = db.insert(Livro.getNomeTabela(), null, valores2);

        db.close();

        if ((resultado == -1) && (resultado2 == 1)) {
            return "Erro ao inserir registro";    // Retornar essa mensagem caso a inserção seja mal-sucedida.
        } else {
            return "Registro Inserido com sucesso!";   // Retornar essa mensagem caso contrário.
        }

    }

    /* Função que consulta os dados de um banco de dados */
        public Cursor carregaDados(){
        Cursor cursor;

        /* Faz com que os dados sejam acessados como somente para leitura */
        db = banco.getReadableDatabase();
     //   cursor = db.query(Carro, campos, null, null, null, null, null, null);
        cursor = db.rawQuery("SELECT * FROM carros, livros", null);


        if(cursor != null){
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }

    /* Função que carrega dados a partir de um ID fornecido como parâmetro */
 /*   public Cursor carregaDadoById(int id){
        Cursor cursor;
        String[] campos =  {banco.getID2(),banco.getModelo(),banco.getMarca(),banco.getAno()};
        String where = MainActivity.getID() + "=" + id;
        db = banco.getReadableDatabase();
        cursor = db.query(MainActivity.getTabela(),campos,where, null, null, null, null, null);

        if(cursor != null){
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }

    public void alteraRegistro(int id, String titulo, String autor, String editora){
        ContentValues valores;
        String where;

        db = banco.getWritableDatabase();

        where = MainActivity.getID() + "=" + id;

        valores = new ContentValues();
        valores.put(MainActivity.getTitulo(), titulo);
        valores.put(MainActivity.getAutor(), autor);
        valores.put(MainActivity.getEditora(), editora);

        db.update(MainActivity.getTabela(),valores,where,null);
        db.close();
    } */

    /* Função que remove, a partir de um id, os dados de um banco de dados */
  /* public void deletaRegistro(int id){
        String where = MainActivity.getID() + "=" + id;
        db = banco.getReadableDatabase();
        db.delete(MainActivity.getTabela(),where,null);
        db.close();
    } */
}
