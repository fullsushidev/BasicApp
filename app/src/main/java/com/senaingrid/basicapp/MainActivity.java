package com.senaingrid.basicapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.parse.LogInCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class MainActivity extends AppCompatActivity {     //same as ActionBarActivity

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Parse.initialize(new Parse.Configuration.Builder(this)
            .applicationId("2vOhlYWATJIId7ITWtuaBVwVm7PAkOedwAc2ebbD")
            .clientKey("BrktoCMEnioJPMrlbSKo9GdPUoGvaJob7c7lYWfa")
            .server("https://parseapi.back4app.com/").build()
        );

        final Button bt_login = (Button) findViewById(R.id.bt_login);
        final Button bt_register = (Button) findViewById(R.id.bt_register);
        final EditText et_username = (EditText) findViewById(R.id.et_username);
        final EditText et_password = (EditText) findViewById(R.id.et_password);
        final TextView message = (TextView) findViewById(R.id.message);

        bt_login.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
               ParseUser.logInInBackground("Username", "Password", new LogInCallback() {
                    @Override
                    public void done(ParseUser parseUser, ParseException e) {
                        if (parseUser != null) {
                            //Login Successful
                            //You may choose what to do or display here
                            message.setText("Deu certo! log");
                            //TODO:deletar msg de teste
                            //For example: Welcome + ParseUser.getUsername()

                        } else {
                            //Login Fail
                            message.setText("Deu errado! Log");
                            //TODO:deletar msg de teste
                            //get error by calling
                            e.getMessage();
                        }
                    }
                });
            }
        });


        bt_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ParseUser user = new ParseUser();
                user.setUsername(et_username.getText().toString());
                user.setPassword(et_password.getText().toString());
                user.signUpInBackground(new SignUpCallback() {
                    @Override
                    public void done(ParseException e) {
                        if (e == null) {
                            //Register Successful
                            message.setText("Deu certo! reg");
                            //TODO:deletar msg de teste
                            //You may choose what to do or display here
                        } else {
                            //Register Fail
                            message.setText("Deu errado! reg");
                            //TODO:deletar msg de teste
                            //get error by calling
                            e.getMessage();
                        }
                    }
                });
            }
        });








    }
}
