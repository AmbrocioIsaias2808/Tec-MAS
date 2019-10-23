package com.example.tecmas.Menu.Section_Inicio;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.tecmas.InfoCards.InfoObjects;
import com.example.tecmas.InfoCards.RecyclerAdapter;
import com.example.tecmas.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class FragmentInicio extends Fragment {

    String URL_DATA= "https://wordpresspruebas210919.000webhostapp.com/wp-json/wp/v2/posts/";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {




        //Crea la vista del frame
        View vista= inflater.inflate(R.layout.menu_fragment_inicio, container, false);


        List<InfoObjects> data = fill_with_data();

        RecyclerView recyclerView = (RecyclerView) vista.findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        RecyclerAdapter adapter = new RecyclerAdapter(data, getContext());
        recyclerView.setAdapter(adapter);


        return vista;




    }

    public List<InfoObjects> fill_with_data() {

        final List<InfoObjects> data = new ArrayList<>();

        StringRequest Datos = new StringRequest(Request.Method.GET, URL_DATA,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {

                          JSONArray array = new JSONArray(response);
                          for(int i=0; i<array.length();i++){
                              JSONObject o = array.getJSONObject(i);
                              data.add(new InfoObjects(o.getInt("id"),o.getString("title"),"",R.drawable.ic_launcher_background));

                          }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        requestQueue.add(Datos);
        
        return data;
    }
}
