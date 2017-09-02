package com.androidlearning.useraccountmanager;
import java.text.SimpleDateFormat;
import java.util.Date;
//由于SimpleDateFormat对应Android库的api版本是26，这个程序的api是14，所以import了相应的Java库进行代替
public class Manager {
    public static Users users[] = new Users[11];
    public static boolean isInitialization = false;
    public static String regUN = "[a-zA-Z0-9_-]*";
    public static String regPN = "0?(13|14|15|18)[0-9]{9}";
    public static String regEA = "[\\w!#$%&'*+/=?^_`{|}~-]+(?:\\.[\\w!#$%&'*+/=?^_`{|}~-]+)*@(?:[\\w](?:[\\w-]*[\\w])?\\.)+[\\w](?:[\\w-]*[\\w])?";
    public static String regPW = "[a-zA-Z0-9_-]{7,11}";
    public static String getData() {
        SimpleDateFormat dataFormat = new SimpleDateFormat("yyyy-MM-dd   HH:mm:ss");
        return dataFormat.format(new Date());
    }
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
