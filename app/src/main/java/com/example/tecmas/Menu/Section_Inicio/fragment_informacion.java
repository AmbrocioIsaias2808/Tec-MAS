package com.example.tecmas.Menu.Section_Inicio;


import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

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

/**
 * A simple {@link Fragment} subclass.
 */
public class fragment_informacion extends Fragment {

    private int ID;
    public WebView browser;
    public String URL= "https://wordpresspruebas210919.000webhostapp.com/wp-json/wp/v2/posts/";
    public String data;
    public fragment_informacion() {
        // Required empty public constructor
    }

    public fragment_informacion(int ID) {
        // Required empty public constructor
        this.URL=this.URL+String.valueOf(ID);
        System.out.println(this.URL);
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_informacion, container, false);

        browser= (WebView) view.findViewById(R.id.info_browser);
        browser.setWebViewClient(new WebViewClient());

        browser.getSettings().setJavaScriptEnabled(true);

        getArticle();




        return view;
    }


    public void getArticle(){
        final ProgressDialog progressDialog = new ProgressDialog(getContext());
        progressDialog.setMessage("Loading Data");
        progressDialog.show();

        StringRequest Datos = new StringRequest(Request.Method.GET, this.URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {


                        try {


                            JSONObject o = new JSONObject(response);
                            JSONObject content= o.getJSONObject("content");


                                data=content.getString("rendered");
                                System.out.println(data);
                                browser.getSettings().setLoadWithOverviewMode(true);
                                browser.getSettings().setUseWideViewPort(true);

                                browser.loadData(data, "text/html; charset=utf-8", "UTF-8");




                        } catch (JSONException e) {
                            Toast t = Toast.makeText(getContext(),e.getMessage(),Toast.LENGTH_LONG);
                            t.show();
                            e.printStackTrace();

                        }
                        finally {
                            progressDialog.dismiss();
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
        requestQueue.add(Datos);

    }

}
