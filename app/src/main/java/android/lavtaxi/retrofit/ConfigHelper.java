package android.lavtaxi.retrofit;

import android.content.Context;
import android.lavtaxi.R;
import android.util.Log;


import java.io.IOException;
import java.util.Properties;

public class ConfigHelper {

    static final String TAG = "ConfigHelper";
    private static Properties PROPERTIES;

    public static String getString(Context ctx, String key) {
        if (PROPERTIES == null) {
            loadProperties(ctx);
        }
        return PROPERTIES.getProperty(key);
    }

    private static void loadProperties(Context ctx) {
        PROPERTIES = new Properties();
        try {
            PROPERTIES.load(ctx.getResources().openRawResource(R.raw.application));
        } catch (IOException e) {
            Log.e(TAG, "load properties error");
        }
    }
}