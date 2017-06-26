package android.lavtaxi;

import android.app.Application;
import android.content.Context;

public class LavApplication extends Application {
    static LavApplication context;
    public void onCreate(){
        super.onCreate();
        context = this;
    }

    public static Context getMyApplicationContext(){
        return context.getApplicationContext();
    }

    public static void removeUserAndLogout() {

    }
}