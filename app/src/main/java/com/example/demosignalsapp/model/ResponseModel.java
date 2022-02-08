package com.example.demosignalsapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ResponseModel implements Serializable {

    @SerializedName("signals_model")
    @Expose
    private SignalsModel signalsModel;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("status")
    @Expose
    private Integer status;

    public SignalsModel getSignals() {
        return signalsModel;
    }

    public void setSignals(SignalsModel signalsModel) {
        this.signalsModel = signalsModel;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

}
