package com.example.tecmas.Menu;


import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.KeyEvent;
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
import com.example.tecmas.R;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * A simple {@link Fragment} subclass.
 */
public class InformationViewer extends Fragment {

    private int ID;
    public WebView browser;
    public String URL= "https://wordpresspruebas210919.000webhostapp.com/wp-json/wp/v2/posts/";
    public String data;
    public String website;
    public InformationViewer() {
        // Required empty public constructor
    }

    public InformationViewer(int ID) {
        // Required empty public constructor
        this.URL=this.URL+String.valueOf(ID);
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.informationviever, container, false);

        browser= (WebView) view.findViewById(R.id.info_browser);
        browser.setWebViewClient(new WebViewClient(){

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                if (url != null && (url.startsWith("http://") || url.startsWith("https://"))) {
                    view.getContext().startActivity(
                            new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
                    return true;
                } else {
                    return false;
                }
            }
        });

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
                            //browser.getSettings().setLoadWithOverviewMode(true);
                            // browser.getSettings().setUseWideViewPort(true);

                            browser.getSettings().setSupportZoom(true);

                            browser.getSettings().setBuiltInZoomControls(true);

                            //Modifico el comportamiento del boton regresar del movil para que regrese a la pagina
                            //anterior del webview y no a una activity anterior.
                            browser.setOnKeyListener(new View.OnKeyListener()
                            {

                                @Override
                                public boolean onKey(View v, int keyCode, KeyEvent event)
                                {
                                    if(event.getAction() == KeyEvent.ACTION_DOWN)
                                    {
                                        WebView webView = (WebView) v;

                                        switch(keyCode)
                                        {
                                            case KeyEvent.KEYCODE_BACK:
                                                if(webView.canGoBack())
                                                {

                                                    webView.goBack();
                                                    Toast t = Toast.makeText(getContext(),webView.getUrl().toString(),Toast.LENGTH_LONG);
                                                    t.show();

                                                    return true;
                                                }
                                                break;
                                        }
                                    }

                                    return false;
                                }
                            });




                            website="<html><head><link rel='stylesheet' type='text/css' href='file:///android_asset/estilos.css'/></head><body>"+data+"</body></html>";




                            browser.loadDataWithBaseURL("file:///android_asset/",website, "text/html; charset=utf-8", "UTF-8",null);
                            Toast t = Toast.makeText(getContext(),browser.getUrl().toString(),Toast.LENGTH_LONG);
                            t.show();
                            System.out.println("\n\n\n\n\n\n"+browser.getUrl().toString());

                            //browser.loadData(website, "text/html; charset=utf-8", "UTF-8");








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
