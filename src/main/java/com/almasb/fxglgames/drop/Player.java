package com.almasb.fxglgames.drop;

import com.almasb.fxgl.entity.component.Component;

public class Player extends Component{
	String name;

	public Player(String name) {
		this.name = name;
	}

	public String GetName() {
		return name;
	}


}
