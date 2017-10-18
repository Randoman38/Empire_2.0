package net.RSoft.Exp.button;

import net.RSoft.Exp.Component;

public class NewMapS extends Button {
	private static final long serialVersionUID = 1L;
	
	public NewMapS(int x, int y, int width, int height, int tw, int th, String id) {
		super(x, y, width, height, tw, th, id);
		
	}
	
	public void onPress() {
		Component.com.game.newMap(Component.WIDTH, Component.HEIGHT, 8, Component.com.game.menu.bmt.type);
	}
	
	public void cusTick() {
		if(contains(Component.com.ms)){
			state = 1;
		}else{
			state = 0;
		}
	}
}