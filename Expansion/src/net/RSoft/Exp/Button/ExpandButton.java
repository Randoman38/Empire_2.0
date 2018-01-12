package net.RSoft.Exp.Button;

import java.awt.Graphics;

import net.RSoft.Exp.Component;

public class ExpandButton extends Button {
	private static final long serialVersionUID = 1L;
	
	public ExpandButton(int x, int y, int width, int height, int tw, int th, String id) {
		super(x, y, width, height, tw, th, id);
		
	}
	
	public void onPress() {
		if(type == 0){
			type = 1;
		}else{
			type = 0;
		}
	}
	
	public void cusTick() {
		if(contains(Component.com.ms)){
			state = 1;
		}else{
			state = 0;
		}
	}
	
	public boolean cusRend(Graphics g) {
		if(state == 1 || type == 1){
			return true;
		}
		
		return false;
	}
}