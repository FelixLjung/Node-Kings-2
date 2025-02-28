package com.almasb.fxglgames.drop.classes;

import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;

public class BoardSquare extends GameApplication {
	private String SquareType;
	// private Army SquareArmy;
	private int XCord;
	private int YCord;

	public BoardSquare(String SquareType, int X, int Y) {
		this.SquareType = SquareType;
		this.XCord = X;
		this.YCord = Y;
	}

	@Override
    protected void initSettings(GameSettings settings) {
    }
}