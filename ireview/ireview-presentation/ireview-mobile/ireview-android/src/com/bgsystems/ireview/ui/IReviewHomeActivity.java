package com.bgsystems.ireview.ui;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.SearchRecentSuggestions;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import com.bgsystems.ireview.R;
import com.bgsystems.ireview.model.IReviewRecentSearchSuggestionProvider;

public class IReviewHomeActivity extends Activity {
	private TextView textView;
	private ListView listView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ireview_home);

		textView = (TextView) findViewById(R.id.text);
		listView = (ListView) findViewById(R.id.list);

		handleIntent(getIntent());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_ireview_home_menu, menu);

		// Get the SearchView and set the searchable configuration
		SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
		SearchView searchView = (SearchView) menu.findItem(R.id.menu_search)
				.getActionView();
		searchView.setSearchableInfo(searchManager
				.getSearchableInfo(getComponentName()));
		searchView.setSubmitButtonEnabled(false);

		// setting the OnActionExpandListener
		MenuItem searchMnuItem = menu.findItem(R.id.menu_search);
		searchMnuItem.setOnActionExpandListener(new OnActionExpandListener() {
			@Override
			public boolean onMenuItemActionCollapse(MenuItem item) {
				IReviewHomeActivity.this.textView
						.setText(getString(R.string.blank));
				return true; // Return true to collapse action view
			}

			@Override
			public boolean onMenuItemActionExpand(MenuItem item) {
				IReviewHomeActivity.this.textView
						.setText(getString(R.string.search_instructions));
				return true; // Return true to expand action view
			}
		});
		return true;
	}

	private void handleIntent(Intent intent) {
		if (Intent.ACTION_VIEW.equals(intent.getAction())) {
			// handles a click on a search suggestion; launches activity to show
			// commodity
			// Intent wordIntent = new Intent(this, WordActivity.class);
			// wordIntent.setData(intent.getData());
			// startActivity(wordIntent);
			// finish();
		} else if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
			// handles a search query
			String query = intent.getStringExtra(SearchManager.QUERY);

			// saving the query to the recent suggestions
			SearchRecentSuggestions suggestions = new SearchRecentSuggestions(
					this, IReviewRecentSearchSuggestionProvider.AUTHORITY,
					IReviewRecentSearchSuggestionProvider.MODE);
			suggestions.saveRecentQuery(query, null);

			// show query results
			showResults(query);
		}
	}

	private void showResults(String query) {

		// Cursor cursor = managedQuery(DictionaryProvider.CONTENT_URI, null,
		// null,
		// new String[] {query}, null);
		//
		// if (cursor == null) {
		// // There are no results
		// mTextView.setText(getString(R.string.no_results, new Object[]
		// {query}));
		// } else {
		// // Display the number of results
		// int count = cursor.getCount();
		// String countString =
		// getResources().getQuantityString(R.plurals.search_results,
		// count, new Object[] {count, query});
		// mTextView.setText(countString);
		//
		// // Specify the columns we want to display in the result
		// String[] from = new String[] { DictionaryDatabase.KEY_WORD,
		// DictionaryDatabase.KEY_DEFINITION };
		//
		// // Specify the corresponding layout elements where we want the
		// columns to go
		// int[] to = new int[] { R.id.word,
		// R.id.definition };
		//
		// // Create a simple cursor adapter for the definitions and apply them
		// to the ListView
		// SimpleCursorAdapter words = new SimpleCursorAdapter(this,
		// R.layout.result, cursor, from, to);
		// mListView.setAdapter(words);
		//
		// // Define the on-click listener for the list items
		// mListView.setOnItemClickListener(new OnItemClickListener() {
		// public void onItemClick(AdapterView<?> parent, View view, int
		// position, long id) {
		// // Build the Intent used to open WordActivity with a specific word
		// Uri
		// Intent wordIntent = new Intent(getApplicationContext(),
		// WordActivity.class);
		// Uri data = Uri.withAppendedPath(DictionaryProvider.CONTENT_URI,
		// String.valueOf(id));
		// wordIntent.setData(data);
		// startActivity(wordIntent);
		// }
		// });
		// }
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.menu_search:
			onSearchRequested();
			return true;
		case android.R.id.home:
			// app icon in action bar clicked; go home
			Intent intent = new Intent(this, IReviewHomeActivity.class);
			intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(intent);
			return true;
		case R.id.menu_clear_search_history:
			SearchRecentSuggestions suggestions = new SearchRecentSuggestions(
					this, IReviewRecentSearchSuggestionProvider.AUTHORITY,
					IReviewRecentSearchSuggestionProvider.MODE);
			suggestions.clearHistory();
			return true;
		default:
			return false;
		}
	}

}
