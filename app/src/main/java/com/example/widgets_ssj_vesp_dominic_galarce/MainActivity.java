package com.example.widgets_ssj_vesp_dominic_galarce;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private ProgressBar barraProgresoMain;
    private TextView textoMain;
    private CheckBox checkBoxCali, checkBoxMisProductos;
    private int progreso; //progreso barra
    private Button botonCargar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        barraProgresoMain = (ProgressBar)findViewById(R.id.pbr);
        textoMain = (TextView)findViewById(R.id.txv);
        checkBoxCali = (CheckBox)findViewById(R.id.cbx1);
        checkBoxMisProductos = (CheckBox)findViewById(R.id.cbx2);
        botonCargar = (Button)findViewById(R.id.btt);
    }

    //rellena el progresbar
    public void Cargar(View view){
        Timer timer = new Timer(); //creamos un temporizador (sirve para correr tareas en segundo plano)

        TimerTask tarea = new TimerTask() { // creamos una tarea
            @Override
            public void run() { //implementa un proceso

                //Rellenar el progresbar en segundo plano
                progreso++; //incrementa el progeso
                barraProgresoMain.setProgress(progreso); //pasamos el progreso a la barra
                textoMain.setText("Mi progreso es: " + barraProgresoMain.getProgress() + "%/100%");
                mostar();
                if (barraProgresoMain.getProgress() == 0){
                    botonCargar.setEnabled(true); //setEnable activa o desactiva el boton
                    cancel();
                }
            }
        };

        timer.schedule(tarea,0,100); //le pasamos la tarea al temporizador.(tarea,tiempo de retraso, periodo de duracion)
    }

    public void mostar(){ //validador de la barra
        if(barraProgresoMain.getProgress() == 100 ){ //si el progreso de la barra es igual a 100
            textoMain.setText("Se ha completado la barra ...");
            //progreso = 0;
            barraProgresoMain.setProgress(0);
        }
    }

    //metodo para navegar entre activities
    public void menu(View view){
        if (checkBoxCali.isChecked() && checkBoxMisProductos.isChecked()){ //preguntamos si estan ambas casillas seleccionadas
            textoMain.setText("Porfavor seleccione 1 sola opcion.");
        }

        else if(!checkBoxCali.isChecked() && !checkBoxMisProductos.isChecked()){
            textoMain.setText("Porfavor seleccione 1 opcion.");
        }

        else{
            if (checkBoxCali.isChecked()){
                Intent i = new Intent(this,Calificaciones_act.class); // pasamos this, la clase de la activity donde queremos saltar
                startActivity(i); //iniciamos la activity pasada anteriormente
            }
            if (checkBoxMisProductos.isChecked()){
                Intent i = new Intent(this,Productos_act.class);
                startActivity(i);
            }
        }
    }
}