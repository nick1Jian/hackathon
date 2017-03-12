package com.booking.hackthon;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by gogolook on 2017/3/11.
 */

public class InviteAdaptor extends RecyclerView.Adapter {

    private static final int TYPE_HEAD = 0;
    private static final int TYPE_FRIEND = 1;
    private static final int TYPE_LOADING = 2;

    private static final int EXTRA_ITEM_COUNT = 2;
    private static final int LOAD_COUNT = 20;


    Context mContext;
    LayoutInflater mInflater;
    ArrayList<Integer> mFriendSeeds;
    RecyclerView.LayoutManager mLayoutManager;


    public InviteAdaptor(Context context, RecyclerView.LayoutManager layoutManager) {
        this.mFriendSeeds = new ArrayList<>();
        this.mContext = context;
        this.mInflater = LayoutInflater.from(context);
        this.mLayoutManager = layoutManager;

        loadItem();
    }


    private void loadItem() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < LOAD_COUNT; i++) {
                    mFriendSeeds.add(mFriendSeeds.size());
                    notifyItemInserted(mFriendSeeds.size());
                }

            }
        }, 1500);

    }


    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return TYPE_HEAD;
        } else if (position < mFriendSeeds.size() + 1) {
            return TYPE_FRIEND;
        }
        return TYPE_LOADING;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;

        if (viewType == TYPE_HEAD) {
            view = mInflater.inflate(R.layout.holder_invite_head, parent, false);
            view.setOnClickListener(mOnClick);
            return new SimpleHolder(view);

        } else if (viewType == TYPE_FRIEND) {
            view = mInflater.inflate(R.layout.holder_invite_item, parent, false);
            view.setOnClickListener(mOnClick);
            final FriendHolder holder = new FriendHolder(view);
            holder.tv_invite.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(mContext, "Invitation Send", Toast.LENGTH_LONG).show();
                    holder.tv_invite.setText("V");
                }
            });
            return holder;

        } else {
            view = mInflater.inflate(R.layout.holder_invite_loading, parent, false);
            view.setOnClickListener(mOnClick);
            return new SimpleHolder(view);
        }
    }


    private View.OnClickListener mOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(mContext, ProfileActivity.class);
            intent.putExtra(ProfileActivity.KEY_SEED, mLayoutManager.getPosition(v));
            mContext.startActivity(intent);

        }
    };

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position) == TYPE_FRIEND) {
            FriendHolder holder1 = (FriendHolder) holder;
            int pos = position;//no need to increase

            LinearLayout ll = (LinearLayout) holder1.ll_tag;
            ll.removeAllViews();
            Utils.setTag(ll, pos);

            Utils.loadProfileImage(mContext, holder1.iv_head, Utils.getProfilePic(pos));
            holder1.tv_emoji.setText(Utils.getEmoji(pos));
            holder1.tv_name.setText(Utils.getName(pos));
            holder1.tv_invite.setText("Invite");
            Log.d("!!!", Utils.getReview(pos).length() + "");
            holder1.tv_desc.setText(Utils.getReview(pos));
            if (Utils.getReview(pos).length() > 70) {
                holder1.tv_more.setVisibility(View.VISIBLE);
            } else {
                holder1.tv_more.setVisibility(View.GONE);
            }

        }

    }

    @Override
    public int getItemCount() {
        return mFriendSeeds.size() + EXTRA_ITEM_COUNT;
    }

    private class SimpleHolder extends RecyclerView.ViewHolder {
        public SimpleHolder(View itemView) {
            super(itemView);
        }
    }

    private class FriendHolder extends RecyclerView.ViewHolder {
        ImageView iv_head;
        TextView tv_name, tv_emoji, tv_desc, tv_more, tv_invite;
        LinearLayout ll_tag;

        public FriendHolder(View itemView) {
            super(itemView);
            iv_head = (ImageView) itemView.findViewById(R.id.iv_head);
            tv_name = (TextView) itemView.findViewById(R.id.tv_name);
            tv_emoji = (TextView) itemView.findViewById(R.id.tv_emoji);
            tv_desc = (TextView) itemView.findViewById(R.id.tv_desc);
            tv_more = (TextView) itemView.findViewById(R.id.tv_more);
            ll_tag = (LinearLayout) itemView.findViewById(R.id.ll_tag);
            tv_invite = (TextView) itemView.findViewById(R.id.tv_invite);
        }

    }
}
