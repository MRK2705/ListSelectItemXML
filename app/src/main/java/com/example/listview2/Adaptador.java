package com.example.listview2;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Adaptador extends BaseAdapter {
    Context context;
    ArrayList<ModeloItem> lista = new ArrayList<ModeloItem>();

    public Adaptador(Context context, ArrayList<ModeloItem> lista) {
        this.context = context;
        this.lista = lista;
    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Object getItem(int i) {
        return lista.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        final ModeloItem item = lista.get(i);
        view = LayoutInflater.from(context).inflate(R.layout.layout_item, null);
        ImageView ivfoto = view.findViewById(R.id.ivFoto);
        TextView tvtitulo = view.findViewById(R.id.tvTitulo);
        TextView tvdetalle = view.findViewById(R.id.tvDetalle);

        ivfoto.setImageResource(item.getFoto());
        tvtitulo.setText(item.getTitulo());
        tvdetalle.setText(item.getDetalle());

        if(item.isSeleccionado()){
            view.setBackgroundColor(Color.GREEN);
        }

        return view;
    }
}
