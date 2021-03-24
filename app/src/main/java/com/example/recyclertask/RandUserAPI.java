package com.example.recyclertask;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RandUserAPI {

    @GET("/api/")
    Call<UserResponse> fetchUsers(@Query("results")int results);
}
