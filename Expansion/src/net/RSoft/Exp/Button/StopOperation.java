package net.RSoft.Exp.Button;

import java.awt.Graphics;

import net.RSoft.Exp.Component;

public class StopOperation extends Button {
	private static final long serialVersionUID = 1L;
	
	public StopOperation(int x, int y, int width, int height, int tw, int th, String id) {
		super(x, y, width, height, tw, th, id);
		
	}
	
	public void onPress() {
		Component.com.game.typing = false;
		Component.com.game.saving = false;
		Component.com.game.opening = false;
		Component.com.game.typeStr = "_";
		Component.com.game.esc.savemapnm.str = "";
		Component.com.game.esc.openmapnm.str = "";
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