package com.pcl.procastlive.api;

import android.util.Log;
import com.pcl.procastlive.api_response.login.loginResponse.LoginResponse;

import java.util.Map;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class WebServiceHandler {
    private RestInterface restInterface;
    private WebServiceResponse webServiceResponse;

    public WebServiceHandler() {
        restInterface = RetrofitSinglton.getClient().create(RestInterface.class);
    }

    public void playerLoginStats(final WebServiceResponse webServiceResponse,String playerId) {
        Call<LoginResponse> call = restInterface.playerLogin(playerId);
        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                Log.e("resp", String.valueOf(response));

                if (response.code() == 400) {
                    webServiceResponse.onErrorHandling(response);

                } else if (response.code() == 401) {
                    webServiceResponse.onErrorHandling(response);
                }
                else if (response.code()==200){
                    webServiceResponse.OnSuccess(response.body());
                }
                else {
                    webServiceResponse.onErrorHandling(response);
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                webServiceResponse.OnFailure();
            }
        });

    }

}
