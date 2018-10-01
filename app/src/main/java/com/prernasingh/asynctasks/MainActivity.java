package com.prernasingh.asynctasks;

import android.graphics.Color;
import android.os.Handler;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "Async";

    Button btnChangeColor;
    ConstraintLayout clBackground;
    ListView lvItems;

    String[] items = new String[]{
            "Alpha",
            "Beta",
            "Gamma",
            "Delta",
            "Phi",
            "Curo",
            "Strata",
            "Humo"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnChangeColor = findViewById(R.id.btnChangeColor);
        clBackground = findViewById(R.id.clBackground);
        lvItems = findViewById(R.id.lvItems);

        ArrayAdapter<String> itemAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                items
        );

        lvItems.setAdapter(itemAdapter);

        btnChangeColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Handler h = new Handler();
                Runnable r = new Runnable() {
                    @Override
                    public void run() {
                        Log.d(TAG, " we have waited 5 sec");
                        clBackground.setBackgroundColor(Color.BLUE);
                    }
                };
                h.postDelayed(r, 5000);

//                Log.d(TAG,"onClick " + System.currentTimeMillis());
//                waitNsec(10);
//                clBackground.setBackgroundColor(Color.BLUE);

            }
        });
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
