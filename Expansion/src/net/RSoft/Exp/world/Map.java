package net.RSoft.Exp.world;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

import net.RSoft.Exp.Component;
import net.RSoft.Exp.colony.ColonyMain;

public class Map {
	public final int WIDTH, HEIGHT, SCALE;
	
	public Biome[] maparr;
	public BufferedImage map;
	
	public Biome[] biomes = {Biome.PLAINS, Biome.DESERT, Biome.FOREST};
	
	public ColonyMain cm;
	
	public Map(int width, int height, int scale, int type){
		WIDTH = width/scale;
		HEIGHT = height/scale;
		SCALE = scale;
		
		maparr = generate(type);
		map = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_3BYTE_BGR);
		
		cm = new ColonyMain(WIDTH, HEIGHT, SCALE);
	}
	
	public Biome[] generate(int type){
		int[] temp = new int[WIDTH*HEIGHT];
		Biome[] finTemp = new Biome[WIDTH*HEIGHT];
		
		int seed = new Random().nextInt(22)+new Random().nextInt(11)+9/SCALE, cool = (new Random().nextInt(5285)+55)/SCALE;
		while(seed > 0){
			for(int i=0;i<temp.length;i++){
				if(seed>0 && new Random().nextInt(50) <= 4 && temp[i] != 26){
					if(cool <= 0){
						temp[i] = 26;
						cool = 350;
						seed--;
						for(int o=0;o<19;o++){
							int x = new Random().nextInt(53)+2,
								y = new Random().nextInt(53)+2;
							
							if(new Random().nextInt(2) == 1){
								if(new Random().nextInt(2) == 1){
									if(i+x+(y*WIDTH)<temp.length){
										temp[i+x+(y*WIDTH)] = new Random().nextInt(new Random().nextInt(15)+3)+9;
									}
								}else{
									if(i+x-(y*WIDTH)<temp.length && i+x-(y*WIDTH) >= 0){
										temp[i+x-(y*WIDTH)] = new Random().nextInt(new Random().nextInt(15)+3)+9;
									}
								}
							}else{
								if(new Random().nextInt(2) == 1){
									if(i-x+(y*WIDTH)<temp.length && i-x+(y*WIDTH) >= 0){
										temp[i-x+(y*WIDTH)] = new Random().nextInt(new Random().nextInt(15)+3)+9;
									}
								}else{
									if(i-x-(y*WIDTH)<temp.length && i-x-(y*WIDTH) >= 0){
										temp[i-x-(y*WIDTH)] = new Random().nextInt(new Random().nextInt(15)+3)+9;
									}
								}
							}
						}
					}else{
						cool--;
						if(temp[i] != 26){
							temp[i] = 0;
						}
					}
				}else if(temp[i] != 26){
					temp[i] = 0;
				}
			}
		}
		
		for(int j=0;j<47;j++){
			for(int i=0;i<temp.length;i++){
				if(temp[i] != 0){
					switch(new Random().nextInt(9)){
					case 0:
						if(i-1 >= 0 && temp[i-1] == 0){
							temp[i-1] = temp[i]-1;
						}
						break;
					case 1:
						if(i+WIDTH < temp.length && temp[i+WIDTH] == 0){
							temp[i+WIDTH] = temp[i]-1;
						}
						break;
					case 2:
						if(i-WIDTH >= 0 && temp[i-WIDTH] == 0){
							temp[i-WIDTH] = temp[i]-1;
						}
						break;
					case 3:
						if(i+1 < temp.length && temp[i+1] == 0){
							temp[i+1] = temp[i]-1;
						}
						break;
					case 4:
						if(i-WIDTH >= 0 && temp[i-WIDTH] == 0){
							temp[i-WIDTH] = temp[i]-1;
						}
						break;
					case 5:
						if(i+1 < temp.length && temp[i+1] == 0){
							temp[i+1] = temp[i]-1;
						}
						break;
					case 6:
						if(i-WIDTH >= 0 && temp[i-WIDTH] == 0){
							temp[i-WIDTH] = temp[i]-1;
						}
						break;
					case 7:
						if(i-WIDTH >= 0 && temp[i-WIDTH] == 0){
							temp[i-WIDTH] = temp[i]-1;
						}
						break;
					case 8:
						if(i-1 >= 0 && temp[i-1] == 0){
							temp[i-1] = temp[i]-1;
						}
						break;
					}
				}
			}
		}
		
		for(int i=0;i<temp.length;i++){
			if(temp[i] != 0){
				if(type == 3){
					finTemp[i] = Biome.PLAINS;
				}else{
					finTemp[i] = biomes[type];
				}
			}else{
				finTemp[i] = Biome.OCEAN;
			}
		}
		
		if(type == 3){
			for(int i=0;i<temp.length;i++){
				if(temp[i] != 0){
					temp[i] = 0;
				}else{
					temp[i] = -1;
				}
			}
			
			seed = new Random().nextInt(3*(Component.com.game.menu.bsa.type+1))+2;
			
			while(seed>0){
				int r = new Random().nextInt(WIDTH*HEIGHT);
				
				if(temp[r] == 0){
					temp[r] = new Random().nextInt(34)+13;
					seed--;
				}
			}
			
			for(int j=0;j<60;j++){
				for(int i=0;i<temp.length;i++){
					if(temp[i] != -1 && temp[i] != 0){
						switch(new Random().nextInt(9)){
						case 0:
							if(i-1 >= 0 && temp[i-1] == 0){
								temp[i-1] = temp[i]-1;
							}
							break;
						case 1:
							if(i+WIDTH < temp.length && temp[i+WIDTH] == 0){
								temp[i+WIDTH] = temp[i]-1;
							}
							break;
						case 2:
							if(i-WIDTH >= 0 && temp[i-WIDTH] == 0){
								temp[i-WIDTH] = temp[i]-1;
							}
							break;
						case 3:
							if(i+1 < temp.length && temp[i+1] == 0){
								temp[i+1] = temp[i]-1;
							}
							break;
						case 4:
							if(i-WIDTH >= 0 && temp[i-WIDTH] == 0){
								temp[i-WIDTH] = temp[i]-1;
							}
							break;
						case 5:
							if(i+1 < temp.length && temp[i+1] == 0){
								temp[i+1] = temp[i]-1;
							}
							break;
						case 6:
							if(i-WIDTH >= 0 && temp[i-WIDTH] == 0){
								temp[i-WIDTH] = temp[i]-1;
							}
							break;
						case 7:
							if(i-WIDTH >= 0 && temp[i-WIDTH] == 0){
								temp[i-WIDTH] = temp[i]-1;
							}
							break;
						case 8:
							if(i-1 >= 0 && temp[i-1] == 0){
								temp[i-1] = temp[i]-1;
							}
							break;
						}
					}
				}
			}
			
			for(int i=0;i<temp.length;i++){
				if(temp[i] != -1 && temp[i] != 0){
					finTemp[i] = Biome.DESERT;
				}
			}
			
			for(int i=0;i<temp.length;i++){
				if(temp[i] != 0){
					temp[i] = 0;
				}else{
					temp[i] = -1;
				}
			}
			
			seed = new Random().nextInt(3*(Component.com.game.menu.bsa.type+1))+2;
			
			while(seed>0){
				int r = new Random().nextInt(WIDTH*HEIGHT);
				
				if(temp[r] == 0){
					temp[r] = new Random().nextInt(13)+8;
					seed--;
				}
			}
			
			for(int j=0;j<60;j++){
				for(int i=0;i<temp.length;i++){
					if(temp[i] != -1 && temp[i] != 0){
						switch(new Random().nextInt(9)){
						case 0:
							if(i-1 >= 0 && temp[i-1] == 0){
								temp[i-1] = temp[i]-1;
							}
							break;
						case 1:
							if(i+WIDTH < temp.length && temp[i+WIDTH] == 0){
								temp[i+WIDTH] = temp[i]-1;
							}
							break;
						case 2:
							if(i-WIDTH >= 0 && temp[i-WIDTH] == 0){
								temp[i-WIDTH] = temp[i]-1;
							}
							break;
						case 3:
							if(i+1 < temp.length && temp[i+1] == 0){
								temp[i+1] = temp[i]-1;
							}
							break;
						case 4:
							if(i-WIDTH >= 0 && temp[i-WIDTH] == 0){
								temp[i-WIDTH] = temp[i]-1;
							}
							break;
						case 5:
							if(i+1 < temp.length && temp[i+1] == 0){
								temp[i+1] = temp[i]-1;
							}
							break;
						case 6:
							if(i-WIDTH >= 0 && temp[i-WIDTH] == 0){
								temp[i-WIDTH] = temp[i]-1;
							}
							break;
						case 7:
							if(i-WIDTH >= 0 && temp[i-WIDTH] == 0){
								temp[i-WIDTH] = temp[i]-1;
							}
							break;
						case 8:
							if(i-1 >= 0 && temp[i-1] == 0){
								temp[i-1] = temp[i]-1;
							}
							break;
						}
					}
				}
			}
			
			for(int i=0;i<temp.length;i++){
				if(temp[i] != -1 && temp[i] != 0){
					finTemp[i] = Biome.FOREST;
				}
			}
		}
		
		return finTemp;
	}
	
	public boolean isLand(int place){
		if(place >= 0 && place < maparr.length){
			if(maparr[place] != Biome.OCEAN){
				return true;
			}
		}
		
		return false;
	}
	
	public boolean isLand(int x, int y){
		if(y*WIDTH+x >= 0 && y*WIDTH+x < maparr.length){
			if(maparr[y*WIDTH+x] != Biome.OCEAN){
				return true;
			}
		}
		
		return false;
	}
	
	public Biome tileOn(int place){
		return maparr[place];
	}
	
	public void tick(){
		for(int i=0;i<maparr.length;i++){
			map.setRGB(i%WIDTH, (i-(i%WIDTH))/WIDTH, maparr[i].color());
		}
		
		cm.tick();
		
		for(int i=0;i<cm.colarr.length;i++){
			if(cm.colarr[i].color != -1){
				map.setRGB(i%WIDTH, (i-(i%WIDTH))/WIDTH, cm.colarr[i].color);
			}
		}
	}
	
	public void render(Graphics g){
		g.drawImage(map, 0, 0, WIDTH*SCALE, HEIGHT*SCALE, null);
	}
}