package net.oschina.app.main.nav;

import android.app.FragmentManager;
import android.content.Context;
import android.view.View;

import net.oschina.app.R;
import net.oschina.app.base.BaseFragment;
import net.oschina.app.main.tab.DynamicTabFragment;
import net.oschina.app.main.tab.TweetViewPagerFragment;

import butterknife.Bind;

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

    public  NavFragment(){}

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

        mNavNews.init(R.drawable.tab_icon_new,R.string.main_tab_name_news,DynamicTabFragment.class);

        mNavTweet.init(R.drawable.tab_icon_tweet,R.string.main_tab_name_tweet,TweetViewPagerFragment.class);


    }

    @Override
    public void onClick(View view) {

    }



    public interface OnNavigationReselectListener {
        void onReselect(NavigationButton navigationButton);
    }

}
