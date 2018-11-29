package cn.linhome.poper;

import android.app.Activity;
import android.view.View;

import cn.linhome.lib.poper.FPoper;

public class BlurPoper extends FPoper
{
    public BlurPoper(Activity activity)
    {
        super(activity);
        setDebug(BuildConfig.DEBUG)
                .setPopView(R.layout.view_blur_pop)
                .setPosition(Position.BottomOutsideCenter);
    }

    @Override
    public FPoper setTarget(View target)
    {
        final View old = getTarget();
        if (old != target)
        {
            if (old != null)
            {
                old.removeOnAttachStateChangeListener(mOnAttachStateChangeListener);
            }

            if (target != null)
            {
                target.removeOnAttachStateChangeListener(mOnAttachStateChangeListener);
                target.addOnAttachStateChangeListener(mOnAttachStateChangeListener);
            }
        }
        return super.setTarget(target);
    }

    private final View.OnAttachStateChangeListener mOnAttachStateChangeListener = new View.OnAttachStateChangeListener()
    {
        @Override
        public void onViewAttachedToWindow(View v)
        {
            attach(true);
        }

        @Override
        public void onViewDetachedFromWindow(View v)
        {
            attach(false);
        }
    };
}
