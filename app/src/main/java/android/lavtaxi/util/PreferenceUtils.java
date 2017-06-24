package android.lavtaxi.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;


public class PreferenceUtils {

    public static Object readStringPreference(Context context, String key, Object defaultValue) {
        SharedPreferences sharedPreferences = getSharedPreferences(context);
        if(defaultValue instanceof String){
            return sharedPreferences.getString(key, (String)defaultValue);
        }
        else if(defaultValue instanceof Boolean){
            return sharedPreferences.getBoolean(key, (Boolean) defaultValue);
        }
        else if (defaultValue instanceof Integer) {
            return sharedPreferences.getInt(key, (Integer)defaultValue);
        }
        return null;
    }

    public static void writePreference(Context context, String key, Object value) {
        SharedPreferences sharedPreferences = getSharedPreferences(context);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        if(value instanceof Boolean){
            editor.putBoolean(key,(Boolean)value);
        }
        else if(value instanceof String){
            editor.putString(key, (String)value);
        }
        else if (value instanceof Integer) {
            editor.putInt(key, (Integer) value);
        }
        editor.apply();
    }

    public static void removeFromPreference(Context context, String key) {
        SharedPreferences sharedPreferences = getSharedPreferences(context);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove(key);
        editor.apply();
    }

    private static SharedPreferences getSharedPreferences(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context);
    }

}
