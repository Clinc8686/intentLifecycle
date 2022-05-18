package de.clinc8686.intentlivecycle;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity_main);
        EditText receivedTextfield = findViewById(R.id.receivedText);
        TextView textHint = findViewById(R.id.textHint);

        Intent receiver = getIntent();
        String receivedString = receiver.getStringExtra("extraString");
        if (receivedString.length() == 0) {
            textHint.setText("empty String!");
        }

        receivedTextfield.setText(receivedString);
    }

    public void sendText(View view) {
        TextView sendingText = (TextView) findViewById(R.id.receivedText);
        String sendingTextString = sendingText.getText().toString();
        Intent mainActivityIntent = new Intent();
        mainActivityIntent.putExtra("extraString", sendingTextString);
        setResult(RESULT_OK, mainActivityIntent);
        finish();
    }
}
