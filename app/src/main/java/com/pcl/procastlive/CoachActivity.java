package com.pcl.procastlive;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

public class CoachActivity extends AppCompatActivity {

    TextView textViewCoachName;
    String coachName;
    AppCompatButton appCompatButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coach);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        textViewCoachName = (TextView)findViewById(R.id.tv_coach_name);
        appCompatButton = (AppCompatButton)findViewById(R.id.btn_cont_coach);

        Intent intent = getIntent();
        coachName = intent.getStringExtra("coachname");

        textViewCoachName.setText(coachName);

        appCompatButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(CoachActivity.this, OwnerViewActivity.class));
            }
        });

    }
}
