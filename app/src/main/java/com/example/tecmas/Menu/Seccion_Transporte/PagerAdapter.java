package com.example.tecmas.Menu.Seccion_Transporte;

import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class PagerAdapter extends FragmentStatePagerAdapter {

    private int numeroDeTabs;


    public PagerAdapter(FragmentManager fm, int ntabs) {
        super(fm);
        this.numeroDeTabs=ntabs;
    }




    @Override
    public Fragment getItem(int position) {
        switch (position){

            case 0:

                return new Section_Transporte_Rutas(position+1);


            case 1:
                return new Section_Transporte_Rutas(position+1);

            case 2:
                return new Section_Transporte_Rutas(position+1);

            case 3:
                return new Section_Transporte_Rutas(position+1);

            default:
                return new Section_Transporte_Rutas();

        }

    }

    @Override
    public int getCount() {
        return numeroDeTabs;
    }
}
