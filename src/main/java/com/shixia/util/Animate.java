package com.shixia.util;

import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;

/**
 * Created by shixiuwen on 15-11-13.
 */
public class Animate {
    //旋转的方法
    public RotateAnimation rotate(float startDegree, float endDegree) {
        RotateAnimation rotateAnimation = new RotateAnimation(startDegree, endDegree, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        //设置为重复不停旋转
        rotateAnimation.setRepeatCount(-1);
        rotateAnimation.setDuration(3000);
        //设置不停旋转的样式（匀速），默认为开始和结束的时候减速
        rotateAnimation.setInterpolator(new LinearInterpolator());

        return rotateAnimation;
    }
}
