package net.RSoft.Exp.Button;

import java.awt.Graphics;

import net.RSoft.Exp.Component;

public class SaveMap extends Button {
	private static final long serialVersionUID = 1L;
	
	public SaveMap(int x, int y, int width, int height, int tw, int th, String id) {
		super(x, y, width, height, tw, th, id);
		
	}
	
	public void onPress() {
		if(!Component.com.game.typing && !Component.com.game.saving && !Component.com.game.opening){
			Component.com.game.typing = true;
			Component.com.game.saving = true;
		}
	}
	
	public void cusTick() {
		if(!Component.com.game.typing && !Component.com.game.saving && !Component.com.game.opening){
			if(contains(Component.com.ms)){
				state = 1;
			}else{
				state = 0;
			}
		}else{
			state = 0;
		}
	}
	
	public boolean cusRend(Graphics g) {
		return true;
	}
}