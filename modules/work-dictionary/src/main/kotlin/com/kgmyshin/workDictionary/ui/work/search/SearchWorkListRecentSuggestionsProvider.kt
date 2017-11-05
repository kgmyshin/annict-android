package com.kgmyshin.workDictionary.ui.work.search

import android.content.SearchRecentSuggestionsProvider

class SearchWorkListRecentSuggestionsProvider : SearchRecentSuggestionsProvider() {

    companion object {
        const val AUTHORITY = "com.kgmyshin.workDictionary.ui.work.search.SearchWorkListRecentSuggestionsProvider"
        const val MODE = DATABASE_MODE_QUERIES
    }

    init {
        setupSuggestions(
                AUTHORITY,
                MODE
        )
    }

}