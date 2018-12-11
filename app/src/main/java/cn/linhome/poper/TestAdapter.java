package cn.linhome.poper;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.fanwe.library.adapter.SDSimpleAdapter;

import java.util.List;

public class TestAdapter extends SDSimpleAdapter<TestModel>
{
    public TestAdapter(List<TestModel> listModel, Activity activity)
    {
        super(listModel, activity);
    }

    @Override
    public int getLayoutId(int position, View convertView, ViewGroup parent)
    {
        return R.layout.item_test;
    }

    @Override
    public void bindData(int position, View convertView, ViewGroup parent, TestModel model)
    {
        TextView tv_test = get(R.id.tv_test, convertView);
        tv_test.setText(model.getTitle());
    }
}
