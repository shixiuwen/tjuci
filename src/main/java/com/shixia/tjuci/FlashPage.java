package com.shixia.tjuci;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;

import com.shixia.util.Animate;

public class FlashPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flash_page);

        ImageView ivIcon = (ImageView) findViewById(R.id.splash_iv_xiaohui);
        Button btnIcon = (Button) findViewById(R.id.splash_btn_xiaohui);

        Animate animate = new Animate();

        //内圈旋转动画
        RotateAnimation rotate = animate.rotate(0f, 360f);
        ivIcon.startAnimation(rotate);

        //设置外圈旋转动画
        RotateAnimation rotate2 = animate.rotate(360f, 0f);
        btnIcon.startAnimation(rotate2);

        new Thread(new Runnable() {
            @Override
            public void run() {
                SystemClock.sleep(3000);
                Intent intent = new Intent(FlashPage.this, EnglishPage.class);
                startActivity(intent);
                finish();
            }
        }).start();
    }

}
