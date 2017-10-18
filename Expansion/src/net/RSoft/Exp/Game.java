package net.RSoft.Exp;

import java.awt.Graphics;

import net.RSoft.Exp.gui.OptionsMenu;
import net.RSoft.Exp.world.Map;

public class Game {
	
	public boolean paused = true;
	
	public Map map;
	public OptionsMenu menu;
	
	public Game(int width, int height, int scale){
		menu = new OptionsMenu(1277, 26);
				
		newMap(width, height, scale, menu.bmt.type);
	}
	
	public void newMap(int width, int height, int scale, int type){
		map = new Map(width, height, scale, type);
	}
	
	public void tick(){
		if(paused){
			menu.tick();
		}
		
		map.tick();
	}
	
	public void render(Graphics g){
		map.render(g);
		if(paused){
			menu.render(g);
		}
	}
}