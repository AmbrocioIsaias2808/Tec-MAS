package com.example.tecmas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tecmas.InfoCards.InfoObjects;
import com.example.tecmas.InfoCards.RecyclerAdapter;
import com.onesignal.OneSignal;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;

import com.example.tecmas.Menu.FragmentBecas;
import com.example.tecmas.Menu.FragmentCalendario;
import com.example.tecmas.Menu.FragmentEmergencias;
import com.example.tecmas.Menu.FragmentInicio;
import com.example.tecmas.Menu.FragmentMapaInteractivo;
import com.example.tecmas.Menu.Fragmenttransporte;
import com.google.android.material.navigation.NavigationView;

import java.util.List;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Begin: OneSginal Code
        OneSignal.startInit(this)
                .inFocusDisplaying(OneSignal.OSInFocusDisplayOption.Notification)
                .unsubscribeWhenNotificationsAreDisabled(true)
                .init();
        //End: OneSignalCode
        setContentView(R.layout.activity_main);
        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer= findViewById(R.id.drawer_layout);
        NavigationView navigationView= findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle toggle= new ActionBarDrawerToggle(this,drawer,toolbar,R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle); toggle.syncState();
        if(savedInstanceState==null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new FragmentInicio()).commit();
            navigationView.setCheckedItem(R.id.navmenu_inicio);
        }


    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.navmenu_inicio:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new FragmentInicio()).commit();
                break;
            case R.id.navmenu_becas:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new FragmentBecas()).commit();
                break;
            case R.id.navmenu_calendario:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new FragmentCalendario()).commit();
                break;
            case R.id.navmenu_emergencias:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new FragmentEmergencias()).commit();
                break;
            case R.id.navmenu_transporte:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new Fragmenttransporte()).commit();
                break;
            case R.id.navmenu_mapainteractivo:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new FragmentMapaInteractivo()).commit();
                break;
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public  void onBackPressed(){
        if (drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        }else{
            super.onBackPressed();
        }
    }

}
