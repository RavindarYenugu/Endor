package com.example.ravindar.alpha;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;


public class HomeActivity extends Activity implements TodoListFragment.OnFragmentInteractionListener, NewTodoItemFragment.OnAddNewItemListener {
    private ArrayAdapter<String> aa;
    private ArrayList<String> todoItems;


    //protected static final String EXTRA_MESSAGE = "com.example.ravindar.alpha.msg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        ArrayList<String> data = new ArrayList<>(Arrays.asList(this.getResources().getStringArray(R.array.todoItems)));

        todoItems = data;


        FragmentManager fm = getFragmentManager();
        NewTodoItemFragment newTodoItemFragment = (NewTodoItemFragment) fm.findFragmentById(R.id.newTodoItem);
        TodoListFragment todoListFragment = (TodoListFragment) fm.findFragmentById(R.id.todoListFragment);
        AbsListView absListView = todoListFragment.getmListView();








/*
        final EditText ed = (EditText) findViewById(R.id.myEditText);
        final ListView lv = (ListView) findViewById(R.id.myListView);

        final ArrayList<String> data = new ArrayList<>(Arrays.asList(this.getResources().getStringArray(R.array.todoItems)));
        final ArrayAdapter<String> aa = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, data);
        lv.setAdapter(aa);

        */


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        switch (id) {
            case R.id.action_search:
                //display_msg in short period of time
                Toast.makeText(getApplicationContext(), "You clicked search.",
                        Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_settings:
                return true;
            default:
                return super.onOptionsItemSelected(item);


        }


    }

    @Override
    public void onFragmentInteraction(String id) {

        Toast toast = Toast.makeText(this, "In Home:" + id, Toast.LENGTH_SHORT);
        toast.show();


    }

    public ArrayList<String> getData() {
        return todoItems;
    }


    @Override
    public void onNewItemAdded(String newItem) {

        todoItems.add(newItem);
        FragmentManager fm = getFragmentManager();

        TodoListFragment todoListFragment = (TodoListFragment) fm.findFragmentById(R.id.todoListFragment);
        AbsListView absListView = todoListFragment.getmListView();

        BaseAdapter lp = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, getData());
        absListView.setAdapter(lp);
        lp.notifyDataSetChanged();


    }


}
