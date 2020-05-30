package com.pcl.procastlive.api;

import android.util.Log;

import com.pcl.procastlive.api_response.login.loginResponse.LoginResponse;
import com.pcl.procastlive.api_response.login.loginResponse.UdpdateResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WebServiceHandlerUpdate {
    private RestInterface2 restInterface;

    public WebServiceHandlerUpdate() {
        restInterface = RetrofitSinglton.getClient().create(RestInterface2.class);
    }
    public void playerUpdateStats(final WebServiceResponse webServiceResponse,String playerId) {
        Call<UdpdateResponse> call = restInterface.updateUser(playerId);
        call.enqueue(new Callback<UdpdateResponse>() {
            @Override
            public void onResponse(Call<UdpdateResponse> call, Response<UdpdateResponse> response) {
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
            public void onFailure(Call<UdpdateResponse> call, Throwable t) {
                webServiceResponse.OnFailure();
            }
        });

    }

}
