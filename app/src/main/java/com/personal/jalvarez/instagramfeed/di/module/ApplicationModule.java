package com.personal.jalvarez.instagramfeed.di.module;

import android.app.Application;
import android.content.Context;

import com.personal.jalvarez.instagramfeed.BuildConfig;
import com.personal.jalvarez.instagramfeed.R;
import com.personal.jalvarez.instagramfeed.data.AppDataManager;
import com.personal.jalvarez.instagramfeed.data.DataManager;
import com.personal.jalvarez.instagramfeed.data.local.AppPreferencesHelper;
import com.personal.jalvarez.instagramfeed.data.local.PreferenceHelper;
import com.personal.jalvarez.instagramfeed.data.local.db.AppDbHelper;
import com.personal.jalvarez.instagramfeed.data.local.db.DbHelper;
import com.personal.jalvarez.instagramfeed.data.local.db.DbOpenHelper;
import com.personal.jalvarez.instagramfeed.data.remote.ApiHeader;
import com.personal.jalvarez.instagramfeed.data.remote.ApiHelper;
import com.personal.jalvarez.instagramfeed.data.remote.AppApiHelper;
import com.personal.jalvarez.instagramfeed.di.ApiInfo;
import com.personal.jalvarez.instagramfeed.di.DatabaseInfo;
import com.personal.jalvarez.instagramfeed.di.PreferenceInfo;
import com.personal.jalvarez.instagramfeed.utils.AppConstants;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by jalvarez on 20/06/2017.
 */
@Module
public class ApplicationModule {
    private final Application application;

    public ApplicationModule(Application application) {
        this.application = application;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return application;
    }

    @Provides
    Application provideApplication() {
        return application;
    }

    @Provides
    @DatabaseInfo
    String provideDatabaseName() {
        return AppConstants.DB_NAME;
    }

    @Provides
    @ApiInfo
    String provideApiKey() {
        return BuildConfig.API_KEY;
    }

    @Provides
    @PreferenceInfo
    String providePreferenceName() {
        return AppConstants.PREF_NAME;
    }


    @Provides
    @Singleton
    DataManager provideDataManager(DbHelper dbHelper, PreferenceHelper preferenceHelper, ApiHelper apiHelper) {
        return new AppDataManager(dbHelper, preferenceHelper, apiHelper);
    }

    @Provides
    @Singleton
    DbHelper provideDbHelper(DbOpenHelper dbOpenHelper) {
        return new AppDbHelper(dbOpenHelper);
    }

    @Provides
    @Singleton
    DbOpenHelper provideDbOpenHelper(@ApplicationContext Context context, @DatabaseInfo String name) {
        return new DbOpenHelper(context, name);
    }

    @Provides
    @Singleton
    PreferenceHelper providePreferencesHelper(@ApplicationContext Context context, @PreferenceInfo String prefFileName) {
        return new AppPreferencesHelper(context, prefFileName);
    }

    @Provides
    @Singleton
    ApiHelper provideApiHelper(ApiHeader apiHeader) {
        return new AppApiHelper(apiHeader);
    }

    @Provides
    @Singleton
    ApiHeader provideApiHeader(@ApiInfo String apiKey, DbHelper dbHelper, PreferenceHelper preferenceHelper) {
        return new ApiHeader(apiKey, dbHelper, preferenceHelper);
    }

    @Provides
    @Singleton
    CalligraphyConfig provideCalligraphyDefaultConfig() {
        return new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/source-sans-pro/SourceSansPro.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build();
    }
}
