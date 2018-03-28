package com.kgmyshin.annict;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.kgmyshin.annict.workDictionary.ui.work.search.SearchWorkListActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // debug
//        startActivity(
//                new Intent(
//                        this,
//                        LoginActivity.class
//                )
//        );
        startActivity(SearchWorkListActivity.Companion.createIntent(this));
    }
}
