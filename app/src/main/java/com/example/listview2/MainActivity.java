package com.example.listview2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lvdata;
    ArrayList<ModeloItem> lista;
    Adaptador adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvdata = findViewById(R.id.lvData);
        lista = new ArrayList<>();
        adaptador = new Adaptador(this, lista);
        lvdata.setAdapter(adaptador);

        cargarDatos();

        lvdata.setOnItemClickListener((adapterView, view, i, l) -> {
            ModeloItem item = lista.get(i);
            item.setSeleccionado(!item.isSeleccionado());
            adaptador.notifyDataSetChanged();
        });

    }

    void cargarDatos(){
        lista.add(new ModeloItem(R.drawable.ic_launcher_background, "ADIDAS", "Asoociación de idiotas dispuestos a superarse"));
        lista.add(new ModeloItem(R.drawable.ic_launcher_background, "NIKE", "Nunca intentes kitarle el empate"));
        lista.add(new ModeloItem(R.drawable.ic_launcher_background, "PUMA", "Pensando un mundo agradable"));
        lista.add(new ModeloItem(R.drawable.ic_launcher_background, "REEBOK", "Rápido, elegante, estilo, bueno, kualkier cosa"));
        lista.add(new ModeloItem(R.drawable.ic_launcher_background, "VANS", "Vamos a no ser serios"));
        lista.add(new ModeloItem(R.drawable.ic_launcher_background, "CONVERSE", "Conversando con la gente"));
    }
}