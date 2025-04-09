package bugworld;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {
	
	private static ArrayList<Bug> bugs = new ArrayList<>();
	private static ArrayList<Plant> plants = new ArrayList<>();
	private static ArrayList<Obstacle> obstacles = new ArrayList<>();
	private static boolean runbugworld = true;
	private static boolean bugmover = true;
	private static Scanner userInput = new Scanner(System.in);
	private static int selectedbugindex;
	private static int homeworldwidth = 20;
	private static int homeworldheight = 10;
	private static World homeworld = new World(homeworldheight, homeworldwidth, bugs, plants, obstacles);
	private static String sparkles = "\n \u2728";
	
	public static void main(String[] args) {
		System.out.println("-----------------------------------------------");
		System.out.println("\ud83d\udc1b"+"     .*.*.Welcome to Bug World!.*.*.     "+"\ud83d\udc1b");
		mainMenu();
	}
	
	public static void mainMenu() {
		while (runbugworld) {
			System.out.println("-----------------------------------------------");
			System.out.println("What would you like to do?"
					+sparkles+" Add new bug (a)"
					+sparkles+" View all bugs (v)"
					+sparkles+" Select a bug (s)"
					+sparkles+" Move a bug (m)"
					+sparkles+" Add a plant (p)"
					+sparkles+" Add a obstacle (o)"
					+sparkles+" Display World (w)"
					+sparkles+" TESTER (t)"
					+sparkles+" Leave BugWorld (l)");
			System.out.println("-----------------------------------------------");
			String input = userInput.nextLine();
			processInput(input);
		}
	}
	

	private static void processInput(String input) {
		if (input.equalsIgnoreCase("a")) {
			addBug();
		} else if (input.equalsIgnoreCase("v")) {
			listBugs();
		} else if (input.equalsIgnoreCase("s")) {
			selectBug();
		} else if (input.equalsIgnoreCase("m")) {
			moveBug();
		} else if (input.equalsIgnoreCase("w")) {
			displayWorld();
		}else if (input.equalsIgnoreCase("p")) {
			addPlant();
		}else if (input.equalsIgnoreCase("o")) {
			addObstacle();
		}else if (input.equalsIgnoreCase("t")) {
			//TESTER INPUT
			printworldbuglist();
		}else if (input.equalsIgnoreCase("l")) {
			runbugworld=false;
			System.out.println(".*.*.Leaving Bug World.*.*.");
			System.out.println("       \ud83d\udc4b"+" Goodbye "+"\ud83d\udc4b");
		} else {
			System.out.println("Invalid input");
		}
	}

	
	public static void addBug() {
		System.out.println("-----------------------------------------------");
		System.out.println(".*.*.Creating a new bug.*.*.");
		System.out.println("Name:");
		String name = userInput.nextLine();
		System.out.print("Species:");
		String species = userInput.nextLine();
		System.out.print("Symbol:");
		String symbol = userInput.nextLine();
		System.out.print("Strength:");
		int strength = userInput.nextInt();
		System.out.print("Health:");
		int health = userInput.nextInt();
		System.out.print("X position:");
		int x = userInput.nextInt();
		System.out.print("Y position:");
		int y = userInput.nextInt();
		userInput.nextLine();
		if (homeworld.emptychecker(x, y)) {
			Bug b = new Bug(species, name, symbol, x, y, strength, health, Bug.BugID);
			Bug.BugID++;
			if (species.equalsIgnoreCase("Ant")) {
				homeworld.addBugtoWorld(new Ant(species, name, symbol, x, y, strength, health, Bug.BugID));
			} else if (species.equalsIgnoreCase("Bee")) {
				homeworld.addBugtoWorld(new Bee(species, name, symbol, x, y, strength, health, Bug.BugID));
			} else if (species.equalsIgnoreCase("beetle")) {
				homeworld.addBugtoWorld(new Beetle(species, name, symbol, x, y, strength, health, Bug.BugID));
			} else {
				homeworld.addBugtoWorld(b);
			}
			System.out.println(".*.*."+b.toString()+" has been added.*.*.");
		} else {
			System.out.println("The requested coordinates are occupied/invalid");
		}
	
	}
	
	public static void addPlant() {
		System.out.println("-----------------------------------------------");
		System.out.println(".*.*.Creating a new plant.*.*.");
		System.out.print("Species:");
		String species = userInput.nextLine();
		System.out.print("Symbol:");
		String symbol = userInput.nextLine();
		System.out.print("Health:");
		int health = userInput.nextInt();
		System.out.print("X position:");
		int x = userInput.nextInt();
		System.out.print("Y position:");
		int y = userInput.nextInt();
		userInput.nextLine();
		if (homeworld.emptychecker(x, y)) {
			Plant p = new Plant(species, symbol, x, y, health);
			homeworld.addPlanttoWorld(p);
			System.out.println(".*.*."+p.toString()+" has been added.*.*.");
		} else {
			System.out.println("The requested coordinates are occupied/invalid");
		}
	
	}
	
	public static void addObstacle() {
		System.out.println("-----------------------------------------------");
		System.out.println(".*.*.Creating a new obstacle.*.*.");
		System.out.print("Type:");
		String type = userInput.nextLine();
		System.out.print("Symbol:");
		String symbol = userInput.nextLine();
		System.out.print("Health:");
		int health = userInput.nextInt();
		System.out.print("X position:");
		int x = userInput.nextInt();
		System.out.print("Y position:");
		int y = userInput.nextInt();
		userInput.nextLine();
		if (homeworld.emptychecker(x, y)) {
			Obstacle o = new Obstacle(type, symbol, x, y, health);
			homeworld.addObstacletoWorld(o);
			System.out.println(".*.*."+o.toString()+" has been added.*.*.");
		} else {
			System.out.println("The requested coordinates are occupied/invalid");
		}
	}
	
	public static void listBugs() {
		System.out.println(".*.*.All Bugs.*.*.");
		for (int i=0; i<bugs.size(); i++) {
			System.out.println(bugs.get(i).getSymbol()+" "+bugs.get(i).toString());
		}
		}
	
	private static void selectBug() {
		System.out.println("Name:");
		String name = userInput.nextLine();
		for (int i=0; i<bugs.size(); i++) {
			Bug currentbug = bugs.get(i);
			if (currentbug.getName().equalsIgnoreCase(name)) {
				System.out.println(".*.*."+currentbug.toString()+" has been selected.*.*.");
				selectedbugindex = i;
			}
		}
		
	}
	
	private static void moveBug() {
		selectBug();
		bugmover = true;
		homeworld.drawWorld();
		while (bugmover) {
			Bug currentbug = bugs.get(selectedbugindex);
			System.out.println("-----------------------------------------------");
			System.out.println("What direction would you like to move "+currentbug.getName()+"?"
					+ sparkles+" North/UP (W)"
					+ sparkles+" South/RIGHT (S)"
					+ sparkles+" East/DOWN (D)"
					+ sparkles+" West/LEFT (A)"
					+ sparkles+" Exit (X)");
			System.out.println("-----------------------------------------------");
			String direction = userInput.nextLine();
			if (direction.equalsIgnoreCase("X")) {
				homeworld.drawWorld();
				bugmover=false;
			} else {
				int x = currentbug.getX();
				int y = currentbug.getY();
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
				if (homeworld.emptychecker(x, y)) {
					currentbug.moveBug(direction);
					homeworld.drawWorld();
				} else if (homeworld.bombchecker(x, y)) {
					homeworld.removeBugfromWorld(currentbug);
					homeworld.removeObstacle(x, y);
					System.out.println("\ud83d\udc80 "+currentbug.getName()+" has been blown up \ud83d\udc80");
					Obstacle explosion = new Obstacle("Explosion", "B", x, y, 100);
					homeworld.addObstacletoWorld(explosion);
					homeworld.drawWorld();
					homeworld.removeObstacle(x, y);
				} else if (homeworld.bugchecker(x, y)) {

				} else {
					   
					System.out.println("Path is blocked");
					homeworld.drawWorld();
				}
			}
		}
	}
	
	private static void displayWorld() {
		homeworld.drawWorld();
	}
	
	private static void printworldbuglist() {
		homeworld.printworldBugList();
	}



	
}