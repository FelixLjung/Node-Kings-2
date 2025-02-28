
package com.almasb.fxglgames.drop;

import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.ui.FXGLButton;

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

		FXGLButton button = new FXGLButton("");
		button.setTranslateX(800);
		button.setTranslateY(400);
		button.setMinWidth(70);
		button.setMaxWidth(70);
		button.setMinHeight(50);
		button.setMaxHeight(50);
	
		// button.setOnAction(CastleClick());
		

		FXGL.addUINode(button);

	}
}