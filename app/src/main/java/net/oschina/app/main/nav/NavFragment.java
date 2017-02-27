package net.oschina.app.main.nav;


import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

import net.oschina.app.R;
import net.oschina.app.base.BaseFragment;
import net.oschina.app.main.tab.DynamicTabFragment;
import net.oschina.app.main.tab.TweetViewPagerFragment;

import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by Jerry on 2017/2/23.
 */

public class NavFragment extends BaseFragment implements View.OnClickListener {

    @Bind(R.id.nav_item_news)
    NavigationButton mNavNews;

    @Bind(R.id.nav_item_tweet)
    NavigationButton mNavTweet;

    @Bind(R.id.nav_item_explore)
    NavigationButton mNavExplore;

    @Bind(R.id.nav_item_me)
    NavigationButton mNavMe;

    private Context mContext;

    private int mContainerId;

    private FragmentManager mFragmentManager;

    private NavigationButton mCurrentNavButton;

    private OnNavigationReselectListener mOnNavigationReselectListener;

    public NavFragment() {
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_nav;
    }


    @Override
    protected void initWidget(View root) {


        super.initWidget(root);


//        ShapeDrawable lineDrawable = new ShapeDrawable(new BorderShape(new RectF(0, 1, 0, 0)));
//        lineDrawable.getPaint().setColor(getResources().getColor(R.color.list_divider_color));
//        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{
//                new ColorDrawable(getResources().getColor(R.color.white)),
//                lineDrawable
//        });
//        root.setBackgroundDrawable(layerDrawable);
//

        mNavNews.init(R.drawable.tab_icon_new, R.string.main_tab_name_news, DynamicTabFragment.class);

        mNavTweet.init(R.drawable.tab_icon_tweet, R.string.main_tab_name_tweet, TweetViewPagerFragment.class);


    }

    @OnClick({R.id.nav_item_news, R.id.nav_item_tweet, R.id.nav_item_explore, R.id.nav_item_me, R.id.nav_item_tweet_pub})
    @Override
    public void onClick(View view) {

        if (view instanceof NavigationButton) {

            NavigationButton nav = (NavigationButton) view;
            doSelect(nav);

        } else if (view.getId() == R.id.nav_item_tweet_pub) {

        }


    }

    private void doSelect(NavigationButton mNavNews) {

        NavigationButton oldNavButton = null;
        if (mCurrentNavButton != null) {

            oldNavButton = mCurrentNavButton;
            if (oldNavButton == mNavNews) {

                onReselect(oldNavButton);
                return;

            }

            oldNavButton.setSelected(false);

        }
        mNavNews.setSelected(true);
        doTabChanged(oldNavButton, mNavNews);

        mCurrentNavButton = mNavNews;


    }


    private void doTabChanged(NavigationButton oldNavButton, NavigationButton newNavButton) {

    }


    public void setUp(Context context, FragmentManager fragmentManager, int contentId, OnNavigationReselectListener listener) {
        mContext = context;
        mFragmentManager = fragmentManager;
        mContainerId = contentId;
        mOnNavigationReselectListener = listener;

        clearOldFragment();
        doSelect(mNavNews);

    }


    private void onReselect(NavigationButton navigationButton) {
        OnNavigationReselectListener listener = mOnNavigationReselectListener;
        if (listener != null) {
            listener.onReselect(navigationButton);
        }

    }

    public interface OnNavigationReselectListener {
        void onReselect(NavigationButton navigationButton);
    }

    private void clearOldFragment() {

        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        List<Fragment> fragmentList = mFragmentManager.getFragments();

    }

}
