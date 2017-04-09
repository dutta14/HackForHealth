package vans.hackforhealth;

import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.TextView;

public class ProfilePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        //Remove title bar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_page);

        UserProfile user = FireBaseWrapper.serverUserProfile.get(getIntent().getIntExtra("position", 0));
        ((TextView)findViewById(R.id.profile_bio)).setText(user.getBio());
        ((TextView)findViewById(R.id.profile_tags)).setText(user.getInterests().get(1));
        ((TextView)findViewById(R.id.profile_name)).setText(user.getName());
        ((TextView)findViewById(R.id.profile_disorder)).setText(user.getDisorder());




        //Set toolbar title
        CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle("Demo");
    }
}
