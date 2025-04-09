package bugworld;
public class Plant {
	
	public String species;
	public String symbol;
	public int x;
	public int y;
	public int health;
	
	public Plant(String species, String symbol, int x, int y, int health) {
		this.species = species;
		this.symbol = "\ud83c\udf31";
		this.x = x;
		this.y = y;
		this.health = health;
	}
	
	public String toString() {
		return this.species;
	}
	
	public String getSymbol() {
		return symbol;
	}

	public int getHealth() {
		return health;
		
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	
}