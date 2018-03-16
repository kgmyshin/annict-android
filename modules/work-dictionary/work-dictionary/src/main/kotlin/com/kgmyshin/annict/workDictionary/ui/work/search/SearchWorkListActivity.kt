package com.kgmyshin.annict.workDictionary.ui.work.search

import android.app.SearchManager
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.provider.SearchRecentSuggestions
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.SearchView
import android.support.v7.widget.Toolbar
import android.view.Menu
import com.kgmyshin.annict.workDictionary.R
import com.kgmyshin.annict.workDictionary.ui.work.ScreenTransition


class SearchWorkListActivity : AppCompatActivity(), ScreenTransition {

    companion object {
        fun createIntent(context: Context): Intent = Intent(context, SearchWorkListActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        supportFragmentManager.beginTransaction().apply {
            replace(
                    R.id.container,
                    SearchWorkListFragment.newInstance()
            )
        }.commitNow()
        handleIntent(intent)
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        handleIntent(intent)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater?.inflate(
                R.menu.menu_search,
                menu
        )
        val searchView = menu?.findItem(R.id.menu_search)?.actionView as? SearchView
        val searchManager = getSystemService(Context.SEARCH_SERVICE) as? SearchManager
        searchView?.queryHint = getString(R.string.searchable_hint)
        if (searchManager != null) {
            searchView?.setSearchableInfo(searchManager.getSearchableInfo(componentName))
        }
        return super.onCreateOptionsMenu(menu)
    }

    override fun moveToDetail() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private fun handleIntent(intent: Intent?) {
        intent?.let {
            if (Intent.ACTION_SEARCH == intent.action) {
                val keyword = intent.getStringExtra(SearchManager.QUERY)
                updateKeyword(keyword)
                saveKeywordHistory(keyword)
            }
        }
    }

    private fun updateKeyword(keyword: String) {
        val fragment = supportFragmentManager.findFragmentById(R.id.container)
        if (fragment != null && fragment is SearchWorkListFragment) {
            fragment.onUpdateKeyword(keyword)
        }
    }

    private fun saveKeywordHistory(keyword: String) {
        val searchRecentSuggestions = SearchRecentSuggestions(
                applicationContext,
                SearchWorkListRecentSuggestionsProvider.AUTHORITY,
                SearchWorkListRecentSuggestionsProvider.MODE)
        searchRecentSuggestions.saveRecentQuery(
                keyword,
                null
        )
    }
}