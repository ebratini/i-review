package com.bgsystems.ireview.model;

import android.content.SearchRecentSuggestionsProvider;

public class IReviewRecentSearchSuggestionProvider extends
		SearchRecentSuggestionsProvider {
	public final static String AUTHORITY = "com.bgsystems.ireview.model.IReviewRecentSearchSuggestionProvider";
	public final static int MODE = DATABASE_MODE_QUERIES;

	public IReviewRecentSearchSuggestionProvider() {
		setupSuggestions(AUTHORITY, MODE);
	}

}
