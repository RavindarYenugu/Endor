package com.example.ravindar.alpha;

import android.view.KeyEvent;
import android.view.View;

/**
 * Created by Ravindar on 5/8/2015.
 */
public class MyETKeyListener implements View.OnKeyListener {
    @Override
    public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
        if (keyEvent.getAction() == KeyEvent.ACTION_DOWN)
            if ((keyCode == KeyEvent.KEYCODE_DPAD_CENTER) ||
                    (keyCode == KeyEvent.KEYCODE_ENTER)) {
                return true;


            }
        return false;

    }

}
