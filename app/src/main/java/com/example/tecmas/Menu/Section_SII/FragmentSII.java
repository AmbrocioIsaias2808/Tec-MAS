package com.example.tecmas.Menu.Section_SII;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.tecmas.R;

public class FragmentSII extends Fragment {

    WebView browser;
    SwipeRefreshLayout RefreshLayout;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.menu_fragment_sii, container, false);

        //Creo el swipeview y lo enlazo con su vista
        RefreshLayout=(SwipeRefreshLayout) vista.findViewById(R.id.menu_sii_SwipeRefreshLayout);

        //Creo el webview y lo enlazo con su vista
        browser= (WebView) vista.findViewById(R.id.menu_sii_browser);
        browser.setWebViewClient(new WebViewClient(){

            //Desactivamos la animación del refreshview cuando se termine de cargar la pagina
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(browser, url);
                RefreshLayout.setRefreshing(false);
            }
        });
        //Habilito el uso de javascript
        browser.getSettings().setJavaScriptEnabled(true);

        //Modifico el zoom para que se ajuste al movil
        browser.getSettings().setLoadWithOverviewMode(true);
        browser.getSettings().setUseWideViewPort(true);
        //Habilito el zoom para modificar con gestos
        browser.getSettings().setSupportZoom(true);

        browser.getSettings().setBuiltInZoomControls(true);
        /* Botones en pantalla para el zoom
        browser.getSettings().setDisplayZoomControls(true);

         */

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
                                return true;
                            }
                            break;
                    }
                }

                return false;
            }
        });
        RefreshLayout.setRefreshing(true);
        //Cargo la url:
        browser.loadUrl("http://mictlantecuhtli.itmatamoros.edu.mx");

        //Habilito el refresh del sitio cuando se "jala el webview hacia abajo"
        RefreshLayout.setOnRefreshListener(
                new SwipeRefreshLayout.OnRefreshListener() {
                    @Override
                    public void onRefresh() {
                        browser.loadUrl( "javascript:window.location.reload( true )" );
                    }

                }


        );



        return vista;
    }

}
