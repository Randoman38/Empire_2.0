package net.RSoft.Exp.button;

import net.RSoft.Exp.Component;

public class NewMapM extends Button {
	private static final long serialVersionUID = 1L;
	
	public NewMapM(int x, int y, int width, int height, int tw, int th, String id) {
		super(x, y, width, height, tw, th, id);
		
	}
	
	public void onPress() {
		Component.com.game.newMap(Component.WIDTH, Component.HEIGHT, 6, Component.com.game.menu.bmt.type);
	}
	
	public void cusTick() {
		if(contains(Component.com.ms)){
			state = 1;
		}else{
			state = 0;
		}
	}
}