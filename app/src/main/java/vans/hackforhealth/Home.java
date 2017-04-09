package vans.hackforhealth;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.google.firebase.analytics.FirebaseAnalytics;

import java.util.ArrayList;
import java.util.List;

public class Home extends AppCompatActivity {
    private Boolean isFabOpen = false;
    private FloatingActionButton fab, forum, chat;
    private Animation fab_open, fab_close, rotate_forward, rotate_backward;
    private StaggeredGridLayoutManager _sGridLayoutManager;
    private FirebaseAnalytics mFirebaseAnalytics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
        FireBaseWrapper fireBaseWrapper= new FireBaseWrapper(this);
        fab = (FloatingActionButton) findViewById(R.id.fab);
        forum = (FloatingActionButton) findViewById(R.id.fab1);
        chat = (FloatingActionButton) findViewById(R.id.fab2);
        fab_open = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_open);
        fab_close = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_close);
        rotate_forward = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate_forward);
        rotate_backward = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate_backward);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animateFAB();
            }
        });
        forum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Forum.class));
            }
        });
        chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Home.this,ChatDisplay.class);
                startActivity(i);
            }
        });

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        _sGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(_sGridLayoutManager);
        List<UserProfile> sList = FireBaseWrapper.serverUserProfile;
        Adapter rcAdapter = new Adapter(Home.this, sList);
        recyclerView.setAdapter(rcAdapter);
    }


    public void animateFAB() {
        if (isFabOpen) {
            fab.startAnimation(rotate_backward);
            forum.startAnimation(fab_close);
            chat.startAnimation(fab_close);
            forum.setClickable(false);
            chat.setClickable(false);
            isFabOpen = false;
        } else {
            fab.startAnimation(rotate_forward);
            forum.startAnimation(fab_open);
            chat.startAnimation(fab_open);
            forum.setClickable(true);
            chat.setClickable(true);
            isFabOpen = true;
        }
    }
}
