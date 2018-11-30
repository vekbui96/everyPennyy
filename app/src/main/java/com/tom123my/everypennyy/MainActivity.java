package com.tom123my.everypennyy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.EditText;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    //Varibles used for login screen
    private Button loginButon;
    private EditText Name;
    private EditText Password;

    //On Create
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Name = (EditText)findViewById(R.id.usernameText);
        Password = (EditText)findViewById(R.id.passwordText);
        loginButon = (Button) findViewById(R.id.loginButton);


        loginButon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(Name.getText().toString(), Password.getText().toString());
            }
        });
    }

    //Checks inf valid username and password
    private void validate(String userName, String userPassword){
        if((userName.equals("Admin")) && (userPassword.equals("1234"))){
            openHomescreen();
        }
    }

    //Goes to home screen
    public void openHomescreen(){
            Intent intent = new Intent(this, homescreen.class);
            startActivity(intent);
    }

}
