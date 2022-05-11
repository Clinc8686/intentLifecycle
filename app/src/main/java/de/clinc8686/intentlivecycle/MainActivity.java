package de.clinc8686.intentlivecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void sendText(View view) {
        TextView sendingText = (TextView) findViewById(R.id.intentText);
        String sendingTextString = sendingText.getText().toString();
        Intent secondActivityIntent = new Intent(MainActivity.this, SecondActivity.class);
        secondActivityIntent.putExtra("extraString", sendingTextString);
        startActivity(secondActivityIntent);
    }
}