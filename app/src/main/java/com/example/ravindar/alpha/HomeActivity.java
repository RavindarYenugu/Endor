package com.example.ravindar.alpha;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;


public class HomeActivity extends Activity {

    //protected static final String EXTRA_MESSAGE = "com.example.ravindar.alpha.msg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        final EditText ed = (EditText) findViewById(R.id.myEditText);
        final ListView lv = (ListView) findViewById(R.id.myListView);

        final ArrayList<String> data = new ArrayList<>(Arrays.asList(this.getResources().getStringArray(R.array.todoItems)));
        final ArrayAdapter<String> aa = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, data);
        lv.setAdapter(aa);

        ed.setOnKeyListener(new EditText.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_DOWN)
                    if ((keyCode == KeyEvent.KEYCODE_DPAD_CENTER) ||
                            (keyCode == KeyEvent.KEYCODE_ENTER)) {
                        data.add(ed.getText().toString());
                        aa.notifyDataSetChanged();
                        ed.setText("");


                        return true;
                    }
                return false;
            }
        });


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

/*    public void sendMessage(View view) {
        EditText editText = (EditText) findViewById(R.id.myEditText);
        String msg = editText.getText().toString();

        Intent intent = new Intent(this, MyFragActivity.class);
        intent.putExtra(EXTRA_MESSAGE, msg);
        startActivity(intent);


    }*/
}
