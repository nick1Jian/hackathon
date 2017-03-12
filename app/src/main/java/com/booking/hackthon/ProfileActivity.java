package com.booking.hackthon;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

/**
 * Created by gogolook on 2017/3/11.
 */

public class ProfileActivity extends Activity {

    static final String KEY_SEED = "seed";
    RecyclerView mRv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_page);

        mRv = (RecyclerView) findViewById(R.id.rv_profile);
        ProfileAdaptor adaptor = new ProfileAdaptor(this, getIntent().getIntExtra(KEY_SEED, 0));
        mRv.setAdapter(adaptor);
        mRv.setLayoutManager(new LinearLayoutManager(this));

    }
}
