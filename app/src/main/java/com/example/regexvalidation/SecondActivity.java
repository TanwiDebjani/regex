
package com.example.regexvalidation;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView DisplayData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        DisplayData = findViewById(R.id.DisplayData);


        String name = getIntent().getStringExtra("name");
        String email = getIntent().getStringExtra("email");
        String studentId = getIntent().getStringExtra("studentId");
        String department = getIntent().getStringExtra("department");


        DisplayData.setText("Name: " + name + "\nEmail: " + email + "\nStudent ID: " + studentId + "\nDepartment: " + department);
    }
}
