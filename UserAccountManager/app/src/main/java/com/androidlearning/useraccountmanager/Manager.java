package com.androidlearning.useraccountmanager;

public class Manager {
    public static Users users[] = new Users[11];
    public static boolean isInitialization = false;
    public static String regUN = "^[a-zA-Z0-9_-]*$";
    public static String regPN = "^1[3|4|5|7|8][0-9]{9}$";
    public static String regEA = "^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";
    public static String regPW = "^[a-zA-Z0-9_-]{7,11}$";
    public static void Initialzation() {
        if (!isInitialization) {
            for (int i = 0;i <= 10;i++) {
                users[i] = new Users();
                isInitialization = true;
            }
            users[0].UserName = "root";
            users[0].PhoneNumber = "18888888888";
            users[0].EmailAddress = "root@users.com";
            users[0].PassWord = "000000000000";//12个0
        }
    }
}
