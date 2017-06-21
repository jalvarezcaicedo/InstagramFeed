package com.personal.jalvarez.instagramfeed.data.remote;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.personal.jalvarez.instagramfeed.data.local.db.DbHelper;
import com.personal.jalvarez.instagramfeed.data.local.PreferenceHelper;

import javax.inject.Inject;

/**
 * Created by jalvarez on 20/06/2017.
 */

public class ApiHeader {

    @Expose
    @SerializedName("api_key")
    private String mApiKey;

    @Expose
    @SerializedName("user_id")
    private Long mUserId;

    @Expose
    @SerializedName("access_token")
    private String mAccessToken;

    @Inject

    public ApiHeader(String mApiKey, DbHelper dbHelper, PreferenceHelper preferenceHelper) {
        this.mApiKey = mApiKey;
        this.mAccessToken = preferenceHelper.getAccessToken();
    }

    public String getmApiKey() {
        return mApiKey;
    }

    public void setmApiKey(String mApiKey) {
        this.mApiKey = mApiKey;
    }

    public Long getmUserId() {
        return mUserId;
    }

    public void setmUserId(Long mUserId) {
        this.mUserId = mUserId;
    }

    public String getmAccessToken() {
        return mAccessToken;
    }

    public void setmAccessToken(String mAccessToken) {
        this.mAccessToken = mAccessToken;
    }
}
