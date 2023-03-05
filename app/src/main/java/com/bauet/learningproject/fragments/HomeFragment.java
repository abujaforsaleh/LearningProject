package com.bauet.learningproject.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.bauet.learningproject.R;

public class HomeFragment extends Fragment implements View.OnClickListener {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button login, registration, roomDB;

        login = view.findViewById(R.id.login);
        registration = view.findViewById(R.id.registration);
        roomDB = view.findViewById(R.id.roomdb);

        login.setOnClickListener(this);
        registration.setOnClickListener(this);
        roomDB.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        NavController navController = Navigation.findNavController(view);
        switch (view.getId()){
            case R.id.login:
                navController.navigate(R.id.action_homeFragment_to_loginFragment);
                break;
            case R.id.roomdb:
                navController.navigate(R.id.action_homeFragment_to_roomDBFragment);
                break;
        }
    }
}