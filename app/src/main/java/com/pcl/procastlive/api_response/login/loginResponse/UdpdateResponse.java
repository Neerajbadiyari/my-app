package com.pcl.procastlive.api_response.login.loginResponse;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class UdpdateResponse
{

        @SerializedName("status")
        private String status;
        @SerializedName("results")
        private List<UpdatrResult2> results2 = null;
        @SerializedName("message")

        private String message;
        @SerializedName("code")
        private Integer code;
        public String getStatus() {
        return status;
    }

        public void setStatus(String status) {
        this.status = status;
    }

        public List<UpdatrResult2> getResults2() {
        return results2;
    }

        public void setResults2(List<UpdatrResult2> results2) {
        this.results2 = results2;
    }

    /*public List<Result2> getResults() {
        return results;
    }

    public void setResults(List<Result2> results)
    {
        this.results = results;
    }*/

        public String getMessage() {
        return message;
    }

        public void setMessage(String message) {
        this.message = message;
    }

        public Integer getCode() {
        return code;
    }

        public void setCode(Integer code) {
        this.code = code;
    }

    }

