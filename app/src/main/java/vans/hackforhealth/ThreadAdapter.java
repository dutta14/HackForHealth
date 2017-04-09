package vans.hackforhealth;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anind on 4/8/2017.
 */

public class ThreadAdapter extends RecyclerView.Adapter<ThreadAdapter.MyViewHolder> {

    private List<UserThread> threadList;

    public ThreadAdapter(List<UserThread> threadList) {
        this.threadList = threadList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.forum_entry_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        UserThread thread = threadList.get(position);
        holder.title.setText(thread.getName());
        ArrayList<String> tags = thread.getTags();
        holder.tag1.setText(tags.get(0));
        holder.tag2.setText(tags.get(1));
        holder.tag3.setText(tags.get(2));
        holder.tag4.setText(tags.get(3));
        holder.tag5.setText(tags.get(4));
    }

    @Override
    public int getItemCount() {
        return threadList.size();
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
