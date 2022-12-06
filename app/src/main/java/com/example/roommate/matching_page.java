/*
package com.example.roommate;

import static androidx.databinding.DataBindingUtil.setContentView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;import
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class matching_page extends AppCompatActivity {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        View view = inflater.inflate(R.layout.fragment_matching_page, container, false);

        Button matching_start = view.findViewById(R.id.matching_start);
        matching_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),matching_start_page.class);
                startActivity(intent);
            }
        });

        return view;
    }
}
*/
