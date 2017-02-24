package net.oschina.app.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;

import net.oschina.app.R;

/**
 * Created by Jerry on 2017/2/24.
 */

public class TitleBar extends FrameLayout {


    public TitleBar(Context context) {
        super(context);
        init(null, 0, 0);
    }

    public TitleBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs, 0, 0);
    }

    public TitleBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs, defStyleAttr, 0);
    }

    private void init(AttributeSet attrs,int defStyleAttr,int defStyleRes)
    {
        Context context = getContext();

        LayoutInflater inflater = LayoutInflater.from(context);

        inflater.inflate(R.layout.lay_title_bar,this,true);





    }



}
