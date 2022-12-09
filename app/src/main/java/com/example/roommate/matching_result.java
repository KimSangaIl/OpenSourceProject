package com.example.roommate;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class matching_result extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matching_result);

        setContentView(R.layout.user_listview);

        Intent intent = getIntent();

        TextView name = findViewById(R.id.result_name);
        name.setText(intent.getStringExtra("name"));
    }
}