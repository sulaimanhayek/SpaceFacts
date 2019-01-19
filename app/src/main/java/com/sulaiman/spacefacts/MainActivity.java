package com.sulaiman.spacefacts;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        upper = findViewById(R.id.upper);
        lower = findViewById(R.id.lower);
        upToDown = AnimationUtils.loadAnimation(this, R.anim.uptodown);
        downToUp = AnimationUtils.loadAnimation(this, R.anim.downtoup);
        lower.setAnimation(downToUp);
        upper.setAnimation(upToDown);
        textView = (TextView) findViewById(R.id.name);
        Paper.init(this);
        // default laguage is english
        String language = Paper.book().read("language");
        if (language == null)
            new Paper().book().write("language", "en");
        updateView((String) Paper.book().read("language"));

    }

    private void updateView(String lang) {
        Context context = LocaleHelper.setLocale(this, lang);
        Resources resources = context.getResources();
        textView.setText(resources.getString(R.string.space_facts));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.language_en) {
            Paper.book().write("language", "en");
            updateView((String) Paper.book().read("language"));
        } else if (item.getItemId() == R.id.language_ar) {
            Paper.book().write("language", "ar");
            updateView((String) Paper.book().read("language"));
        }
        else if (item.getItemId() == R.id.language_tr) {
            Paper.book().write("language", "tr");
            updateView((String) Paper.book().read("language"));
        }
        return true;

    }
}
