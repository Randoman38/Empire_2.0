package net.RSoft.Exp.Button;

import java.awt.Graphics;
import java.util.Random;

import net.RSoft.Exp.Component;
import net.RSoft.Exp.Colony.Colonist;

public class Randomize extends Button{
	private static final long serialVersionUID = 1L;
	
	public Randomize(int x, int y, int width, int height, int tw, int th, String id) {
		super(x, y, width, height, tw, th, id);
		
	}
	
	public void onPress() {
		Component.com.game.map.cm.clear();
		for(int k=0;k<Component.com.game.menu.gmt.type+1;k++){
			for(int i=0;i<Component.com.game.map.cm.colonies.length;i++){
				int r = 0;
				boolean b = true;
				
				while(b){
					r = new Random().nextInt(Component.com.game.map.maparr.length);
					
					if(Component.com.game.map.isLand(r)){
						b = false;
					}
				}
				
				Component.com.game.map.cm.colarr[r] = new Colonist(Component.com.game.map.cm.colonies[i], r);
			}
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
		return true;
	}
}