package com.leminhtriet.lab3_ex1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView loginTextView;
    Button loginBtn;
    EditText loginInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginTextView = findViewById(R.id.TextView);
        loginInput = findViewById(R.id.linkInput);
        loginBtn = findViewById(R.id.linkBtn);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Activity2.class);
                intent.putExtra("EmailKey", loginInput.getText().toString());
                //startActivity(intent);
                startActivityForResult(intent, 1);

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1) {
            if(resultCode == RESULT_OK) {
                loginTextView.setText("Hẹn gặp lại");
                loginInput.setText(data.getStringExtra("NameKey"));
                loginBtn.setVisibility(View.GONE);
            }

        }
    }
}