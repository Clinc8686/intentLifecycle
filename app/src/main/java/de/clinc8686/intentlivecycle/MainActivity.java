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
    }


    //Hier wäre es besser auf null/empty zu prüfen, statt in der second_Activity. Dann könnte man direkt den passende string übertragen, ob leer ist
    public void sendText(View view) {
        TextView sendingText = (TextView) findViewById(R.id.intentText);
        String sendingTextString = sendingText.getText().toString();
        Intent secondActivityIntent = new Intent(MainActivity.this, SecondActivity.class);  //Expliziter Intent verwendet, anderes (nicht hier) wäre Impliziter Intent. Implizit ist für Standardapps wie Browser, sodass gefragt wird welche App man verwenden möchte
        secondActivityIntent.putExtra("extraString", sendingTextString);
        //startActivity(secondActivityIntent);
        startActivityForResult(secondActivityIntent, RESULT_OK);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        Log.e("a", "b");
        super.onActivityResult(requestCode, resultCode, data);
        TextView resultText = (TextView) findViewById(R.id.resultCode);
        resultText.setText("Message received! Result code: " + resultText);

        EditText receivedTextfield = findViewById(R.id.intentText);

        Intent receiver = getIntent();
        String receivedString = receiver.getStringExtra("extraString");
        if (receivedString.length() == 0) {
            resultText.setText("empty String!");
        }

        receivedTextfield.setText(receivedString);
    }
}