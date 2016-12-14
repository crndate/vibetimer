package com.rinpach.vibetimer;

import android.os.CountDownTimer;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.util.Log;
        import android.view.View;
        import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
        import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button startButton, stopButton;
    private TextView timerText;
    private EditText imputmin, imputsec;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imputmin = (EditText)findViewById(R.id.imputmin);
        imputsec = (EditText)findViewById(R.id.imputsec);
        startButton = (Button)findViewById(R.id.start_button);
        stopButton = (Button)findViewById(R.id.stop_button);
        timerText = (TextView)findViewById(R.id.timer);
        timerText.setText("Timer");

        Vibrator vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
        final CountDown countDown = new CountDown(60000, 1000);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 開始
                countDown.start();
            }
        });

        stopButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // 中止
                countDown.cancel();
                timerText.setText("0:00");
            }
        });
    }

    class CountDown extends CountDownTimer {

        public CountDown(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onFinish() {
            // 完了
            timerText.setText("0:00");
        }

        // インターバルで呼ばれる
        @Override
        public void onTick(long millisUntilFinished) {
            // 残り時間を分、秒に分割
            long mm = millisUntilFinished / 1000 / 60;
            long ss = millisUntilFinished / 1000 % 60;

            timerText.setText(String.format("%1$02d:%2$02d", mm, ss));
        }
    }

}
