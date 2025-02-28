
package com.almasb.fxglgames.drop;

import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.dsl.FXGL;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public class Graphics extends GameApplication {

	@Override
	protected void initSettings(GameSettings settings) {
		
	}

	public void Draw_map() {
		
		draw(400,0,1100,640, Color.YELLOWGREEN);

	}

	public void DrawGame() {
		Draw_map();
		Draw_castles();
	} 


	private void draw(int spawnPosX, int spawnPosY, int length, int width, Color color ) {
		FXGL.entityBuilder()
		.at(spawnPosX,spawnPosY)
		.view(new Rectangle(length,width, color))
		.buildAndAttach();
	}

	public void Draw_castles() {
		draw(800,400, 50,70, Color.BLACK);

	}
}