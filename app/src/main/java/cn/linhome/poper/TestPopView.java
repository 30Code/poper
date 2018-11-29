package cn.linhome.poper;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.fanwe.library.adapter.SDSimpleRecyclerAdapter;
import com.fanwe.library.adapter.viewholder.SDRecyclerViewHolder;
import com.fanwe.library.view.SDAppView;
import com.fanwe.library.view.SDRecyclerView;

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

    private SDRecyclerView mListView;
    private SDSimpleRecyclerAdapter<String> mAdapter;

    private FPoper mPoper;

    private void init()
    {
        setContentView(R.layout.view_test_pop);
        mListView = findViewById(R.id.lv_content);

//        new BlurPoper(getActivity()).setTarget(this);
//        new BlurPoper(getActivity()).setTarget(this).setPosition(FPoper.Position.TopOutsideCenter);

        mListView.setAdapter(mAdapter);

        final List<String> list = new ArrayList<>();
        for (int i = 0; i < 20; i++)
        {
            list.add(String.valueOf(i));
        }
        getAdapter().setData(list);
    }

    private SDSimpleRecyclerAdapter<String> getAdapter()
    {
        if (mAdapter == null)
        {
            mAdapter = new SDSimpleRecyclerAdapter<String>(getActivity())
            {
                @Override
                public void onBindData(SDRecyclerViewHolder<String> holder, int position, final String model)
                {
                    final TextView textView = holder.get(R.id.tv_content);
                    textView.setText(model);
                    holder.itemView.setOnClickListener(new OnClickListener()
                    {
                        @Override
                        public void onClick(View v)
                        {
                            getAdapter().removeData(model);
                        }
                    });
                    holder.itemView.setOnLongClickListener(new OnLongClickListener()
                    {
                        @Override
                        public boolean onLongClick(View v)
                        {
                            mAdapter.appendData(String.valueOf(getItemCount()));
                            return false;
                        }
                    });
                }

                @Override
                public int getLayoutId(ViewGroup parent, int viewType)
                {
                    return R.layout.item_test_pop;
                }
            };
        }
        return mAdapter;
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
