package com.pcl.procastlive.api;


import com.pcl.procastlive.api_response.login.loginResponse.LoginResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;


public interface RestInterface {

    @GET("users/{playerMobile}")
    Call<LoginResponse> playerLogin(@Path("playerMobile") String playerMobile);

   //@POST("tournaments/getPlayerDetails")
   // Call<LoginResponse> playerGetDetails(@Body Map<String, String> playerData);

}

