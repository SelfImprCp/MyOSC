package net.oschina.app.base;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;

import butterknife.ButterKnife;

/**
 * Created by Jerry on 2017/2/22.
 */

public abstract class BaseActivity extends AppCompatActivity {

    protected RequestManager mImageLoader;

    private boolean mIsDestroy;

    private Fragment mFragment;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (initBundle(getIntent().getExtras())) {

            setContentView(getContentView());
            initWindow();

            ButterKnife.bind(this);

            initWidget();

            initData();


        } else {
            finish();
        }


    }


    protected void addFragment(int frameLayoutId, Fragment fragment) {

        if (fragment != null) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            if (fragment.isAdded()) {

                if (mFragment != null) {
                    transaction.hide(mFragment).show(fragment);

                } else {
                    transaction.show(fragment);

                }

            } else {
                if (mFragment != null) {
                    transaction.hide(mFragment).add(frameLayoutId, fragment);
                } else {
                    transaction.add(frameLayoutId, fragment);

                }
            }

            mFragment = fragment;
            transaction.commit();

        }


    }

    protected void replaceFragment(int frameLayoutId, Fragment fragment) {
        if (fragment != null) {
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

            fragmentTransaction.replace(frameLayoutId, fragment);
            fragmentTransaction.commit();
        }

    }


    protected abstract int getContentView();


    protected boolean initBundle(Bundle bundle) {
        return true;
    }

    protected void initWindow() {
    }

    protected void initWidget() {
    }

    protected void initData() {
    }

    public synchronized RequestManager getmImageLoader() {
        if (mImageLoader == null)
            mImageLoader = Glide.with(this);

        return mImageLoader;
    }

    @Override
    protected void onDestroy() {
        mIsDestroy = true;

        super.onDestroy();
    }

    public boolean isDestroy() {
        return mIsDestroy;
    }
}
