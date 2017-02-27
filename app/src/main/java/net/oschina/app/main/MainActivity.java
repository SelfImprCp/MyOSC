package net.oschina.app.main;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;

import net.oschina.app.R;
import net.oschina.app.base.BaseActivity;
import net.oschina.app.main.nav.NavFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

public class MainActivity extends BaseActivity {


    @Bind(R.id.activity_main_ui)
    LinearLayout mMainUi;


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
        mNavBar.setup()



    }

    @Override
    protected int getContentView() {
        return R.layout.activity_main_ui;
    }
}
