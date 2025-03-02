package com.almasb.fxglgames.drop;

import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.ui.FXGLButton;
import com.almasb.fxglgames.drop.DropApp.Type;
import com.almasb.fxglgames.drop.classes.Castle;


public class Button extends GameApplication {

	Castle castle;
	Graphics graphics;
	@Override
    protected void initSettings(GameSettings settings) {
    }

	// HIGH KEY detta borde vara en subclass till Button, specifikt för castles

	public Button(Castle castle, Graphics graphics) {
		this.castle = castle;
		this.graphics = graphics;
	}



	private boolean ClickCastle() {
		Entity player = FXGL.getGameWorld().getEntitiesByType(Type.PLAYER).get(0); // kör get för det är en lista, hoppas att första är rätt!
		String name = player.getComponent(Player.class).GetName(); // hämtar ut klassen från Enityy och kör metoden GetName
		System.out.println(name + " Klickade på Castle " + castle);
		graphics.DrawCastleInfo(name, castle.getName(), castle.getOwner(), castle);
		return true;
	}

	public void AddButton(int posX, int posY, int width, int height) {
		FXGLButton newButton = new FXGLButton();
		newButton.setTranslateX(posX);
		newButton.setTranslateY(posY);
		
		newButton.setMaxWidth(width);
		newButton.setMinWidth(width);

		newButton.setMaxHeight(height);
		newButton.setMinHeight(height);
		FXGL.addUINode(newButton);

		newButton.setOnAction(e -> ClickCastle());

	}
}