package com.example.usuario.loguearse;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ResumeActivity extends AppCompatActivity implements View.OnClickListener {
    //EditText nombre, apellidos, edad;
    Button volver, finalizar;
    //Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resume);
        volver = (Button) findViewById(R.id.btnVolver);
        volver.setOnClickListener(this);
        finalizar = (Button) findViewById(R.id.btnFinalizar);
        finalizar.setOnClickListener(this);
        TextView display = (TextView) findViewById(R.id.textView);
        Persona persona = getIntent().getParcelableExtra("persona");
        display.setText("- Nombre: " + persona.getNombre() + "\n" + " - Apellidos: " + persona.getApellidos() + "\n" + " - Edad: " + persona.getEdad() + "\n" + " - Dirección: " + persona.getDireccion());
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnVolver:
                Intent intent = new Intent();
                intent.putExtra("respuesta", "he respondido");
                setResult(RESULT_OK, intent);
                finish();
                break;
            case R.id.btnFinalizar:
                finish();
                break;
        }
    }
}