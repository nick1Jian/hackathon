package com.booking.hackthon;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

/**
 * Created by gogolook on 2017/3/11.
 */

public class InviteActivity extends Activity {

    RecyclerView mRv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.invite_page);

        mRv = (RecyclerView) findViewById(R.id.rv_invite);
        RecyclerView.LayoutManager lm = new LinearLayoutManager(this);
        mRv.setLayoutManager(lm);
        InviteAdaptor adaptor = new InviteAdaptor(this, lm);
        mRv.setAdapter(adaptor);

    }
}
