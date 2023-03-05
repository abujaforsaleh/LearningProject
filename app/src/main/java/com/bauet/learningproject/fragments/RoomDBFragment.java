package com.bauet.learningproject.fragments;

import android.os.AsyncTask;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.room.Room;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.bauet.learningproject.R;
import com.bauet.learningproject.db.MyRoomDB;
import com.bauet.learningproject.db.UserDao;
import com.bauet.learningproject.models.User;

import java.util.List;
import java.util.Random;

public class RoomDBFragment extends Fragment implements View.OnClickListener {
    MyRoomDB db;
    UserDao userDao;
    TextView tv;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_room_d_b, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        db = Room.databaseBuilder(getContext(),
                MyRoomDB.class, "userdb").build();
        userDao = db.userDao();

        Button createBtn, fetchBtn;


        tv = view.findViewById(R.id.textView);
        createBtn = view.findViewById(R.id.create_btn_id);
        fetchBtn = view.findViewById(R.id.fetch_btn_id);

        createBtn.setOnClickListener(this);
        fetchBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        if(view.getId()==R.id.create_btn_id){
            new CreateDataTask().execute();

        }else{
            new GetDataTask().execute();

        }
    }

    private class CreateDataTask extends AsyncTask<Void, Void, Void> {
        Random random = new Random();
        @Override
        protected Void doInBackground(Void... voids) {
            User user = new User("abu "+random.nextInt(100), "jafor "+random.nextInt(100));
            userDao.insert(user);

            return null;
        }
    }

    private class GetDataTask extends AsyncTask<Void, Void, String> {

        @Override
        protected String doInBackground(Void... voids) {
            List<User> users = userDao.getAll();
            String output = "";
            for(User val : users){
                output+=val.firstName+" "+val.lastName+"\n";
            }

            return output;
        }

        @Override
        protected void onPostExecute(String output) {
            tv.setText(output);

            super.onPostExecute(output);
        }
    }


}