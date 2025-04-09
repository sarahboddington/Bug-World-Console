package bugworld;
public class Obstacle {
	
	public String type;
	public String symbol;
	public int x;
	public int y;
	public int health;
	public String bomb = "\ud83d\udca3";
	public String explosion = "\uD83D\uDCA5";
	
	public Obstacle(String type, String symbol, int x, int y, int health) {
		this.type = type;
		if (type.equalsIgnoreCase("bomb")) {
			this.symbol = bomb;
		} else if (type.equalsIgnoreCase("explosion")) {
			this.symbol = explosion;
		} else {
			this.symbol=symbol;
		}
		this.x = x;
		this.y = y;
		this.health = health;
	}
	
	public String toString() {
		return this.type;
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