package net.RSoft.Exp.Colony;

import java.util.Random;

import net.RSoft.Exp.Component;
import net.RSoft.Exp.World.Biome;

public class Colonist {
	
	public int color, place;
	public int strength, age = 0, repMax, rep = 0;
	
	public boolean alive = true, ticked = false, diseased = false, onSea = false;
	public int seaDir = -1;
	
	public Colonist(int color, int place, int strength, boolean diseased){
		this.color = color;
		this.place = place;
		this.repMax = new Random().nextInt(13)+new Random().nextInt(7)+2;
		this.diseased = diseased;
		
		if(strength > 63){
			this.strength = 51;
		}else{
			this.strength = strength;
		}
	}
	
	public Colonist(Colonist c, int place){
		color = c.color;
		strength = c.strength;
		age = c.age;
		repMax = c.repMax;
		rep = c.rep;
		onSea = c.onSea;
		seaDir = c.seaDir;
		
		this.place = place;
	}
	
	public Colonist(int c, int place){
		color = c;
		this.place = place;
		
		strength = new Random().nextInt(35)+new Random().nextInt(27)+3;
		repMax = new Random().nextInt(13)+new Random().nextInt(7)+2;
	}
	
	public Colonist(){
		color = -1;
		alive = false;
	}
	
	public void move(){
		ticked = true;
		if(Component.com.game.map.isLand(place)){
			onSea = false;
		}
		
		if(!onSea){
			int r = new Random().nextInt(4);
			
			switch(r){
			case 0:
				if(place-Component.com.game.map.cm.WIDTH >= 0){
					if(Component.com.game.map.isLand(place-Component.com.game.map.cm.WIDTH)){
						if(!Component.com.game.map.cm.colarr[place-Component.com.game.map.cm.WIDTH].alive){
							Component.com.game.map.cm.colarr[place-Component.com.game.map.cm.WIDTH] = new Colonist(this, place-Component.com.game.map.cm.WIDTH);
							alive = false;
						}else{
							if(Component.com.game.map.cm.colarr[place-Component.com.game.map.cm.WIDTH].color != color){
								if(strength > Component.com.game.map.cm.colarr[place-Component.com.game.map.cm.WIDTH].strength){
									Component.com.game.map.cm.colarr[place-Component.com.game.map.cm.WIDTH] = new Colonist(this, place-Component.com.game.map.cm.WIDTH);
									alive = false;
								}else{
									alive = false;
								}
							}
						}
					}else if(new Random().nextInt(500) < 1){
						seaDir = 0;
						onSea = true;
						
						if(!Component.com.game.map.cm.colarr[place-Component.com.game.map.cm.WIDTH].alive){
							Component.com.game.map.cm.colarr[place-Component.com.game.map.cm.WIDTH] = new Colonist(this, place-Component.com.game.map.cm.WIDTH);
							alive = false;
						}else{
							if(Component.com.game.map.cm.colarr[place-Component.com.game.map.cm.WIDTH].color != color){
								if(strength > Component.com.game.map.cm.colarr[place-Component.com.game.map.cm.WIDTH].strength){
									Component.com.game.map.cm.colarr[place-Component.com.game.map.cm.WIDTH] = new Colonist(this, place-Component.com.game.map.cm.WIDTH);
									alive = false;
								}else{
									alive = false;
								}
							}
						}
					}
				}
				break;
			case 1:
				if(place+Component.com.game.map.cm.WIDTH < Component.com.game.map.cm.colarr.length){
					if(Component.com.game.map.isLand(place+Component.com.game.map.cm.WIDTH)){
						if(!Component.com.game.map.cm.colarr[place+Component.com.game.map.cm.WIDTH].alive){
							Component.com.game.map.cm.colarr[place+Component.com.game.map.cm.WIDTH] = new Colonist(this, place+Component.com.game.map.cm.WIDTH);
							alive = false;
						}else{
							if(Component.com.game.map.cm.colarr[place+Component.com.game.map.cm.WIDTH].color != color){
								if(strength > Component.com.game.map.cm.colarr[place+Component.com.game.map.cm.WIDTH].strength){
									Component.com.game.map.cm.colarr[place+Component.com.game.map.cm.WIDTH] = new Colonist(this, place+Component.com.game.map.cm.WIDTH);
									alive = false;
								}else{
									alive = false;
								}
							}
						}
					}else if(new Random().nextInt(500) < 1){
						seaDir = 1;
						onSea = true;
						
						if(!Component.com.game.map.cm.colarr[place+Component.com.game.map.cm.WIDTH].alive){
							Component.com.game.map.cm.colarr[place+Component.com.game.map.cm.WIDTH] = new Colonist(this, place+Component.com.game.map.cm.WIDTH);
							alive = false;
						}else{
							if(Component.com.game.map.cm.colarr[place+Component.com.game.map.cm.WIDTH].color != color){
								if(strength > Component.com.game.map.cm.colarr[place+Component.com.game.map.cm.WIDTH].strength){
									Component.com.game.map.cm.colarr[place+Component.com.game.map.cm.WIDTH] = new Colonist(this, place+Component.com.game.map.cm.WIDTH);
									alive = false;
								}else{
									alive = false;
								}
							}
						}
					}
				}
				break;
			case 2:
				if(place+1 < Component.com.game.map.cm.colarr.length){
					if(Component.com.game.map.isLand(place+1)){
						if(!Component.com.game.map.cm.colarr[place+1].alive){
							Component.com.game.map.cm.colarr[place+1] = new Colonist(this, place+1);
							alive = false;
						}else{
							if(Component.com.game.map.cm.colarr[place+1].color != color){
								if(strength > Component.com.game.map.cm.colarr[place+1].strength){
									Component.com.game.map.cm.colarr[place+1] = new Colonist(this, place+1);
									alive = false;
								}else{
									alive = false;
								}
							}
						}
					}else if(new Random().nextInt(500) < 1){
						seaDir = 2;
						onSea = true;
						
						if(!Component.com.game.map.cm.colarr[place+1].alive){
							Component.com.game.map.cm.colarr[place+1] = new Colonist(this, place+1);
							alive = false;
						}else{
							if(Component.com.game.map.cm.colarr[place+1].color != color){
								if(strength > Component.com.game.map.cm.colarr[place+1].strength){
									Component.com.game.map.cm.colarr[place+1] = new Colonist(this, place+1);
									alive = false;
								}else{
									alive = false;
								}
							}
						}
					}
				}
				break;
			case 3:
				if(place-1 >= 0){
					if(Component.com.game.map.isLand(place-1)){
						if(!Component.com.game.map.cm.colarr[place-1].alive){
							Component.com.game.map.cm.colarr[place-1] = new Colonist(this, place-1);
							alive = false;
						}else{
							if(Component.com.game.map.cm.colarr[place-1].color != color){
								if(strength > Component.com.game.map.cm.colarr[place-1].strength){
									Component.com.game.map.cm.colarr[place-1] = new Colonist(this, place-1);
									alive = false;
								}else{
									alive = false;
								}
							}
						}
					}else if(new Random().nextInt(500) < 1){
						seaDir = 3;
						onSea = true;
						
						if(!Component.com.game.map.cm.colarr[place-1].alive){
							Component.com.game.map.cm.colarr[place-1] = new Colonist(this, place-1);
							alive = false;
						}else{
							if(Component.com.game.map.cm.colarr[place-1].color != color){
								if(strength > Component.com.game.map.cm.colarr[place-1].strength){
									Component.com.game.map.cm.colarr[place-1] = new Colonist(this, place-1);
									alive = false;
								}else{
									alive = false;
								}
							}
						}
					}
				}
				break;
			}
		}else{
			switch(seaDir){
			case 0:
				if(place-Component.com.game.map.cm.WIDTH >= 0){
					if(!Component.com.game.map.cm.colarr[place-Component.com.game.map.cm.WIDTH].alive){
						Component.com.game.map.cm.colarr[place-Component.com.game.map.cm.WIDTH] = new Colonist(this, place-Component.com.game.map.cm.WIDTH);
						alive = false;
					}else{
						if(Component.com.game.map.cm.colarr[place-Component.com.game.map.cm.WIDTH].color != color){
							if(strength > Component.com.game.map.cm.colarr[place-Component.com.game.map.cm.WIDTH].strength){
								Component.com.game.map.cm.colarr[place-Component.com.game.map.cm.WIDTH] = new Colonist(this, place-Component.com.game.map.cm.WIDTH);
								alive = false;
							}else{
								alive = false;
							}
						}
					}
				}
				break;
			case 1:
				if(place+Component.com.game.map.cm.WIDTH < Component.com.game.map.cm.colarr.length){
					if(!Component.com.game.map.cm.colarr[place+Component.com.game.map.cm.WIDTH].alive){
						Component.com.game.map.cm.colarr[place+Component.com.game.map.cm.WIDTH] = new Colonist(this, place+Component.com.game.map.cm.WIDTH);
						alive = false;
					}else{
						if(Component.com.game.map.cm.colarr[place+Component.com.game.map.cm.WIDTH].color != color){
							if(strength > Component.com.game.map.cm.colarr[place+Component.com.game.map.cm.WIDTH].strength){
								Component.com.game.map.cm.colarr[place+Component.com.game.map.cm.WIDTH] = new Colonist(this, place+Component.com.game.map.cm.WIDTH);
								alive = false;
							}else{
								alive = false;
							}
						}
					}
				}
				break;
			case 2:
				if(place+1 < Component.com.game.map.cm.colarr.length){
					if(!Component.com.game.map.cm.colarr[place+1].alive){
						Component.com.game.map.cm.colarr[place+1] = new Colonist(this, place+1);
						alive = false;
					}else{
						if(Component.com.game.map.cm.colarr[place+1].color != color){
							if(strength > Component.com.game.map.cm.colarr[place+1].strength){
								Component.com.game.map.cm.colarr[place+1] = new Colonist(this, place+1);
								alive = false;
							}else{
								alive = false;
							}
						}
					}
				}
				break;
			case 3:
				if(place-1 >= 0){
					if(!Component.com.game.map.cm.colarr[place-1].alive){
						Component.com.game.map.cm.colarr[place-1] = new Colonist(this, place-1);
						alive = false;
					}else{
						if(Component.com.game.map.cm.colarr[place-1].color != color){
							if(strength > Component.com.game.map.cm.colarr[place-1].strength){
								Component.com.game.map.cm.colarr[place-1] = new Colonist(this, place-1);
								alive = false;
							}else{
								alive = false;
							}
						}
					}
				}
				break;
			}
		}
	}
	
	public void reproduce(){
		int r = new Random().nextInt(4);
		
		switch(r){
		case 0:
			if(place-Component.com.game.map.cm.WIDTH >= 0 && Component.com.game.map.isLand(place-Component.com.game.map.cm.WIDTH)){
				if(!Component.com.game.map.cm.colarr[place-Component.com.game.map.cm.WIDTH].alive){
					if(new Random().nextInt(2) == 1){
						Component.com.game.map.cm.colarr[place-Component.com.game.map.cm.WIDTH] = new Colonist(this, place-Component.com.game.map.cm.WIDTH);
					}else{
						if(new Random().nextInt(2) == 1){
							if(new Random().nextInt(2) == 1){
								Component.com.game.map.cm.colarr[place-Component.com.game.map.cm.WIDTH] = new Colonist(color, place-Component.com.game.map.cm.WIDTH, strength+new Random().nextInt(8)+2, false);
							}else{
								Component.com.game.map.cm.colarr[place-Component.com.game.map.cm.WIDTH] = new Colonist(color, place-Component.com.game.map.cm.WIDTH, strength-new Random().nextInt(8)+2, false);
							}
						}else{
							Component.com.game.map.cm.colarr[place-Component.com.game.map.cm.WIDTH] = new Colonist(color, place-Component.com.game.map.cm.WIDTH, strength, true);
						}
					}
				}else{
					if(Component.com.game.map.cm.colarr[place-Component.com.game.map.cm.WIDTH].color != color){
						if(strength > Component.com.game.map.cm.colarr[place-Component.com.game.map.cm.WIDTH].strength){
							if(new Random().nextInt(2) == 1){
								Component.com.game.map.cm.colarr[place-Component.com.game.map.cm.WIDTH] = new Colonist(this, place-Component.com.game.map.cm.WIDTH);
							}else{
								if(new Random().nextInt(2) == 1){
									if(new Random().nextInt(2) == 1){
										Component.com.game.map.cm.colarr[place-Component.com.game.map.cm.WIDTH] = new Colonist(color, place-Component.com.game.map.cm.WIDTH, strength+new Random().nextInt(8)+2, false);
									}else{
										Component.com.game.map.cm.colarr[place-Component.com.game.map.cm.WIDTH] = new Colonist(color, place-Component.com.game.map.cm.WIDTH, strength-new Random().nextInt(8)+2, false);
									}
								}else{
									Component.com.game.map.cm.colarr[place-Component.com.game.map.cm.WIDTH] = new Colonist(color, place-Component.com.game.map.cm.WIDTH, strength, true);
								}
							}
						}
					}
				}
			}
			break;
		case 1:
			if(place+Component.com.game.map.cm.WIDTH < Component.com.game.map.cm.colarr.length && Component.com.game.map.isLand(place+Component.com.game.map.cm.WIDTH)){
				if(!Component.com.game.map.cm.colarr[place+Component.com.game.map.cm.WIDTH].alive){
					if(new Random().nextInt(2) == 1){
						Component.com.game.map.cm.colarr[place+Component.com.game.map.cm.WIDTH] = new Colonist(this, place+Component.com.game.map.cm.WIDTH);
					}else{
						if(new Random().nextInt(2) == 1){
							if(new Random().nextInt(2) == 1){
								Component.com.game.map.cm.colarr[place+Component.com.game.map.cm.WIDTH] = new Colonist(color, place+Component.com.game.map.cm.WIDTH, strength+new Random().nextInt(8)+2, false);
							}else{
								Component.com.game.map.cm.colarr[place+Component.com.game.map.cm.WIDTH] = new Colonist(color, place+Component.com.game.map.cm.WIDTH, strength-new Random().nextInt(8)+2, false);
							}
						}else{
							Component.com.game.map.cm.colarr[place+Component.com.game.map.cm.WIDTH] = new Colonist(color, place+Component.com.game.map.cm.WIDTH, strength, true);
						}
					}
				}else{
					if(Component.com.game.map.cm.colarr[place+Component.com.game.map.cm.WIDTH].color != color){
						if(strength > Component.com.game.map.cm.colarr[place+Component.com.game.map.cm.WIDTH].strength){
							if(new Random().nextInt(2) == 1){
								Component.com.game.map.cm.colarr[place+Component.com.game.map.cm.WIDTH] = new Colonist(this, place+Component.com.game.map.cm.WIDTH);
							}else{
								if(new Random().nextInt(2) == 1){
									if(new Random().nextInt(2) == 1){
										Component.com.game.map.cm.colarr[place+Component.com.game.map.cm.WIDTH] = new Colonist(color, place+Component.com.game.map.cm.WIDTH, strength+new Random().nextInt(8)+2, false);
									}else{
										Component.com.game.map.cm.colarr[place+Component.com.game.map.cm.WIDTH] = new Colonist(color, place+Component.com.game.map.cm.WIDTH, strength-new Random().nextInt(8)+2, false);
									}
								}else{
									Component.com.game.map.cm.colarr[place+Component.com.game.map.cm.WIDTH] = new Colonist(color, place+Component.com.game.map.cm.WIDTH, strength, true);
								}
							}
						}
					}
				}
			}
			break;
		case 2:
			if(place+1 < Component.com.game.map.cm.colarr.length && Component.com.game.map.isLand(place+1)){
				if(!Component.com.game.map.cm.colarr[place+1].alive){
					if(new Random().nextInt(2) == 1){
						Component.com.game.map.cm.colarr[place+1] = new Colonist(this, place+1);
					}else{
						if(new Random().nextInt(2) == 1){
							if(new Random().nextInt(2) == 1){
								Component.com.game.map.cm.colarr[place+1] = new Colonist(color, place+1, strength+new Random().nextInt(8)+2, false);
							}else{
								Component.com.game.map.cm.colarr[place+1] = new Colonist(color, place+1, strength-new Random().nextInt(8)+2, false);
							}
						}else{
							Component.com.game.map.cm.colarr[place+1] = new Colonist(color, place+1, strength, true);
						}
					}
				}else{
					if(Component.com.game.map.cm.colarr[place+1].color != color){
						if(strength > Component.com.game.map.cm.colarr[place+1].strength){
							if(new Random().nextInt(2) == 1){
								Component.com.game.map.cm.colarr[place+1] = new Colonist(this, place+1);
							}else{
								if(new Random().nextInt(2) == 1){
									if(new Random().nextInt(2) == 1){
										Component.com.game.map.cm.colarr[place+1] = new Colonist(color, place+1, strength+new Random().nextInt(8)+2, false);
									}else{
										Component.com.game.map.cm.colarr[place+1] = new Colonist(color, place+1, strength-new Random().nextInt(8)+2, false);
									}
								}else{
									Component.com.game.map.cm.colarr[place+1] = new Colonist(color, place+1, strength, true);
								}
							}
						}
					}
				}
			}
			break;
		case 3:
			if(place-1 >= 0 && Component.com.game.map.isLand(place-1)){
				if(!Component.com.game.map.cm.colarr[place-1].alive){
					if(new Random().nextInt(2) == 1){
						Component.com.game.map.cm.colarr[place-1] = new Colonist(this, place-1);
					}else{
						if(new Random().nextInt(2) == 1){
							if(new Random().nextInt(2) == 1){
								Component.com.game.map.cm.colarr[place-1] = new Colonist(color, place-1, strength+new Random().nextInt(8)+2, false);
							}else{
								Component.com.game.map.cm.colarr[place-1] = new Colonist(color, place-1, strength-new Random().nextInt(8)+2, false);
							}
						}else{
							Component.com.game.map.cm.colarr[place-1] = new Colonist(color, place-1, strength, true);
						}
					}
				}else{
					if(Component.com.game.map.cm.colarr[place-1].color != color){
						if(strength > Component.com.game.map.cm.colarr[place-1].strength){
							if(new Random().nextInt(2) == 1){
								Component.com.game.map.cm.colarr[place-1] = new Colonist(this, place-1);
							}else{
								if(new Random().nextInt(2) == 1){
									if(new Random().nextInt(2) == 1){
										Component.com.game.map.cm.colarr[place-1] = new Colonist(color, place-1, strength+new Random().nextInt(8)+2, false);
									}else{
										Component.com.game.map.cm.colarr[place-1] = new Colonist(color, place-1, strength-new Random().nextInt(8)+2, false);
									}
								}else{
									Component.com.game.map.cm.colarr[place-1] = new Colonist(color, place-1, strength, true);
								}
							}
						}
					}
				}
			}
			break;
		}
	}
	
	public void tick(){
		if(!diseased && !onSea){
			age++;
		}else{
			age+=2;
		}
		
		if(Component.com.game.map.tileOn(place) == Biome.DESERT){
			if(!diseased){
				age++;
			}else{
				age+=2;
			}
		}
		
		rep++;
		
		if(Component.com.game.map.tileOn(place) != Biome.FOREST){
			move();
		}else if(new Random().nextInt(50)<7){
			move();
		}
		
		if(Component.com.game.map.tileOn(place) != Biome.FOREST){
			if(!onSea && rep >= repMax){
				rep = 0;
				reproduce();
			}
		}else if(new Random().nextInt(50)<15){
			if(!onSea && rep >= repMax){
				rep = 0;
				reproduce();
			}
		}
		if(age >= strength){
			alive = false;
		}
	}
}