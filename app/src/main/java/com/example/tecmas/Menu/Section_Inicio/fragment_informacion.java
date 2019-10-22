package com.example.tecmas.Menu.Section_Inicio;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.example.tecmas.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class fragment_informacion extends Fragment {

    private int ID;
    public WebView browser;
    public String data=
            "<html><head></head><body>"+
            "<!-- wp:image -->\n" +
            "<figure class=\"wp-block-image\"><img style=\"width:100%; height:25%\" src=\"http://www.itmatamoros.edu.mx/wp-content/uploads/2019/09/index_fichas_nuevo_ingreso2.jpg\" alt=\"\"/></figure>\n" +
            "<!-- /wp:image -->\n" +
            "\n" +
            "<div id=\"content\" class=\"clearfix\"> <br /><!--\n" +
            "\t<article class=\"post-content\">\n" +
            "-->REQUISITOS PARA EL INGRESO\n" +
            "<p>A.- Presentar y aprobar el examen de ingreso</p>\n" +
            "<p>B.- Asistir obligatoriamente de manera regular al curso de nivelación de álgebra</p>\n" +
            "<p>C.- Cumplir con toda la documentación solicitada por el Departamento de Servicios Escolares.</p>\n" +
            "<p style=\"text-align: center;\"><span style=\"color: #ff0000;\"><strong>PROCEDIMIENTO PARA SOLICITAR </strong></span></p>\n" +
            "<p style=\"text-align: center;\"><span style=\"color: #ff0000;\"><strong>FICHA DE NUEVO INGRESO:</strong></span></p>\n" +
            "<p style=\"text-align: center;\"><strong>PERIODO DE FICHAS A PARTIR DEL 20 DE SEPTIEMBRE AL 06 DE DICIEMBRE DE 2019</strong></p>\n" +
            "<p>1.- PAGAR POR CONCEPTO DE FICHA Y GUÍA, <strong>$2000.00 PESOS</strong> EN CUALQUIER SUCURSAL DEL BANCO <strong>BANAMEX</strong> EN LA <strong>CUENTA 7600458, SUC. 146, REFERENCIA: EXAMENCENEVAL89.</strong></p>\n" +
            "<p>2.- PRESENTARSE EN EL  <strong>DEPARTAMENTO DE SERVICIOS ESCOLARES </strong> UBICADO EN EL EDIFICIO ADMINISTRATIVO PARA REVISIÓN DE DOCUMENTOS.</p>\n" +
            "<p>PRESENTAR EN EL SIGUIENTE ORDEN:</p>\n" +
            "<ul>\n" +
            "<li>FICHA DE DEPÓSITO BANCARIO</li>\n" +
            "<li>ORIGINAL Y COPIA DEL CERTIFICADO DE BACHILLERATO O REVALIDACIÓN DE ESTUDIOS(SI ESTUDIO EN EL EXTRANJERO)</li>\n" +
            "<li>ORIGINAL Y COPIA DEL ACTA DE NACIMIENTO CON FECHA DE EXPEDICIÓN NO MAYOR A UN AÑO</li>\n" +
            "<li>COPIA DE LA CURP FORMATO ACTUAL AL 2019</li>\n" +
            "<li>SEIS  FOTOGRAFÍAS EN PAPEL <u>MATE</u> AUTOHADERIBLES BLANCO Y NEGRO O A COLOR RECIENTES.</li>\n" +
            "</ul>\n" +
            "<p>3.- UNA VEZ REVISADO EL EXPEDIENTE PASAR AL DEPARTAMENTO DE <strong>RECURSOS FINANCIEROS</strong> PARA CANJEAR LA FICHA BANCARIA POR <strong>RECIBO OFICIAL</strong> EN VENTANILLA DEL DEPARTAMENTO DE RECURSOS FINANCIEROS<strong>.</strong></p>\n" +
            "<p> </p>\n" +
            "<p><strong><em>NO SE ACEPTARÁN PAGOS EN EL PLANTEL, SÓLO EN EL BANCO.</em></strong></p>\n" +
            "<p> </p>\n" +
            "<p><strong>NOTA: CON BASE EN LOS PROCESOS DECLARADOS AL SISTEMA DE GESTIÓN DE CALIDAD, NO ES POSIBLE DEVOLVER LA CUOTA DE EXAMEN CENEVAL PAGADA INDEBIDAMENTE (SIN EXCEPCIÓN).</strong></p>\n" +
            "<p><strong>QUIEN REQUIERA RECIBO (FACTURA ELECTRÓNICA) A NOMBRE DE LA EMPRESA O PERSONA FÍSICA.</strong></p>\n" +
            "<p><strong>Deberá realizar el pago en ventanilla del Departamento de Recursos Financieros, con cheque, tarjeta de crédito o débito, presentando cédula y domicilio fiscal de la empresa o persona física.</strong></p>\n" +
            "<p> </p>\n" +
            "<p>4.- DIRIGIRSE NUEVAMENTE AL <strong>DEPARTAMENTO DE SERVICIOS ESCOLARES </strong> PARA LA IMPRESIÓN DE SU <strong>FICHA</strong>.</p>\n" +
            "<p>5.- ACUDIR AL  <strong>DEPARTAMENTO DE DESARROLLO ACADÉMICO </strong>PARA ENTREGAR LA <strong>FICHA DE EXAMEN</strong></p>\n" +
            "<p><strong>NOTA: DESCARGAR LA GUÍA DE  ESTUDIOS</strong> CORRESPONDIENTE.</p>\n" +
            "<ul>\n" +
            "<li><a href=\"http://www.itmatamoros.edu.mx/wp-content/themes/tecnologico/pdf/GUIA_DE_EXAMEN_DE_ADMISION_PARA_INGENIERIAS.pdf\"  rel=\"noopener noreferrer\">GUÍA DE EXAMEN DE ADMISIÓN PARA INGENIERÍAS</a></li>\n" +
            "<li><a href=\"http://www.itmatamoros.edu.mx/wp-content/themes/tecnologico/pdf/GUIA_PARA_EL_EXAMEN_DE_INGRESO_A_CONTADOR_PUBLICO_Y_ADMINISTRACION.pdf\" rel=\"noopener noreferrer\">GUÍA PARA EL EXAMEN DE INGRESO A CONTADOR PÚBLICO Y ADMINISTRACIÓN</a></li>\n" +
            "</ul>\n" +
            "<p>6.- Presentarse al Examen el viernes 10 de enero del 2020 a las 08:00 en el Centro de Cómputo.</p>\n" +
            "<p>7.- Publicación de Lista de Resultados el viernes 10 de enero del 2020 a las 19:00hrs. en el portal www.matamoros.tecnm.mx</p>\n" +
            "<p>8.- Curso de Nivelación es obligatorio y será del 13 al 23 de enero del 2020 de 08:00 a 11:00 hrs, de lunes a viernes, en el edificio “R”.</p>\n" +
            "<p>9.- Los aspirantes aceptados deberán presentarse a las pláticas de inducción el miércoles 15  de enero de 2020 a las 11:00 hrs. en el Centro de Información.</p>\n" +
            "<p> </p>\n" +
            "<p style=\"text-align: center;\">NOTA: TOMAR EN CUENTA QUE ES <strong>REQUISITO INDISPENSABLE</strong>  ACUDIR PUNTUALMENTE AL <strong>EXAMEN DE SELECCIÓN</strong>  Y PRESENTAR: <strong>LA FICHA DE EXAMEN</strong> (RECIBIDA EN EL DEPARTAMENTO DE SERVICIOS ESCOLARES)</p>\n" +
            "<p> </p>\n" +
            "<p> </p>\n" +
            "<p>Se ofertan los programas educativos:</p>\n" +
            "<p>Ingeniería Industrial</p>\n" +
            "<p>Ingeniería Mecatrónica</p>\n" +
            "<p>Ingeniería en Gestión Empresarial</p>\n" +
            "<p>Licenciatura en Administración</p>\n" +
            "<p>Contador Público</p>\n" +
            "<p><strong> </strong></p>\n" +
            "<p><strong> </strong></p>\n" +
            "<p style=\"text-align: center;\"><span style=\"color: #ff0000;\"><strong>Horario: de 9:00 a 18:00 hrs.   </strong></span></p>\n" +
            "<p style=\"text-align: center;\"><span style=\"color: #ff0000;\"><strong> Tel.: 8688140952 y 53 </strong></span></p>\n" +
            "<p style=\"text-align: center;\"><span style=\"color: #ff0000;\"><strong> Depto. Servicios Escolares ext. 250</strong></span></p>\n" +
            "<p style=\"text-align: center;\"><span style=\"color: #ff0000;\"><strong>Depto. Desarrollo Académico ext. 390</strong></span></p>\n" +
            "<p style=\"text-align: center;\"><span style=\"color: #ff0000;\"><strong>Depto.  Ciencias Básicas ext.  310 y 312</strong></span></p>\n" +
            "<p style=\"text-align: center;\"><span style=\"color: #ff0000;\"><strong>División de Estudios Prof.  ext. 396</strong></span></p>\n" +
            "<div class=\"snap_nopreview sharing robots-nocontent\"> </div></body>";
    public fragment_informacion() {
        // Required empty public constructor
    }

    public fragment_informacion(int ID) {
        // Required empty public constructor
        this.ID=ID;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_informacion, container, false);

        browser= (WebView) view.findViewById(R.id.info_browser);
        browser.setWebViewClient(new WebViewClient());

        browser.getSettings().setJavaScriptEnabled(true);

        browser.loadData(data, "text/html; charset=utf-8", "UTF-8");

        Toast t = Toast.makeText(getContext(),"ArticleID="+ID,Toast.LENGTH_LONG);
        t.show();




        return view;
    }

}
