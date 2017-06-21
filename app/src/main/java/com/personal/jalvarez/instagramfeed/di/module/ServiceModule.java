package com.personal.jalvarez.instagramfeed.di.module;

import android.app.Service;

import dagger.Module;

/**
 * Created by jalvarez on 20/06/2017.
 */

@Module
public class ServiceModule {
    private final Service service;

    public ServiceModule(Service service) {
        this.service = service;
    }
}
