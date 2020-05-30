package com.pcl.procastlive.api;

import retrofit2.Response;

public interface WebServiceResponse {
    public void OnSuccess(Object object);
    public void OnFailure();
    void onErrorHandling(Response response);

}
