package com.pallab.receiverapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private TextView volume, fat, snf;
    TextView sendBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        volume = findViewById(R.id.et_volume);
        fat = findViewById(R.id.et_fat);
        snf = findViewById(R.id.et_snf);
        sendBtn = findViewById(R.id.send_btn);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM); //bellow setSupportActionBar(toolbar);
        getSupportActionBar().setCustomView(R.layout.titlebar);

        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sendIntent = new Intent();
                sendIntent.setClassName("com.pallab.mainapp", "com.pallab.mainapp.MainActivity");
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(sendIntent);
                finish();
            }
        });
        handleSendText();


    }

    void handleSendText() {
        Intent intent = getIntent();
        String volumeText = intent.getStringExtra("volume");
        String snfText = intent.getStringExtra("snf");
        String fatText = intent.getStringExtra("fat");

        if (volumeText != null && snfText != null && fatText != null) {
            volume.setText(volumeText);
            snf.setText(snfText);
            fat.setText(fatText);
        }

    }
}