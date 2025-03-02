
package com.almasb.fxglgames.drop;

import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.dsl.FXGL;
import static com.almasb.fxgl.dsl.FXGL.getGameWorld;
import static com.almasb.fxgl.dsl.FXGL.removeUINode;

import java.util.LinkedList;


import com.almasb.ButtonComponent;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.GameWorld;
import com.almasb.fxgl.ui.FXGLButton;
import com.almasb.fxglgames.drop.classes.Castle;

import javafx.scene.Node;
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
	Text castleInfoText = null;
	LinkedList<Node> castleInfoObjects;

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

	private static Text print(String text, int posX, int posY) {
		
        Text uiText = new Text(text);

        FXGL.addUINode(uiText, posX, posY);
		return uiText;
	}

	public void Draw_castles(int posX, int posY, int width, int height ) {

		draw(posX,posY, height,width, Color.BLACK);

	}

	private void clearCastleInfo() {
		while (castleInfoObjects.size() > 0) {
			removeUINode(castleInfoObjects.remove());
			
		}
		
	}

	public void DrawCastleInfo(String player, String name, String owner, Castle castle) {
		if (castleInfoObjects == null) {
			castleInfoObjects = new LinkedList<>();
		}
		else {
			GameWorld world = getGameWorld();
			world.removeEntity(castleInfo);
			
			System.out.println("{DrawCastleInfo} clearing previous");
			
			clearCastleInfo();
			System.out.println("{DrawCastleInfo} clearing done");
		}

		castleInfo = draw(bottomX, bottomY, bottomHeight, bottomWidth, Color.BLANCHEDALMOND);
		castleInfoText = print(name + " of " + owner, bottomX + 50, bottomY + 50);
		castleInfoObjects.add(castleInfoText);
		// Försökte lägga till en button som komponent, gick sådär
		// ButtonComponent buttonComponent = new ButtonComponent();
		// buttonComponent.AddButton(bottomY, bottomX, bottomWidth, bottomHeight);
		// castleInfo.addComponent(buttonComponent);
		// castleInfo.getComponent(ButtonComponent.class).
		// 	AddButton(bottomX+ 250, bottomY+ 50, 50, 30);
		
		if (player.equals(owner)) {
			FXGLButton trainButton = new FXGLButton("Train");
			trainButton.setTranslateX(bottomX + 50);
			trainButton.setTranslateY(bottomY + 50);
			trainButton.setOnAction(e -> castle.train());

			FXGL.addUINode(trainButton);
			castleInfoObjects.add(trainButton);
		} else {
			FXGLButton attackButton = new FXGLButton("Attack");
			attackButton.setTranslateX(bottomX + 50);
			attackButton.setTranslateY(bottomY + 50);
			attackButton.setOnAction(e -> castle.attack(player));
			FXGL.addUINode(attackButton);
			castleInfoObjects.add(attackButton);
		}



		
		
	}
}