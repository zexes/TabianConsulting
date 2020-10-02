package com.zikozee.tabianconsulting.issues;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.zikozee.tabianconsulting.R;
import com.zikozee.tabianconsulting.models.Issue;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by User on 4/16/2018.
 */

public class IssuesRecyclerViewAdapter extends SelectableAdapter<RecyclerView.ViewHolder> {

    private ArrayList<Issue> mIssues = new ArrayList<>();
    private Context mContext;
    private int[] mIcons;
    private RecyclerViewClickListener mRecyclerViewClickListener;

    public IssuesRecyclerViewAdapter(Context context, ArrayList<Issue> issues, int[] icons, RecyclerViewClickListener recyclerViewClickListener) {
        mIssues = issues;
        mContext = context;
        mIcons = icons;
        mRecyclerViewClickListener = recyclerViewClickListener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_issue_list_item, parent, false);
        final ViewHolder holder = new ViewHolder(view, mRecyclerViewClickListener);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final Issue issue = mIssues.get(position);

        RequestOptions options = new RequestOptions()
                .placeholder(R.drawable.default_avatar)
                .centerInside()
                .override(100, 100);

        int icon;
        if(issue.getIssue_type().equals(Issue.TASK)){
            icon = mIcons[0];
        }
        else{
            icon = mIcons[1];
        }
        Glide.with(mContext)
                .setDefaultRequestOptions(options)
                .load(icon)
                .thumbnail(0.1f)
                .into(((ViewHolder)holder).icon);

        ((ViewHolder)holder).summary.setText(issue.getSummary());
        ((ViewHolder)holder).timestamp.setText(issue.getTime_reported().toString());

        switch (issue.getPriority()){
            case 1:{ // LOW PRIORITY
                Glide.with(mContext)
                        .setDefaultRequestOptions(options)
                        .load(R.drawable.ic_low_priority)
                        .thumbnail(0.1f)
                        .into(((ViewHolder)holder).priority);
                break;
            }
            case 2:{ // MEDIUM PRIORITY
                Glide.with(mContext)
                        .setDefaultRequestOptions(options)
                        .load(R.drawable.ic_medium_priority)
                        .thumbnail(0.1f)
                        .into(((ViewHolder)holder).priority);
                break;
            }
            case 3:{ // HIGH PRIORITY
                Glide.with(mContext)
                        .setDefaultRequestOptions(options)
                        .load(R.drawable.ic_high_priority)
                        .thumbnail(0.1f)
                        .into(((ViewHolder)holder).priority);
                break;
            }
        }

        ((ViewHolder)holder).parentLayout.setBackgroundColor(
                isSelected(position) ?
                        mContext.getResources().getColor(R.color.transparentGrey) :
                        Color.TRANSPARENT);
    }

    @Override
    public int getItemCount() {
        return mIssues.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements
            View.OnClickListener,
            View.OnLongClickListener
    {

        private static final String TAG = "ViewHolder";

        CircleImageView icon;
        TextView summary, timestamp;
        CircleImageView priority;
        LinearLayout parentLayout;

        RecyclerViewClickListener listener;

        public ViewHolder(View itemView, RecyclerViewClickListener listener) {
            super(itemView);
            icon = itemView.findViewById(R.id.image);
            summary = itemView.findViewById(R.id.issue_summary);
            timestamp = itemView.findViewById(R.id.timestamp);
            priority = itemView.findViewById(R.id.priority);
            parentLayout = itemView.findViewById(R.id.parent_layout);

            this.listener = listener;

            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (listener != null) {
                listener.onItemClicked(getAdapterPosition());
            }
        }

        @Override
        public boolean onLongClick(View v) {
            if (listener != null) {
                return listener.onItemLongClicked(getAdapterPosition());
            }

            return false;
        }
    }

    public interface RecyclerViewClickListener {
        public void onItemClicked(int position);
        public boolean onItemLongClicked(int position);
    }

}








