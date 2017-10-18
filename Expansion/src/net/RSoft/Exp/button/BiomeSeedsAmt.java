package net.RSoft.Exp.button;

import net.RSoft.Exp.Component;

public class BiomeSeedsAmt extends Button{
	private static final long serialVersionUID = 1L;
	
	public BiomeSeedsAmt(int x, int y, int width, int height, int tw, int th, String id) {
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
		if(Component.com.game.menu.bmt.type == 3){
			if(contains(Component.com.ms)){
				state = 1;
			}else{
				state = 0;
			}
		}else{
			state = 2;
		}
	}
}