package com.personal.jalvarez.instagramfeed;

import android.app.Application;
import android.content.Context;

import com.personal.jalvarez.instagramfeed.data.DataManager;
import com.personal.jalvarez.instagramfeed.di.component.ApplicationComponent;
import com.personal.jalvarez.instagramfeed.di.component.DaggerApplicationComponent;
import com.personal.jalvarez.instagramfeed.di.module.ApplicationModule;

import javax.inject.Inject;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by jalvarez on 20/06/2017.
 */

public class MvpApp extends Application {

    @Inject
    DataManager dataManager;

    @Inject
    CalligraphyConfig calligraphyConfig;

    private ApplicationComponent applicationComponent;

    public static MvpApp get(Context context) {
        return (MvpApp) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();

        applicationComponent = DaggerApplicationComponent.builder().applicationModule(new ApplicationModule(this)).build();

        applicationComponent.inject(this);

        CalligraphyConfig.initDefault(calligraphyConfig);
    }

    public ApplicationComponent getComponent() {
        return applicationComponent;
    }
}
