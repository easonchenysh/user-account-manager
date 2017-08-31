package com.androidlearning.useraccountmanager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class Register extends AppCompatActivity {
    private EditText RegisterUserName;
    private EditText RegisterPhoneNumber;
    private EditText RegisterEmailAddress;
    private EditText RegisterPassWord;
    private Button Register;
    private Button RegisterBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        BuildControl();
        setOnClickListener();
    }
    private void BuildControl() {
        RegisterUserName = (EditText) findViewById(R.id.RegisterUserName);
        RegisterPhoneNumber = (EditText) findViewById(R.id.RegisterPhoneNumber);
        RegisterEmailAddress = (EditText) findViewById(R.id.RegisterEmailAddress);
        RegisterPassWord = (EditText) findViewById(R.id.RegisterPassWord);
        Register = (Button) findViewById(R.id.Register);
        RegisterBack = (Button) findViewById(R.id.RegisterBack);
    }
    private void setOnClickListener() {
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ButtonClicked(v);
            }
        };
        Register.setOnClickListener(listener);
        RegisterBack.setOnClickListener(listener);
    }
    private void ButtonClicked(View v) {
        switch (v.getId()) {
            case R.id.Register:{
                Register();
                break;
            }
            case R.id.RegisterBack:{
                finish();
                break;
            }
        }
    }
    private void Register() {
        String UserName = RegisterUserName.getText().toString();
        String PhoneNumber = RegisterPhoneNumber.getText().toString();
        String EmailAddress = RegisterEmailAddress.getText().toString();
        String PassWord = RegisterPassWord.getText().toString();
        String regUN = "^[a-zA-Z0-9_-]*$";
        String regPN = "^1[3|4|5|7|8][0-9]{9}$";
        String regEA = "^[a-zA-Z_]{1,}[0-9]{0,}@(([a-zA-z0-9]-*){1,}\\.){1,3}[a-zA-z\\-]{1,}$";
        String regPW = "^[a-zA-Z0-9_-]{7,11}$";
        boolean ok;
        int UserNumber;
        if (UserName.equals("")) {
            Toast.makeText(this, "用户名不能为空", Toast.LENGTH_SHORT).show();
            ok = false;
        }
        else {
            ok = true;
        }
        if (!Pattern.matches(regUN,UserName)) {
            ok = false;
            Toast.makeText(this, "用户名中存在非法字符", Toast.LENGTH_SHORT).show();
        }
        if (!Pattern.matches(regPN,PhoneNumber)) {
            ok = false;
            Toast.makeText(this, "手机号码格式错误", Toast.LENGTH_SHORT).show();
        }
        if (!Pattern.matches(regEA,EmailAddress)) {
            ok = false;
            Toast.makeText(this, "邮箱格式错误", Toast.LENGTH_SHORT).show();
        }
        if (!Pattern.matches(regPW,PassWord)) {
            ok = false;
            Toast.makeText(this, "密码格式错误", Toast.LENGTH_SHORT).show();
        }
        for (UserNumber = 0;UserNumber <= 10;UserNumber ++) { //防止重复注册机制
            if (Manager.users[UserNumber].UserName.equals(UserName)) {
                Toast.makeText(this, "用户名已注册", Toast.LENGTH_SHORT).show();
                ok = false;
            }
            if (Manager.users[UserNumber].PhoneNumber.equals(PhoneNumber)) {
                Toast.makeText(this, "手机号码已注册", Toast.LENGTH_SHORT).show();
                ok = false;
            }
            if (Manager.users[UserNumber].EmailAddress.equals(EmailAddress)) {
                Toast.makeText(this, "邮箱已注册", Toast.LENGTH_SHORT).show();
                ok = false;
            }
            if (!Manager.users[UserNumber].CheckOccu()) {
                break;
            }
        }
        if (!ok) {
            return;
        }
        UserNumber ++;
        if (UserNumber == 11) {
            Toast.makeText(this, "用户已满", Toast.LENGTH_SHORT).show();
            return;
        }
        Manager.users[UserNumber].setData(UserName,PhoneNumber,EmailAddress,PassWord);
        Toast.makeText(this, "注册成功", Toast.LENGTH_SHORT).show();
        finish();
    }
}
