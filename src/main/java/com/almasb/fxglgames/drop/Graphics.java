
package com.almasb.fxglgames.drop;

import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.dsl.FXGL;
import static com.almasb.fxgl.dsl.FXGL.getGameWorld;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.GameWorld;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;


public class Graphics extends GameApplication {

	
	Button button;

	private int bottomX = 400;
	private int bottomY = 640;
	private int bottomHeight = 1080 - 640;
	private int bottomWidth = 1100;

	Entity castleInfo = null;

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


	private static Entity draw(int spawnPosX, int spawnPosY, int length, int width, Color color ) {
		return FXGL.entityBuilder()
		.at(spawnPosX,spawnPosY)
		.view(new Rectangle(width,length, color))
		.buildAndAttach();
	}

	private static void print(String text, int posX, int posY) {
		
        Text uiText = new Text(text);

        // 2. add the UI object to game scene (easy way) at 100, 100
        FXGL.addUINode(uiText, posX, posY);
	}

	public void Draw_castles(int posX, int posY, int width, int height ) {

		draw(posX,posY, height,width, Color.BLACK);

	}

	public void DrawCastleInfo(String name, String owner) {
		if (castleInfo != null) {
			GameWorld world = getGameWorld();
			world.removeEntity(castleInfo);
			System.out.println("Försöker radera!");
		}

		castleInfo = draw(bottomX, bottomY, bottomHeight, bottomWidth, Color.BLANCHEDALMOND);
		print(name, bottomX + 50, bottomY + 50);
	
	}
}