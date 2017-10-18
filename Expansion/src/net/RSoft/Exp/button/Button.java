package net.RSoft.Exp.button;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import net.RSoft.Exp.Component;

public abstract class Button extends Rectangle{
	private static final long serialVersionUID = 1L;
	
	public int tw, th;
	public int state = 0, type = 0;
	
	public BufferedImage img;
	
	public Button(int x, int y, int width, int height, int tw, int th, String id){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.tw = tw;
		this.th = th;
		
		try{
			img = ImageIO.read(new File("res/" + id + ".png"));
		}catch(Exception e){ }
	}
	
	public abstract void onPress();
	public abstract void cusTick();
	
	public void tick(){
		cusTick();
		
			if(contains(Component.com.ms)){
				if(!Component.com.ms.pressBut && Component.com.ms.released){
					Component.com.ms.pressBut = true;
					//System.out.println("eb");
					onPress();
				}
			}
	}
	
	public void render(Graphics g){
		g.drawImage(img, x, y, x+width, y+height, tw*type, th*state, tw*type+tw, th*state+th, null);
	}
}