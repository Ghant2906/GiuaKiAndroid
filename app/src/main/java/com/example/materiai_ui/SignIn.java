package com.example.materiai_ui;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SignIn extends AppCompatActivity {
    Button btnLogin, btnSignUp;
    TextView email, pass;

    private void thongBao(String title, String mess){
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setTitle(title);
        alertDialog.setMessage(mess);
        alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        alertDialog.show();

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        btnLogin = (Button) findViewById(R.id.loginButton_Login);
        btnSignUp = (Button) findViewById(R.id.signUpButton_Login);
        email = (TextView) findViewById(R.id.emailText_Login);
        pass = (TextView) findViewById(R.id.pass_Login);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(email.getText().toString().equals("") || pass.getText().toString().equals(""))
                    thongBao("Error","Vui lòng nhập tài khoản, mật khẩu");
                else if(email.getText().toString().equals("abc") && pass.getText().toString().equals("123") ){
                    Toast.makeText(getApplicationContext(),"Đăng nhập thành công",Toast.LENGTH_SHORT).show();
                    Intent home = new Intent(SignIn.this, Home.class);
                    startActivity(home);
                }
                else{
                    thongBao("Error","Tài khoản hoặc mật khẩu sai!");
                }
            }
        });

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent signUp = new Intent(SignIn.this, SignUp.class);
                startActivity(signUp);
            }
        });
    }
}