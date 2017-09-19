package com.example.usuario.loguearse;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText nombre, apellidos, edad, direccion;
    Button siguiente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nombre = (EditText) findViewById(R.id.nombre);
        apellidos = (EditText) findViewById(R.id.apellidos);
        edad = (EditText) findViewById(R.id.edad);
        direccion = (EditText) findViewById(R.id.direccion);
        siguiente = (Button) findViewById(R.id.btnSiguiente);
        siguiente.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this, ResumeActivity.class);
        login(intent);
        startActivityForResult(intent, 0);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Toast.makeText(this, data.getStringExtra("respuesta"), Toast.LENGTH_LONG).show();
    }

    public void login(Intent intent) {
        String name = nombre.getText().toString();
        String surname = apellidos.getText().toString();
        Integer age = Integer.parseInt(edad.getText().toString());
        String direction = direccion.getText().toString();
        Persona p = new Persona(name, surname, age, direction);
        intent.putExtra("persona", p);
    }
}