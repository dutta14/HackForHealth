package vans.hackforhealth;


import android.app.ProgressDialog;
import android.content.Context;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import static com.google.android.gms.internal.zzt.TAG;

/**
 * Created by root on 8/4/17.
 */

public class FireBaseWrapper {

    //static Firebase myFirebaseRef = new Firebase("https://hackforhealth-76f5a.firebaseio.com/");
    static FirebaseDatabase database;
    static DatabaseReference myRef;

    static String seedUrl="https://hackforhealth-76f5a.firebaseio.com";
    static String dbProfile="Profile";
    static String dbChat="Chat";
    static String dbForum="Forum";
    Context context=null;

    static ArrayList<UserThread> serverUserThreads;



    public FireBaseWrapper(Context context) {
        this.context=context;
        database = FirebaseDatabase.getInstance();
        myRef = database.getReferenceFromUrl("https://hackforhealth-76f5a.firebaseio.com/");
        chatListener();
    }

    public void sendToCloud(String text){
        myRef.setValue(text);

        //myRef=myRef.push();
        Log.e("Hello",myRef.getKey());
    }

    public void sendUserDataToCloud(String val){
        database.getReference(dbProfile).push().setValue(val);
    }

    public static void sendChatToCloud(ChatMsg val){
        database.getReference(dbChat).push().setValue(val);
    }

    public static void sendForumToCloud(UserThread val){
        database.getReference(dbForum).push().setValue(val);
    }

    public void sendCommentToCloud(String val){
        database.getReference(dbProfile).push().setValue(val);
    }

    public void chatListener(){
        ValueEventListener postListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // Get Post object and use the values to update the UI
                ChatMsg post = dataSnapshot.getValue(ChatMsg.class);
                // [START_EXCLUDE]
               // mAuthorView.setText(post.author);
               // mTitleView.setText(post.title);
               // mBodyView.setText(post.body);
                // [END_EXCLUDE]
                ChatDisplay.getUpdate(context,post);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Getting Post failed, log a message
                Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
                // [START_EXCLUDE]
                // [END_EXCLUDE]
            }
        };
        database.getReference(dbChat).addValueEventListener(postListener);
    }

    public static List<UserThread> getData(Context context, final String child)
    {
        try {

            final ProgressDialog progDailog = ProgressDialog.show(context,
                    "Loading Data...",
                    "Please wait....", true);
            new Thread() {
                public void run() {
                    try {

                        // sleep the thread, whatever time you want.
                        database.getReference(dbForum).addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot snapshot) {
                                System.out.println("There are " + snapshot.getChildrenCount() + " blog posts");
                                serverUserThreads=  new ArrayList<UserThread>();;
                                int i=0;
                                for (DataSnapshot postSnapshot : snapshot.getChildren()) {
                                    UserThread post = postSnapshot.getValue(UserThread.class);
                                    serverUserThreads.add(post);
                                    //System.out.println(post.getTimestamp().toString() + " - " + post.getState());

                                }
                            }

                            @Override
                            public void onCancelled(DatabaseError databaseError) {
                                // Getting Post failed, log a message
                                Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
                                // [START_EXCLUDE]
                                // [END_EXCLUDE]
                            }
                        });
                        sleep(5000);
                    } catch (Exception e) {
                    }
                    progDailog.dismiss();
                }
            }.start();

        } catch (Exception e) {
            Log.e("Error", "");

        }

        return serverUserThreads;
    }


}
