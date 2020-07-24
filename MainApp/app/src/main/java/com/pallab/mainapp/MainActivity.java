package com.pallab.mainapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText et_volume;
    private EditText et_snf;
    private EditText et_fat;
    LinearLayout sendBtn ,read_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_volume = findViewById(R.id.et_volume);
        et_snf = findViewById(R.id.et_snf);
        et_fat = findViewById(R.id.et_fat);
        sendBtn = findViewById(R.id.send_btn);
        read_btn = findViewById(R.id.read_btn);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM); //bellow setSupportActionBar(toolbar);
        getSupportActionBar().setCustomView(R.layout.titlebar);



        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (et_volume.getText().toString().equals("") || et_snf.getText().toString().equals("") || et_fat.getText().toString().equals("")) {
                    Toast.makeText(MainActivity.this, "Please fill up all the fields !!!", Toast.LENGTH_SHORT).show();
                } else {
                    send();
                }
            }
        });


        read_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et_volume.setText("120");
                et_fat.setText("4.8");
               et_snf.setText("7.4");
            }
        });

    }

    private void send() {
        Intent sendIntent = new Intent();
        sendIntent.setClassName("com.pallab.receiverapp", "com.pallab.receiverapp.MainActivity");
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        String volume = et_volume.getText().toString();
        String snf = et_snf.getText().toString();
        String fat = et_fat.getText().toString();

        sendIntent.putExtra("volume", volume);
        sendIntent.putExtra("snf", snf);
        sendIntent.putExtra("fat", fat);

        startActivity(sendIntent);
        finish();
    }
}