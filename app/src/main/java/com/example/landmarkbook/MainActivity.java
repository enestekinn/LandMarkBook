package com.example.landmarkbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.listView);


        final ArrayList <String> landmarkNames = new ArrayList<>();
        landmarkNames.add("Zeugma");
        landmarkNames.add("Galata Kulesi");
        landmarkNames.add("Peri Bacalari");
        landmarkNames.add("Uzungol");

        final ArrayList<String>cityNames = new ArrayList<>();
        cityNames.add("Gaziantep");
        cityNames.add("Istanbul");
        cityNames.add("Nevsehir");
        cityNames.add("Trabzon");

        Bitmap gaziantep = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.gaziantep);
        Bitmap istanbul = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.istanbul);
        Bitmap nevsehir = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.nevsehir);
        Bitmap trabzon = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.trabzon);

        final ArrayList<Bitmap> landmarkImages = new ArrayList<>();
        landmarkImages.add(gaziantep);
        landmarkImages.add(istanbul);
        landmarkImages.add(nevsehir);
        landmarkImages.add(trabzon);


        ArrayAdapter arrayAdapter = new ArrayAdapter(MainActivity.this,android.R.layout.simple_list_item_1,landmarkNames);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                System.out.println(landmarkNames.get(position));
                System.out.println(cityNames.get(position));
                Intent intent = new Intent(getApplicationContext(), DetailActivity.class);
                intent.putExtra("name", landmarkNames.get(position));
                intent.putExtra("city", cityNames.get(position));
                Singleton singleton = Singleton.getInstance();
                singleton.setChosenImage(landmarkImages.get(position));

                startActivity(intent);
            }
                });

        }

}
