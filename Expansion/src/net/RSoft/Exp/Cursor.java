package net.RSoft.Exp;

import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Cursor extends Point implements MouseListener{
	private static final long serialVersionUID = 1L;
	
	public boolean held = false, released = false, pressBut = false;
	private int count = 1;

	public Cursor(){
		
	}
	
	public int[] getXY(){ return new int[] {x, y}; }
	
	public void tick(){
		x = MouseInfo.getPointerInfo().getLocation().x - Component.com.getX();
		y = MouseInfo.getPointerInfo().getLocation().y - Component.com.getY();
		//System.out.println(x + ", " + y);
		
		if(count <= 0){
			count = 1;
			released = false;
			pressBut = false;
		}else if(released && count > 0){
			count--;
		}
	}
	
	public void mousePressed(MouseEvent e) {
		int button = e.getButton();
		
		if(button == MouseEvent.BUTTON1){
			held = true;
		}
	}

	public void mouseReleased(MouseEvent e) {
		int button = e.getButton();
		
		if(Component.com.game.esc.failopen){
			Component.com.game.esc.failopen = false;
		}
		
		if(button == MouseEvent.BUTTON1){
			held = false;
			released = true;
		}else if(button == MouseEvent.BUTTON3){
			if(!Component.com.game.edit){
				Component.com.game.map.cm.colIndex++;
				
				if(Component.com.game.map.cm.colIndex >= Component.com.game.map.cm.colonies.length){
					Component.com.game.map.cm.colIndex = 0;
				}
			}else{
				Component.com.game.map.biomeIndex++;
				
				if(Component.com.game.map.biomeIndex >= Component.com.game.map.biomesComp.length){
					Component.com.game.map.biomeIndex = 0;
				}
			}
		}
	}
	
	public void mouseClicked(MouseEvent e) {
		
	}
	
	public void mouseEntered(MouseEvent e) {
		
	}
	
	public void mouseExited(MouseEvent e) {
		
	}
}