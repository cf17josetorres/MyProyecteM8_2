package com.example.myproyectem8_2;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import java.util.ArrayList;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.ViewHolder> {

    private ArrayList<incidencia> array;
    private Context context;

    public RVAdapter(Context con, ArrayList<incidencia> arrN) {
        array = arrN;
        context = con;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView etiquetaTitol;
        TextView etiquetaUrgencia;
        TextView etiquetaDescripcion;
        TextView etiquetaEstado;
        TextView etiquetaData;
        ConstraintLayout layout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            etiquetaTitol = itemView.findViewById(R.id.itemlistadoIncidencia);
            etiquetaUrgencia = itemView.findViewById(R.id.itemlistadourgencia);
            etiquetaEstado =itemView.findViewById(R.id.itemlistaestado);
            layout = itemView.findViewById(R.id.layout);
        }

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.etiquetaTitol.setText(array.get(position).getTitol());
        holder.etiquetaUrgencia.setText(array.get(position).getUrgencia());
        holder.etiquetaDescripcion.setText(array.get(position).getDesc());
        holder.etiquetaEstado.setText(array.get(position).getEstat());
        holder.etiquetaData.setText(array.get(position).fechaactual());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatActivity activity = (AppCompatActivity)v.getContext();
                Informaciondelosdatos activi =new Informaciondelosdatos();
                Bundle bundle = new Bundle();
                bundle.putString("ITEM_TITLE", array.get(position).getTitol());
                bundle.putString("ITEM_URGENCIA",array.get(position).getUrgencia());
                bundle.putString("ITEM_DESCRIPCION",array.get(position).getDesc());
                bundle.putInt("ITEM_ESTADO",array.get(position).getEstat());
                bundle.putString("ITEM_DATA",array.get(position).fechaactual());

                activi.setArguments(bundle);
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.contenedor, activi).addToBackStack(null).commit();
            }
        });
    }

    @Override
    public int getItemCount() {
        return array.size();
    }
}
