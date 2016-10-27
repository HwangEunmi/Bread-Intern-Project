package com.bread.hwang.bread.mypage;


import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.bread.hwang.bread.MembershipActivity;
import com.bread.hwang.bread.R;
import com.bread.hwang.bread.SplashActivity;
import com.bread.hwang.bread.manager.PropertyManager;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyPageFragment extends Fragment {
    /* 비밀번호 수정하는 api도 없어? 그럼 그냥 비번 확인API로 비번 맞는지 확인받고
    * 회원수정API저기다가 비번 넣어서 수정해야될 듯*/
    /* 저 API없으면 그냥 로그인할때 SharedPreference에다가 id, name(nickname), pass) 받아와서 넣어야할듯.. */

    /* 로그아웃API, 회원탈퇴API */
     /* 일단 로그아웃, 탈퇴하면 바로 Splash화면으로 이동(Dialog 확인창 이런건 나중에 구현) */
    Intent intent;
    TextView updateText;
    AlertDialog dialog;

    public MyPageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_my_page, container, false);
        updateText = (TextView) view.findViewById(R.id.text_mypageUpdate);
        updateText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getContext(), UpdateProfileActivity.class);
                startActivity(intent);
            }
        });

        Button logout = (Button) view.findViewById(R.id.btn_logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setIcon(android.R.drawable.ic_dialog_alert);
                builder.setTitle("Logout");
                builder.setMessage("Do you want logout?");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        intent = new Intent(getContext(), SplashActivity.class);
                        startActivity(intent);
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                dialog = builder.create();
                dialog.show();

                PropertyManager.getInstance().setUserId("");
                PropertyManager.getInstance().setUserName("");
                PropertyManager.getInstance().setUserPassword("");

            }
        });

        Button bye = (Button) view.findViewById(R.id.btn_bye);
        bye.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setIcon(android.R.drawable.ic_dialog_alert);
                builder.setTitle("Leave");
                builder.setMessage("Do you want leave?");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        intent = new Intent(getContext(), SplashActivity.class);
                        startActivity(intent);
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                dialog = builder.create();
                dialog.show();
            }
        });

        return view;
    }

}
