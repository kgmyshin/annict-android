package com.kgmyshin.annict.workDictionary.ui.work.search

import android.content.SearchRecentSuggestionsProvider

class SearchWorkListRecentSuggestionsProvider : SearchRecentSuggestionsProvider() {

    companion object {
        const val AUTHORITY = "com.kgmyshin.annict.workDictionary.SearchWorkListRecentSuggestionsProvider"
        const val MODE = DATABASE_MODE_QUERIES
    }

    init {
        setupSuggestions(
                AUTHORITY,
                MODE
        )
    }

}