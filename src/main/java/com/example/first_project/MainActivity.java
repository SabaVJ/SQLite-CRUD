package com.example.first_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText nameTxt,passwordTxt;
    TextView saveBtn,showBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nameTxt = findViewById(R.id.nameTxt);
        passwordTxt = findViewById(R.id.passwordTxt);
        saveBtn = findViewById(R.id.SaveBtn);
        showBtn = findViewById(R.id.ShowBtn);

        // onClick for save Btn
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stringName = nameTxt.getText().toString();
                String stringPassword = passwordTxt.getText().toString();

                if (stringName.length() <=0 || stringPassword.length() <=0){
                    Toast.makeText(MainActivity.this, "Enter All Data", Toast.LENGTH_SHORT).show();
                }else {
                    DatabaseHelperClass databaseHelperClass = new DatabaseHelperClass(MainActivity.this);
                    ModelClass modelClass = new ModelClass(stringName,stringPassword);
                    databaseHelperClass.addUsers(modelClass);
                    Toast.makeText(MainActivity.this, "Add User Successfully", Toast.LENGTH_SHORT).show();
                    finish();
                    startActivity(getIntent());
                }
            }
        });

        // onClick for show Btn
        showBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ViewActivity.class);
                startActivity(intent);
            }
        });
    }
    }
