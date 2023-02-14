package com.example.first_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class Splash_Screen extends AppCompatActivity {

    TextView titleTxt;
    ImageView menuImg,profileImg;
    MaterialButton startBtn;
    Animation anime_txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        titleTxt = findViewById(R.id.titleTxt);
        menuImg = findViewById(R.id.menuImg);
        profileImg = findViewById(R.id.profileImg);
        startBtn = findViewById(R.id.startBtn);
        anime_txt = AnimationUtils.loadAnimation(this,R.anim.anime_txt);



        // onClick for start Btn
        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Splash_Screen.this,MainActivity.class);
                startActivity(i);

            }
        });

        // anime for Txt
        titleTxt.setAnimation(anime_txt);

        // onClick for menu
        menuImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Splash_Screen.this, "Menu", Toast.LENGTH_SHORT).show();
            }
        });


        // onClick for profile
        profileImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Splash_Screen.this, "Profile", Toast.LENGTH_SHORT).show();
            }
        });



    }
}