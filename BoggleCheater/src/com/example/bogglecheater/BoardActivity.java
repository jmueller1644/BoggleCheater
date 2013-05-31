package com.example.bogglecheater;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

public class BoardActivity extends Activity {
	public final static String BOARD = "com.example.bogglecheater.BOARD";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_board);
		EditText firstBox = (EditText)findViewById(R.id.board00);
		getRequestedOrientation();
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_NOSENSOR);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.board, menu);
		return true;
	}

	public void submit(View view) {
		Intent intent = new Intent(this, SolutionActivity.class);
		ArrayList<String> board = new ArrayList<String>();
		
		board.add(((EditText)findViewById(R.id.board00)).getText().toString().toUpperCase());
		board.add(((EditText)findViewById(R.id.board01)).getText().toString().toUpperCase());
		board.add(((EditText)findViewById(R.id.board02)).getText().toString().toUpperCase());
		board.add(((EditText)findViewById(R.id.board03)).getText().toString().toUpperCase());
		board.add(((EditText)findViewById(R.id.board10)).getText().toString().toUpperCase());
		board.add(((EditText)findViewById(R.id.board11)).getText().toString().toUpperCase());
		board.add(((EditText)findViewById(R.id.board12)).getText().toString().toUpperCase());
		board.add(((EditText)findViewById(R.id.board13)).getText().toString().toUpperCase());
		board.add(((EditText)findViewById(R.id.board20)).getText().toString().toUpperCase());
		board.add(((EditText)findViewById(R.id.board21)).getText().toString().toUpperCase());
		board.add(((EditText)findViewById(R.id.board22)).getText().toString().toUpperCase());
		board.add(((EditText)findViewById(R.id.board23)).getText().toString().toUpperCase());
		board.add(((EditText)findViewById(R.id.board30)).getText().toString().toUpperCase());
		board.add(((EditText)findViewById(R.id.board31)).getText().toString().toUpperCase());
		board.add(((EditText)findViewById(R.id.board32)).getText().toString().toUpperCase());
		board.add(((EditText)findViewById(R.id.board33)).getText().toString().toUpperCase());
		
		intent.putStringArrayListExtra(BOARD, board);
		startActivity(intent);
	}
}
