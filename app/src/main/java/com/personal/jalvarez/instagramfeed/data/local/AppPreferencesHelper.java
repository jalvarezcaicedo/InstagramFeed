package com.personal.jalvarez.instagramfeed.data.local;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by jalvarez on 20/06/2017.
 */

public class AppPreferencesHelper implements PreferenceHelper {

    private static final String PREF_KEY_ACCESS_TOKEN = "PREF_KEY_ACCESS_TOKEN";
    private final SharedPreferences preferences;

    public AppPreferencesHelper(Context context, String prefFileName) {
        preferences = context.getSharedPreferences(prefFileName, Context.MODE_PRIVATE);
    }

    @Override
    public String getAccessToken() {
        return preferences.getString(PREF_KEY_ACCESS_TOKEN, null);
    }

    @Override
    public void setAccessToken(String accessToken) {
        preferences.edit().putString(PREF_KEY_ACCESS_TOKEN, accessToken).apply();
    }
}
