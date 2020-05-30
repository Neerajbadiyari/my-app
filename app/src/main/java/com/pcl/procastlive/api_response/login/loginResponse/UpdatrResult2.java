package com.pcl.procastlive.api_response.login.loginResponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UpdatrResult2 {
    @SerializedName("userId")
    @Expose
    private Integer userId;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("mobile")
    @Expose
    private String mobile;
    @SerializedName("acedemy_name")
    @Expose
    private String acedemyName;
    @SerializedName("acedemy_description")
    @Expose
    private Object acedemyDescription;
    @SerializedName("acedemy_address")
    @Expose
    private String acedemyAddress;
    @SerializedName("acedemy_location")
    private String acedemyLocation;
    @SerializedName("coach_name")
    private String coachname;
    @SerializedName("coach_description")
    private String coachdescription;
    @SerializedName("coach_id")
    private String coachid;
    @SerializedName("academy_id")
    private String academyid;

    public String getStudentname() {
        return studentname;
    }

    public void setStudentname(String studentname) {
        this.studentname = studentname;
    }

    public String getStudentdescription() {
        return studentdescription;
    }

    public void setStudentdescription(String studentdescription) {
        this.studentdescription = studentdescription;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getAgegroup() {
        return agegroup;
    }

    public void setAgegroup(String agegroup) {
        this.agegroup = agegroup;
    }

    public String getStudentaddress() {
        return studentaddress;
    }

    public void setStudentaddress(String studentaddress) {
        this.studentaddress = studentaddress;
    }

    public String getStudentlocation() {
        return studentlocation;
    }

    public void setStudentlocation(String studentlocation) {
        this.studentlocation = studentlocation;
    }

    @SerializedName("student_name")
    private String studentname;
    @SerializedName("student_description")
    private String studentdescription;
    @SerializedName("DOB")
    private String dob;
    @SerializedName("Age_Group")
    private String agegroup;
    @SerializedName("student_address")
    private String studentaddress;
    @SerializedName("student_location")
    private String studentlocation;

    public String getUsercreationdate() {
        return usercreationdate;
    }

    public void setUsercreationdate(String usercreationdate) {
        this.usercreationdate = usercreationdate;
    }

    @SerializedName("user_creation_date")
    private String usercreationdate;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }
    public String getCoachname() {
        return coachname;
    }

    public void setCoachname(String coachname) {
        this.coachname = coachname;
    }

    public String getCoachdescription() {
        return coachdescription;
    }

    public void setCoachdescription(String coachdescription) {
        this.coachdescription = coachdescription;
    }


    public void setStatus(String status) {
        this.status = status;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAcedemyName() {
        return acedemyName;
    }

    public void setAcedemyName(String acedemyName) {
        this.acedemyName = acedemyName;
    }

    public Object getAcedemyDescription() {
        return acedemyDescription;
    }

    public void setAcedemyDescription(Object acedemyDescription) {
        this.acedemyDescription = acedemyDescription;
    }

    public String getAcedemyAddress() {
        return acedemyAddress;
    }

    public void setAcedemyAddress(String acedemyAddress) {
        this.acedemyAddress = acedemyAddress;
    }

    public String getAcedemyLocation() {
        return acedemyLocation;
    }

    public void setAcedemyLocation(String acedemyLocation) {
        this.acedemyLocation = acedemyLocation;
    }

}
