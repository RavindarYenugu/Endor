package com.example.ravindar.alpha;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;

import java.util.ArrayList;


public class HomeActivity extends Activity implements NewItemFragment.OnNewItemAddedListener {

    private ArrayList<ToDoItem> todoItems;
    private ToDoItemAdapter aa;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Inflate your view
        setContentView(R.layout.home);

        // Get references to the Fragments
        FragmentManager fm = getFragmentManager();
        ToDoListFragment todoListFragment =
                (ToDoListFragment) fm.findFragmentById(R.id.todoListFragment);

        // Create the array list of to do items
        todoItems = new ArrayList<ToDoItem>();

        // Create the array adapter to bind the array to the ListView

        aa = new ToDoItemAdapter(this, R.layout.todolist_item, todoItems);

        // Bind the array adapter to the ListView.
        todoListFragment.setListAdapter(aa);
    }

    public void onNewItemAdded(String newItem) {
        ToDoItem newTodoItem = new ToDoItem(newItem);

        IntentFilter batIntentFilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        Intent battery = this.registerReceiver(null, batIntentFilter);
        int status = 0;
        if (battery != null) {
            status = battery.getIntExtra(BatteryManager.EXTRA_STATUS, -1);
        }
        boolean isCharging =
                status == BatteryManager.BATTERY_STATUS_CHARGING ||
                        status == BatteryManager.BATTERY_STATUS_FULL;


        LocalBroadcastManager lbm = LocalBroadcastManager.getInstance(this);


        todoItems.add(0, newTodoItem);
        aa.notifyDataSetChanged();


    }
}
