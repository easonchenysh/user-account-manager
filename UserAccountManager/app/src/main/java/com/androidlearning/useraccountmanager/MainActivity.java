package com.androidlearning.useraccountmanager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    private EditText LogInUserName;
    private EditText LogInPassWord;
    private Button GoToRegister;
    private Button LogIn;
    private Button GoToResetPassWord;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Manager.Initialzation();
        BuildControl();
        setOnClickListener();
    }
    private void BuildControl() {
        LogInUserName = (EditText) findViewById(R.id.LogInUserName);
        LogInPassWord = (EditText) findViewById(R.id.LogInPassWord);
        GoToRegister = (Button) findViewById(R.id.GoToRegister);
        LogIn = (Button) findViewById(R.id.LogIn);
        GoToResetPassWord = (Button) findViewById(R.id.GoToResetPassWord);
    }
    private void setOnClickListener() {
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ButtonClicked(v);
            }
        };
        GoToRegister.setOnClickListener(listener);
        LogIn.setOnClickListener(listener);
        GoToResetPassWord.setOnClickListener(listener);
    }
    private void ButtonClicked(View v) {
        switch (v.getId()) {
            case R.id.GoToRegister:{
                Intent intent = new Intent(MainActivity.this,Register.class);
                startActivity(intent);
                break;
            }
            case R.id.LogIn:{
                LogIn();
                break;
            }
            case R.id.GoToResetPassWord:{
                Intent intent = new Intent(MainActivity.this,ResetPassWord.class);
                startActivity(intent);
                break;
            }
        }
    }
    private void LogIn() {
        int i;
        String UserName = LogInUserName.getText().toString();
        String PassWord = LogInPassWord.getText().toString();
        String Type;
        boolean ok = true;
        if (UserName.equals("")) {
            Toast.makeText(this, "用户名不能为空", Toast.LENGTH_SHORT).show();
            ok = false;
        }
        if (PassWord.equals("")) {
            Toast.makeText(this, "密码不能为空", Toast.LENGTH_SHORT).show();
            ok = false;
        }
        if (!ok) {
            return;
        }
        if (Pattern.matches(Manager.regPN, UserName)) {
            Type = "PN";
        }
        else if (Pattern.matches(Manager.regEA, UserName)) {
            Type = "EA";
        }
        else {
            Type = "UN";
//            UN不是UnKnow,而是UserName
        }
        for (i = 0;i <= 10;i++) {
            if (Manager.users[i].isthis(Type,UserName)) {
                break;
            }
        }
        if (i == 11) {
            Toast.makeText(this, "用户不存在", Toast.LENGTH_SHORT).show();
            return;
        }
        if (Manager.users[i].LogIn(Type,UserName,PassWord)) {
            if (i == 0) {
                Intent intent = new Intent(MainActivity.this,Root.class);
                startActivity(intent);
            }
            else {
                Intent intent = new Intent(MainActivity.this,Show.class);
                startActivity(intent);
            }
        }
        else {
            Toast.makeText(this, "用户名或密码错误", Toast.LENGTH_SHORT).show();
        }
    }
}
