package com.dh.foundation.widget.AfkImageView;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;

/**
 * Created by lee on 2015/9/22.
 */
public abstract class ToggleAnimation implements ExcessiveAnimation {
    protected double progress;

    private int duration = 5 * 100;
    protected Drawable mLastDrawable;
    protected Drawable mDrawable;

    private boolean mIsFinish;

    @Override
    public boolean draw(Canvas canvas) {
        mIsFinish = progress <= 0;
//        if (mIsFinish)
//            finish(canvas);
//        else
        {
            drawLastDrawable(canvas);
            drawDrawable(canvas);
        }

        return mIsFinish;
    }

    @Override
    public void setImage(Drawable drawable) {
        mLastDrawable = mDrawable;
        mDrawable = drawable;
    }

    @Override
    public void changeProgress(double progress) {
        this.progress = progress;
    }

    @Override
    public int duration() {
        return duration;
    }

    public void setDuration(int duration){
        this.duration = duration;
    }

    protected abstract void drawLastDrawable(Canvas canvas);

    protected abstract void drawDrawable(Canvas canvas);

    protected abstract void finish(Canvas canvas);
}