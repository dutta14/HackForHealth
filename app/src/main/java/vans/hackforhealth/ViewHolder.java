package vans.hackforhealth;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ViewHolder extends RecyclerView.ViewHolder implements
        View.OnClickListener
{
    public TextView bookName;
    public TextView authorName;
    public ImageView im;

    public ViewHolder(View itemView)
    {
        super(itemView);
        //itemView.setOnClickListener(this);
        bookName = (TextView) itemView.findViewById(R.id.BookName);
        authorName = (TextView) itemView.findViewById(R.id.chatBtn);
        im = (ImageView) itemView.findViewById(R.id.image1);

        bookName.setOnClickListener(this);
        authorName.setOnClickListener(this);
        im.setOnClickListener(this);
    }

    @Override
    public void onClick(View view)
    {
        switch (view.getId()) {
            case R.id.BookName:
                Intent profile = new Intent(view.getContext(),ProfilePage.class);
                profile.putExtra("position", getPosition());
                view.getContext().startActivity(profile);
                break;
            case R.id.image1:
                Log.d("hey","image");
                view.getContext().startActivity(new Intent(view.getContext(),ProfilePage.class));
                break;
            case R.id.chatBtn:
                Toast.makeText(view.getContext(),
                        "Chat Position = " + getPosition(), Toast.LENGTH_SHORT)
                        .show();
                break;
            default:
                break;
        }

    }
}