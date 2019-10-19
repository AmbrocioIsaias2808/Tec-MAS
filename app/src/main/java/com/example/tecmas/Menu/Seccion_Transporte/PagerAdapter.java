package com.example.tecmas.Menu.Seccion_Transporte;

import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class PagerAdapter extends FragmentStatePagerAdapter {

    private int numeroDeTabs;
    private Section_Transporte_Rutas[] objetos;


    public PagerAdapter(FragmentManager fm, int ntabs) {
        super(fm);
        this.numeroDeTabs=ntabs;
        objetos= new Section_Transporte_Rutas[ntabs];
        for (int i=0; i<ntabs;i++){
            objetos[i] = new Section_Transporte_Rutas(i);
        }

    }




    @Override
    public Fragment getItem(int position) {
        return objetos[position];

    }

    @Override
    public int getCount() {
        return numeroDeTabs;
    }
}
