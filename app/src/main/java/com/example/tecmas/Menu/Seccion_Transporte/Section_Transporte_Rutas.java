package com.example.tecmas.Menu.Seccion_Transporte;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tecmas.FullScreen_ImagesViews;
import com.example.tecmas.Menu.Seccion_Transporte.RecyclerAdapterTransporte;
import com.example.tecmas.R;

public class Section_Transporte_Rutas extends Fragment {

    int nruta;

    TextView ruta;
    ImageView mapa;
    TextView hora;
    View view;
    RecyclerAdapterTransporte adapter;

    public Section_Transporte_Rutas(int nruta) {
        // Required empty public constructor
        this.nruta=nruta;
    }

    public Section_Transporte_Rutas(){

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.section_transporte_rutas, container, false);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerview_tabs_transporte);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        setInfo();
        recyclerView.setAdapter(adapter);


        return  view;
    }

    void setInfo(){
        switch (this.nruta){
            case 0:
                adapter = new RecyclerAdapterTransporte("Ruta 1","http://www.itmatamoros.edu.mx/wp-content/uploads/2019/02/Ruta-Tec-1-2019.jpg","10:00", getContext());
                /*mapa.setBackgroundResource(R.drawable.mapa_ruta_1);
                mapa.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(getContext(), FullScreen_ImagesViews.class);
                        intent.putExtra("imagenid",R.drawable.mapa_ruta_1);
                        startActivity(intent);

                    }
                });*/
                //mapa.setOnTouchListener(new ImageMatrixTouchHandler(view.getContext()));

                break;
            case 1:
                adapter = new RecyclerAdapterTransporte("Ruta 2","http://www.itmatamoros.edu.mx/wp-content/uploads/2019/02/Ruta-Tec-2-2019.jpg","10:00", getContext());
                /*mapa.setBackgroundResource(R.drawable.mapa_ruta_2);
                //mapa.setOnTouchListener(new ImageMatrixTouchHandler(view.getContext()));
                mapa.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(getContext(), FullScreen_ImagesViews.class);
                        intent.putExtra("imagenid",R.drawable.mapa_ruta_2);
                        startActivity(intent);

                    }
                });*/

                break;
            case 2:
                adapter = new RecyclerAdapterTransporte("Ruta 3","http://www.itmatamoros.edu.mx/wp-content/uploads/2019/02/Ruta-Tec-3-2019.jpg","10:20", getContext());
                /*mapa.setBackgroundResource(R.drawable.mapa_ruta_3);
                //mapa.setOnTouchListener(new ImageMatrixTouchHandler(view.getContext()));
                mapa.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(getContext(), FullScreen_ImagesViews.class);

                        intent.putExtra("imagenid",R.drawable.mapa_ruta_3);
                        startActivity(intent);

                    }
                });*/

                break;
        }

    }

}
