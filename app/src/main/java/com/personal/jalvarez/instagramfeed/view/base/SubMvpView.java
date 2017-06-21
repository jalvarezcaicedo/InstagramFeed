package com.personal.jalvarez.instagramfeed.view.base;

/**
 * Created by jalvarez on 20/06/2017.
 */

public interface SubMvpView extends MvpView {

    void onCreate();

    void onStart();

    void onResume();

    void onPause();

    void onStop();

    void onDestroy();

    void attachParentMvpView(MvpView mvpView);

}
