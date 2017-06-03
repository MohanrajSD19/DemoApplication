package com.intertech;

/**
 * Created by Mohanraj.S,innobot-linux-4 on 3/6/17.
 */

public class Singleton {
    private static Singleton mInstance = null;

    private String mString;
    private String dashboardVal;

    private Singleton(){
        mString = "Hello";
    }

    public static Singleton getInstance(){
        if(mInstance == null)
        {
            mInstance = new Singleton();
        }
        return mInstance;
    }

    public String getString(){
        return this.mString;
    }

    public void setString(String value){
        mString = value;
    }

    public String getDashboardVal() {
        return dashboardVal;
    }

    public void setDashboardVal(String dashboardVal) {
        this.dashboardVal = dashboardVal;
    }
}
