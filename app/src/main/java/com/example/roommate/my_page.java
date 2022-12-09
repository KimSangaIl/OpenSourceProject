package com.example.roommate;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.fragment.app.Fragment;

import com.google.firebase.auth.FirebaseAuth;

public class my_page extends Fragment {
    private FirebaseAuth mAuth;
    // private String uname;
    // private String ugender;
    // private String uage;
    // private String udorm;
    // private String umate;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);

        // 타이틀 바 내용 바꾸기
        ActionBar actionBar = ((MainActivity)getActivity()).getSupportActionBar();
        actionBar.setTitle("마이 페이지");

        View v = inflater.inflate(R.layout.fragment_my_page, container, false);

        TextView logout = (TextView)v.findViewById(R.id.logout);
        Button userDel = (Button)v.findViewById(R.id.btnDel);

        mAuth = FirebaseAuth.getInstance();

        // 로그아웃
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
                getActivity().finish();//현재 액티비티 파괴
            }
        });

        // 회원탈퇴
        userDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth.getCurrentUser().delete();
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
                getActivity().finish();//현재 액티비티 파괴
            }
        });

        return v;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }
}