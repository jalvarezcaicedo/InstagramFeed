package com.personal.jalvarez.instagramfeed.data.remote;

/**
 * Created by jalvarez on 20/06/2017.
 */

public final class AppApiHelper implements ApiHelper {

    private ApiHeader mApiHeader;

    public AppApiHelper(ApiHeader mApiHeader) {
        this.mApiHeader = mApiHeader;
    }

    @Override
    public ApiHeader getApiHeader() {
        return mApiHeader;
    }

    @Override
    public void setApiHeader(ApiHeader apiHeader) {
        //
    }
}
