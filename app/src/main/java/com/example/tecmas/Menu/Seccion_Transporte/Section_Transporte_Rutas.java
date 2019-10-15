package com.example.tecmas.Menu.Seccion_Transporte;
import android.media.Image;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tecmas.R;

public class Section_Transporte_Rutas extends Fragment {

    int nruta;

    TextView ruta;
    ImageView mapa;
    TextView hora;

    public Section_Transporte_Rutas(int nruta) {
        // Required empty public constructor
        this.nruta=nruta;
    }

    public Section_Transporte_Rutas(){

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.section_transporte_rutas, container, false);

        ruta = (TextView) view.findViewById(R.id.Ruta);
         mapa = (ImageView) view.findViewById(R.id.Mapa_Ruta);
        hora = (TextView) view.findViewById(R.id.Ruta_hora);

        setInfo();

        return  view;
    }

    void setInfo(){
        switch (this.nruta){
            case 1:
                ruta.setText("Ruta 1");
                mapa.setBackgroundResource(R.drawable.mapa_ruta_1);
                hora.setText("9:00");
                break;
            case 2:
                ruta.setText("Ruta 2");
                mapa.setBackgroundResource(R.drawable.mapa_ruta_2);
                hora.setText("9:00");
                break;
            case 3:
                ruta.setText("Ruta 3");
                mapa.setBackgroundResource(R.drawable.mapa_ruta_3);
                hora.setText("9:00");
                break;
        }

    }

}
