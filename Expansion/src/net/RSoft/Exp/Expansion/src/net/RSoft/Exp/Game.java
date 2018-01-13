package net.RSoft.Exp;

import java.awt.Graphics;

import net.RSoft.Exp.GUI.EscMenu;
import net.RSoft.Exp.GUI.OptionsMenu;
import net.RSoft.Exp.World.Biome;
import net.RSoft.Exp.World.Map;

public class Game {
	
	public boolean paused = true, escape = false, edit = false, saving = false, opening = false;
	
	public boolean typing = false, shifting = false;
	public String typeStr = "_";
	
	public Map map;
	public OptionsMenu menu;
	public EscMenu esc;
	
	public Game(int width, int height, int scale){
		menu = new OptionsMenu(1277, 26);
		esc = new EscMenu(width, height);
				
		newMap(width, height, scale, menu.bmt.type);
	}
	
	public void newMap(int width, int height, int scale, int type){
		map = new Map(width, height, scale, type);
	}
	
	public void newMap(int width, int height, int scale, Biome[] mapa){
		map = new Map(width, height, scale, mapa);
	}
	
	public void tick(){
		if(paused){
			if(escape){
				esc.tick();
			}else{
				menu.tick();
			}
		}
		
		map.tick();
	}
	
	public void render(Graphics g){
		map.render(g);
		
		if(paused){
			if(!escape){
				menu.render(g);
			}else{
				esc.render(g);
			}
		}
	}
}