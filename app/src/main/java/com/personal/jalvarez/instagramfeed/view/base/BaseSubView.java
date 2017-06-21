package com.personal.jalvarez.instagramfeed.view.base;

import android.annotation.TargetApi;
import android.content.Context;
import android.support.annotation.StringRes;
import android.util.AttributeSet;
import android.view.ViewGroup;

/**
 * Created by jalvarez on 20/06/2017.
 */

public abstract class BaseSubView extends ViewGroup implements SubMvpView {

    private MvpView mParentMvpView;

    public BaseSubView(Context context) {
        super(context);
    }

    public BaseSubView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BaseSubView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(21)
    public BaseSubView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public void attachParentMvpView(MvpView mvpView) {
        mParentMvpView = mvpView;
    }

    @Override
    public void showLoading() {
        if (mParentMvpView != null)
            mParentMvpView.showLoading();
    }

    @Override
    public void hideLoading() {
        if (mParentMvpView != null)
            mParentMvpView.hideLoading();
    }

    @Override
    public void onError(@StringRes int resId) {
        if (mParentMvpView != null)
            mParentMvpView.onError(resId);
    }

    @Override
    public void onError(String msg) {
        if (mParentMvpView != null)
            mParentMvpView.onError(msg);
    }

    @Override
    public void hideKeyboard() {
        if (mParentMvpView != null)
            mParentMvpView.hideKeyboard();
    }

    @Override
    public boolean isNetworkConnected() {
        return mParentMvpView != null && mParentMvpView.isNetworkConnected();
    }

    @Override
    public void openActivityOnTokenExpire() {
        if (mParentMvpView != null)
            mParentMvpView.openActivityOnTokenExpire();
    }

    protected abstract void bindViewsAndSetOnClickListeners();

    protected abstract void setUp();
}
