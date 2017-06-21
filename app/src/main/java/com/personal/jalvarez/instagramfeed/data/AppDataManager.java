package com.personal.jalvarez.instagramfeed.data;

import com.personal.jalvarez.instagramfeed.data.local.db.DbHelper;
import com.personal.jalvarez.instagramfeed.data.local.PreferenceHelper;
import com.personal.jalvarez.instagramfeed.data.local.db.model.User;
import com.personal.jalvarez.instagramfeed.data.remote.ApiHeader;
import com.personal.jalvarez.instagramfeed.data.remote.ApiHelper;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by jalvarez on 20/06/2017.
 */

public class AppDataManager implements DataManager {

    private final DbHelper dbHelper;
    private final PreferenceHelper preferenceHelper;
    private final ApiHelper apiHelper;

    public AppDataManager(DbHelper dbHelper, PreferenceHelper preferenceHelper, ApiHelper apiHelper) {
        this.dbHelper = dbHelper;
        this.preferenceHelper = preferenceHelper;
        this.apiHelper = apiHelper;
    }

    @Override
    public String getAccessToken() {
        return preferenceHelper.getAccessToken();
    }

    @Override
    public void setAccessToken(String accessToken) {
        preferenceHelper.setAccessToken(accessToken);
        apiHelper.getApiHeader().setmAccessToken(accessToken);
    }

    @Override
    public ApiHeader getApiHeader() {
        return apiHelper.getApiHeader();
    }

    @Override
    public void setApiHeader(ApiHeader apiHeader) {
        apiHelper.setApiHeader(apiHeader);
    }

    /*@Override
    public Observable<Long> insertUser(User user) {
        return dbHelper.insertUser(user);
    }

    @Override
    public Observable<List<User>> getAllUser() {
        return dbHelper.getAllUser();
    }*/
}
