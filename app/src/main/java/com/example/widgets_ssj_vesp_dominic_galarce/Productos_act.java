package com.example.widgets_ssj_vesp_dominic_galarce;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

public class Productos_act extends AppCompatActivity {

    private RadioButton rkilo1, rkilo2;
    private TextView texto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productos);

        rkilo1 = (RadioButton)findViewById(R.id.rbt1);
        rkilo2 = (RadioButton)findViewById(R.id.rbt2);
        texto = (TextView)findViewById(R.id.txv1);
    }

    public void calcular(View view){
        if (rkilo1.isChecked()){
            int resultado = 1000*1;
            texto.setText("1 kilo son: $" + resultado);
        }

        if (rkilo2.isChecked()){
            int resultado = 1000*2;
            texto.setText("2 kilos son: $" + resultado);
        }
    }

    public void VolverMenu(View view){
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
    }
}