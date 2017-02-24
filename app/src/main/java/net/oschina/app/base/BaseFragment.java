package net.oschina.app.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.RequestManager;

import butterknife.ButterKnife;

/**
 * Created by Jerry on 2017/2/24.
 */

public abstract class BaseFragment extends Fragment {


    protected Context mContext;
    protected View mRoot;
    protected Bundle mBundle;
    private RequestManager mImageLoader;
    protected LayoutInflater mInflater;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mContext = null;

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mBundle = getArguments();
        initBundle(mBundle);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if (mRoot != null) {
            ViewGroup parent = (ViewGroup) mRoot.getParent();
            if (parent != null)
                parent.removeView(mRoot);

        } else {
            mRoot = inflater.inflate(getLayoutId(), container, false);

            mInflater = inflater;

            onBindViewBefore(mRoot);

            ButterKnife.bind(this, mRoot);

            if (savedInstanceState != null)
                onRestartInstance(savedInstanceState);

            initWidget(mRoot);

            initData();

        }


        return mRoot;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        ButterKnife.unbind(this);
        mImageLoader = null;
        mBundle = null;
    }

    protected void initBundle(Bundle bundle) {

    }

    protected abstract int getLayoutId()
            ;

    protected void initData() {
    }

    protected void initWidget(View root) {
    }


    protected void onBindViewBefore(View root) {
    }


    protected <T extends View> T findView(int viewId) {
        return (T) mRoot.findViewById(viewId);

    }


    protected void onRestartInstance(Bundle bundle) {
    }










}
