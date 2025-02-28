package com.almasb.fxglgames.drop;

import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.ui.FXGLButton;


public class Button extends GameApplication {
	@Override
    protected void initSettings(GameSettings settings) {
    }


	public static void AddButton(int posX, int posY, int width, int height) {
		FXGLButton newButton = new FXGLButton();
		newButton.setTranslateX(posX);
		newButton.setTranslateY(posY);
		
		newButton.setMaxWidth(width);
		newButton.setMinWidth(width);

		newButton.setMaxHeight(height);
		newButton.setMinHeight(height);
		FXGL.addUINode(newButton);


	}
}