package vans.hackforhealth;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.Console;

import static vans.hackforhealth.R.id.signup_input_layout_name;

public class RegisterActivity extends AppCompatActivity {

    SharedPreferences pref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        pref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);


        Button mRegister = (Button) findViewById(R.id.btn_signup);
        mRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(((EditText)findViewById(R.id.signup_input_name)).getText().toString().isEmpty() ||
                        ((EditText)findViewById(R.id.signup_input_email)).getText().toString().isEmpty() ||
                            ((EditText)findViewById(R.id.signup_input_password)).getText().toString().isEmpty() ||
                                ((EditText)findViewById(R.id.signup_input_age)).getText().toString().isEmpty() ||
                                    ((EditText)findViewById(R.id.signup_bio)).getText().toString().isEmpty() ||
                                        ((EditText)findViewById(R.id.signup_tags)).getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(),"Kindly fill all the fields.",Toast.LENGTH_LONG).show();
                }else {
                    String name = ((EditText)findViewById(R.id.signup_input_name)).getText().toString();
                    String email = ((EditText)findViewById(R.id.signup_input_email)).getText().toString();
                    String password = ((EditText)findViewById(R.id.signup_input_password)).getText().toString();
                    String dob = ((EditText)findViewById(R.id.signup_input_age)).getText().toString();
                    String bio = ((EditText)findViewById(R.id.signup_bio)).getText().toString();
                    String tags = ((EditText)findViewById(R.id.signup_tags)).getText().toString();
                    String disorder = ((EditText)findViewById(R.id.signup_disorder)).getText().toString();


                    UserProfile user = new UserProfile(name,email,password,dob,'F',bio,tags,disorder);
                    Log.d("print-before", "user");
                    FireBaseWrapper.sendUserDataToCloud(user);
                    Log.d("print", "user");

                    startActivity(new Intent(getApplicationContext(), Home.class));
                }
            }
        });

        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/


    }

}
