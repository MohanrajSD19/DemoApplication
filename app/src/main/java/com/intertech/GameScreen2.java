package com.intertech;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class GameScreen2 extends Activity {

	EditText scoreET;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.screen2);
		scoreET = (EditText) findViewById(R.id.gameScore);
	}

	@Override
	protected void onResume() {
		super.onResume();
		GlobalState state = ((GlobalState) getApplicationContext());
		scoreET.setText(String.valueOf(state.getGameScore()));
	}

	public void incrementScore(View view) {
		GlobalState state = ((GlobalState) getApplicationContext());
		state.incrementScore();
		scoreET.setText(String.valueOf(state.getGameScore()));
	}

	public void previousScreen(View view) {
		this.finish();
	}
}