package vans.hackforhealth;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;

public class ChatDisplay extends AppCompatActivity {

    LinearLayout mainList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_display);
        mainList=(LinearLayout)findViewById(R.id.RLchatwindows);

    }


}
