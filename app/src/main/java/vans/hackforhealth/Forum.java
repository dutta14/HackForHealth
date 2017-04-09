package vans.hackforhealth;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class Forum extends AppCompatActivity {

    private List<UserThread> threadList = new ArrayList<>();
    private RecyclerView recyclerView;
    private ThreadAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forum);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        mAdapter = new ThreadAdapter(threadList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        prepareData();
    }

    private void prepareData() {
        ArrayList<String> tags = new ArrayList<>();
        tags.add("Tag 1");
        tags.add("Tag 2");
        tags.add("Tag 3");
        tags.add("Tag 4");
        tags.add("Tag 5");
        UserThread thread = new UserThread("Mad Max: Fury Road", tags, "");
        threadList.add(thread);

        thread = new UserThread("Inside Out", tags, "");
        threadList.add(thread);

        thread = new UserThread("Star Wars: Episode VII - The Force Awakens", tags, "");
        threadList.add(thread);

        thread = new UserThread("Shaun the Sheep", tags, "");
        threadList.add(thread);

        thread = new UserThread("The Martian", tags, "");
        threadList.add(thread);

        thread = new UserThread("Mission: Impossible Rogue Nation", tags, "");
        threadList.add(thread);

        thread = new UserThread("Up", tags, "");
        threadList.add(thread);

        thread = new UserThread("Star Trek", tags, "");
        threadList.add(thread);

        thread = new UserThread("The LEGO UserThread", tags, "");
        threadList.add(thread);

        thread = new UserThread("Iron Man", tags, "");
        threadList.add(thread);

        mAdapter.notifyDataSetChanged();
    }

}
