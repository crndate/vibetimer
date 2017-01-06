package com.example.crndate.vibetimer;

import android.app.AlarmManager;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private Button setButton, startButton, stopButton;
    private TextView timerText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setButton = (Button)findViewById(R.id.set_button);
        startButton = (Button)findViewById(R.id.start_button);
        stopButton = (Button)findViewById(R.id.stop_button);
        timerText = (TextView)findViewById(R.id.timer);
        timerText.setText("セットしなさいよね！！");

        Vibrator vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);

    }
}
