package net.RSoft.Exp.Button;

import java.awt.Graphics;

import net.RSoft.Exp.Component;

public class EnsureMap extends Button {
	private static final long serialVersionUID = 1L;
	
	public EnsureMap(int x, int y, int width, int height, int tw, int th, String id) {
		super(x, y, width, height, tw, th, id);
		
	}
	
	public void onPress() {
		if(state != 2){
			Component.com.game.typing = false;
			if(Component.com.game.saving){
				if(Component.com.game.typeStr.endsWith("_")){
					Component.com.game.map.saveMap(Component.com.game.typeStr.substring(0, Component.com.game.typeStr.length()-1));
				}else{
					Component.com.game.map.saveMap(Component.com.game.typeStr);
				}
				Component.com.game.saving = false;
			}else if(Component.com.game.opening){
				if(Component.com.game.typeStr.endsWith("_")){
					Component.com.game.map.importMap(Component.com.game.typeStr.substring(0, Component.com.game.typeStr.length()-1));
				}else{
					Component.com.game.map.importMap(Component.com.game.typeStr);
				}
				Component.com.game.opening = false;
			}
			Component.com.game.typeStr = "_";
		}
	}
	
	public void cusTick() {
		if(Component.com.game.typeStr != "_" && Component.com.game.typeStr != " " && Component.com.game.typeStr != ""){
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