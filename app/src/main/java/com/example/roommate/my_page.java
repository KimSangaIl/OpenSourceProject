package com.example.roommate;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

public class my_page extends Fragment {
    private FirebaseAuth mAuth;
    private FirebaseDatabase mDatabase;
    private DatabaseReference mDatabaseRef;
    private Button btnListMate;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);

        // 타이틀 바 내용 바꾸기
        ActionBar actionBar = ((MainActivity)getActivity()).getSupportActionBar();
        actionBar.setTitle("마이 페이지");

        View v = inflater.inflate(R.layout.fragment_my_page, container, false);


        TextView UMName = (TextView)v.findViewById(R.id.name);
        TextView uName = (TextView)v.findViewById(R.id.info_name);
        TextView uGen = (TextView)v.findViewById(R.id.info_gender);
        TextView uAge = (TextView)v.findViewById(R.id.info_birth);
        TextView uDorm = (TextView)v.findViewById(R.id.info_dormitory);
        TextView uRoommate = (TextView)v.findViewById(R.id.info_roommate);

        TextView logout = (TextView)v.findViewById(R.id.logout);
        Button userDel = (Button)v.findViewById(R.id.btnDel);
        Button goList = (Button)v.findViewById(R.id.btnListMate);

        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance();
        mDatabaseRef = FirebaseDatabase.getInstance().getReference("Roommate");

        FirebaseUser firebaseUser = mAuth.getCurrentUser();



        //상태창 변경
        mDatabaseRef.child("UserAccount").child(firebaseUser.getUid()).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                UserAccount group = snapshot.getValue(UserAccount.class);

                String gname = group.getName();
                String ggen = group.getGen();
                String gage = group.getAge();
                String gdorm = group.getDorm();

                UMName.setText(gname);
                uName.setText(gname);
                uGen.setText(ggen);
                uAge.setText(gage);
                uDorm.setText(gdorm);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        // 로그아웃
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(getActivity(), "로그아웃 되었습니다.",Toast.LENGTH_SHORT);
                toast.show();

                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
                getActivity().finish();//현재 액티비티 파괴
            }
        });

        //룸메이트 신청 목록 보기
        goList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ApplyActivity.class);
                startActivity(intent);
            }
        });

        // 회원탈퇴
        userDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder Dialog = new AlertDialog.Builder(getActivity(),
                        android.R.style.Theme_DeviceDefault_Light_Dialog);
                Dialog.setMessage("정말 탈퇴 하시겠습니까?")
                        .setPositiveButton("아니오", new DialogInterface.OnClickListener()
                        {
                            @Override
                            public void onClick(DialogInterface dialog, int which)
                            {
                                Log.i("Dialog", "취소");
                            }
                        })
                        .setNegativeButton("예", new DialogInterface.OnClickListener()
                        {
                            public void onClick(DialogInterface dialog, int which)
                            {
                                Toast toast = Toast.makeText(getActivity(), "탈퇴 되었습니다.",Toast.LENGTH_SHORT);
                                toast.show();

                                mAuth.getCurrentUser().delete();
                                Intent intent = new Intent(getActivity(), LoginActivity.class);
                                startActivity(intent);
                                getActivity().finish();//현재 액티비티 파괴
                            }
                        })
                        .setCancelable(false) // 백버튼으로 팝업창이 닫히지 않도록 한다.
                        .show();
            }
        });

        return v;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }
}