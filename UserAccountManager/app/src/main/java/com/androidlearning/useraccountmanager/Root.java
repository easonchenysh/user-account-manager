package com.androidlearning.useraccountmanager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Root extends AppCompatActivity {
    private TextView RootShowDate;
    private TextView data0;
    private TextView data1;
    private TextView data2;
    private TextView data3;
    private TextView data4;
    private TextView data5;
    private TextView data6;
    private TextView data7;
    private TextView data8;
    private TextView data9;
    private TextView data10;
    private Button RootBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_root);
        BuildControl();
        setOnClickListener();
        ShowDate();
        ShowData();
    }
    private void BuildControl() {
        RootShowDate = (TextView) findViewById(R.id.RootShowDate);
        data0 = (TextView) findViewById(R.id.data0);
        data1 = (TextView) findViewById(R.id.data1);
        data2 = (TextView) findViewById(R.id.data2);
        data3 = (TextView) findViewById(R.id.data3);
        data4 = (TextView) findViewById(R.id.data4);
        data5 = (TextView) findViewById(R.id.data5);
        data6 = (TextView) findViewById(R.id.data6);
        data7 = (TextView) findViewById(R.id.data7);
        data8 = (TextView) findViewById(R.id.data8);
        data9 = (TextView) findViewById(R.id.data9);
        data10 = (TextView) findViewById(R.id.data10);
        RootBack = (Button) findViewById(R.id.RootBack);
    }
    private void setOnClickListener() {
        RootBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ButtonClicked(v);
            }
        });
    }
    private void ShowData() {
        data0.setText("用户名:" + Manager.users[0].UserName + "  " + "手机号码:" + Manager.users[0].PhoneNumber + "   " + "电子邮箱" + Manager.users[0].EmailAddress + "    " + "密码:" + Manager.users[0].PassWord);
        data1.setText("用户名:" + Manager.users[1].UserName + "  " + "手机号码:" + Manager.users[1].PhoneNumber + "   " + "电子邮箱" + Manager.users[1].EmailAddress + "    " + "密码:" + Manager.users[1].PassWord);
        data2.setText("用户名:" + Manager.users[2].UserName + "  " + "手机号码:" + Manager.users[2].PhoneNumber + "   " + "电子邮箱" + Manager.users[2].EmailAddress + "    " + "密码:" + Manager.users[2].PassWord);
        data3.setText("用户名:" + Manager.users[3].UserName + "  " + "手机号码:" + Manager.users[3].PhoneNumber + "   " + "电子邮箱" + Manager.users[3].EmailAddress + "    " + "密码:" + Manager.users[3].PassWord);
        data4.setText("用户名:" + Manager.users[4].UserName + "  " + "手机号码:" + Manager.users[4].PhoneNumber + "   " + "电子邮箱" + Manager.users[4].EmailAddress + "    " + "密码:" + Manager.users[4].PassWord);
        data5.setText("用户名:" + Manager.users[5].UserName + "  " + "手机号码:" + Manager.users[5].PhoneNumber + "   " + "电子邮箱" + Manager.users[5].EmailAddress + "    " + "密码:" + Manager.users[5].PassWord);
        data6.setText("用户名:" + Manager.users[6].UserName + "  " + "手机号码:" + Manager.users[6].PhoneNumber + "   " + "电子邮箱" + Manager.users[6].EmailAddress + "    " + "密码:" + Manager.users[6].PassWord);
        data7.setText("用户名:" + Manager.users[7].UserName + "  " + "手机号码:" + Manager.users[7].PhoneNumber + "   " + "电子邮箱" + Manager.users[7].EmailAddress + "    " + "密码:" + Manager.users[7].PassWord);
        data8.setText("用户名:" + Manager.users[8].UserName + "  " + "手机号码:" + Manager.users[8].PhoneNumber + "   " + "电子邮箱" + Manager.users[8].EmailAddress + "    " + "密码:" + Manager.users[8].PassWord);
        data9.setText("用户名:" + Manager.users[9].UserName + "  " + "手机号码:" + Manager.users[9].PhoneNumber + "   " + "电子邮箱" + Manager.users[9].EmailAddress + "    " + "密码:" + Manager.users[9].PassWord);
        data10.setText("用户名:" + Manager.users[10].UserName + "  " + "手机号码:" + Manager.users[10].PhoneNumber + "   " + "电子邮箱" + Manager.users[10].EmailAddress + "    " + "密码:" + Manager.users[10].PassWord);
    }
    private void ButtonClicked(View v) {
        finish();
    }
    private void ShowDate() {
        RootShowDate.setText("登录时间:" + Manager.getData());
    }
}
