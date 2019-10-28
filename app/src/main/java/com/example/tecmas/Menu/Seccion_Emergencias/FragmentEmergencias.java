package com.example.tecmas.Menu.Seccion_Emergencias;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

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

public class FragmentEmergencias extends Fragment {


    String URL_DATA= "https://wordpresspruebas210919.000webhostapp.com/wp-json/wp/v2/posts?categories=4";
    RecyclerAdapter adapter;
    RecyclerView recyclerView;
    private List<InfoObjects> data;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View vista = inflater.inflate(R.layout.menu_fragment_emergencias, container, false);

        data = new ArrayList<>();
        fill_with_data();

        recyclerView = (RecyclerView) vista.findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.getLayoutManager().scrollToPosition(0);


        return vista;
    }

    @Override
    public void onResume() {
        super.onResume();

    }


    public void fill_with_data() {
        Toast t = Toast.makeText(getContext(),"Cargando Datos...",Toast.LENGTH_LONG);
        t.show();
        //final ProgressDialog progressDialog = new ProgressDialog(getContext());
        //progressDialog.setMessage("Loading Data");
        //progressDialog.show();

        StringRequest Datos = new StringRequest(Request.Method.GET, URL_DATA,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {


                        try {

                            JSONArray array = new JSONArray(response);
                            for(int i=0; i<array.length();i++){
                                JSONObject o = array.getJSONObject(i);

                                JSONObject title = o.getJSONObject("title");
                                //String imagen="https://wordpresspruebas210919.000webhostapp.com/wp-content/uploads/2019/10/presidum-768x402-300x157.jpg";
                                String imagen;
                                try{
                                    JSONObject JsonImage = o.getJSONObject("better_featured_image").getJSONObject("media_details").getJSONObject("sizes").getJSONObject("medium");
                                    imagen= JsonImage.getString("source_url");

                                }catch (JSONException e){
                                    imagen="https://wordpresspruebas210919.000webhostapp.com/wp-content/themes/shapely/assets/images/placeholder.jpg";
                                }


                                InfoObjects item = new InfoObjects(
                                        o.getInt("id"),     title.getString("rendered"),"",imagen
                                );
                                data.add(item);
                            }

                            adapter = new RecyclerAdapter(data, getContext());

                            recyclerView.setAdapter(adapter);

                        } catch (JSONException e) {
                            Toast t = Toast.makeText(getContext(),e.getMessage(),Toast.LENGTH_LONG);
                            t.show();
                            e.printStackTrace();

                        }
                        finally {
                            //progressDialog.dismiss();
                        }




                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast t = Toast.makeText(getContext(),error.getMessage(),Toast.LENGTH_LONG);
                        t.show();
                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        requestQueue.getCache().clear();
        requestQueue.add(Datos);

    }
}
