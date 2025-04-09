package bugworld;



import java.util.ArrayList;
import bugworldcomparators.*;

public class World {
	
	
	public int height;
	public int width;
	private ArrayList<Bug> worldbuglist = new ArrayList<>();
	private ArrayList<Plant> worldplantlist = new ArrayList<>();
	private ArrayList<Obstacle> worldobstaclelist = new ArrayList<>();
    public String RESET = "\u001B[0m";
    public String GREY_BG = "\u001B[48;5;252m";
    public String bomb = "\ud83d\udca3";
	public static String antsymbol = "\ud83d\udc1c";
	public static String beesymbol = "\ud83d\udc1d";
	public static String beetlesymbol = "\uD83E\uDEB2";
	
	public World(int height, int width, ArrayList<Bug> worldbuglist, ArrayList<Plant> worldplantlist, ArrayList<Obstacle> worldobstaclelist) {
		this.height = height+2;
		this.width = width+2;
		this.worldbuglist = worldbuglist;
		this.worldplantlist = worldplantlist;
		this.worldobstaclelist = worldobstaclelist;
		worldbuglist.add(new Ant("Andy", "Angelica", "A", 10, 10, 1, 10, Bug.BugID));
		Bug.BugID++;
		worldbuglist.add(new Bee("Bee", "Bruce", "B", 15, 5, 20, 20, Bug.BugID));
		Bug.BugID++;
		worldbuglist.add(new Beetle("Beetle", "Belinda", "B", 14, 3, 10, 10, Bug.BugID));
		Bug.BugID++;
		worldplantlist.add(new Plant("Sapling", "S", 1, 1, 1));
		worldplantlist.add(new Plant("Sapling", "S", 1, 2, 2));
		worldplantlist.add(new Plant("Sapling", "S", 1, 3, 3));
		worldplantlist.add(new Plant("Sapling", "S", 1, 4, 4));
		worldplantlist.add(new Plant("Sapling", "S", 1, 5, 4));
		worldplantlist.add(new Plant("Sapling", "S", 2, 2, 1));
		worldplantlist.add(new Plant("Sapling", "S", 2, 3, 2));
		worldplantlist.add(new Plant("Sapling", "S", 2, 4, 3));
		worldplantlist.add(new Plant("Sapling", "S", 3, 1, 2));
		worldplantlist.add(new Plant("Sapling", "S", 3, 3, 2));
		worldplantlist.add(new Plant("Sapling", "S", 4, 2, 1));
		worldobstaclelist.add(new Obstacle("Bomb", "B", 6, 8, 100));
		worldobstaclelist.add(new Obstacle("Bomb", "B", 17, 2, 100));
	}
	
	public int getHeight() {
		return height;
	}
	
	public int getWidth() {
		return width;
	}
	
	public void addBugtoWorld(Bug b) {
		worldbuglist.add(b);
	}
	
	public void removeBugfromWorld(Bug b) {
		worldbuglist.remove(b);
	}
	
	public void addPlanttoWorld(Plant p) {
		worldplantlist.add(p);
	}
	
	public void addObstacletoWorld(Obstacle o) {
		worldobstaclelist.add(o);
	}
	
	public void removeObstacle(int x, int y) {
		for (int o=0; o<worldobstaclelist.size(); o++) {
			int obstaclex = worldobstaclelist.get(o).getX();
			int obstacley = worldobstaclelist.get(o).getY();
			if (obstaclex==x && obstacley==y) {
			worldobstaclelist.remove(o);
			}
		}
	}
	
	public void printworldBugList() {
		this.worldbuglist.sort(new BugEnergyComparator());
		for (int b=0; b<worldbuglist.size(); b++) {
			System.out.println(worldbuglist.get(b).toStringwEnergy());
		}
	}
	
	public String [][] createWorldDisplay () {
		String[][] worlddisplay = new String [height][width];
		for (int h=0; h<height; h++) {
			for (int w=0; w<width; w++) {
				if (h==0||w==0||h==height-1||w==width-1) {
					worlddisplay[h][w] = "\uD83D\uDCA0";
				} else {
					worlddisplay[h][w] = "\u2B1C";
				}
			}
		}
		for (int b=0; b<worldbuglist.size(); b++) {
			worlddisplay[worldbuglist.get(b).getY()][worldbuglist.get(b).getX()] = worldbuglist.get(b).getSymbol();
		}
		for (int p=0; p<worldplantlist.size(); p++) {
			worlddisplay[worldplantlist.get(p).getY()][worldplantlist.get(p).getX()] = worldplantlist.get(p).getSymbol();
		}
		for (int o=0; o<worldobstaclelist.size(); o++) {
			worlddisplay[worldobstaclelist.get(o).getY()][worldobstaclelist.get(o).getX()] = worldobstaclelist.get(o).getSymbol();
		}
		return worlddisplay;
	}


	public void drawWorld() {
		String worlddisplay[][] = createWorldDisplay();
		for (int h=0; h<height; h++) {
			for (int w=0; w<width; w++) {
				System.out.print(GREY_BG+worlddisplay[h][w]+ RESET);
				try {
				    // to sleep 10 seconds
				    Thread.sleep(0);
				} catch (InterruptedException e) {
				    // recommended because catching InterruptedException clears interrupt flag
				    Thread.currentThread().interrupt();
				    // you probably want to quit if the thread is interrupted
				    return;
				}
				
			}
			System.out.println();
		}
	}

	public boolean emptychecker(int x, int y) {
		boolean empty = true;
		String worlddisplay[][] = createWorldDisplay();
		if (worlddisplay[y][x].equals("\u2B1C")){
			empty=true;
		} else {
			empty=false;
		}
		return empty;
		
	}
	
	public boolean bombchecker(int x, int y) {
		boolean bombcheck = true;
		String worlddisplay[][] = createWorldDisplay();
		if (worlddisplay[y][x].equals(bomb)){
			bombcheck=true;
		} else {
			bombcheck=false;
		}
		return bombcheck;
		
	}
	
	public boolean bugchecker(int x, int y) {
		boolean bugcheck = true;
		String worlddisplay[][] = createWorldDisplay();
		if (worlddisplay[y][x].equals(antsymbol)||worlddisplay[y][x].equals(beesymbol)||worlddisplay[y][x].equals(beetlesymbol)){
			bugcheck=true;
		} else {
			bugcheck=false;
		}
		return bugcheck;
		
	}

	public ArrayList<Plant> getplants() {
		// TODO Auto-generated method stub
		return worldplantlist;
	}
	

	
	
}