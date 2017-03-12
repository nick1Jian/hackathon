package com.booking.hackthon;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by gogolook on 2017/3/11.
 */

public class ProfileAdaptor extends RecyclerView.Adapter {

    private static final int TYPE_HEAD = 0;
    private static final int TYPE_SUMMARY = 1;
    private static final int TYPE_PEER_REVIEW = 2;

    private static final int EXTRA_ITEM_COUNT = 2;


    Context mContext;
    LayoutInflater mInflater;
    int mSeed;
    String name;
    ArrayList<Utils.Review> mReviews;


    public ProfileAdaptor(Context context, int seed) {
        Random rand = new Random(seed);
        this.mReviews = Utils.getReviewList(rand.nextInt(8) + 3, seed);
        this.mContext = context;
        this.mSeed = seed;
        this.mInflater = LayoutInflater.from(context);
        name = Utils.getName(mSeed);
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return TYPE_HEAD;
        } else if (position == 1) {
            return TYPE_SUMMARY;
        }
        return TYPE_PEER_REVIEW;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        if (viewType == TYPE_HEAD) {
            view = mInflater.inflate(R.layout.holder_head, parent, false);

            ((TextView) view.findViewById(R.id.tv_name)).setText(name);
            Utils.loadProfileImage(mContext, (ImageView) view.findViewById(R.id.iv_head), Utils.getProfilePic(mSeed));

            return new SimpleHolder(view);
        } else if (viewType == TYPE_SUMMARY) {
            view = mInflater.inflate(R.layout.holder_summary, parent, false);
            ((TextView) view.findViewById(R.id.tv_summary)).setText(Utils.getSummary(mSeed));
            ((TextView) view.findViewById(R.id.tv_review)).setText(Utils.getEmojiReview(mSeed));
            ((TextView) view.findViewById(R.id.tv_friend_title)).setText("Friends of " + name);
            LinearLayout ll = (LinearLayout) view.findViewById(R.id.ll_tag);
            String[] tags = Utils.getTags(mSeed);

            if (tags.length != 0) {
                Random rand = new Random();
                for (int i = 0; i < tags.length; i++) {
                    TextView tv = new TextView(mContext);
                    tv.setText(tags[i]);
                    tv.setPadding(8, 8, 8, 8);
                    tv.setTextColor(Color.WHITE);
                    tv.setBackgroundColor(Color.rgb(rand.nextInt(128), rand.nextInt(128), rand.nextInt(128)));

                    LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                    lp.setMargins(0, 0, 20, 0);
                    tv.setLayoutParams(lp);
                    ll.addView(tv);
                }
            } else {
                ll.setVisibility(View.INVISIBLE);
            }
            return new SimpleHolder(view);

        } else if (viewType == TYPE_PEER_REVIEW) {
            view = mInflater.inflate(R.layout.holder_review, parent, false);
            return new ReviewHolder(view);
        }


        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position) == TYPE_PEER_REVIEW) {
            ReviewHolder holder1 = (ReviewHolder) holder;
            int pos = position - 2;
            Utils.loadProfileImage(mContext, holder1.iv_head, mReviews.get(pos).photo);
            holder1.tv_emoji.setText(mReviews.get(pos).emoji);
            holder1.tv_name.setText(mReviews.get(pos).name);
            holder1.tv_review.setText(mReviews.get(pos).comment);
        }

    }

    @Override
    public int getItemCount() {
        return mReviews.size() + EXTRA_ITEM_COUNT;
    }

    private class SimpleHolder extends RecyclerView.ViewHolder {
        public SimpleHolder(View itemView) {
            super(itemView);
        }
    }

    private class ReviewHolder extends RecyclerView.ViewHolder {
        ImageView iv_head;
        TextView tv_name, tv_emoji, tv_review;

        public ReviewHolder(View itemView) {
            super(itemView);
            iv_head = (ImageView) itemView.findViewById(R.id.iv_head);
            tv_name = (TextView) itemView.findViewById(R.id.tv_name);
            tv_emoji = (TextView) itemView.findViewById(R.id.tv_emoji);
            tv_review = (TextView) itemView.findViewById(R.id.tv_review);
        }

    }
}
