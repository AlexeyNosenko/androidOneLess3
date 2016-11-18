package com.example.nosenko.l3;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static com.example.nosenko.l3.RicipientActivity.SENDER_TEXT;

public class MainActivity extends Activity {

    private Intent intentSendText;

    public static final int U_CODE = 506;
    public static final String GET_MESS = "GET_MESS";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnSend = (Button) findViewById(R.id.btnSendText);
        btnSend.setOnClickListener(listenerBtnSend);
        intentSendText = new Intent(this, RicipientActivity.class);

        Button button = (Button) findViewById(R.id.btnExplicit);
        button.setOnClickListener(listenerExplicit);
    }

    private View.OnClickListener listenerBtnSend = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Log.d("MainActivity", "onClick");
            EditText etSendText = (EditText)findViewById(R.id.etSendText);
            String text = etSendText.getText().toString();
            intentSendText.putExtra(SENDER_TEXT, text);
            startActivityForResult(intentSendText, U_CODE);
        }
    };

    private View.OnClickListener listenerExplicit = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            final String myIntentView = "ru.startandroid.intent.action.showmustgoon";
            //final String notMyIntentView = android.content.Intent.ACTION_VIEW;

            Intent intent = new Intent(myIntentView);
            //intent.setDataAndType(Uri.parse("url"), "image/*");
            List<ResolveInfo> resolveInfoList = getPackageManager().queryIntentActivities(intent, 0);
            if (resolveInfoList.size() != 0){
                startActivity(intent);
            }
        }
    };

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        Log.d("MainActivity", "onActivityResult");
        if (requestCode == U_CODE){
            if (resultCode == Activity.RESULT_OK){
                TextView tvSendText = (TextView) findViewById(R.id.tvGetText);
                tvSendText.setText(data.getStringExtra(GET_MESS));
            }
        }
    }
}
