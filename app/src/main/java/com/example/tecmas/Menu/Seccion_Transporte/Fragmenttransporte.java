package com.example.tecmas.Menu.Seccion_Transporte;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.tecmas.R;
import com.google.android.material.tabs.TabLayout;

public class Fragmenttransporte extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.menu_fragment_transporte, container, false);

        TabLayout tabs = (TabLayout) view.findViewById(R.id.tabs);

        tabs.addTab(tabs.newTab().setText("Ruta 1"));
        tabs.addTab(tabs.newTab().setText("Ruta 2"));
        tabs.addTab(tabs.newTab().setText("Ruta 3"));
        tabs.addTab(tabs.newTab().setText("Ruta 4"));
        tabs.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager = (ViewPager) view.findViewById(R.id.viewPagerTransporte);
        PagerAdapter adaptador = new PagerAdapter(getChildFragmentManager(),tabs.getTabCount());
        viewPager.setAdapter(adaptador);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabs));

        tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position= tab.getPosition();

                viewPager.setCurrentItem(position);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        return view;
    }
}
