package de.clinc8686.intentlivecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("Lifecycle Main", "Create");
    }


    //Hier wäre es besser auf null/empty zu prüfen, statt in der second_Activity. Dann könnte man direkt den passenden string übertragen, ob leer ist - check
    public void sendText(View view) {
        TextView sendingText = (TextView) findViewById(R.id.intentText);
        String sendingTextString = sendingText.getText().toString();
        if (sendingText.length() <= 0) {
            sendingTextString = "Empty String!";
        }

        Intent secondActivityIntent = new Intent(MainActivity.this, SecondActivity.class);  //Expliziter Intent verwendet, anderes (nicht hier) wäre Impliziter Intent. Implizit ist für Standardapps wie Browser, sodass gefragt wird welche App man verwenden möchte
        secondActivityIntent.putExtra("extraString", sendingTextString);
        startActivityForResult(secondActivityIntent, RESULT_CANCELED);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        TextView resultText = (TextView) findViewById(R.id.resultCode);
        resultText.setText("Message received! Request code: " + requestCode);

        EditText receivedTextfield = findViewById(R.id.intentText);

        String receivedString = "";
        try {
            receivedString = data.getStringExtra("extraString");
        } catch (NullPointerException e){
            resultText.setText("Exception! Back Button gedrückt.");
            return;
        }

        if (receivedString.length() == 0) {
            resultText.setText("empty String!");
        }

        receivedTextfield.setText(receivedString);
    }
    //Widerherstellen beim drehen des Bildschirms mit onSaveInstanceState und onRestoreInstanceState

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Lifecycle Main", "Start");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Lifecycle Main", "Pause");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("Lifecycle Main", "Restart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Lifecycle Main", "Resume");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Lifecycle Main", "Stop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Lifecycle Main", "Destroy");
    }
}