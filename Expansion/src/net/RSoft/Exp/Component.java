package net.RSoft.Exp;

import java.awt.*;

import javax.swing.JFrame;

public class Component extends JFrame implements Runnable {
	private static final long serialVersionUID = 1L;
	
	public boolean isRunning = false, inGame = true;
	public static final String NAME = "Empire_2.0";
	public static final int WIDTH = 1280, HEIGHT = 720, SCALE = 6;
	
	private Image scr;
	private Thread thread;
	public static Component com;
	
	public Game game;
	public Cursor ms;
	
	public Component(){
		thread = new Thread(this);
		
		game = new Game(WIDTH, HEIGHT, SCALE);
		ms = new Cursor();
		
		addKeyListener(new InputHandler());
		addMouseListener(ms);
		
		setSize(WIDTH, HEIGHT);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setTitle(NAME);
		
		start();
	}
	
	public static void main(String args[]){
		com = new Component();
	}
	
	public void start(){
		isRunning = true;
		thread.start();
	}
	
	public void tick(){
		ms.tick();
		
		if(inGame){
			game.tick();
		}
	}
	
	public void render(){
		Graphics g = scr.getGraphics();
		
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		if(inGame){
			game.render(g);
		}
		
		g = getGraphics();
		//x = 3, y = 26
		g.drawImage(scr, 0, 0, WIDTH, HEIGHT, null);
		g.dispose();
	}
	
	public void run() {
		scr = createVolatileImage(WIDTH, HEIGHT);
		
		while(isRunning){
			tick();
			render();
			
			try{
				Thread.sleep(20);
			}catch(Exception e){ }
		}
	}
}