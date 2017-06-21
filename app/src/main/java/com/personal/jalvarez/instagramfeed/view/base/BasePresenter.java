package com.personal.jalvarez.instagramfeed.view.base;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.personal.jalvarez.instagramfeed.R;
import com.personal.jalvarez.instagramfeed.data.DataManager;
import com.personal.jalvarez.instagramfeed.data.remote.model.ApiError;
import com.personal.jalvarez.instagramfeed.utils.AppConstants;

import javax.inject.Inject;

/**
 * Created by jalvarez on 20/06/2017.
 */

public class BasePresenter<V extends MvpView> implements MvpPresenter<V> {

    private final DataManager dataManager;
    private V mvpView;


    @Inject
    public BasePresenter(DataManager dataManager) {
        this.dataManager = dataManager;
    }


    @Override
    public void onAttach(V mvpView) {
        this.mvpView = mvpView;
    }

    @Override
    public void onDetach() {
        mvpView = null;
    }

    public boolean isViewAttached() {
        return mvpView != null;
    }

    public V getMvpView() {
        return mvpView;
    }

    public void checkViewAttached() {
        if (!isViewAttached()) throw new MvpViewNotAttachedException();
    }

    public DataManager getDataManager() {
        return dataManager;
    }

    @Override
    public void handleApiError(ApiError apiError) {
        final GsonBuilder builder = new GsonBuilder().excludeFieldsWithoutExposeAnnotation();
        final Gson gson = builder.create();

        try {
            if (apiError == null || apiError.getMessage() == null) {
                getMvpView().onError(R.string.api_default_error);
                return;
            }
            switch (apiError.getErrorCode()) {
                case AppConstants.API_STATUS_CODE_BAD_REQUEST:
                    setUserAsLoggedOut();
                    getMvpView().openActivityOnTokenExpire();
                case AppConstants.API_STATUS_CODE_INTERNAL_SERVER_ERROR:
                case AppConstants.API_STATUS_CODE_NOT_FOUND:
                default:
                    getMvpView().onError(apiError.getMessage());
            }
        } catch (JsonSyntaxException | NullPointerException e) {
            e.printStackTrace();
            getMvpView().onError(R.string.api_default_error);
        }
    }

    @Override
    public void setUserAsLoggedOut() {
        getDataManager().setAccessToken(null);
    }

    public static class MvpViewNotAttachedException extends RuntimeException {
        public MvpViewNotAttachedException() {
            super("Porfavor llame a Presenter.onAttach(MvpView) antes de solicitar data a el presentador");
        }
    }
}
