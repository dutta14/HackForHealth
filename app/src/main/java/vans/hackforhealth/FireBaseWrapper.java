package vans.hackforhealth;


import android.content.Context;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

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

    public void sendForumToCloud(UserThread val){
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

}
