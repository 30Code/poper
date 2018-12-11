package cn.linhome.poper;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.fanwe.library.activity.SDBaseActivity;

import cn.linhome.lib.poper.FPoper;
import cn.linhome.lib.poper.layouter.BoundLayouter;
import cn.linhome.lib.poper.layouter.FixBoundLayouter;
import cn.linhome.lib.poper.layouter.ViewBoundLayouter;

/**
 * des:
 * Created by 30Code
 * on 2018/12/11
 */
public class TestActivity extends SDBaseActivity
{
    private TextView tv_title;

    @Override
    protected void init(Bundle savedInstanceState)
    {
        setContentView(R.layout.act_test);
        tv_title = findViewById(R.id.tv_title);

        tv_title.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                getPopView().getPoper().attach(!getPopView().getPoper().isAttached());
            }
        });
    }

    private TestPopView mPopView;

    public TestPopView getPopView()
    {
        if (mPopView == null)
        {
            mPopView = new TestPopView(this);
            mPopView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT));
            mPopView.getPoper()
                    .setTarget(tv_title)
                    .setPosition(FPoper.Position.BottomOutsideCenter);
        }
        return mPopView;
    }
}
