package com.personal.jalvarez.instagramfeed.di.component;

import com.personal.jalvarez.instagramfeed.di.PerService;
import com.personal.jalvarez.instagramfeed.di.module.ServiceModule;

import dagger.Component;

/**
 * Created by jalvarez on 20/06/2017.
 */

@PerService
@Component(dependencies = ApplicationComponent.class, modules = ServiceModule.class)
public interface ServiceComponent {
}
