package com.personal.jalvarez.instagramfeed.view.base;

import android.annotation.TargetApi;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import com.personal.jalvarez.instagramfeed.MvpApp;
import com.personal.jalvarez.instagramfeed.R;
import com.personal.jalvarez.instagramfeed.di.component.ActivityComponent;
import com.personal.jalvarez.instagramfeed.di.component.DaggerActivityComponent;
import com.personal.jalvarez.instagramfeed.di.module.ActivityModule;
import com.personal.jalvarez.instagramfeed.utils.CommonUtils;
import com.personal.jalvarez.instagramfeed.utils.NetworkUtils;

import butterknife.Unbinder;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

/**
 * Created by jalvarez on 20/06/2017.
 */

public abstract class BaseActivity extends AppCompatActivity implements MvpView, BaseFragment.Callback {

    private ProgressDialog progressDialog;

    private ActivityComponent activityComponent;

    private Unbinder unbinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityComponent = DaggerActivityComponent.builder()
                .activityModule(new ActivityModule(this))
                .applicationComponent(MvpApp.get(this).getComponent())
                .build();
    }

    public ActivityComponent getActivityComponent() {
        return activityComponent;
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @TargetApi(Build.VERSION_CODES.M)
    public void requestPermissionsSafely(String[] permissions, int requestCode) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(permissions, requestCode);
        }
    }

    @TargetApi(Build.VERSION_CODES.M)
    public boolean hasPermissions(String permissions) {
        return Build.VERSION.SDK_INT < Build.VERSION_CODES.M || checkSelfPermission(permissions) == PackageManager.PERMISSION_GRANTED;
    }

    @Override
    public void showLoading() {
        hideLoading();
        progressDialog = CommonUtils.showLoadingDialog(this);
    }

    @Override
    public void hideLoading() {
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.cancel();
        }
    }

    @Override
    public void onError(String msg) {
        if (msg != null)
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, getString(R.string.some_error), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onError(@StringRes int resId) {
        onError(getString(resId));
    }

    @Override
    public boolean isNetworkConnected() {
        return NetworkUtils.isNetworkConnected(getApplicationContext());
    }

    @Override
    public void onFragmentAttached() {

    }

    @Override
    public void onFragmentDetached(String tag) {

    }

    public void hideKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    @Override
    public void openActivityOnTokenExpire() {
        /*startActivity(LoginActivity.getStartIntent(this));
        finish();*/
    }

    public void setUnbinder(Unbinder unbinder) {
        this.unbinder = unbinder;
    }

    @Override
    protected void onDestroy() {
        if (this.unbinder != null)
            unbinder.unbind();
        super.onDestroy();
    }

    protected abstract void setUp();
}
