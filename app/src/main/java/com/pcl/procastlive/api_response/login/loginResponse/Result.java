package com.pcl.procastlive.api_response.login.loginResponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Result {
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("team_id")
    @Expose
    private String teamId;
    @SerializedName("team_name")
    @Expose
    private String teamName;
    @SerializedName("player_name")
    @Expose
    private String playerName;
    @SerializedName("total_runs")
    @Expose
    private String totalRuns;
    @SerializedName("played_last_match")
    @Expose
    private Integer playedLastMatch;
    @SerializedName("total_wkts")
    @Expose
    private Object totalWkts;
    @SerializedName("season8")
    @Expose
    private String season8;
    @SerializedName("is_mail_error")
    @Expose
    private String isMailError;
    @SerializedName("designation")
    @Expose
    private Object designation;
    @SerializedName("tshirt_name")
    @Expose
    private Object tshirtName;
    @SerializedName("tshirt_size")
    @Expose
    private Object tshirtSize;
    @SerializedName("tshirt_no")
    @Expose
    private Object tshirtNo;
    @SerializedName("total_points")
    @Expose
    private Object totalPoints;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getTotalRuns() {
        return totalRuns;
    }

    public void setTotalRuns(String totalRuns) {
        this.totalRuns = totalRuns;
    }

    public Integer getPlayedLastMatch() {
        return playedLastMatch;
    }

    public void setPlayedLastMatch(Integer playedLastMatch) {
        this.playedLastMatch = playedLastMatch;
    }

    public Object getTotalWkts() {
        return totalWkts;
    }

    public void setTotalWkts(Object totalWkts) {
        this.totalWkts = totalWkts;
    }

    public String getSeason8() {
        return season8;
    }

    public void setSeason8(String season8) {
        this.season8 = season8;
    }

    public String getIsMailError() {
        return isMailError;
    }

    public void setIsMailError(String isMailError) {
        this.isMailError = isMailError;
    }

    public Object getDesignation() {
        return designation;
    }

    public void setDesignation(Object designation) {
        this.designation = designation;
    }

    public Object getTshirtName() {
        return tshirtName;
    }

    public void setTshirtName(Object tshirtName) {
        this.tshirtName = tshirtName;
    }

    public Object getTshirtSize() {
        return tshirtSize;
    }

    public void setTshirtSize(Object tshirtSize) {
        this.tshirtSize = tshirtSize;
    }

    public Object getTshirtNo() {
        return tshirtNo;
    }

    public void setTshirtNo(Object tshirtNo) {
        this.tshirtNo = tshirtNo;
    }

    public Object getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(Object totalPoints) {
        this.totalPoints = totalPoints;
    }

}
