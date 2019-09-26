package com.example.threadexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        handler = new Handler();

        textView = findViewById(R.id.tv);
    }

    public void button(View view) {
        WorkerThread wt = new WorkerThread();
        Thread thread = new Thread(wt);
        thread.start();

    }

    class WorkerThread implements Runnable {
        String name = "Siva";

        public void run() {
            handler.post(new Runnable() {
                @Override
                public void run() {
                    textView.setText(name);

                }
            });
        }

    }
}
