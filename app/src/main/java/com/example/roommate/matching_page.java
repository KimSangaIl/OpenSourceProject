package com.example.roommate;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.appcompat.app.ActionBar;
import androidx.fragment.app.Fragment;

public class matching_page extends Fragment {

    private  Button btn_start;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // 타이틀 바 내용 바꾸기
        ActionBar actionBar = ((MainActivity)getActivity()).getSupportActionBar();
        actionBar.setTitle("룸메이트 매칭");

        View view = inflater.inflate(R.layout.fragment_matching_page, container, false);

        btn_start = view.findViewById(R.id.matching_start);
        btn_start.setOnClickListener(view1 -> {
            Intent intent = new Intent(getActivity(),matching_start.class);
            startActivity(intent);
        });
        return view;
    }
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}