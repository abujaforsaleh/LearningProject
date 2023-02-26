package com.bauet.learningproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.bauet.learningproject.adapters.MyRecyclerViewAdapter;
import com.bauet.learningproject.models.RecyclerViewModel;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    ArrayList<RecyclerViewModel> dataListForRecyclerView = new ArrayList<>();
    //ArrayList<Integer> imageList = new ArrayList<>();
    RecyclerView myRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpRecyclerModels();

        myRecyclerView = findViewById(R.id.recyclerView);
        MyRecyclerViewAdapter adapter = new MyRecyclerViewAdapter(this, dataListForRecyclerView);
        myRecyclerView.setAdapter(adapter);
        //myRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        myRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));

    }

    private void setUpRecyclerModels(){

        String[] placeName = getResources().getStringArray(R.array.place_names);
        String[] placeCountry = getResources().getStringArray(R.array.place_country);
        String[] placeLocation = getResources().getStringArray(R.array.place_location);
        int length = placeName.length;
        for(int i = 0;i<length;i++){
            String imageName = placeName[i].replace(" ", "_").replace("-", "_").toLowerCase();
            //imageList.add(getResources().getIdentifier(imageName, "drawable", getPackageName()));
            int id = getResources().getIdentifier(imageName, "drawable", getPackageName());
            dataListForRecyclerView.add(new RecyclerViewModel(placeName[i], placeCountry[i], placeLocation[i], id));

        }
    }
}