package vans.hackforhealth;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import java.util.ArrayList;
import java.util.List;

public class Home extends AppCompatActivity {
    private Boolean isFabOpen = false;
    private FloatingActionButton fab, forum, chat;
    private Animation fab_open, fab_close, rotate_forward, rotate_backward;
    private StaggeredGridLayoutManager _sGridLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
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

            }
        });
        chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                if (dy > 0) {
                    // Scroll Down
                    if (fab.isShown()) {
                        fab.hide();
                    }
                } else if (dy < 0) {
                    // Scroll Up
                    if (!fab.isShown()) {
                        fab.show();
                    }
                }
            }
        });
        _sGridLayoutManager = new StaggeredGridLayoutManager(2,
                StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(_sGridLayoutManager);

        List<Profile> sList = getListItemData();

        Adapter rcAdapter = new Adapter(
                Home.this, sList);
        recyclerView.setAdapter(rcAdapter);

    }

    private List<Profile> getListItemData() {
        List<Profile> listViewItems = new ArrayList<Profile>();
        listViewItems.add(new Profile("1984", "George Orwell"));
        listViewItems.add(new Profile("Pride and Prejudice", "Jane Austen"));
        listViewItems.add(new Profile("One Hundred Years of Solitude", "Gabriel Garcia Marquez"));
        listViewItems.add(new Profile("The Book Thief", "Markus Zusak"));
        listViewItems.add(new Profile("The Hunger Games", "Suzanne Collins"));
        listViewItems.add(new Profile("The Hitchhiker's Guide to the Galaxy", "Douglas Adams"));
        listViewItems.add(new Profile("The Theory Of Everything", "Dr Stephen Hawking"));

        return listViewItems;
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
