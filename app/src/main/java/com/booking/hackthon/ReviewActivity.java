package com.booking.hackthon;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import static com.booking.hackthon.Utils.EMOJIS;

/**
 * Created by gogolook on 2017/3/11.
 */

public class ReviewActivity extends Activity {


    LinearLayout ll_tag, ll_emojis;
    TextView tv_emoji, tv_done;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.review_page);
        ll_tag = (LinearLayout) findViewById(R.id.ll_tag);
        ll_emojis = (LinearLayout) findViewById(R.id.ll_emojis);
        tv_emoji = (TextView) findViewById(R.id.tv_emoji);
        tv_done = (TextView) findViewById(R.id.tv_done);

        Utils.setTag(ll_tag, 99999);

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "you add a " + ((TextView) v).getText() + " to Mark Rutte", Toast.LENGTH_SHORT).show();
                tv_emoji.setText(((TextView) v).getText());
            }
        };

        for (int i = 0; i < EMOJIS.length; i++) {
            TextView tv = new TextView(this);
            tv.setText(EMOJIS[i]);
            tv.setPadding(8, 8, 8, 8);
            tv.setTextSize(20);

            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            lp.setMargins(0, 0, 20, 0);
            tv.setLayoutParams(lp);
            ll_emojis.addView(tv);
            tv.setOnClickListener(onClickListener);


        }
        tv_done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
