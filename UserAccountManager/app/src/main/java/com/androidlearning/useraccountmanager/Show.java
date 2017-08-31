package com.androidlearning.useraccountmanager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Show extends AppCompatActivity {
    private TextView ShowTime;
    private Button ShowBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        BuildControl();
        showTime();
    }
    private void BuildControl() {
        ShowTime = (TextView) findViewById(R.id.ShowTime);
        ShowBack = (Button) findViewById(R.id.ShowBack);
        ShowBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ButtonClicked(v);
            }
        });
    }
    private void showTime() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy年MM月dd日  HH:mm:ss");
        String DT = formatter.format(new Date());
        ShowTime.setText("登录时间:" + DT);
    }
    private void ButtonClicked(View v) {
        Intent intent = new Intent(Show.this,MainActivity.class);
        startActivity(intent);
    }
}
