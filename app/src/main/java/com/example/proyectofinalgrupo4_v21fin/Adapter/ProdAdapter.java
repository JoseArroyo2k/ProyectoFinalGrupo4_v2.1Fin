package com.example.proyectofinalgrupo4_v21fin.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyectofinalgrupo4_v21fin.R;

import java.util.List;

public class ProdAdapter extends RecyclerView.Adapter<ProdAdapter.ViewHolder>{

    private List<Productos> prodList;
    private Context context;

    public ProdAdapter(List<Productos> prodList, Context context) {
        this.prodList = prodList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tarjeta_producto,parent);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtNombre.setText(prodList.get(position).getNombre());
        holder.txtPrecio.setText(prodList.get(position).getPrecio());
    }

    @Override
    public int getItemCount() {
        return prodList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        private TextView txtNombre;
        private TextView txtPrecio;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtNombre=itemView.findViewById(R.id.textView9);
            txtPrecio=itemView.findViewById(R.id.textView10);
        }
    }
}
