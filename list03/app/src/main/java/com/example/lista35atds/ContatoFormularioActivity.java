package com.example.lista35atds;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

public class ContatoFormularioActivity extends AppCompatActivity {
    private EditText edtCodigo;
    private EditText edtNome;
    private EditText edtTelefone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contato_formulario);

        edtCodigo = findViewById(R.id.edtCodigo);
        edtNome = findViewById(R.id.edtNome);
        edtTelefone = findViewById(R.id.edtTelefone);

        Intent intentRecebida = getIntent();

        if (intentRecebida.hasExtra("contato")) {
            Contato contato = (Contato) intentRecebida.getSerializableExtra("contato");

            edtCodigo.setText(String.valueOf(contato.getCodigo()));
            edtNome.setText(contato.getNome());
            edtTelefone.setText(contato.getTelefone());

        }
    }
}