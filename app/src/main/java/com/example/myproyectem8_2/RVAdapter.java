package com.example.myproyectem8_2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import java.util.ArrayList;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.ViewHolder> {

    private ArrayList<incidencia> array;
    private llistaincidencia context;

    public RVAdapter(llistaincidencia con, ArrayList<incidencia> arrN) {
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
        ConstraintLayout layout;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            etiquetaTitol = itemView.findViewById(R.id.itemlistadoIncidencia);
            etiquetaUrgencia = itemView.findViewById(R.id.itemlistadourgencia);
            layout = itemView.findViewById(R.id.layout);
        }


    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.etiquetaTitol.setText(array.get(position).getTitol());
        holder.etiquetaUrgencia.setText(array.get(position).getUrgencia());
    }

    @Override
    public int getItemCount() {
        return array.size();
    }
}
