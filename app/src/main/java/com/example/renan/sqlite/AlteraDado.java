package com.example.renan.sqlite;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.renan.sqlite.BancoController;
import com.example.renan.sqlite.R;


public class AlteraDado extends Activity {
    EditText livro;
    EditText autor;
    EditText editora;
    Button alterar;
    Button deletar;
    Cursor cursor;
    BancoController crud;
    String codigo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alteracao);

        codigo = this.getIntent().getStringExtra("codigo");

        crud = new BancoController(getBaseContext());

        livro = (EditText)findViewById(R.id.editText4);
        autor = (EditText)findViewById(R.id.editText5);
        editora = (EditText)findViewById(R.id.editText6);

        alterar = (Button)findViewById(R.id.button2);

        int id = Integer.parseInt(codigo);

    /*    cursor = crud.carregaDadoById(Integer.parseInt(codigo));
        livro.setText(cursor.getString(cursor.getColumnIndexOrThrow(MainActivity.getTitulo())));
        autor.setText(cursor.getString(cursor.getColumnIndexOrThrow(MainActivity.getAutor())));
        editora.setText(cursor.getString(cursor.getColumnIndexOrThrow(MainActivity.getEditora()))); */

        /* Ao pressionar o botão, enviar comando para a alteração ser realizada no banco de dados
        e ir para outra Activity, onde todos os registros do banco de dados serão exibidos.
         */
     /*   alterar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                crud.alteraRegistro(Integer.parseInt(codigo), livro.getText().toString(),autor.getText().toString(),
                        editora.getText().toString());
                Intent intent = new Intent(AlteraDado.this, ConsultaDado.class);
                startActivity(intent);
                finish();
            }
        });

        deletar = (Button)findViewById(R.id.button3);
        deletar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                crud.deletaRegistro(Integer.parseInt(codigo));
                Intent intent = new Intent(AlteraDado.this, ConsultaDado.class);
                startActivity(intent);
                finish();
            }
        }); */
    }
}