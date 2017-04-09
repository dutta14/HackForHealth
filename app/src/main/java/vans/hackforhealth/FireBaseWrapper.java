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
    static ArrayList<ChatMsg> serverChats;
    static ArrayList<UserProfile> serverUserProfile;


    public FireBaseWrapper(Context context) {
        this.context=context;
        database = FirebaseDatabase.getInstance();
        myRef = database.getReferenceFromUrl("https://hackforhealth-76f5a.firebaseio.com/");

        if(serverUserThreads == null || serverUserThreads.size() <= 0)
            getData(context);
        getDataChats(context);
    }

    public void sendToCloud(String text){
        myRef.setValue(text);

        //myRef=myRef.push();
        Log.e("Hello",myRef.getKey());
    }

    public void sendUserDataToCloud(UserProfile val){
        database.getReference(dbProfile).push().setValue(val);
    }

  /*  public static void sendChatToCloud(ChatMsg val){
        database.getReference(dbChat).push().setValue(val);
    }*/

    public static void sendForumToCloud(UserThread val){
        database.getReference(dbForum).push().setValue(val);
    }

    public void sendCommentToCloud(String val){
        database.getReference(dbProfile).push().setValue(val);
    }

    public static List<UserThread> getData(Context context) {
        try {

            final ProgressDialog progDailog = ProgressDialog.show(context,
                    "Loading Data...",
                    "Please wait....", true);
            new Thread() {
                public void run() {
                    try {

                        database.getReference(dbForum).addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot snapshot) {
                                System.out.println("There are " + snapshot.getChildrenCount() + " blog posts");
                                serverUserThreads=  new ArrayList<UserThread>();
                                for (DataSnapshot postSnapshot : snapshot.getChildren()) {
                                    UserThread post = postSnapshot.getValue(UserThread.class);
                                    Log.e("post",post.body);
                                    serverUserThreads.add(post);
                                }
                            }

                            @Override
                            public void onCancelled(DatabaseError databaseError) {
                                // Getting Post failed, log a message
                                Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
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

    public static List<ChatMsg> getDataChats(Context context) {
        try {
            final ProgressDialog progDialog = ProgressDialog.show(context, "Loading Data...", "Please wait....", true);
            new Thread() {
                public void run() {
                    try {
                        // sleep the thread, whatever time you want.
                        database.getReference(dbChat).addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot snapshot) {
                                System.out.println("There are " + snapshot.getChildrenCount() + " blog posts");
                                serverChats=  new ArrayList<ChatMsg>();
                                for (DataSnapshot postSnapshot : snapshot.getChildren()) {
                                    ChatMsg post = postSnapshot.getValue(ChatMsg.class);
                                    Log.e("post",post.toString());
                                    serverChats.add(post);
                                }
                            }

                            @Override
                            public void onCancelled(DatabaseError databaseError) {

                                Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
                            }
                        });
                        sleep(5000);
                    } catch (Exception e) {
                    }
                    progDialog.dismiss();
                }
            }.start();
        } catch (Exception e) {
            Log.e("Error", "");
        }
        return serverChats;
    }

    public static List<UserProfile> getUserProfile(Context context) {
        try {
            final ProgressDialog progDialog = ProgressDialog.show(context, "Loading Data...", "Please wait....", true);
            new Thread() {
                public void run() {
                    try {
                        // sleep the thread, whatever time you want.
                        database.getReference(dbProfile).addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot snapshot) {
                                System.out.println("There are " + snapshot.getChildrenCount() + " blog posts");
                                serverUserProfile=  new ArrayList<UserProfile>();
                                for (DataSnapshot postSnapshot : snapshot.getChildren()) {
                                    UserProfile post = postSnapshot.getValue(UserProfile.class);
                                    Log.e("post",post.toString());
                                    serverUserProfile.add(post);
                                }
                            }

                            @Override
                            public void onCancelled(DatabaseError databaseError) {
                                Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
                            }
                        });
                        sleep(5000);
                    } catch (Exception e) {
                    }
                    progDialog.dismiss();
                }
            }.start();
        } catch (Exception e) {
            Log.e("Error", "");
        }
        return serverUserProfile;
    }

}
