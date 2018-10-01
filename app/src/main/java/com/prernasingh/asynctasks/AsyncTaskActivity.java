package com.prernasingh.asynctasks;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class AsyncTaskActivity extends AppCompatActivity {
    public static final String TAG = "AT";
    Button btnStart, btnRandom;
    TextView tvCounter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_task);

        //findViewById
        btnStart = findViewById(R.id.btnStart);
        btnRandom= findViewById(R.id.btnRandom);
        tvCounter = findViewById(R.id.tvCounter);

        btnRandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random r = new Random();
                tvCounter.setText(String.valueOf(r.nextInt(100)));
            }
        });

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "Start Pressed");
                CountTask cTask = new CountTask();
                cTask.execute(5);
            }
        });

    }

    class CountTask  extends AsyncTask<Integer, Integer, Void>{

        @Override
        protected Void doInBackground(Integer... integers) {
            Log.d(TAG, "doInBackground : start ");
            int n = integers[0];
            //waitNsec(n);
            for(int i = 0;i<n ;i++){
                waitsec();
                publishProgress(i);

            }
            Log.d(TAG, "doInBackground : end");
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            tvCounter.setText(String.valueOf(values[0]));
        }
    }
    void waitsec(){
        long Starttime = System.currentTimeMillis();
        while(System.currentTimeMillis() < Starttime + 1000);
    }

    void waitNsec(int n){
        for (int i =0;i<n;i++){
            waitsec();
        }
    }
}
