package net.RSoft.Exp.Button;

import java.awt.Graphics;

import net.RSoft.Exp.Component;

public class BrushSizeWE extends Button {
	private static final long serialVersionUID = 1L;
	
	public BrushSizeWE(int x, int y, int width, int height, int tw, int th, String id) {
		super(x, y, width, height, tw, th, id);
		
	}
	
	public void onPress() {
		if(state != 2){
			type++;
			
			if(type >= 3){
				type = 0;
			}
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