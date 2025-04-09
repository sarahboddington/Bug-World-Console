package bugworld;
public class Bee extends Bug {
	
	public static String beesymbol = "\ud83d\udc1d";

	public Bee(String species, String name, String symbol, int x, int y, int energy,int health, int ID) {
		super("Bee", name, beesymbol, x, y, energy, health, ID);
	}
	
}