package net.RSoft.Exp.Button;

import java.awt.Graphics;

import net.RSoft.Exp.Component;

public class ClearWE extends Button {
	private static final long serialVersionUID = 1L;
	
	public ClearWE(int x, int y, int width, int height, int tw, int th, String id) {
		super(x, y, width, height, tw, th, id);
		
	}
	
	public void onPress() {
		if(state != 2){
			Component.com.game.map.clear();
		}
	}
	
	public void cusTick() {
		if(Component.com.game.edit){
			if(contains(Component.com.ms)){
				state = 1;
			}else{
				state = 0;
			}
		}else{
			state = 2;
		}
	}

	public boolean cusRend(Graphics g) {
		return true;
	}
}