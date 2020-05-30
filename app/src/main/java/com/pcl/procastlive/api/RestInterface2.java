package com.pcl.procastlive.api;

import com.pcl.procastlive.api_response.login.loginResponse.LoginResponse;
import com.pcl.procastlive.api_response.login.loginResponse.UdpdateResponse;

import retrofit2.Call;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface RestInterface2 {
    @PUT("updateusers/{user/update}")
    Call<UdpdateResponse> updateUser(@Path("user/update") String Update);
}
