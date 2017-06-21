package com.personal.jalvarez.instagramfeed.view.base;

import com.personal.jalvarez.instagramfeed.data.remote.model.ApiError;

/**
 * Created by jalvarez on 20/06/2017.
 */

public interface MvpPresenter<V extends MvpView> {

    void onAttach(V mvpView);

    void onDetach();

    void handleApiError(ApiError apiError);

    void setUserAsLoggedOut();

}
