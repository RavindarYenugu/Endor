package com.example.ravindar.alpha;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;

import android.view.MenuItem;


public class MyFragActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_container_layout);

        FragmentManager fm = getFragmentManager();

        DetailsFragment df = (DetailsFragment) fm.findFragmentById(R.id.details_container);

        if (df == null) {
            FragmentTransaction ft = fm.beginTransaction();
            ft.add(R.id.details_container, new DetailsFragment());

            ft.add(R.id.ui_container, new MyListFragment());

            ft.commit();


        }


    }


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
}
