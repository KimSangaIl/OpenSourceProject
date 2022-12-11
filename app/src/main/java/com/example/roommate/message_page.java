package com.example.roommate;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.fragment.app.Fragment;

public class message_page extends Fragment {

    private  Button btn_write;
    private  Button btn_find;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);

        // 타이틀 바 내용 바꾸기
        ActionBar actionBar = ((MainActivity)getActivity()).getSupportActionBar();
        actionBar.setTitle("게시판");

        View view = inflater.inflate(R.layout.fragment_message_page, container, false);

        btn_write = view.findViewById(R.id.write_post);
        btn_write.setOnClickListener(view1 -> {
            Toast.makeText(getContext(),"게시글을 작성할 수 없습니다",Toast.LENGTH_SHORT).show();
        });

        btn_find = view.findViewById(R.id.find_post);
        btn_find.setOnClickListener(view1 -> {
            Toast.makeText(getContext(),"검색할 게시글이 없습니다",Toast.LENGTH_SHORT).show();
        });

        return view;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

}