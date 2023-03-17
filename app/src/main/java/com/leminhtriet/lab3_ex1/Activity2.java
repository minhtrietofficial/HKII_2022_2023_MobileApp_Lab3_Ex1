package com.leminhtriet.lab3_ex1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Activity2 extends AppCompatActivity {
    TextView logoutTextView;
    EditText nameInput;
    Button logoutBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2);

        logoutTextView = findViewById(R.id.logoutTextView);
        nameInput = findViewById(R.id.nameInput);
        logoutBtn = findViewById(R.id.logoutBtn);

        logoutTextView.setText("Xin chào, "+  getIntent().getStringExtra("EmailKey") +". Vui lòng nhập tên");

        logoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("NameKey", nameInput.getText().toString());

                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}