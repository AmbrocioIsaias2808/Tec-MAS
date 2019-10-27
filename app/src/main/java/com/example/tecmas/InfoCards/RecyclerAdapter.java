package com.example.tecmas.InfoCards;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apersonalizedlibrary.TextJustification;
import com.example.tecmas.Menu.Section_Inicio.fragment_informacion;
import com.example.tecmas.R;
import com.squareup.picasso.Picasso;

import java.util.Collections;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.View_Holder> {

    public static class View_Holder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView title;
       // TextView description;
        ImageView imageView;

        View_Holder(View itemView) {
            super(itemView);
            cv = (CardView) itemView.findViewById(R.id.cardView);
            title = (TextView) itemView.findViewById(R.id.title);
           // description = (TextView) itemView.findViewById(R.id.description);
            imageView = (ImageView) itemView.findViewById(R.id.imageView);
        }
    }



    List<InfoObjects> list = Collections.emptyList();
    Context context;

    public RecyclerAdapter(List<InfoObjects> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public View_Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Inflate the layout, initialize the View Holder
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cards_items, parent, false);
        View_Holder holder = new View_Holder(v);
        return holder;

    }

    @Override
    public void onBindViewHolder(View_Holder holder, final int position) {

        //Use the provided View Holder on the onCreateViewHolder method to populate the current row on the RecyclerView
        holder.title.setText(list.get(position).title);
        //TextJustification.justify(holder.title); //para justificar el texto
       // holder.description.setText(list.get(position).description);
        Picasso.get().load(list.get(position).imageId).into(holder.imageView);

        holder.cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast t = Toast.makeText(context,"Funciona",Toast.LENGTH_LONG);
                //t.show();
                AppCompatActivity activity = (AppCompatActivity) v.getContext();
                Fragment myFragment = new fragment_informacion(list.get(position).articleID);
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, myFragment).addToBackStack(null).commit();


            }
        });


        //animate(holder);

    }

    @Override
    public int getItemCount() {
        //returns the number of elements the RecyclerView will display
        return list.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    // Insert a new item to the RecyclerView on a predefined position
    public void insert(int position, InfoObjects data) {
        list.add(position, data);
        notifyItemInserted(position);

    }

    public void clear(){
        list.clear();
    }

    // Remove a RecyclerView item containing a specified InfoObjects object
    public void remove(InfoObjects data) {
        int position = list.indexOf(data);
        list.remove(position);
        notifyItemRemoved(position);
    }

}

