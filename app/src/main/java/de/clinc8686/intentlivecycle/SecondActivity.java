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
        Log.d("Lifecycle Second", "Create");
        setContentView(R.layout.second_activity_main);
        EditText receivedTextfield = findViewById(R.id.receivedText);
        TextView textHint = findViewById(R.id.textHint);

        Intent receiver = getIntent();
        String receivedString = receiver.getStringExtra("extraString");
        receivedTextfield.setText(receivedString);
    }

    public void sendText(View view) {
        TextView sendingText = (TextView) findViewById(R.id.receivedText);
        String sendingTextString = sendingText.getText().toString();
        Intent mainActivityIntent = new Intent();
        mainActivityIntent.putExtra("extraString", sendingTextString);
        setResult(RESULT_CANCELED, mainActivityIntent);
        finish();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Lifecycle Second", "Start");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Lifecycle Second", "Pause");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("Lifecycle Second", "Restart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Lifecycle Second", "Resume");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Lifecycle Second", "Stop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Lifecycle Second", "Destroy");
    }
}
