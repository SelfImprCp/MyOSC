package net.oschina.app.base;

import android.view.View;
import android.view.ViewStub;

import net.oschina.app.R;
import net.oschina.app.widget.TitleBar;

/**
 * Created by Jerry on 2017/2/24.
 */

public abstract class BaseTitleFragment
        extends BaseFragment {


    TitleBar mTitleBar;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_base_title;
    }


    @Override
    protected void onBindViewBefore(View root) {
        super.onBindViewBefore(root);
        ViewStub stub = (ViewStub) root.findViewById(R.id.lay_content);
        stub.setLayoutResource(getContentLayoutId());
        stub.inflate();

    }

    @Override
    protected void initWidget(View root) {
        super.initWidget(root);

        mTitleBar = (TitleBar) root.findViewById(R.id.nav_title_bar);
        mTitleBar.setmTitle(getTitleRes());
        mTitleBar.setmIcon(getIconRes());
        mTitleBar.setIconOnClickListener(getIconClickListener());
    }

    protected abstract int
    getContentLayoutId();


    protected abstract int getTitleRes();

    protected int getIconRes() {
        return 0;
    }

    protected View.OnClickListener getIconClickListener() {
        return null;
    }
}
