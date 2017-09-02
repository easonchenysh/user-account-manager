package com.androidlearning.useraccountmanager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

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
        ShowTime.setText("登录时间:" + Manager.getData());
    }
    private void ButtonClicked(View v) {
        finish();
    }
}
