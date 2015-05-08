import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.example.ravindar.alpha.R;

/**
 * Created by Ravindar on 5/8/2015.
 */
public class ClearablEditText extends LinearLayout {

    EditText editText;
    Button clearButton;

    public ClearablEditText(Context context) {
        super(context);
        String infService = context.LAYOUT_INFLATER_SERVICE;
        LayoutInflater li;
        li = (LayoutInflater) getContext().getSystemService(infService);

        editText = (EditText) findViewById(R.id.editText);
        clearButton = (Button) findViewById(R.id.clearButton);
        hookupButton();

    }

    private void hookupButton() {
        clearButton.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View view) {
                editText.setText("");
            }
        });
    }
}
