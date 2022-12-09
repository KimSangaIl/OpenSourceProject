package com.example.roommate;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.UUID;

public class matching_start extends AppCompatActivity {

    private Button matching_start;

    private ArrayList<UserAccount> data = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matching_start);

        matching_start=findViewById(R.id.matching_start);
        matching_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(matching_start.this, matching_start2.class);
                startActivity(intent);
            }
        });

        ListView listView = (ListView) findViewById(R.id.listview);

        data = new ArrayList<>();

        UserAccount user1 = new UserAccount();
        data.add(user1);

        listview_adapter adapter = new listview_adapter(this, R.layout.user_listview, data);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), matching_result.class);
                intent.putExtra("name", data.get(position).getName());
                startActivity(intent);
            }
        });
    }
}