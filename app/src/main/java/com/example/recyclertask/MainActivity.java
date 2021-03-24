package com.example.recyclertask;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView UserList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        UserList = findViewById(R.id.UserList);

        final UserAdaptor adapter = new UserAdaptor();
        UserList.setLayoutManager(new LinearLayoutManager(this));
        UserList.setAdapter(adapter);

        RandUserAPI client = RetrofitClient.getClient().create(RandUserAPI.class);
        client.fetchUsers(20).enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                List<Result> mlist = response.body().getResults();
                adapter.setData(mlist);
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                Log.e("Main", t.toString());
            }
        });





    }
}