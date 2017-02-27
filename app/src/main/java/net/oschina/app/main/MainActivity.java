package net.oschina.app.main;

import android.os.SystemClock;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.Toast;

import net.oschina.app.AppConfig;
import net.oschina.app.R;
import net.oschina.app.base.BaseActivity;
import net.oschina.app.base.BaseApplication;
import net.oschina.app.interf.OnTabReselectListener;
import net.oschina.app.main.nav.NavFragment;
import net.oschina.app.main.nav.NavigationButton;
import net.oschina.app.util.SharePreferencesUitl;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

public class MainActivity extends BaseActivity implements NavFragment.OnNavigationReselectListener {


    @Bind(R.id.activity_main_ui)
    LinearLayout mMainUi;

    private long mBackPressedTime;

    private NavFragment mNavBar;

    private List<TurnBackListener> mTurnBackListeners = new ArrayList<>();


    public interface TurnBackListener {
        boolean onTurnBack();
    }

    @Override
    protected void initWidget() {
        super.initWidget();

        FragmentManager manager = getSupportFragmentManager();
        mNavBar = (NavFragment) manager.findFragmentById(R.id.fag_nav);
        mNavBar.setUp(this, manager, R.id.main_container, this);


    }

    @Override
    protected int getContentView() {
        return R.layout.activity_main_ui;
    }

    @Override
    public void onReselect(NavigationButton navigationButton) {

        Fragment fragment = navigationButton.getFragment();
        if (fragment != null && fragment instanceof OnTabReselectListener) {
            OnTabReselectListener listener = (OnTabReselectListener) fragment;
            listener.onTabReselect();
        }


    }

    @Override
    protected void initData() {
        super.initData();
    }


    public void addOnTurnBackListener(TurnBackListener l) {
        this.mTurnBackListeners.add(l);

    }

    public void toggleNavTabView(boolean isShowOrHide) {


    }


    @Override
    public void onBackPressed() {

        for (TurnBackListener l : mTurnBackListeners) {
            if (l.onTurnBack())
                return;
        }

        boolean isDoubleClick = (boolean) SharePreferencesUitl.get(MainActivity.this,AppConfig.KEY_DOUBLE_CLICK_EXIT, true);
        if (isDoubleClick) {
            long curTime = SystemClock.uptimeMillis();
            if ((curTime - mBackPressedTime) < (3 * 1000)) {
                finish();
            } else {
                mBackPressedTime = curTime;
                Toast.makeText(this, "再次单击退出开源中国", Toast.LENGTH_SHORT).show();
            }

        } else {
            finish();
        }


    }
}
