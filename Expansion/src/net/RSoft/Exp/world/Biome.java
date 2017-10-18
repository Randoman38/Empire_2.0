package net.RSoft.Exp.world;

public enum Biome {
	OCEAN(0x12DFFF),
	PLAINS(0x24B831),
	FOREST(0x259227),
	DESERT(0xF4D45E);
	
	private final int c;
	
	Biome(int c){
		this.c = c;
	}
	
	public int color(){ return c; }
}