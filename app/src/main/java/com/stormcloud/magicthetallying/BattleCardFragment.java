package com.stormcloud.magicthetallying;

import android.app.Fragment;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

/**
 * Created by schhan on 1/7/15.
 *
 * Displays life. Starts with a default value.
 *
 * Plus and minus buttons increment and decrement, respectively, from the displayed life value.
 */
public class BattleCardFragment extends Fragment{

    int mLife;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mLife = 20;

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (container == null) {
            // We have different layouts, and in one of them this
            // fragment's containing frame doesn't exist.  The fragment
            // may still be created from its saved state, but there is
            // no reason to try to create its view hierarchy because it
            // won't be displayed.  Note this is not needed -- we could
            // just run the code below, where we would create and return
            // the view hierarchy; it would just never be used.
            return null;
        }

        View v = inflater.inflate(R.layout.fragment_battle_card, container, false);
//        View tv = v.findViewById(R.id.text);
//        ((TextView)tv).setText(mLabel != null ? mLabel : "(no label)");
//        tv.setBackgroundDrawable(getResources().getDrawable(android.R.drawable.gallery_thumb));


        final TextView tv = (TextView)v.findViewById(R.id.life_playerTextView);
        tv.setText(String.valueOf(mLife));

        tv.setTextSize(32 * getResources().getDisplayMetrics().density);

        int pad = (int) (32 * getResources().getDisplayMetrics().density);

        Button btnPlus = (Button)v.findViewById(R.id.player_plusButton);
        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mLife++;
                tv.setText(String.valueOf(mLife));

                if(mLife >= 1) {
                    getActivity().findViewById(R.id.restartButton).setVisibility(View.INVISIBLE);
                }
            }
        });
        btnPlus.setTextSize(32 * getResources().getDisplayMetrics().density);
        btnPlus.setPadding(pad, 0, pad, 0);


        pad = (int) (48 * getResources().getDisplayMetrics().density);
        Button btnMinus= (Button)v.findViewById(R.id.player_minusButton);
        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mLife--;
                tv.setText(String.valueOf(mLife));

                if(mLife <= 0) {
                    getActivity().findViewById(R.id.restartButton).setVisibility(View.VISIBLE);
                }
            }
        });
        btnMinus.setTextSize(32 * getResources().getDisplayMetrics().density);

        btnMinus.setPadding(pad, 0, pad, 0);

        return v;

    }

}
