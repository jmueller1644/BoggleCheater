package com.example.bogglecheater;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends Activity {
	public final static String ROW1 = "com.example.bogglecheater.ROW1";
	public final static String ROW2 = "com.example.bogglecheater.ROW2";
	public final static String ROW3 = "com.example.bogglecheater.ROW3";
	public final static String ROW4 = "com.example.bogglecheater.ROW4";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		EditText firstBox = (EditText)findViewById(R.id.board00);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void submit(View view) {
		Intent intent = new Intent(this, SolutionActivity.class);
		
		EditText[] row1 = new EditText[4];
		EditText[] row2 = new EditText[4];
		EditText[] row3 = new EditText[4];
		EditText[] row4 = new EditText[4];
		
		row1[0] = (EditText)findViewById(R.id.board00);
		row1[1] = (EditText)findViewById(R.id.board01);
		row1[2] = (EditText)findViewById(R.id.board02);
		row1[3] = (EditText)findViewById(R.id.board03);
		row2[0] = (EditText)findViewById(R.id.board10);
		row2[1] = (EditText)findViewById(R.id.board11);
		row2[2] = (EditText)findViewById(R.id.board12);
		row2[3] = (EditText)findViewById(R.id.board13);
		row3[0] = (EditText)findViewById(R.id.board20);
		row3[1] = (EditText)findViewById(R.id.board21);
		row3[2] = (EditText)findViewById(R.id.board22);
		row3[3] = (EditText)findViewById(R.id.board23);
		row4[0] = (EditText)findViewById(R.id.board30);
		row4[1] = (EditText)findViewById(R.id.board31);
		row4[2] = (EditText)findViewById(R.id.board32);
		row4[3] = (EditText)findViewById(R.id.board33);
		
		String[] r1 = new String[4];
		String[] r2 = new String[4];
		String[] r3 = new String[4];
		String[] r4 = new String[4];
		
		for (int i = 0; i < 4; i ++) {
			r1[i] = row1[i].getText().toString().toUpperCase();
			r2[i] = row2[i].getText().toString().toUpperCase();
			r3[i] = row3[i].getText().toString().toUpperCase();
			r4[i] = row4[i].getText().toString().toUpperCase();
		}
		
		intent.putExtra(ROW1, r1);
		intent.putExtra(ROW2, r2);
		intent.putExtra(ROW3, r3);
		intent.putExtra(ROW4, r4);
		
		startActivity(intent);
	}
}
