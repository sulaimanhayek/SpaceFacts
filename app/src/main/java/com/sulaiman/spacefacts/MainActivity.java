package com.sulaiman.spacefacts;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.sulaiman.spacefacts.Helper.LocaleHelper;

import io.paperdb.Paper;

public class MainActivity extends AppCompatActivity {
    LinearLayout upper, lower;
    Button button;
    Animation upToDown, downToUp;
    TextView textView;

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(LocaleHelper.onAttach(newBase, "en"));
    }

    @Override
    protected void onStart() {
        super.onStart();
        textView = (TextView) findViewById(R.id.name);
        Paper.init(this);
        // default laguage is english
        String language = Paper.book().read("language");
        if (language == null)
            new Paper().book().write("language", "en");
        updateView((String) Paper.book().read("language"));


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        upper = findViewById(R.id.upper);
        lower = findViewById(R.id.lower);
        upToDown = AnimationUtils.loadAnimation(this, R.anim.uptodown);
        downToUp = AnimationUtils.loadAnimation(this, R.anim.downtoup);
        upper.setAnimation(upToDown);
        lower.setAnimation(downToUp);
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(MainActivity.this, LangActivity.class);
                startActivity(intent);

            }

        });


    }
    public void updateView(String lang) {
        Context context = LocaleHelper.setLocale(this, lang);
        Resources resources = context.getResources();
        textView.setText(resources.getString(R.string.space_facts));
        button.setText(resources.getString(R.string.journey));
    }
}
