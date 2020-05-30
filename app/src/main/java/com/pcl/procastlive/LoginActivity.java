package com.pcl.procastlive;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.navigation.ui.NavigationUI;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.auth.api.credentials.HintRequest;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.pcl.procastlive.api.WebServiceHandler;
import com.pcl.procastlive.api.WebServiceResponse;
import com.pcl.procastlive.api_response.login.loginResponse.LoginResponse;
import com.pcl.procastlive.api_response.login.loginResponse.Result;
import com.pcl.procastlive.api_response.login.loginResponse.Result2;
import com.pcl.procastlive.utils.GlobalUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Response;


public class LoginActivity extends AppCompatActivity implements GoogleApiClient.ConnectionCallbacks,
        SmsBroadcastReceiver.OtpReceivedListener, GoogleApiClient.OnConnectionFailedListener, WebServiceResponse, View.OnClickListener{

    private static int RESOLVE_HINT = 2;
    @BindView(R.id.btn_submit)
    AppCompatButton btn_submit;
    @BindView(R.id.progress_bar)
    ProgressBar progressBar;
    EditText editTextNumber;
    private GoogleApiClient googleApiClient;
    private static String phoneNumber;
    int requestType = 1;
    List<Result2> playerResult = new ArrayList<>();
    public static String token;
    public static Boolean booltype;
    public static final String playerMobile="0000000000";
    String streamId="streamID";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //set google api client for hint request

        SharedPreferences pref = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        booltype=pref.getBoolean("Booltype", Boolean.parseBoolean(""));

        if(booltype){
            startActivity(new Intent(LoginActivity.this, MainActivity.class));
            finish();
        }

        googleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(LoginActivity.this)
                .enableAutoManage(this, this)
                .addApi(Auth.CREDENTIALS_API)
                .build();
        editTextNumber = findViewById(R.id.phone_number_field);
        GetHintPhoneNumber();
        ButterKnife.bind(this);
        btn_submit.setOnClickListener(this);
        editTextNumber.setOnFocusChangeListener((view, b) -> {
            if (b) {
                editTextNumber.setHint("Enter Mobile Number");
            } else {
                editTextNumber.setHint("******");
            }
        });

    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {
    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onOtpReceived(String otp) {

    }

    @Override
    public void onOtpTimeout() {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
    }

    private boolean validation() {
        String number = editTextNumber.getText().toString().trim();
        if (number.isEmpty()) {
            editTextNumber.setError("please enter 10 digit mobile number.");
            editTextNumber.requestFocus();
            return false;
        } else if (number.length() == 10) {
            phoneNumber = number;
        } else if (number.length() < 10) {
            editTextNumber.setError("please enter 10 digit mobile number.");
            editTextNumber.requestFocus();
            return false;
        }
        return true;
    }

    public void GetHintPhoneNumber() {
        HintRequest hintRequest = new HintRequest.Builder()
                .setPhoneNumberIdentifierSupported(true)
                .build();
        PendingIntent mIntent = Auth.CredentialsApi.getHintPickerIntent(googleApiClient, hintRequest);
        try {
            startIntentSenderForResult(mIntent.getIntentSender(), RESOLVE_HINT, null, 0, 0, 0);
        } catch (IntentSender.SendIntentException e) {

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //Result if we want hint number
        if (requestCode == RESOLVE_HINT) {
            if (resultCode == Activity.RESULT_OK) {
                if (data != null) {
                    Credential credential = data.getParcelableExtra(Credential.EXTRA_KEY);
                    phoneNumber = (credential.getId()).toString();
                    correctPhoneNumber(phoneNumber);
                }
            }
        }
    }
    public void correctPhoneNumber(String  str) {
        // String str = editText.getText().toString();
        str = str.replace("+91", "");
        str = str.replaceAll(" ", "");
        phoneNumber = str;
        editTextNumber.setText(phoneNumber);
    }

    @Override
    public void OnSuccess(Object object) {
        progressBar.setVisibility(View.GONE);
        if (requestType == 1 && object instanceof LoginResponse) {
            LoginResponse loginResponse = (LoginResponse)object;
            String status = loginResponse.getStatus();
            playerResult = new ArrayList<>();
            playerResult = loginResponse.getResults2();
            booltype=true;
                String status1  = playerResult.get(0).getStatus();
            SharedPreferences playerMob = getSharedPreferences("playerMobile", 0);
                    SharedPreferences.Editor editor=playerMob.edit();
                if (status1.equalsIgnoreCase("new")){
                // Call Web View
                    Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                    startActivity(intent);
                    finish();
                }
                else if(status1.equalsIgnoreCase("owner")){
                // call
                int  userId = playerResult.get(0).getUserId();
                String playerMobile = playerResult.get(0).getMobile();
                    editor.putString("mobile",playerMobile);
                    editor.commit();


                String message = playerResult.get(0).getMessage();
                String acedemyName = playerResult.get(0).getAcedemyName();
                if(playerResult.get(0).getAcedemyDescription() != null){
                    String acedemyDescription = playerResult.get(0).getAcedemyDescription().toString();
                }else {
                    String acedemyDescription = " ";
                }
                String acedemyAddress = playerResult.get(0).getAcedemyAddress();
                String acedemyLocation = playerResult.get(0).getAcedemyLocation();
                startActivity(new Intent(LoginActivity.this, OwnerViewActivity.class));
                finish();
                   // NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
                }
                else if(status1.equalsIgnoreCase("coach")){
                    int  userId = playerResult.get(0).getUserId();
                    String playerMobile = playerResult.get(0).getMobile();
                                  editor.putString("mobile",playerMobile);
                                  editor.commit();
                    String message = playerResult.get(0).getMessage();
                    String acedemyName = playerResult.get(0).getAcedemyName();
                    if(playerResult.get(0).getAcedemyDescription() != null){
                        String acedemyDescription = playerResult.get(0).getAcedemyDescription().toString();
                    }else {                        String acedemyDescription = " ";
                    }
                    String acedemyAddress = playerResult.get(0).getAcedemyAddress();
                    String acedemyLocation = playerResult.get(0).getAcedemyLocation();
                    String coachName = playerResult.get(0).getCoachname();
                    String coachDescription = playerResult.get(0).getCoachdescription();

                    Intent intent = new Intent(LoginActivity.this,CoachActivity.class);
                    intent.putExtra("coachname",coachName);
                    startActivity(intent);
                    finish();
                }
                else if(status1.equalsIgnoreCase("student")){
                    int  userId = playerResult.get(0).getUserId();
                    String playerMobile = playerResult.get(0).getMobile();
                    editor.putString("mobile",playerMobile);
                    editor.commit();
                    String message = playerResult.get(0).getMessage();
                    String acedemyName = playerResult.get(0).getAcedemyName();
                    if(playerResult.get(0).getAcedemyDescription() != null){
                        String acedemyDescription = playerResult.get(0).getAcedemyDescription().toString();
                    }else {
                        String acedemyDescription = " ";
                    }
                    String acedemyAddress = playerResult.get(0).getAcedemyAddress();
                    String acedemyLocation = playerResult.get(0).getAcedemyLocation();

                    String studentName = playerResult.get(0).getStudentname();
                    String studentDescription = playerResult.get(0).getStudentdescription();
                    String studentDob = playerResult.get(0).getDob();
                    String ageGroup = playerResult.get(0).getAgegroup();
                    String studentAddress = playerResult.get(0).getStudentaddress();
                    String studentLocation = playerResult.get(0).getStudentlocation();
                    String coachName = playerResult.get(0).getCoachname();

                    Intent intent = new Intent(LoginActivity.this,HomeActivity.class);
                    intent.putExtra("userid",userId);
                    intent.putExtra("name",studentName);
                    intent.putExtra("ageGroup",ageGroup);
                    intent.putExtra("coachname",coachName);
                    intent.putExtra("studentlocation",studentLocation);
                    startActivity(intent);
                    finish();


                }
                else if(status1.equalsIgnoreCase("guest")){
                    // Call Web View
                    int  userId = playerResult.get(0).getUserId();
                    String playerMobile = playerResult.get(0).getMobile();
                    editor.putString("mobile",playerMobile);
                    editor.commit();
                    String message = playerResult.get(0).getMessage();
                    String userCreationdate = playerResult.get(0).getUsercreationdate();
                    Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                    startActivity(intent);
                    finish();
                }

                /*SharedPreferences pref = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
                SharedPreferences.Editor edit = pref.edit();
                edit.putString("phone", phoneNumber);
                edit.putString("name", name);
                edit.putBoolean("Booltype",booltype);
                edit.apply();
                Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                startActivity(intent);
                finish();*/
        }
    }

    @Override
    public void OnFailure() {
        progressBar.setVisibility(View.GONE);
        //GlobalUtils.showToast(getApplicationContext(),"login failed");
    }

    @Override
    public void onErrorHandling(Response response) {
        progressBar.setVisibility(View.GONE);
        //GlobalUtils.showToast(getApplicationContext(),"login failed");
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_submit:
                //Do this and this        break;
                if (GlobalUtils.isNetworkAvailable(this)) {
                    if (validation()) {

                        playerLogin();
                    }
                } else {
                    GlobalUtils.showToast(this, getString(R.string.no_internet));
                }
            default: //For all other cases, do this        break;
        }

    }

    //retrofit use for login
    public void playerLogin() {
        progressBar.setVisibility(View.VISIBLE);
        if (GlobalUtils.isNetworkAvailable(this)) {
            new WebServiceHandler().playerLoginStats(this, phoneNumber);
            requestType = 1;
        }
    }

}

