package vans.hackforhealth;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Date;

public class ChatDisplay extends AppCompatActivity {

    static LinearLayout mainList;
    ImageView imgSend;
    EditText etSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_display);
        mainList=(LinearLayout)findViewById(R.id.LinLayView);
        imgSend=(ImageView)findViewById(R.id.sendB);
        etSend=(EditText)findViewById(R.id.etSend);
        imgSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FireBaseWrapper.sendChatToCloud(new ChatMsg("1","2",etSend.getText().toString(),new Date().getTime()));
            }
        });
    }

    public static void getUpdate(Context context,ChatMsg post){
        TextView tv = new TextView(context);
        if(post != null) {
            tv.setText(post.getBody());
            if(mainList != null)
               mainList.addView(tv);
        }
    }


}
