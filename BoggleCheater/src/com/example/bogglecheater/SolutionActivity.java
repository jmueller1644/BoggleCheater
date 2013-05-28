package com.example.bogglecheater;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;

public class SolutionActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_solution);
		setupActionBar();
		Trie dict = loadDictionary(this, R.raw.dictionary);
		Intent intent = getIntent();
		String [][] board = new String[4][4];
		String[] row1 = intent.getStringArrayExtra(MainActivity.ROW1);
		String[] row2 = intent.getStringArrayExtra(MainActivity.ROW2);
		String[] row3 = intent.getStringArrayExtra(MainActivity.ROW3);
		String[] row4 = intent.getStringArrayExtra(MainActivity.ROW4);
		board[0] = row1;
		board[1] = row2;
		board[2] = row3;
		board[3] = row4;
		
		Solver solver = new Solver(board, dict);
		solver.solve();
	}

	public static Trie loadDictionary(Context ctx, int resId) {
		InputStream inputStream = ctx.getResources().openRawResource(resId);

	    InputStreamReader inputreader = new InputStreamReader(inputStream);
	    BufferedReader bufferedreader = new BufferedReader(inputreader);
	    String line;
	    Trie dict = new Trie();
	        
	    try {
	        while ((line = bufferedreader.readLine()) != null) {
	            dict.insert(line);              
	        }
	    } 
	    catch (IOException e) {
	        return null;
	    }
	    return dict;
	}
	
	/**
	 * Set up the {@link android.app.ActionBar}.
	 */
	private void setupActionBar() {

		getActionBar().setDisplayHomeAsUpEnabled(true);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.solution, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
