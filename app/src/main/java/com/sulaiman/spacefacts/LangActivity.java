package com.sulaiman.spacefacts;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.sulaiman.spacefacts.Helper.LocaleHelper;

import java.text.BreakIterator;

import io.paperdb.Paper;

public class LangActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lang);

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


    public void updateView(String lang) {
        Context context = LocaleHelper.setLocale(this, lang);
        Resources resources = context.getResources();
    }
}
