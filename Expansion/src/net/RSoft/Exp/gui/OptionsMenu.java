package net.RSoft.Exp.gui;

import java.awt.*;

import net.RSoft.Exp.Component;
import net.RSoft.Exp.button.*;

public class OptionsMenu extends Rectangle{
	private static final long serialVersionUID = 1L;
	
	private int bx;
	
	public int state = 0;
	public boolean moving = false;
	
	public Rectangle color;
	
	public ExpandButton exB;
	
	public NewMapS nms;
	public NewMapM nmm;
	public NewMapL nml;
	
	public GenAmt gmt;
	public Randomize rdm;
	public Clear clr;
	
	public BiomeType bmt;
	public BiomeSeedsAmt bsa;
	
	public OptionsMenu(int x, int y){
		this.x = x;
		this.y = y;
		bx = x;
		
		width = 56;
		height = 691;
		
		color = new Rectangle(x+4, y+639, 48, 48);
		
		exB = new ExpandButton(x-24, y, 24, 108, 6, 27, "ExpandButton");
		
		nms = new NewMapS(x+4, y+8, 48, 48, 12, 12, "MapSmall");
		nmm = new NewMapM(x+4, y+64, 48, 48, 12, 12, "MapMed");
		nml = new NewMapL(x+4, y+120, 48, 48, 12, 12, "MapLarge");
		
		gmt = new GenAmt(x+4, y+184, 48, 48, 12, 12, "GenAmt");
		rdm = new Randomize(x+4, y+240, 48, 48, 12, 12, "Randomize");
		clr = new Clear(x+4, y+296, 48, 48, 12, 12, "Clear");
		
		bmt = new BiomeType(x+4, y+360, 48, 48, 12, 12, "BiomeType");
		bsa = new BiomeSeedsAmt(x+4, y+424, 48, 48, 12, 12, "BiomeSeedsAmt");
	}
	
	public void matchXY(Rectangle r, int xOff, int yOff){
		r.x = x+xOff;
		r.y = y+yOff;
	}
	
	public void moveOut(){
		if(!moving){
			moving = true;
		}else{
			x-=2;
			
			if(x <= bx-width){
				x = bx-width;
				moving = false;
				state = exB.type;
			}
		}
	}
	
	public void moveIn(){
		if(!moving){
			moving = true;
		}else{
			x+=2;
			
			if(x >= bx){
				x = bx;
				moving = false;
				state = exB.type;
			}
		}
	}
	
	public void tick(){
		if(state != exB.type){
			if(exB.type == 1){
				moveOut();
			}else{
				moveIn();
			}
		}
		
		exB.tick();
		
		nms.tick();
		nmm.tick();
		nml.tick();
		
		gmt.tick();
		rdm.tick();
		clr.tick();
		
		bmt.tick();
		bsa.tick();
		
		matchXY(color, 4, 639);
		
		matchXY(exB, -24, 0);
		
		matchXY(nms, 4, 8);
		matchXY(nmm, 4, 64);
		matchXY(nml, 4, 120);
		
		matchXY(gmt, 4, 184);
		matchXY(rdm, 4, 240);
		matchXY(clr, 4, 296);
		
		matchXY(bmt, 4, 360);
		matchXY(bsa, 4, 416);
	}
	
	public void render(Graphics g){
		g.setColor(new Color(60, 60, 60));
		g.fillRect(x, y, width, height);
		
		g.setColor(new Color(Component.com.game.map.cm.colonies[Component.com.game.map.cm.colIndex]));
		g.fillRect(color.x, color.y, color.width, color.height);
		
		exB.render(g);
		
		nms.render(g);
		nmm.render(g);
		nml.render(g);
		
		gmt.render(g);
		rdm.render(g);
		clr.render(g);
		
		bmt.render(g);
		bsa.render(g);
	}
}