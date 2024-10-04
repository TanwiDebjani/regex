
package com.example.regexvalidation;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.widget.Toast;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    EditText etName, etEmail, etPassword, etStudentId;
    Spinner spinnerDept;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etName);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        etStudentId = findViewById(R.id.etStudentId);
        spinnerDept = findViewById(R.id.spinnerDept);
        btnSubmit = findViewById(R.id.btnSubmit);


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.departments, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerDept.setAdapter(adapter);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateAndSubmit();
            }
        });
    }

    private void validateAndSubmit() {
        String name = etName.getText().toString().trim();
        String email = etEmail.getText().toString().trim();
        String password = etPassword.getText().toString().trim();
        String studentId = etStudentId.getText().toString().trim();
        String department = spinnerDept.getSelectedItem().toString();


        if (!Pattern.matches("^[a-zA-Z\\s]+$", name)) {
            etName.setError("Invalid Name");
            return;
        }

        if (!Pattern.matches("^[\\w._%+-]+@[\\w.-]+\\.[a-zA-Z]{2,6}$", email)) {
            etEmail.setError("Invalid Email");
            return;
        }

        if (!Pattern.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,}$", password)) {
            etPassword.setError("Password must be at least 8 characters long, with uppercase, lowercase, and a number");
            return;
        }

        if (!Pattern.matches("^\\d{5,10}$", studentId)) {
            etStudentId.setError("Invalid Student ID (5 to 10 digits required)");
            return;
        }

        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        intent.putExtra("name", name);
        intent.putExtra("email", email);
        intent.putExtra("studentId", studentId);
        intent.putExtra("department", department);
        startActivity(intent);
    }
}
