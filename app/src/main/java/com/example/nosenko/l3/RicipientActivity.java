package com.example.nosenko.l3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;


/**
 * Created by Nosenko on 18.11.2016.
 */

public class RicipientActivity extends AppCompatActivity {

    public static final String SENDER_TEXT = "MESSAGE";

    private Intent intent;
    private String mess;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ricipient_activity);
        intent = getIntent();
        getMess();
    }

    private void getMess(){
        Log.d("RicipientActivity", "getMess");
        TextView tvRicipientText = (TextView) findViewById(R.id.tvRicipientText);
        mess = intent.getStringExtra(SENDER_TEXT);
        tvRicipientText.setText(mess);
    }

    @Override
    public void onBackPressed(){
        final String answer = "You send " + mess;
        Log.d("RicipientActivity", "onBackPressed");
        intent.putExtra(MainActivity.GET_MESS, answer);
        setResult(Activity.RESULT_OK, intent);
        super.onBackPressed();
    }
}
