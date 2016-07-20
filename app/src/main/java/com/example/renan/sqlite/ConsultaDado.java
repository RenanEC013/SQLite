package com.example.renan.sqlite;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

/**
 * Created by renan on 11/07/2016.
 */
public class ConsultaDado extends Activity {
    private ListView lista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta);

        BancoController crud = new BancoController(getBaseContext());
        final Cursor cursor = crud.carregaDados();

        String[] nomeCampos = new String[] {Carro.getModelo(), Livro.getTitulo()};
        int[] idViews = new int[] {R.id.idLivro, R.id.nomeLivro};

        SimpleCursorAdapter adaptador = new SimpleCursorAdapter(getBaseContext(),
               R.layout.activity_consulta,cursor,nomeCampos,idViews, 0);
        lista = (ListView)findViewById(R.id.listView);
        lista.setAdapter(adaptador);

        System.out.println(lista);

       //lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /* Ao ser clicado, o conteúdo do cursor para a primeira posição captura o código que está contido dentro do cursor */
        //    @Override
          //  public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
          //      String codigo;
          //      cursor.moveToPosition(position);
          //      codigo = cursor.getString(cursor.getColumnIndexOrThrow(MainActivity.getID()));
                /* E o conteúdo é enviado para a próxima Activity */
          //      Intent intent = new Intent(ConsultaDado.this, AlteraDado.class);
        //        intent.putExtra("codigo", codigo);
           //     startActivity(intent);
           //     finish();
           // }
     //   });
    }
}

