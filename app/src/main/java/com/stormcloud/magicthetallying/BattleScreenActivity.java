package com.stormcloud.magicthetallying;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class BattleScreenActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battle_screen_2);

        getActionBar().hide();
//        setContentView(R.layout.fragment_battle_card);

//        FragmentManager fm = getFragmentManager();

//        BattleCardFragment bcSelf = new BattleCardFragment();
//        BattleCardFragment bcOpp = new BattleCardFragment();

//        fm.beginTransaction().add()

//                .commit();

        final Button btnRestart = (Button)findViewById(R.id.restartButton);
        btnRestart.setVisibility(View.INVISIBLE);

        btnRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // First-time init; create fragment to embed in activity.
                FragmentTransaction ft1 = getFragmentManager().beginTransaction();

                BattleCardFragment bcSelf = new BattleCardFragment();
//            BattleCardFragment newFragment = MyFragment.newInstance("From Arguments");
                ft1.replace(R.id.fragmentPlayerSelf, bcSelf);
                ft1.commit();

                FragmentTransaction ft2 = getFragmentManager().beginTransaction();

                BattleCardFragment bcOpp = new BattleCardFragment();
//            BattleCardFragment newFragment = MyFragment.newInstance("From Arguments");
                ft2.replace(R.id.fragmentPlayerOpponent, bcOpp);
                ft2.commit();

                btnRestart.setVisibility(View.INVISIBLE );
            }
        });


        if (savedInstanceState == null) {
            // First-time init; create fragment to embed in activity.
            FragmentTransaction ft1 = getFragmentManager().beginTransaction();

            BattleCardFragment bcSelf = new BattleCardFragment();
//            BattleCardFragment newFragment = MyFragment.newInstance("From Arguments");
            ft1.add(R.id.fragmentPlayerSelf, bcSelf);
            ft1.commit();

            FragmentTransaction ft2 = getFragmentManager().beginTransaction();

            BattleCardFragment bcOpp = new BattleCardFragment();
//            BattleCardFragment newFragment = MyFragment.newInstance("From Arguments");
            ft2.add(R.id.fragmentPlayerOpponent, bcOpp);
            ft2.commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_battle_screen, menu);
        return true;
    }

//    @Override
//    public void onCreateView()

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//
//        View v = new View(this);
//        return v;
//    }

//    @Override
//    public View onCreateView (String name, Context context, AttributeSet attrs) {
//
//        View v = View.inflate(this, R.layout.activity_battle_screen_2, );
//
//        return v;
//
//
//    }
}
