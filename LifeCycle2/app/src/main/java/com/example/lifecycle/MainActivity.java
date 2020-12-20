package com.example.lifecycle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btn_clicker;
    TextView tv_counter;

    int clicks = 0;

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("clickervalue", clicks);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        clicks = savedInstanceState.getInt("clickervalue");
        tv_counter = findViewById(R.id.tv_counter);
        tv_counter.setText(Integer.toString(clicks));
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Lifecyclefilter ", "The app is started ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Lifecyclefilter ", "The app is stopped ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Lifecyclefilter ", "The app is destroyed ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Lifecyclefilter ", "The app is paused ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Lifecyclefilter ", "The app is resumed ");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("Lifecyclefilter ", "The app is restarted ");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("Lifecyclefilter ", "The app is created ");

        btn_clicker = findViewById(R.id.btn_clicker);
        tv_counter = findViewById(R.id.tv_counter);

        btn_clicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clicks++;
                tv_counter.setText(Integer.toString(clicks));
            }
        });
    }
}