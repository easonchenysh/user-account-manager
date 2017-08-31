package com.androidlearning.useraccountmanager;

public class Manager {
    public static Users users[] = new Users[11];
    public static boolean isInitialization = false;
    public static void Initialzation() {
        if (isInitialization == false) {
            for (int i = 0;i <= 10;i++) {
                users[i] = new Users();
                isInitialization = true;
            }
        }
    }
}
