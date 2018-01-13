package net.RSoft.Exp.Button;

import java.awt.Graphics;

import net.RSoft.Exp.Component;

public class NewMapL extends Button {
	private static final long serialVersionUID = 1L;
	
	public NewMapL(int x, int y, int width, int height, int tw, int th, String id) {
		super(x, y, width, height, tw, th, id);
		
	}
	
	public void onPress() {
		Component.com.game.newMap(Component.WIDTH, Component.HEIGHT, 5, Component.com.game.menu.bmt.type);
	}
	
	public void cusTick() {
		if(contains(Component.com.ms)){
			state = 1;
		}else{
			state = 0;
		}
	}
	
	public boolean cusRend(Graphics g) {
		return true;
	}
}