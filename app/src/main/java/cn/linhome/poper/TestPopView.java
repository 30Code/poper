package cn.linhome.poper;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;
import com.fanwe.library.view.SDAppView;

import java.util.ArrayList;
import java.util.List;

import cn.linhome.lib.poper.FPoper;

public class TestPopView extends SDAppView
{
    public TestPopView(Context context, AttributeSet attrs, int defStyle)
    {
        super(context, attrs, defStyle);
        init();
    }

    public TestPopView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        init();
    }

    public TestPopView(Context context)
    {
        super(context);
        init();
    }

    private ListView mListView;
    private TestAdapter mAdapter;

    private FPoper mPoper;

    private void init()
    {
        setContentView(R.layout.view_test_pop);
        mListView = findViewById(R.id.lv_content);

//        new BlurPoper(getActivity()).setTarget(this);
//        new BlurPoper(getActivity()).setTarget(this).setPosition(FPoper.Position.TopOutsideCenter);

        mAdapter = new TestAdapter(null, getActivity());
        mListView.setAdapter(mAdapter);

        TestModel testModel = null;
        final List<TestModel> list = new ArrayList<>();
        for (int i = 0; i < 20; i++)
        {
            testModel = new TestModel();
            testModel.setTitle("第" + i + "hang");
            list.add(testModel);
        }
        mAdapter.updateData(list);
    }

    public FPoper getPoper()
    {
        if (mPoper == null)
        {
            mPoper = new FPoper(getActivity());
            mPoper.setDebug(true)
                    .setPopView(this);
        }
        return mPoper;
    }
}
