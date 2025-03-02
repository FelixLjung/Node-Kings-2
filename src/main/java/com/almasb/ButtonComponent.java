package com.almasb;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.component.Component;
import com.almasb.fxgl.ui.FXGLButton;

public class ButtonComponent extends Component{

    public void AddButton(int posX, int posY, int width, int height) {
        FXGLButton newButton = new FXGLButton("Attack ");
        newButton.setText("Attack");
        newButton.setStyle("-fx-base: lightgreen");
        newButton.setTranslateX(posX);
        newButton.setTranslateY(posY);
        
        newButton.setMaxWidth(width);
        newButton.setMinWidth(width);

        newButton.setMaxHeight(height);
        newButton.setMinHeight(height);
        FXGL.addUINode(newButton);

    // newButton.setOnAction(e -> ClickCastle());

	}
}
