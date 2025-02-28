
package com.almasb.fxglgames.drop;

import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.dsl.FXGL;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public class Graphics extends GameApplication {

	
	Button button;
	@Override
	protected void initSettings(GameSettings settings) {
		
	}

	

	public void Draw_map() {
		
		draw(400,0,640,1100, Color.YELLOWGREEN);

	}

	public void DrawGame() {
		Draw_map();
		// Draw_castles();
	} 


	private static void draw(int spawnPosX, int spawnPosY, int length, int width, Color color ) {
		FXGL.entityBuilder()
		.at(spawnPosX,spawnPosY)
		.view(new Rectangle(width,length, color))
		.buildAndAttach();
	}

	public void Draw_castles(int posX, int posY, int width, int height ) {

		draw(posX,posY, height,width, Color.BLACK);


		
		// button.setOnAction(CastleClick());
		

		// FXGL.addUINode(button);

	}
}