package com.sulaiman.spacefacts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    LinearLayout upper, lower;
    Button button;
    Animation upToDown, downToUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button);
        upper = (LinearLayout) findViewById(R.id.upper);
        lower = (LinearLayout) findViewById(R.id.lower);
        upToDown = AnimationUtils.loadAnimation(this, R.anim.uptodown);
        downToUp = AnimationUtils.loadAnimation(this,R.anim.downtoup);
        lower.setAnimation(downToUp);
        upper.setAnimation(upToDown);


    }
}
