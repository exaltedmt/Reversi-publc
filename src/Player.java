import java.io.File;

/**
 * allows to read all children subplayer types
 */
public abstract class Player {
	
	public String[][] yourGrid;
	public String[][] viableGrid;
	public int playerX = 0;
	public int playerY = 0;
	public String playerType = "";
	public boolean conditions = false;
	public String nameTag = "";
	
	
	/**
	 * sets up player's grids
	 */
	public Player(){
		
		yourGrid = new String[8][8];
		viableGrid = new String[8][8];
		
			for (int x = 0; x < yourGrid.length; x++){
				for (int y = 0; y < yourGrid[x].length; y++){
					yourGrid[x][y]=".";
					viableGrid[x][y]=".";
				}
			}
			
	}
	/**
	 * takes input from user or random numbers
	 */
	public void move(){}
	/**
	 * move for intelligent player
	 */
	public void move(Player p2){}
	/**
	 * viable grid resetter
	 */
	public void emptyGrid(){
		
		for (int x = 0; x < yourGrid.length; x++){
			for (int y = 0; y < yourGrid[x].length; y++){
				viableGrid[x][y]=".";
			}
		}
	}
			
	}
	
	
