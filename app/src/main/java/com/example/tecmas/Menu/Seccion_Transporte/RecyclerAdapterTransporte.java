package com.example.tecmas.Menu.Seccion_Transporte;

import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apersonalizedlibrary.TextJustification;
import com.example.tecmas.InfoCards.InfoObjects;
import com.example.tecmas.R;
import com.jsibbold.zoomage.ZoomageView;
import com.squareup.picasso.Picasso;
import com.example.tecmas.FullScreen_ImagesViews;
import java.util.Collections;
import java.util.List;

public class RecyclerAdapterTransporte extends RecyclerView.Adapter<RecyclerAdapterTransporte.View_Holder> {

    public static class View_Holder extends RecyclerView.ViewHolder {
        LinearLayout ly;
        TextView ruta;
       TextView hora;
        ZoomageView mapa;

        View_Holder(View itemView) {
            super(itemView);
            ly = (LinearLayout) itemView.findViewById(R.id.tabscontent_layout);
            ruta = (TextView) itemView.findViewById(R.id.Ruta);
            hora = (TextView) itemView.findViewById(R.id.Ruta_hora);
            mapa = (ZoomageView) itemView.findViewById(R.id.Mapa_Ruta);
        }
    }



    String Ruta;
    String Hora;
    String Mapa;
    Context context;

    public RecyclerAdapterTransporte(String ruta,String mapa, String hora, Context context) {
        this.Ruta= ruta;
        this.Hora=hora;
        this.Mapa=mapa;
        this.context = context;
    }

    @Override
    public View_Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Inflate the layout, initialize the View Holder
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.tabs_transporte_content, parent, false);
        View_Holder holder = new View_Holder(v);
        return holder;

    }

    @Override
    public void onBindViewHolder(View_Holder holder, int position) {

        //Use the provided View Holder on the onCreateViewHolder method to populate the current row on the RecyclerView
        //holder.ruta.setText(Ruta);
        //TextJustification.justify(holder.ruta); //para justificar el texto
        //holder.hora.setText(Hora);
        Picasso.get().load(Mapa).into(holder.mapa);
        holder.mapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, FullScreen_ImagesViews.class);
                intent.putExtra("imagenid",Mapa);
                context.startActivity(intent);

            }
        });


    }

    @Override
    public int getItemCount() {
        //returns the number of elements the RecyclerView will display
        return 1;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }


}

