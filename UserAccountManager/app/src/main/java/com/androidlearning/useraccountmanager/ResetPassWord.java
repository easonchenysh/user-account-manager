package com.androidlearning.useraccountmanager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.regex.Pattern;

public class ResetPassWord extends AppCompatActivity {
    private EditText ResetPassWordUserName;
    private EditText ResetPassWordPhoneNumber;
    private EditText ResetPassWordEmailAddress;
    private EditText ResetPassWordPassWord;
    private Button ResetPassWordOK;
    private Button ResetPassWordBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_pass_word);
        BuildControl();
        setOnClickListener();
    }
    private void BuildControl() {
        ResetPassWordUserName = (EditText) findViewById(R.id.ResetPassWordUserName);
        ResetPassWordPhoneNumber = (EditText) findViewById(R.id.ResetPassWordPhoneNumber);
        ResetPassWordEmailAddress = (EditText) findViewById(R.id.ResetPassWordEmailAddress);
        ResetPassWordPassWord = (EditText) findViewById(R.id.ResetPassWordPassWord);
        ResetPassWordOK = (Button) findViewById(R.id.ResetPassWordOK);
        ResetPassWordBack = (Button) findViewById(R.id.ResetPassWordBack);
    }
    private void setOnClickListener() {
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ButtonClicked(v);
            }
        };
        ResetPassWordOK.setOnClickListener(listener);
        ResetPassWordBack.setOnClickListener(listener);
    }
    private void ButtonClicked(View v) {
        switch (v.getId()) {
            case R.id.ResetPassWordOK:{
                ResetPassWord();
                break;
            }
            case R.id.ResetPassWordBack:{
                Back();
                break;
            }
        }
    }
    private void Back() {
        finish();
    }
    private void ResetPassWord() {
        String UserName = ResetPassWordUserName.getText().toString();
        String PhoneNumber = ResetPassWordPhoneNumber.getText().toString();
        String EmailAddress = ResetPassWordEmailAddress.getText().toString();
        String PassWord = ResetPassWordPassWord.getText().toString();
        int i;
        if (!Pattern.matches(Manager.regPW,PassWord)){
            Toast.makeText(this, "密码格式错误", Toast.LENGTH_SHORT).show();
            return;
        }
        for (i= 0;i <= 10;i++) {
            if (Manager.users[i].isthis("UN",UserName)) {
                break;
            }
        }
        if (!Manager.users[i].ResetPassWord(UserName,PhoneNumber,EmailAddress,PassWord)) {
            Toast.makeText(this, "验证信息错误", Toast.LENGTH_SHORT).show();
            return;
        }
        else {
            Back();
        }
    }
}
