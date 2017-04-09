package vans.hackforhealth;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anind on 4/8/2017.
 */

public class ThreadAdapter extends RecyclerView.Adapter<ThreadAdapter.MyViewHolder> {

    private List<UserThread> threadList;
    Context mContext;

    public ThreadAdapter(List<UserThread> threadList) {
        this.threadList = threadList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        final View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.forum_entry_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        final UserThread thread = threadList.get(position);
        holder.title.setText(thread.getName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(mContext, ThreadDetail.class);
                i.putExtra("thread", thread);
                mContext.startActivity(i);
            }
        });

        ArrayList<String> tags = thread.getTags();
        if(tags.size()>0) {
            holder.tag1.setText(tags.get(0));
            holder.tag1.setVisibility(View.VISIBLE);
        } else {
            holder.tag1.setVisibility(View.GONE);
        }
        if(tags.size()>1) {
            holder.tag2.setText(tags.get(1));
            holder.tag2.setVisibility(View.VISIBLE);
        } else {
            holder.tag2.setVisibility(View.GONE);
        }
        if(tags.size()>2) {
            holder.tag3.setText(tags.get(2));
            holder.tag3.setVisibility(View.VISIBLE);
        } else {
            holder.tag3.setVisibility(View.GONE);
        }
        if(tags.size()>3) {
            holder.tag4.setText(tags.get(3));
            holder.tag4.setVisibility(View.VISIBLE);
        } else {
            holder.tag4.setVisibility(View.GONE);
        }
        if(tags.size()>4) {
            holder.tag5.setText(tags.get(4));
            holder.tag5.setVisibility(View.VISIBLE);
        } else {
            holder.tag5.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        if(threadList!=null)
            return threadList.size();
        return 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, tag1, tag2, tag3, tag4, tag5;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            tag1 = (TextView) view.findViewById(R.id.tag1);
            tag2 = (TextView) view.findViewById(R.id.tag2);
            tag3 = (TextView) view.findViewById(R.id.tag3);
            tag4 = (TextView) view.findViewById(R.id.tag4);
            tag5 = (TextView) view.findViewById(R.id.tag5);
        }
    }
}
