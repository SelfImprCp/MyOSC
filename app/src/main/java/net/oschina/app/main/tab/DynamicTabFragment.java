package net.oschina.app.main.tab;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.widget.ImageView;

import net.oschina.app.R;
import net.oschina.app.base.BaseTitleFragment;
import net.oschina.app.main.MainActivity;

import butterknife.Bind;

/**
 * Created by Jerry on 2017/2/24.
 */

public class DynamicTabFragment  extends BaseTitleFragment{


    @Bind(R.id.layout_tab)
    TabLayout mLayoutTab;

    @Bind(R.id.view_pager)
    ViewPager mViewPager;

    @Bind(R.id.iv_arrow_down)
    ImageView mViewArrowDown;


    private MainActivity activity;



    @Override
    protected int getContentLayoutId() {
        return R.layout.fragment_dynamic_tab;
    }

    @Override
    protected int getTitleRes() {
        return R.string.main_tab_name_news;
    }
}
