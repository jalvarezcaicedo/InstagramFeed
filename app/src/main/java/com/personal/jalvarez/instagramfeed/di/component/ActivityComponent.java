package com.personal.jalvarez.instagramfeed.di.component;

import com.personal.jalvarez.instagramfeed.di.PerActivity;
import com.personal.jalvarez.instagramfeed.di.module.ActivityModule;

import dagger.Component;

/**
 * Created by jalvarez on 20/06/2017.
 */

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    /*void inject(MainActivity activity);

    void inject(LoginActivity activity);

    void inject(SplashActivity activity);

    void inject(SettingFragment fragment);*/

}
