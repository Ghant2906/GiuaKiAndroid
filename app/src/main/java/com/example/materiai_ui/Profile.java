package com.example.materiai_ui;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Profile extends AppCompatActivity {
    Button btnBack, btnFL, btnLogOut;
    TextView followerTextView;
    int followerText;

    private void thongBaoComfirm(String title, String mess) {

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        btnBack = (Button) findViewById(R.id.backButton);
        btnFL = (Button) findViewById(R.id.button);
        followerTextView = (TextView) findViewById(R.id.fllowerText);
        btnLogOut = (Button) findViewById(R.id.logoutButton);
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);

        btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.setTitle("Comfirm đăng xuất");
                alertDialog.setMessage("Bạn có chắc chắn muốn đăng xuất?");
                alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                        Intent signIn = new Intent(Profile.this, SignIn.class);
                        startActivity(signIn);
                    }
                });
                alertDialog.setNegativeButton("Hủy", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                alertDialog.show();

            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent home = new Intent(Profile.this, Home.class);
                startActivity(home);
            }
        });

        btnFL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(btnFL.getText().equals("Follow")) {
                    followerText =Integer.parseInt(followerTextView.getText().toString()) + 1;
                    followerTextView.setText("0"+followerText);
                    btnFL.setText("UnFollow");
                }
                else {
                    followerText =Integer.parseInt(followerTextView.getText().toString()) - 1;
                    followerTextView.setText("0"+followerText);
                    btnFL.setText("Follow");}
            }
        });

    }
}