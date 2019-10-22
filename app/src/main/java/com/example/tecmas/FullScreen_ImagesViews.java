package com.example.tecmas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.jsibbold.zoomage.ZoomageView;
import com.squareup.picasso.Picasso;

//import com.bogdwellers.pinchtozoom.ImageMatrixTouchHandler;

public class FullScreen_ImagesViews extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fullscreen_images_views);
        ZoomageView mapa= (ZoomageView) findViewById(R.id.FullScreenImagesViews) ;
        String image= getIntent().getStringExtra("imagenid");
        Picasso.get().load(image).into(mapa);
    }
}
