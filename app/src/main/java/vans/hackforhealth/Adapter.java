package vans.hackforhealth;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<ViewHolder>
{
    private List<UserProfile> itemList;
    private Context context;

    public Adapter(Context context,List<UserProfile> itemList)
    {
        this.itemList = itemList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.activity_adapter, null);
        ViewHolder rcv = new ViewHolder(layoutView);
        return rcv;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position)
    {
        holder.bookName.setText(itemList.get(position).getName());
        //holder.authorName.setText(itemList.get(position).getAuthor());
    }

    @Override
    public int getItemCount()
    {
        return this.itemList.size();
    }
}