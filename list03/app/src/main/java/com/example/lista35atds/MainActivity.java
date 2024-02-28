package com.example.lista35atds;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // fonte de dados
        Contato[] contatos = {
                new Contato(1, "Nome 1", "(11) 11111-1111"),
                new Contato(2, "Nome 2", "(22) 22222-2222"),
                new Contato(3, "Nome 3", "(33) 33333-3333"),
                new Contato(4, "Nome 4", "(44) 44444-4444"),
                new Contato(5, "Nome 5", "(55) 55555-5555")
                };

        // componente de lista
        ListView ltvLista = findViewById(R.id.ltvLista);

        // adaptador
        ContatoArrayAdapter adaptador =
                new ContatoArrayAdapter(MainActivity.this,
                                        R.layout.item_contato,
                                        contatos);

        // associar adaptador ao componente de lista
        ltvLista.setAdapter(adaptador);

        ltvLista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent abrirContatoFormulario = new Intent(MainActivity.this, ContatoFormularioActivity.class);

                Contato contatoSelecioado = (Contato) parent.getItemAtPosition(position);
                abrirContatoFormulario.putExtra("contato", contatoSelecioado);

                startActivity(abrirContatoFormulario);
            }
        });
    }
}