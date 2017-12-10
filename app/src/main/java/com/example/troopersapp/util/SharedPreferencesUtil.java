package com.example.troopersapp.util;

import android.content.SharedPreferences;

/**
 * Created by lslopes on 18/11/2017.
 */

public class SharedPreferencesUtil {
    private SharedPreferences sharedPreferences;

    public SharedPreferencesUtil(SharedPreferences preferences) {
        this.sharedPreferences = preferences;
    }

    public String get (String key) {
        return sharedPreferences.getString(key, "");
    }

    public boolean hasValue(String key) {
        return sharedPreferences.contains(key);
    }

    public void save(String key, String value) {
        SharedPreferences.Editor editor = sharedPreferences.edit();

    }
}
