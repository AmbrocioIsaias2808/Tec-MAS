package com.example.tecmas.Menu;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tecmas.InfoCards.InfoObjects;
import com.example.tecmas.InfoCards.RecyclerAdapter;
import com.example.tecmas.R;

import java.util.ArrayList;
import java.util.List;

public class FragmentInicio extends Fragment {

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

        List<InfoObjects> data = new ArrayList<>();

        data.add(new InfoObjects("Entrega de Reconocimientos y Constancias a Personal del Instituto Tecnológico de Matamoros", "El Departamento de Recursos Humanos convocó a personal Docente y de Apoyo a la Docencia para realizar la entrega de constancias, estímulos por antigüedad por 10, 15, 20 y 25 años de servicio", R.drawable.img1));
        data.add(new InfoObjects("El Campus Matamoros del TecNM Inicia Ciclo Escolar con 5,000 Estudiantes", "El Tecnológico Nacional de México campus Instituto Tecnológico de Matamoros celebró ceremonia de inicio del Ciclo Escolar 2019-2020 el lunes 19 de agosto en punto de las 10:00 hrs. en el Gimnasio Auditorio del plantel con la asistencia de 1,000 personas entre estudiantes, docentes, personal de apoyo a  la docencia e invitados especiales y de Honor.", R.drawable.ic_launcher_background));
        data.add(new InfoObjects("A nuestra gran comunidad del Instituto Tecnológico de Matamoros", "Da inicio un nuevo ciclo académico, con lo que reafirmamos nuestros objetivos y metas, fortaleciendo los proyectos de mejora continua que cada uno de quienes integramos al TecNM en Matamoros, mantenemos semestre a semestre como parte del compromiso educativo en la región.", R.drawable.img2));
        data.add(new InfoObjects("1er. Lugar en Área de Administración en Maratón de Conocimientos de ANFECA", "Estudiantes del programa educativo de Licenciatura en Administración del Tecnológico Nacional de México (TecNM)  campus Instituto Tecnológico de Matamoros ganaron el 1er. Lugar en la disciplina de Administración", R.drawable.img1));
        data.add(new InfoObjects("Celebramos 47 años de ser Territorio Gorila", "Con un contingente conformado por más de  1,000 jóvenes Estudiantes, Fundadores, Docentes y Personal de Apoyo a la Educación encabezado por la Maestra Mara Grassiel Acosta González, Directora del I.T.Matamoros y la Maestra Genoveva Hi González Directora de la Escuela Secundaria Técnica No. 4 “Gral. Lázaro Cárdenas del Río”, ", R.drawable.img2));
        data.add(new InfoObjects("El TecNM campus Matamoros Entrega 119 Títulos Profesionales", " El viernes 27 de septiembre de 2019 se realizó Ceremonia de Entrega de Títulos a egresados de 11 programas educativos, que acudieron en punto de las 18:00 hrs. al Centro de Información “Q.B.P. Andrés Ortega Guzmán”;", R.drawable.img1));

        return data;
    }
}
