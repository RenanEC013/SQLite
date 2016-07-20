package com.example.renan.sqlite;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by renan on 11/07/2016.
 * Função que conversa com a tela do aplicativo e envia as informações a serem
 * inseridas no banco de dados.
 */
public class InsereDado extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button botao = (Button)findViewById(R.id.button);

        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BancoController crud = new BancoController(getBaseContext());
                EditText titulo = (EditText)findViewById(R.id.editText);
                EditText autor = (EditText)findViewById((R.id.editText2));
                EditText editora = (EditText)findViewById(R.id.editText3);
                String tituloString = titulo.getText().toString();
                String autorString = autor.getText().toString();
                String editoraString = editora.getText().toString();

                EditText modelo = (EditText)findViewById(R.id.editText4);
                EditText marca = (EditText)findViewById((R.id.editText5));
                EditText ano = (EditText)findViewById(R.id.editText6);
                String modeloString = modelo.getText().toString();
                String marcaString = marca.getText().toString();
                String anoString = ano.getText().toString();


                String resultado;

                /* Com os dados a serem inseridos no BD obtidos, enviá-los para a função de inserção */
                resultado = crud.insereDado(tituloString, autorString, editoraString, modeloString, marcaString, anoString);

                Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();
            }
        });

        Button botao2 = (Button)findViewById(R.id.button2);

        botao2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), ConsultaDado.class);
                startActivity(intent);
            }
        });

    }
}