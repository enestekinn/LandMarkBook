package com.example.landmarkbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ImageView imageView = findViewById(R.id.imageView);
        TextView landmarkNameText = findViewById(R.id.landmarkNameText);
        TextView cityNameText = findViewById(R.id.cityNameText);

        Intent intent = getIntent();
        String landmarkName = intent.getStringExtra("name");
        String cityName = intent.getStringExtra("city");

        landmarkNameText.setText(landmarkName);
        cityNameText.setText(cityName);

       Singleton singleton = Singleton.getInstance();
               imageView.setImageBitmap(singleton.getChosenImage());

    }
}
