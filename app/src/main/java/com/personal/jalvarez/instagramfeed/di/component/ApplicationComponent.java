package com.personal.jalvarez.instagramfeed.di.component;

import android.app.Application;
import android.content.Context;

import com.personal.jalvarez.instagramfeed.MvpApp;
import com.personal.jalvarez.instagramfeed.data.DataManager;
import com.personal.jalvarez.instagramfeed.di.module.ApplicationContext;
import com.personal.jalvarez.instagramfeed.di.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by jalvarez on 20/06/2017.
 */
@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(MvpApp app);

    @ApplicationContext
    Context context();

    Application application();

    DataManager getDataManager();
}
