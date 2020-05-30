package com.pcl.procastlive;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.mikhaellopez.circularimageview.CircularImageView;
import com.squareup.picasso.Picasso;

public class HomeActivity extends AppCompatActivity {

    TextView textViewStudentName,textViewCoachName,textViewStudentAge,textViewFavCri,textViewStudentlocation;
    String studentName,studentAgeGroup,studentCoachName,studentLocation;
    AppCompatButton appCompatButton;
    CircularImageView circularImageView;
    int userId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        textViewStudentName = (TextView)findViewById(R.id.tv_studuent_name);
        textViewCoachName = (TextView)findViewById(R.id.coachtext);
        textViewStudentAge = (TextView)findViewById(R.id.agetxt);
        textViewFavCri = (TextView)findViewById(R.id.favcri);
        textViewStudentlocation = (TextView)findViewById(R.id.loctext);
        appCompatButton = (AppCompatButton)findViewById(R.id.btn_cont);
        circularImageView = (CircularImageView)findViewById(R.id.iv_student_image);

        Intent intent = getIntent();
        userId = intent.getIntExtra("userid",0);
        studentName = intent.getStringExtra("name");
        studentAgeGroup = intent.getStringExtra("ageGroup");
        studentCoachName = intent.getStringExtra("coachname");
        studentLocation = intent.getStringExtra("studentlocation");

        textViewStudentName.setText(studentName);
        textViewCoachName.setText(studentCoachName);
        textViewStudentAge.setText(studentAgeGroup);
        textViewStudentlocation.setText(studentLocation);

        appCompatButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, OwnerViewActivity.class));
            }
        });

        init();
    }

    public void init(){
        String imageUri = "https://procorporateleague.com/product/images/home/academy/1/kids/";
        String studentImageUrl = imageUri+userId+".png";
        //ImageView ivBasicImage = (ImageView) findViewById(R.id.ivBasicImage);
        Picasso.get().load(studentImageUrl).into(circularImageView);
    }
   /* public void update(){
        if(textViewStudentName.isEmpty()) {
            textViewStudentName.setError("Student Name is required");
            textViewStudentName.requestFocus();
            return;
        }
        else if(textViewCoachName.isEmpty()){
            textViewCoachName.setError("Coach name is required");
            textViewCoachName.requestFocus();
            return;
        }
        else if(textViewFavCri.isEmpty()){
            textViewCoachName.setError("Favorite Cricketer is required");
            textViewCoachName.requestFocus();
            return;
        }
        else if(textViewStudentAge.isEmpty()){
            textViewStudentAge.setError("Student Age is required");
            textViewStudentAge.requestFocus();
            return;
        }
        else if(textViewStudentlocation.isEmpty()){
            textViewStudentlocation.setError("Student Location is required");
            textViewStudentlocation.requestFocus();
            return;
        }
    }*/
}
