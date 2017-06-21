package com.personal.jalvarez.instagramfeed.data.local.db;

import com.personal.jalvarez.instagramfeed.data.local.db.model.DaoMaster;
import com.personal.jalvarez.instagramfeed.data.local.db.model.DaoSession;
import com.personal.jalvarez.instagramfeed.data.local.db.model.User;

import java.util.List;
import java.util.concurrent.Callable;

import io.reactivex.Observable;

/**
 * Created by jalvarez on 20/06/2017.
 */

public class AppDbHelper implements DbHelper{

    private final DaoSession daoSession;

    public AppDbHelper(DbOpenHelper dbOpenHelper) {
        this.daoSession = new DaoMaster(dbOpenHelper.getWritableDb()).newSession();
    }

    /*@Override
    public Observable<Long> insertUser(final User user) {
        return Observable.fromCallable(new Callable<Long>() {
            @Override
            public Long call() throws Exception {
                return daoSession.getUserDao.insert(user);
            }
        });
    }

    @Override
    public Observable<List<User>> getAllUser() {
        return Observable.fromCallable(new Callable<List<User>>() {
            @Override
            public List<User> call() throws Exception {
                return daoSession.getUserDao().loadAll();
            }
        });
    }*/
}
