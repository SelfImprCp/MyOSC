package net.oschina.app.main.tab;

import net.oschina.app.R;
import net.oschina.app.base.BaseTitleFragment;

/**
 * Created by Jerry on 2017/2/24.
 */

public class DynamicTabFragment  extends BaseTitleFragment{
    @Override
    protected int getContentLayoutId() {
        return R.layout.fragment_dynamic_tab;
    }

    @Override
    protected int getTitleRes() {
        return R.string.main_tab_name_news;
    }
}
