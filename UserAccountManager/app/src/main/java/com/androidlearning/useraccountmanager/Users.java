package com.androidlearning.useraccountmanager;

public class Users {
    String UserName = "";
    String PhoneNumber = "";
    String EmailAddress = "";
    String PassWord = "";
    public boolean CheckOccu() {
        boolean Occu;
        Occu = UserName.equals("");
        if (PhoneNumber.equals("")) {
            Occu = false;
        }
        if (EmailAddress.equals("")) {
            Occu = false;
        }
        if (PassWord.equals("")) {
            Occu = false;
        }
        return Occu;
    }
    public void setData (String UN,String PN,String EA,String PW) {
        UserName = UN;
        PhoneNumber = PN;
        EmailAddress = EA;
        PassWord = PW;
    }
    public boolean ResetPassWord (String UN,String PN,String EA,String PW) {
        boolean correct;
        if (UserName.equals(UN)) {
            correct = true;
        }
        else {
            correct = false;
        }
        if (!PhoneNumber.equals(PN)) {
            correct = false;
        }
        if (!EmailAddress.equals(EA)) {
            correct = false;
        }
        if (correct) {
            PassWord = PW;
        }
        return correct;
    }
    public boolean LogIn(String type,String data,String Password) {
        boolean right = false;
        if (type.equals("UN") && data.equals(UserName)) {
            right = true;
        }
        if (type.equals("PN") && data.equals(PhoneNumber)) {
            right = true;
        }
        if (type.equals("EA") && data.equals(EmailAddress)) {
            right = true;
        }
        if (right && Password.equals(PassWord)) {
           right = true;
        } else {
            right = false;
        }
        return right;
    }
    public boolean isthis(String type,String data) {
        boolean temp = false;
        switch (type) {
            case "UN":{
                if (data.equals(UserName)) {
                    temp = true;
                }
                else {
                    temp = false;
                }
                break;
            }
            case "PN":{
                if (data.equals(PhoneNumber)) {
                    temp = true;
                }
                else {
                    temp = false;
                }
                break;
            }
            case "EA":{
                if (data.equals(EmailAddress)) {
                    temp = true;
                }
                else {
                    temp = false;
                }
                break;
            }
        }
        return temp;
    }
}
