package com.example.materiai_ui;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SignUp extends AppCompatActivity {
    Button btnSignUp, btnBackSignIn;
    TextView passWord, comfirmPass;

    private void thongBaoDangKy(String title, String mess, int x) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setTitle(title);
        alertDialog.setMessage(mess);
        alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if(x == 0)
                    dialogInterface.dismiss();
                if(x == 1)
                    finish();
            }
        });
        alertDialog.show();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        btnSignUp = (Button) findViewById(R.id.signUpButton_SignUp);
        btnBackSignIn = (Button) findViewById(R.id.backLoginButton_SignUp);
        passWord = (TextView) findViewById(R.id.passText_SignUp);
        comfirmPass = (TextView) findViewById(R.id.comfirmPassText);

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(passWord.getText().toString().equals(comfirmPass.getText().toString())){
                    thongBaoDangKy("Succesful","Đăng ký thành công. Vui lòng đăng nhập", 1);
                } else {
                    thongBaoDangKy("Error","Mật khẩu không trùng nhau", 0);
                }
            }
        });

        btnBackSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent main = new Intent(SignUp.this, SignIn.class);
                startActivity(main);
            }
        });
    }
}