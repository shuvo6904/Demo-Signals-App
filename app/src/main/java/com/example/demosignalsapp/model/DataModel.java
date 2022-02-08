package com.example.demosignalsapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class DataModel implements Serializable {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("app_info_id")
    @Expose
    private Integer appInfoId;
    @SerializedName("action")
    @Expose
    private String action;
    @SerializedName("open_price")
    @Expose
    private String openPrice;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("stop_loss")
    @Expose
    private String stopLoss;
    @SerializedName("take_profit_3")
    @Expose
    private String takeProfit3;
    @SerializedName("take_profit")
    @Expose
    private String takeProfit;
    @SerializedName("take_profit_2")
    @Expose
    private String takeProfit2;
    @SerializedName("trade_close")
    @Expose
    private String tradeClose;
    @SerializedName("trade_opening_time")
    @Expose
    private String tradeOpeningTime;
    @SerializedName("trade_result")
    @Expose
    private String tradeResult;
    @SerializedName("currency")
    @Expose
    private String currency;
    @SerializedName("old_new")
    @Expose
    private String oldNew;
    @SerializedName("is_notifiable")
    @Expose
    private Integer isNotifiable;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("time_frame")
    @Expose
    private String timeFrame;
    @SerializedName("probability")
    @Expose
    private String probability;
    @SerializedName("app_info_model")
    @Expose
    private AppInfoModel appInfoModel;


    public DataModel(Integer id, Integer appInfoId, String action, String openPrice, String status, String stopLoss, String takeProfit3, String takeProfit, String takeProfit2, String tradeClose, String tradeOpeningTime, String tradeResult, String currency, String oldNew, Integer isNotifiable, String createdAt, String updatedAt, String timeFrame, String probability, AppInfoModel appInfoModel) {
        this.id = id;
        this.appInfoId = appInfoId;
        this.action = action;
        this.openPrice = openPrice;
        this.status = status;
        this.stopLoss = stopLoss;
        this.takeProfit3 = takeProfit3;
        this.takeProfit = takeProfit;
        this.takeProfit2 = takeProfit2;
        this.tradeClose = tradeClose;
        this.tradeOpeningTime = tradeOpeningTime;
        this.tradeResult = tradeResult;
        this.currency = currency;
        this.oldNew = oldNew;
        this.isNotifiable = isNotifiable;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.timeFrame = timeFrame;
        this.probability = probability;
        this.appInfoModel = appInfoModel;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAppInfoId() {
        return appInfoId;
    }

    public void setAppInfoId(Integer appInfoId) {
        this.appInfoId = appInfoId;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getOpenPrice() {
        return openPrice;
    }

    public void setOpenPrice(String openPrice) {
        this.openPrice = openPrice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStopLoss() {
        return stopLoss;
    }

    public void setStopLoss(String stopLoss) {
        this.stopLoss = stopLoss;
    }

    public String getTakeProfit3() {
        return takeProfit3;
    }

    public void setTakeProfit3(String takeProfit3) {
        this.takeProfit3 = takeProfit3;
    }

    public String getTakeProfit() {
        return takeProfit;
    }

    public void setTakeProfit(String takeProfit) {
        this.takeProfit = takeProfit;
    }

    public String getTakeProfit2() {
        return takeProfit2;
    }

    public void setTakeProfit2(String takeProfit2) {
        this.takeProfit2 = takeProfit2;
    }

    public String getTradeClose() {
        return tradeClose;
    }

    public void setTradeClose(String tradeClose) {
        this.tradeClose = tradeClose;
    }

    public String getTradeOpeningTime() {
        return tradeOpeningTime;
    }

    public void setTradeOpeningTime(String tradeOpeningTime) {
        this.tradeOpeningTime = tradeOpeningTime;
    }

    public String getTradeResult() {
        return tradeResult;
    }

    public void setTradeResult(String tradeResult) {
        this.tradeResult = tradeResult;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getOldNew() {
        return oldNew;
    }

    public void setOldNew(String oldNew) {
        this.oldNew = oldNew;
    }

    public Integer getIsNotifiable() {
        return isNotifiable;
    }

    public void setIsNotifiable(Integer isNotifiable) {
        this.isNotifiable = isNotifiable;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getTimeFrame() {
        return timeFrame;
    }

    public void setTimeFrame(String timeFrame) {
        this.timeFrame = timeFrame;
    }

    public String getProbability() {
        return probability;
    }

    public void setProbability(String probability) {
        this.probability = probability;
    }

    public AppInfoModel getAppInfoModel() {
        return appInfoModel;
    }

    public void setAppInfoModel(AppInfoModel appInfoModel) {
        this.appInfoModel = appInfoModel;
    }
}
