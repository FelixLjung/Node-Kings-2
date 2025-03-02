/*
 * FXGL - JavaFX Game Library. The MIT License (MIT).
 * Copyright (c) AlmasB (almaslvl@gmail.com).
 * See LICENSE for details.
 */

package com.almasb.fxglgames.drop;
import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.core.math.FXGLMath;
import com.almasb.fxgl.dsl.FXGL;
import static com.almasb.fxgl.dsl.FXGL.entityBuilder;
import static com.almasb.fxgl.dsl.FXGL.getAppHeight;
import static com.almasb.fxgl.dsl.FXGL.getAppWidth;
import static com.almasb.fxgl.dsl.FXGL.getInput;
import static com.almasb.fxgl.dsl.FXGL.onCollisionBegin;
import static com.almasb.fxgl.dsl.FXGL.play;
import static com.almasb.fxgl.dsl.FXGL.showMessage;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.ui.FXGLButton;
import com.almasb.fxglgames.Client;
import com.almasb.fxglgames.Server;
import com.almasb.fxglgames.drop.classes.BoardSquare;
import com.almasb.fxglgames.drop.classes.Castle;

import javafx.scene.control.Button;
import javafx.scene.text.Text;

/**
 * This is an FXGL version of the libGDX simple game tutorial, which can be found
 * here - https://github.com/libgdx/libgdx/wiki/A-simple-game
 *
 * The player can move the bucket left and right to catch water droplets.
 * There are no win/lose conditions.
 *
 * Note: for simplicity's sake all of the code is kept in this file.
 * In addition, most of typical FXGL API is not used to avoid overwhelming
 * FXGL beginners with a lot of new concepts to learn.
 *
 * Although the code is self-explanatory, some may find the comments useful
 * for following the code.
 *
 * @author Almas Baimagambetov (AlmasB) (almaslvl@gmail.com)
 */
public class DropApp extends GameApplication {


	public Player player;
    public Server s;
    public Client c;
    /**
     * Types of entities in this game.
     */
    public enum Type {
        DROPLET, BUCKET, PLAYER
    }

    private Graphics graphics;

    @Override
    protected void initSettings(GameSettings settings) {
        // initialize common game / window settings.
        settings.setTitle("Drop");
        settings.setVersion("1.0");
        settings.setWidth(1920);
        settings.setHeight(1080);
    }

	private void basicGraphics() {
		graphics = new Graphics();

		graphics.DrawGame();
		// graphics.Draw_castles(800,400,50,70);
		


	}

    private void StartServer() {
       s = new Server(5000,2);
    }

    private void JoinServer() {
        c = new Client("127.0.0.1", 5000);
    }

    private void ServerButtons() {
        FXGLButton buttonServer = new FXGLButton("Start Server");
        buttonServer.setTranslateX(250);
        buttonServer.setTranslateY(250);
        buttonServer.setOnAction(e -> StartServer());

        FXGL.addUINode(buttonServer);

        FXGLButton buttonJoin = new FXGLButton("Join Server");
        
        buttonJoin.setTranslateX(350);
        buttonJoin.setTranslateY(250);

        buttonJoin.setOnAction(e->JoinServer());
        FXGL.addUINode(buttonJoin);
    }

    @Override
    protected void initGame() {
        // spawnBucket();

        // creates a timer that runs spawnDroplet() every second
        // run(() -> spawnDroplet(), Duration.seconds(1));

		basicGraphics();
		Player player1 = new Player("Felix");
		Player player2 = new Player("Alfred");
		this.player = player1;
        
        Entity clientPlayer = FXGL.entityBuilder().type(Type.PLAYER).buildAndAttach();
        
        clientPlayer.addComponent(new Player(player1.GetName()));
        
		Castle castle1 = new Castle(800,400, "Castle 1", player1.GetName(), graphics);
		Castle castle2 = new Castle(1200,500, "Castle 2", player2.GetName(), graphics);



		FXGLButton button = new FXGLButton("Click here");
		
		
		button.setOnAction(e -> showMessage("YOOO"));

        Text uiText = new Text("Hello World");

        // 2. add the UI object to game scene (easy way) at 100, 100
        FXGL.addUINode(uiText, 100, 100);
		Button btn = new Button("Knappen pär");

		btn.setTranslateX(350);
        btn.setTranslateY(250);

        // Add action event
        btn.setOnAction(e -> showMessage("Button Clicked!"));

        // Add to UI
        // FXGL.addUINode(btn);

		button.setTranslateX(500);
		button.setTranslateY(500);

		FXGL.addUINode(button);

        BoardSquare square = new BoardSquare("Castle", 40,40);
        

        

        ServerButtons();

        FXGLButton buttonNextTurn = new FXGLButton("Next Turn");
        buttonNextTurn.setTranslateX(1000);
        buttonNextTurn.setTranslateY(500);
        buttonNextTurn.setOnAction(e->c.NextTurn());
        FXGL.addUINode(buttonNextTurn);
		// FXGL.entityBuilder()
        // loopBGM("bgm.mp3");
    }

    @Override
    protected void initPhysics() {
        onCollisionBegin(Type.BUCKET, Type.DROPLET, (bucket, droplet) -> {

            // code in this block is called when there is a collision between Type.BUCKET and Type.DROPLET

            // remove the collided droplet from the game
            droplet.removeFromWorld();

            // play a sound effect located in /resources/assets/sounds/
            play("drop.wav");
        });
    }

    @Override
    protected void onUpdate(double tpf) {

        // for each entity of Type.DROPLET translate (move) it down
       // getGameWorld().getEntitiesByType(Type.DROPLET).forEach(droplet -> droplet.translateY(150 * tpf));
    }

    private void spawnBucket() {
        // build an entity with Type.BUCKET
        // at the position X = getAppWidth() / 2 and Y = getAppHeight() - 200
        // with a view "bucket.png", which is an image located in /resources/assets/textures/
        // also create a bounding box from that view
        // make the entity collidable
        // finally, complete building and attach to the game world

        Entity bucket = entityBuilder()
                .type(Type.BUCKET)
                .at(getAppWidth() / 2, getAppHeight() - 200)
                .viewWithBBox("bucket.png")
                .collidable()
                .buildAndAttach();

        // bind bucket's X value to mouse X
        bucket.xProperty().bind(getInput().mouseXWorldProperty());
    }

    private void spawnDroplet() {
        entityBuilder()
                .type(Type.DROPLET)
                .at(FXGLMath.random(0, getAppWidth() - 64), 0)
                .viewWithBBox("droplet.png")
                .collidable()
                .buildAndAttach();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
