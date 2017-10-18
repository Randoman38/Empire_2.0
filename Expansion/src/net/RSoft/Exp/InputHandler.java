package net.RSoft.Exp;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InputHandler implements KeyListener {
	
	public void keyPressed(KeyEvent e) {
		
	}
	
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		
		switch(key){
		case KeyEvent.VK_SPACE:
			if(Component.com.game.paused){
				Component.com.game.paused = false;
			}else{
				Component.com.game.paused = true;
			}
			break;
		}
	}
	
	public void keyTyped(KeyEvent e) {
		
	}
}
