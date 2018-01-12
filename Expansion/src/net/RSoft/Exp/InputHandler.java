package net.RSoft.Exp;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InputHandler implements KeyListener {
	
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		if(Component.com.game.typing){
			switch(key){
			case KeyEvent.VK_SHIFT:
				Component.com.game.shifting = true;
				break;
			}
		}
	}
	
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		
		if(!Component.com.game.typing){
			switch(key){
			case KeyEvent.VK_SPACE:
				if(!Component.com.game.escape){
					if(Component.com.game.paused){
						Component.com.game.paused = false;
					}else{
						Component.com.game.paused = true;
					}
				}
				break;
			case KeyEvent.VK_ESCAPE:
				if(!Component.com.game.edit){
					if(!Component.com.game.escape){
						Component.com.game.paused = true;
						Component.com.game.escape = true;
					}else{
						if(Component.com.game.esc.failopen){
							Component.com.game.esc.failopen = false;
						}
						Component.com.game.escape = false;
					}
				}
				break;
			}
		}else{
			if(Component.com.game.typeStr.endsWith("_")){
				Component.com.game.typeStr = Component.com.game.typeStr.substring(0, Component.com.game.typeStr.length()-1);
			}
			
			switch(key){
			case KeyEvent.VK_A:
				if(Component.com.game.shifting){
					if(Component.com.game.typeStr.length() < 10) Component.com.game.typeStr += "A";
				}else{
					if(Component.com.game.typeStr.length() < 10) Component.com.game.typeStr += "a";
				}
				break;
			case KeyEvent.VK_B:
				if(Component.com.game.shifting){
					if(Component.com.game.typeStr.length() < 10) Component.com.game.typeStr += "B";
				}else{
					if(Component.com.game.typeStr.length() < 10) Component.com.game.typeStr += "b";
				}
				break;
			case KeyEvent.VK_C:
				if(Component.com.game.shifting){
					if(Component.com.game.typeStr.length() < 10) Component.com.game.typeStr += "C";
				}else{
					if(Component.com.game.typeStr.length() < 10) Component.com.game.typeStr += "c";
				}
				break;
			case KeyEvent.VK_D:
				if(Component.com.game.shifting){
					if(Component.com.game.typeStr.length() < 10) Component.com.game.typeStr += "D";
				}else{
					if(Component.com.game.typeStr.length() < 10) Component.com.game.typeStr += "d";
				}
				break;
			case KeyEvent.VK_E:
				if(Component.com.game.shifting){
					if(Component.com.game.typeStr.length() < 10) Component.com.game.typeStr += "E";
				}else{
					if(Component.com.game.typeStr.length() < 10) Component.com.game.typeStr += "e";
				}
				break;
			case KeyEvent.VK_F:
				if(Component.com.game.shifting){
					if(Component.com.game.typeStr.length() < 10) Component.com.game.typeStr += "F";
				}else{
					if(Component.com.game.typeStr.length() < 10) Component.com.game.typeStr += "f";
				}
				break;
			case KeyEvent.VK_G:
				if(Component.com.game.shifting){
					if(Component.com.game.typeStr.length() < 10) Component.com.game.typeStr += "G";
				}else{
					if(Component.com.game.typeStr.length() < 10) Component.com.game.typeStr += "g";
				}
				break;
			case KeyEvent.VK_H:
				if(Component.com.game.shifting){
					if(Component.com.game.typeStr.length() < 10) Component.com.game.typeStr += "H";
				}else{
					if(Component.com.game.typeStr.length() < 10) Component.com.game.typeStr += "h";
				}
				break;
			case KeyEvent.VK_I:
				if(Component.com.game.shifting){
					if(Component.com.game.typeStr.length() < 10) Component.com.game.typeStr += "I";
				}else{
					if(Component.com.game.typeStr.length() < 10) Component.com.game.typeStr += "i";
				}
				break;
			case KeyEvent.VK_J:
				if(Component.com.game.shifting){
					if(Component.com.game.typeStr.length() < 10) Component.com.game.typeStr += "J";
				}else{
					if(Component.com.game.typeStr.length() < 10) Component.com.game.typeStr += "j";
				}
				break;
			case KeyEvent.VK_K:
				if(Component.com.game.shifting){
					if(Component.com.game.typeStr.length() < 10) Component.com.game.typeStr += "K";
				}else{
					if(Component.com.game.typeStr.length() < 10) Component.com.game.typeStr += "k";
				}
				break;
			case KeyEvent.VK_L:
				if(Component.com.game.shifting){
					if(Component.com.game.typeStr.length() < 10) Component.com.game.typeStr += "L";
				}else{
					if(Component.com.game.typeStr.length() < 10) Component.com.game.typeStr += "l";
				}
				break;
			case KeyEvent.VK_M:
				if(Component.com.game.shifting){
					if(Component.com.game.typeStr.length() < 10) Component.com.game.typeStr += "M";
				}else{
					if(Component.com.game.typeStr.length() < 10) Component.com.game.typeStr += "m";
				}
				break;
			case KeyEvent.VK_N:
				if(Component.com.game.shifting){
					if(Component.com.game.typeStr.length() < 10) Component.com.game.typeStr += "N";
				}else{
					if(Component.com.game.typeStr.length() < 10) Component.com.game.typeStr += "n";
				}
				break;
			case KeyEvent.VK_O:
				if(Component.com.game.shifting){
					if(Component.com.game.typeStr.length() < 10) Component.com.game.typeStr += "O";
				}else{
					if(Component.com.game.typeStr.length() < 10) Component.com.game.typeStr += "o";
				}
				break;
			case KeyEvent.VK_P:
				if(Component.com.game.shifting){
					if(Component.com.game.typeStr.length() < 10) Component.com.game.typeStr += "P";
				}else{
					if(Component.com.game.typeStr.length() < 10) Component.com.game.typeStr += "p";
				}
				break;
			case KeyEvent.VK_Q:
				if(Component.com.game.shifting){
					if(Component.com.game.typeStr.length() < 10) Component.com.game.typeStr += "Q";
				}else{
					if(Component.com.game.typeStr.length() < 10) Component.com.game.typeStr += "q";
				}
				break;
			case KeyEvent.VK_R:
				if(Component.com.game.shifting){
					if(Component.com.game.typeStr.length() < 10) Component.com.game.typeStr += "R";
				}else{
					if(Component.com.game.typeStr.length() < 10) Component.com.game.typeStr += "r";
				}
				break;
			case KeyEvent.VK_S:
				if(Component.com.game.shifting){
					if(Component.com.game.typeStr.length() < 10) Component.com.game.typeStr += "S";
				}else{
					if(Component.com.game.typeStr.length() < 10) Component.com.game.typeStr += "s";
				}
				break;
			case KeyEvent.VK_T:
				if(Component.com.game.shifting){
					if(Component.com.game.typeStr.length() < 10) Component.com.game.typeStr += "T";
				}else{
					if(Component.com.game.typeStr.length() < 10) Component.com.game.typeStr += "t";
				}
				break;
			case KeyEvent.VK_U:
				if(Component.com.game.shifting){
					if(Component.com.game.typeStr.length() < 10) Component.com.game.typeStr += "U";
				}else{
					if(Component.com.game.typeStr.length() < 10) Component.com.game.typeStr += "u";
				}
				break;
			case KeyEvent.VK_V:
				if(Component.com.game.shifting){
					if(Component.com.game.typeStr.length() < 10) Component.com.game.typeStr += "V";
				}else{
					if(Component.com.game.typeStr.length() < 10) Component.com.game.typeStr += "v";
				}
				break;
			case KeyEvent.VK_W:
				if(Component.com.game.shifting){
					if(Component.com.game.typeStr.length() < 10) Component.com.game.typeStr += "W";
				}else{
					if(Component.com.game.typeStr.length() < 10) Component.com.game.typeStr += "w";
				}
				break;
			case KeyEvent.VK_X:
				if(Component.com.game.shifting){
					if(Component.com.game.typeStr.length() < 10) Component.com.game.typeStr += "X";
				}else{
					if(Component.com.game.typeStr.length() < 10) Component.com.game.typeStr += "x";
				}
				break;
			case KeyEvent.VK_Y:
				if(Component.com.game.shifting){
					if(Component.com.game.typeStr.length() < 10) Component.com.game.typeStr += "Y";
				}else{
					if(Component.com.game.typeStr.length() < 10) Component.com.game.typeStr += "y";
				}
				break;
			case KeyEvent.VK_Z:
				if(Component.com.game.shifting){
					if(Component.com.game.typeStr.length() < 10) Component.com.game.typeStr += "Z";
				}else{
					if(Component.com.game.typeStr.length() < 10) Component.com.game.typeStr += "z";
				}
				break;
			case KeyEvent.VK_SPACE:
				if(Component.com.game.typeStr.length() < 10) Component.com.game.typeStr += " ";
				break;
			case KeyEvent.VK_BACK_SPACE:
				if(Component.com.game.typeStr.length() > 0) Component.com.game.typeStr = Component.com.game.typeStr.substring(0, Component.com.game.typeStr.length()-1);
				break;
			case KeyEvent.VK_SHIFT:
				Component.com.game.shifting = false;
				break;
			}
			
			if(Component.com.game.typeStr.length() < 10){
				Component.com.game.typeStr += "_";
			}
		}
	}
	
	public void keyTyped(KeyEvent e) {
		
	}
}
