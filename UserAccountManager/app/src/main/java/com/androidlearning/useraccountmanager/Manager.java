package com.androidlearning.useraccountmanager;

public class Manager {
    public static Users users[] = new Users[11];
    public static boolean isInitialization = false;
    public static void Initialzation() {
        if (!isInitialization) {
            for (int i = 0;i <= 10;i++) {
                users[i] = new Users();
                isInitialization = true;
            }
            users[0].UserName = "root";
            users[0].PhoneNumber = "18888888888";
            users[0].EmailAddress = "root@users.com";
            users[0].PassWord = "012345678901";
        }
    }
}
