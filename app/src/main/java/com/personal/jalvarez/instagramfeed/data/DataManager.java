package com.personal.jalvarez.instagramfeed.data;

import com.personal.jalvarez.instagramfeed.data.local.db.DbHelper;
import com.personal.jalvarez.instagramfeed.data.local.PreferenceHelper;
import com.personal.jalvarez.instagramfeed.data.remote.ApiHelper;

/**
 * Created by jalvarez on 20/06/2017.
 */

public interface DataManager extends DbHelper, PreferenceHelper, ApiHelper{

}
