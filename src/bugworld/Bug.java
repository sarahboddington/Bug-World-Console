//Ant
//Bee
//beetle
package bugworld;



public class Bug {
	

	public static int BugID=1;
	public String species;
	public String name;
	public String symbol;
	public int x;
	public int y;
	public int strength;
	public int health;
	public int ID;
	
	public Bug(String species, String name, String symbol, int x, int y, int strength,int health, int ID) {
		this.species = species;
		this.name = name;
		this.symbol = symbol;
		this.x = x;
		this.y = y;
		this.strength = strength;
		this.health = health;
		this.ID = BugID++;
	}
	
	public String toText() {
		return this.ID + ":" + this.name + ";" + this.species + ";" + this.symbol + ";" + this.strength;
	}
	
	public String toString() {
		return this.name + " the " + this.species;
	}
	
	public String toStringwEnergy() {
		return this.name + " the " + this.species+" : Energy is "+strength;
	}
	
	public String getName() {
		return name;
	}
	
	public String getSymbol() {
		return symbol;
	}
	
	public int getStrength() {
		return strength;
		
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

	public void moveBug(String direction) {
		if (direction.equalsIgnoreCase("W")) {
			y = y-1;
		} else if (direction.equalsIgnoreCase("S")) {
			y = y+1;
		} else if (direction.equalsIgnoreCase("D")) {
			x = x+1;
		} else if (direction.equalsIgnoreCase("A")) {
			x = x-1;
		} else {
			System.out.println("Not a valid direction");
		}
	}

	public String printxy() {
		return this.name + " the " + this.species+" is at x: "+this.x+" y: "+this.y;
	}

	
	
}