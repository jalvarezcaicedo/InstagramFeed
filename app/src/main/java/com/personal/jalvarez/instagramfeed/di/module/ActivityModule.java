package com.personal.jalvarez.instagramfeed.di.module;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;

import com.personal.jalvarez.instagramfeed.di.ActivityContext;
import com.personal.jalvarez.instagramfeed.di.PerActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by jalvarez on 20/06/2017.
 */

@Module
public class ActivityModule {
    private Activity activity;

    public ActivityModule(Activity activity) {
        this.activity = activity;
    }

    @Provides
    @ActivityContext
    Context provideContext() {
        return activity;
    }

    @Provides
    Activity provideActivity() {
        return activity;
    }

    @Provides
    @PerActivity
    LayoutInflater provideLayoutInflater() {
        return LayoutInflater.from(activity);
    }

    @Provides
    LinearLayoutManager provideLayoutManager() {
        return new LinearLayoutManager(activity);
    }

    /**
     *      * We are providing the SplashMvpPresenter by constructing it, because we want the Dependency
     *      * graph to provide the interfaces for these classes for loose binding to its implementation.
     *

    @Provides
    @PerActivity
    SplashMvpPresenter<SplashMvpView> provideSplashPresenter(DataManager dataManager) {
        return new SplashPresenter<>(dataManager);
    }

    @Provides
    @PerActivity
    SettingMvpPresenter<SettingMvpView> provideSettingPresenter(DataManager dataManager) {
        return new SettingPresenter<>(dataManager);
    }

    @Provides
    @PerActivity
    LoginMvpPresenter<LoginMvpView> provideLoginPresenter(DataManager dataManager) {
        return new LoginPresenter<>(dataManager);
    }

    @Provides
    @PerActivity
    MainMvpPresenter<MainMvpView> provideMainPresenter(DataManager dataManager) {
        return new MainPresenter<>(dataManager);
    }*/
}
