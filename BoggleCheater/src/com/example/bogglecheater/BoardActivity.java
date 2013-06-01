package com.example.bogglecheater;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ListView;

public class BoardActivity extends Activity {
	public final static String BOARD = "com.example.bogglecheater.BOARD";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_board);
		EditText[] editTexts = getEditTexts();
		for (int i = 0; i < editTexts.length; i ++) {
			editTexts[i].setOnClickListener(customTexts(editTexts[i]));
		}
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
		EditText[] editTexts = getEditTexts();
		ArrayList<String> board = new ArrayList<String>();
		for (int i = 0; i < 16; i ++) {
			board.add(editTexts[i].getText().toString().toUpperCase());
		}
		
		intent.putStringArrayListExtra(BOARD, board);
		startActivity(intent);
	}
	
	public EditText[] getEditTexts() {
		EditText[] texts = new EditText[16];
		texts[0] = (EditText)findViewById(R.id.board00);
		texts[1] = (EditText)findViewById(R.id.board01);
		texts[2] = (EditText)findViewById(R.id.board02);
		texts[3] = (EditText)findViewById(R.id.board03);
		texts[4] = (EditText)findViewById(R.id.board10);
		texts[5] = (EditText)findViewById(R.id.board11);
		texts[6] = (EditText)findViewById(R.id.board12);
		texts[7] = (EditText)findViewById(R.id.board13);
		texts[8] = (EditText)findViewById(R.id.board20);
		texts[9] = (EditText)findViewById(R.id.board21);
		texts[10] = (EditText)findViewById(R.id.board22);
		texts[11] = (EditText)findViewById(R.id.board23);
		texts[12] = (EditText)findViewById(R.id.board30);
		texts[13] = (EditText)findViewById(R.id.board31);
		texts[14] = (EditText)findViewById(R.id.board32);
		texts[15] = (EditText)findViewById(R.id.board33);
		
		return texts;
	}

	View.OnClickListener customTexts(final EditText et) {
		return new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				ColorDrawable backgroundColor = (ColorDrawable)et.getBackground();
				int color = backgroundColor.getColor();
				System.out.println("Color: " + color);
				if (et.getText().toString().length() != 0) {
					if (color == 0xffffffff || color == -1) {
						et.setBackgroundColor(0xff00ff00);
					} else if (color == 0xff00ff00) {
						et.setBackgroundColor(0xffffff00);
					} else if (color == 0xffffff00) {
						et.setBackgroundColor(0xff0000ff);
					} else if (color == 0xff0000ff) {
						et.setBackgroundColor(0xffff0000);
					} else if (color == 0xffff0000) {
						et.setBackgroundColor(0xffffffff);
					}
				}
			}
		};
	}
}
