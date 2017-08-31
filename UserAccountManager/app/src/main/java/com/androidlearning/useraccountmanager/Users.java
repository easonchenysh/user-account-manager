package com.androidlearning.useraccountmanager;

public class Users {
    String UserName = "";
    String PhoneNumber = "";
    String EmailAddress = "";
    String PassWord = "";
    public boolean CheckOccu() {
        boolean Occu;
        Occu = UserName == "";
        if (PhoneNumber == "") {
            Occu = false;
        }
        if (EmailAddress == "") {
            Occu = false;
        }
        if (PassWord == "") {
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
        if (UserName == UN) {
            correct = true;
        }
        else {
            correct = false;
        }
        if (PhoneNumber != PN) {
            correct = false;
        }
        if (EmailAddress != EA) {
            correct = false;
        }
        if (correct == true) {
            PassWord = PW;
        }
        return correct;
    }
    public boolean LogIn(String type,String data,String Password) {
        boolean right = false;
        if (type == "UN") {
            if (data == UserName) {
                right = true;
            }
            else {
                right = false;
            }
        }
        if (type == "PN") {
            if (data != PhoneNumber) {
                right = false;
            }
        }
        if (type == "EA") {
            if (data != UserName) {
               right = false;
            }
        }
        if (Password != PassWord) {
           right = false;
        }
        return right;
    }
    public boolean isthis(String type,String data) {
        boolean temp = false;
        switch (type) {
            case "UN":{
                if (data == UserName) {
                    temp = true;
                }
                else {
                    temp = false;
                }
                break;
            }
            case "PN":{
                if (data == PhoneNumber) {
                    temp = true;
                }
                else {
                    temp = false;
                }
                break;
            }
            case "EA":{
                if (data == EmailAddress) {
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
