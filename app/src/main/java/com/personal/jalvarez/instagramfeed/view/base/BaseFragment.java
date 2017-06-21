package com.personal.jalvarez.instagramfeed.view.base;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.view.View;

import com.personal.jalvarez.instagramfeed.di.component.ActivityComponent;

import butterknife.Unbinder;

/**
 * Created by jalvarez on 20/06/2017.
 */

public abstract class BaseFragment extends Fragment implements MvpView {

    private BaseActivity activity;
    private Unbinder unbinder;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(false);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof BaseActivity) {
            BaseActivity activity = (BaseActivity) context;
            this.activity = activity;
            activity.onFragmentAttached();
        }
    }

    @Override
    public void showLoading() {
        if (activity != null) {
            activity.showLoading();
        }
    }

    @Override
    public void hideLoading() {
        if (activity != null) {
            activity.hideLoading();
        }
    }

    @Override
    public void onError(String msg) {
        if (activity != null)
            activity.onError(msg);
    }

    @Override
    public void onError(@StringRes int resId) {
        if (activity != null)
            activity.onError(getString(resId));
    }

    @Override
    public boolean isNetworkConnected() {
        return activity != null && activity.isNetworkConnected();
    }

    @Override
    public void onDetach() {
        activity = null;
        super.onDetach();
    }

    @Override
    public void hideKeyboard() {
        if (activity != null)
            activity.hideKeyboard();
    }

    @Override
    public void openActivityOnTokenExpire() {
        if (activity != null)
            activity.openActivityOnTokenExpire();
    }

    public ActivityComponent getActivityComponent() {
        return activity.getActivityComponent();
    }

    public BaseActivity getBaseActivity() {
        return activity;
    }

    private void setUnbinder(Unbinder unbinder) {
        this.unbinder = unbinder;
    }

    protected abstract void setUp(View view);

    @Override
    public void onDestroy() {
        if (this.unbinder != null)
            this.unbinder.unbind();
        super.onDestroy();
    }

    public interface Callback {
        void onFragmentAttached();
        void onFragmentDetached(String tag);
    }
}
