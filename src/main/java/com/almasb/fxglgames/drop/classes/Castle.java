package com.almasb.fxglgames.drop.classes;

import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxglgames.drop.Button;
import com.almasb.fxglgames.drop.Graphics;

public class Castle extends GameApplication{

	int posX;
	int posY;
	int width = 50;
	int height = 70;

	Graphics graphics;
	String name;
	String owner;

	@Override
	protected void initSettings(GameSettings settings) {
	}
	
	public Castle(int posX, int posY, String name, String owner) {
		graphics = new Graphics();
		this.posX = posX; 
		this.posY = posY;
		this.name = name; 
		this.owner = owner;

		graphics.Draw_castles(posX,posY,width,height);
		Button button = new Button(this);
		button.AddButton(posX,posY,	width, height);
	}

	@Override
	public String toString() {
		return name + " of " + owner;
	}


	public String getName() {
		return name;
	}
	public String getOwner() {
		return owner;
	}



}
