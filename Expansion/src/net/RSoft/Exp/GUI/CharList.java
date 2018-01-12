package net.RSoft.Exp.GUI;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class CharList extends Rectangle{
	private static final long serialVersionUID = 1L;
	
	private static final int TILEWIDTH = 7, TILEHEIGHT = 8;
	private int scale = 0;
	private static String[] index = {"ABCDEFGHIJKLMNOPQRSTUVWXYZ",
									 "abcdefghijklmnopqrstuvwxyz",
									 "0123456789':;/-.,_"};
	
	public String str;
	
	private static BufferedImage font;
	
	public CharList(String str, int x, int y, int scale){
		this.str = str;
		this.scale = scale;
		
		this.x = x;
		this.y = y;
		width = str.length()*scale;
		height = scale;
		
		try{
			font = ImageIO.read(new File("res/Font.png"));
		}catch(Exception e){ }
	}
	
	public static void update(String upd, CharList cls){
		cls.str = upd;
		cls.width = cls.str.length()*cls.scale;
	}
	
	public static void drawList(Graphics g, CharList cls){
		for(int i=0;i<cls.str.length();i++){
			for(int x=0;x<index.length;x++){
				for(int y=0;y<index[x].length();y++){
					if(cls.str.charAt(i) == index[x].charAt(y)){
						g.drawImage(font, cls.x+cls.scale*i, cls.y, (cls.x+cls.scale*i)+cls.scale, cls.y+cls.scale, TILEWIDTH*y, x*TILEHEIGHT, TILEWIDTH*y+TILEWIDTH, x*TILEHEIGHT+TILEHEIGHT, null);
					}
				}
			}
		}
	}
}
