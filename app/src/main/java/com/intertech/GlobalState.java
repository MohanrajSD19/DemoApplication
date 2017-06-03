package com.intertech;

import android.app.Application;

public class GlobalState extends Application {
	
	private int gameScore = 0;

	private int dashboardVal =0,signIOVal =0;


	public int getGameScore() {
		return gameScore;
	}

	public void setGameScore(int gameScore) {
		this.gameScore = gameScore;
	}
	
	public void incrementScore(){
		gameScore++;
	}


	public int getDashboardVal() {
		return dashboardVal;
	}

	public void setDashboardVal(int dashboardVal) {
		this.dashboardVal = dashboardVal;
	}

	public int getSignIOVal() {
		return signIOVal;
	}

	public void setSignIOVal(int signIOVal) {
		this.signIOVal = signIOVal;
	}
}
