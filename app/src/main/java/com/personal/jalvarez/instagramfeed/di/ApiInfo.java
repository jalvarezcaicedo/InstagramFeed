package com.personal.jalvarez.instagramfeed.di;

/**
 * Created by jalvarez on 20/06/2017.
 */
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;


@Qualifier
@Retention(RetentionPolicy.RUNTIME)
public @interface ApiInfo {
}
