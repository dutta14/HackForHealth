package vans.hackforhealth;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class NewThread extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_thread);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = ((EditText) findViewById(R.id.input_title)).getText().toString().trim(),
                        message = ((EditText) findViewById(R.id.input_content)).getText().toString().trim(),
                        tags[] = ((EditText) findViewById(R.id.input_tag)).getText().toString().trim().split(" ");

                ArrayList<String> tagList = new ArrayList<>();
                for(int i=0; i<tags.length; i++) {
                    tagList.add(tags[i].trim());
                }

                UserThread uThread = new UserThread(title, tagList, message);
                FireBaseWrapper.sendForumToCloud(uThread);
                Log.e("anindya","sent");
                CoordinatorLayout tlayout = (CoordinatorLayout) findViewById(R.id.tlayout);
                Snackbar.make(tlayout, "Thread posted", Snackbar.LENGTH_SHORT).show();
                finish();

            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
