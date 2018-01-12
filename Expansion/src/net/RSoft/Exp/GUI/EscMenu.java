package net.RSoft.Exp.GUI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import net.RSoft.Exp.Component;
import net.RSoft.Exp.Button.EnsureMap;
import net.RSoft.Exp.Button.OpenMap;
import net.RSoft.Exp.Button.SaveMap;
import net.RSoft.Exp.Button.StopOperation;

public class EscMenu extends Rectangle{
	private static final long serialVersionUID = 1L;
	
	public boolean failopen = false;
	
	private BufferedImage typingBar;
	
	public CharList savemapnm = new CharList("", 148, 78, 50),
					name = new CharList("Name:", 120, 42, 20),
					openmapnm = new CharList("", 148, 190, 50),
					name2 = new CharList("Name:", 120, 154, 20),
					fail = new CharList("File not found", 124, 260, 40);
	
	public SaveMap smp;
	public OpenMap opm;
	public EnsureMap clm, imm;
	public StopOperation sts, sto;

	public EscMenu(int width, int height){
		this.width = width;
		this.height = height;
		
		try{
			typingBar = ImageIO.read(new File("res/TypingBar.png"));
		}catch(Exception e){ }
		
		smp = new SaveMap(20, 46, 96, 96, 12, 12, "SaveMap");
		opm = new OpenMap(20, 158, 96, 96, 12, 12, "OpenMap");
		clm = new EnsureMap(20, 46, 96, 96, 12, 12, "EnsureMap");
		imm = new EnsureMap(20, 158, 96, 96, 12, 12, "EnsureMap");
		sts = new StopOperation(692, 46, 96, 96, 12, 12, "StopOperation");
		sto = new StopOperation(692, 158, 96, 96, 12, 12, "StopOperation");
	}
	
	public void tick(){
		if(!Component.com.game.typing && !Component.com.game.saving && !Component.com.game.opening){
			smp.tick();
			opm.tick();
		}
		
		if(Component.com.game.typing){
			if(Component.com.game.saving){
				savemapnm.str = Component.com.game.typeStr;
				clm.tick();
				sts.tick();
			}else if(Component.com.game.opening){
				openmapnm.str = Component.com.game.typeStr;
				imm.tick();
				sto.tick(); 
			}
		}
	}
	
	public void render(Graphics g){
		g.setColor(new Color(0, 0, 0, 100));
		g.fillRect(0, 0, width, height);
		
		if(!Component.com.game.saving){
			smp.render(g);
		}else{
			opm.state = 1;
			opm.render(g);
		}
		
		if(!Component.com.game.opening){
			opm.render(g);
		}else{
			smp.state = 1;
			smp.render(g);
		}
		
		if(Component.com.game.typing){
			if(Component.com.game.saving){
				g.drawImage(typingBar, 116, 62, 576, 80, null);
				CharList.drawList(g, savemapnm);
				CharList.drawList(g, name);
				clm.render(g);
				sts.render(g);
			}else if(Component.com.game.opening){
				g.drawImage(typingBar, 116, 174, 576, 80, null);
				CharList.drawList(g, openmapnm);
				CharList.drawList(g, name2);
				imm.render(g);
				sto.render(g);
			}
		}
		
		if(failopen){
			CharList.drawList(g, fail);
		}
	}
}