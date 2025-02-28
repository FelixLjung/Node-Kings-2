package com.almasb.fxglgames.drop;

import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.ui.FXGLButton;
import com.almasb.fxglgames.drop.classes.Castle;


public class Button extends GameApplication {

	Castle castle;
	@Override
    protected void initSettings(GameSettings settings) {
    }

	// HIGH KEY detta borde vara en subclass till Button, specifikt för castles
	
	public Button(Castle castle) {
		this.castle = castle;
	}



	private boolean ClickCastle() {
		System.out.println("Klickade på Castle " + castle);
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