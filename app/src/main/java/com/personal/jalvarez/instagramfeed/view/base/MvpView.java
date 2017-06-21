package com.personal.jalvarez.instagramfeed.view.base;

import android.support.annotation.StringRes;

/**
 * Created by jalvarez on 20/06/2017.
 */

public interface MvpView {
    void showLoading();

    void hideLoading();

    void openActivityOnTokenExpire();

    void onError(@StringRes int resId);

    void onError(String msg);

    boolean isNetworkConnected();

    void hideKeyboard();
}
