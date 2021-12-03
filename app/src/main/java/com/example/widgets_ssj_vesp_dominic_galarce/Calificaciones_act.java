package com.example.widgets_ssj_vesp_dominic_galarce;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RatingBar;
import android.widget.Toast;

public class Calificaciones_act extends AppCompatActivity {

    private RatingBar calificacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calificaciones);

        calificacion = (RatingBar)findViewById(R.id.rtb);
    }

    public void calificar(View view){
        //calificacion.setRating(5); //pinta estrellas
        float rat = calificacion.getRating(); //obtiene las estrellas pintadas

        Toast.makeText(this,"Calificacion: " + rat, Toast.LENGTH_LONG).show();
    }
    public void VolverMenu(View vies){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}