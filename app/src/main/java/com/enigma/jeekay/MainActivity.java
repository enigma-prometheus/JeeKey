package com.enigma.jeekay;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText UserName, Password;
    private Button Login;
    private int counter = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        UserName = (EditText)findViewById(R.id.etUserName);
        Password = (EditText)findViewById(R.id.etPassword);
        Login = (Button)findViewById(R.id.btnLogin);
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(UserName.getText().toString(), Password.getText().toString());
            }
        });
    }

    public void validate(String username, String userPassword){
        if((username.equalsIgnoreCase("admin")) && (userPassword.equals("adminpw"))){
            Intent intent = new Intent(MainActivity.this, Bookings.class);
            UserName.setText("");
            Password.setText("");
            startActivity(intent);
        }
        else{
            counter--;
            Toast.makeText(this, "No. Of Attempts left: " + counter, Toast.LENGTH_LONG ).show();
            if(counter == 0){
                Login.setEnabled(false);
                Toast.makeText(this, "You Have exhausted 5 login attempts please restart App to try again ", Toast.LENGTH_LONG ).show();
            }
        }
    }
}
