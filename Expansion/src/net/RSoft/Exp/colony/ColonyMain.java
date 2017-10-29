package net.RSoft.Exp.colony;

import net.RSoft.Exp.Component;

public class ColonyMain {
	
	public int[] colonies = {0x573AFF, 0xFF4215, 0x88FBBE, 0xB846A1};
	public int colIndex = 0;
	
	public final int WIDTH, HEIGHT, SCALE;
	public Colonist[] colarr;
	
	public ColonyMain(int width, int height, int scale){
		WIDTH = width;
		HEIGHT = height;
		SCALE = scale;
		
		colarr = new Colonist[WIDTH*HEIGHT];
		
		for(int i=0;i<colarr.length;i++){
			colarr[i] = new Colonist();
		}
	}
	
	public void clear(){
		for(int i=0;i<colarr.length;i++){
			colarr[i] = new Colonist();
		}
	}
	
	public void tick(){
		if(Component.com.game.paused){
			if((Component.com.ms.released || Component.com.ms.held) && !Component.com.ms.pressBut){
				int[] xy = Component.com.ms.getXY();
				xy[0] = (int) Math.floor(xy[0] / SCALE);
				xy[1] = (int) Math.floor(xy[1] / SCALE);
				
				if(Component.com.game.map.isLand(xy[0], xy[1])){
					colarr[xy[1]*WIDTH+xy[0]] = new Colonist(colonies[colIndex], xy[1]*WIDTH+xy[0]);
				}
			}
		}else{
			for(int i=0;i<colarr.length;i++){
				if(colarr[i].color != -1){
					colarr[i].ticked = false;
				}
			}
			
			for(int i=0;i<colarr.length;i++){
				if(colarr[i].color != -1 && !colarr[i].ticked){
					colarr[i].tick();
				}
			}
			
			for(int i=0;i<colarr.length;i++){
				if(colarr[i].color != -1 && !colarr[i].alive){
					colarr[i] = new Colonist();
				}
			}
		}
	}
}