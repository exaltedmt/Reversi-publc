import java.io.File;

/**
	 Creates visible grid
	 */
public class ReversiBoard implements Board{

	private String printedGrid = "";
	
	/**
	 * Puts player chips in grids
	 */
	public ReversiBoard(Player p1, Player p2){
		
		p1.yourGrid[3][3] = p1.playerType;
		p1.yourGrid[4][4] = p1.playerType;
		
		p2.yourGrid[3][4] = p2.playerType;
		p2.yourGrid[4][3] = p2.playerType;
		
	}
	
	/**
	 * @return A grid with p1 and p2 chips and possible moves values
	 */
	public void boardPrint(Player p1, Player p2){
		
		printedGrid = "\n"; //empties everytime run()'s while loop
		
		printedGrid += "    1"; 
		for(int col = 1;col < p1.yourGrid[0].length;col++)
		{
			printedGrid += " "+(col+1);//numbering
		}
		printedGrid += "\n";
		
		for (int row = 0; row < p1.yourGrid.length; row++){
			printedGrid += "  " + (row+1);
			
			for (int col = 0; col < p1.yourGrid[row].length; col++){
				if(p1.viableGrid[row][col].equals("_"))
					printedGrid += " "+p1.viableGrid[row][col];

				else if(p1.yourGrid[row][col].equals(p1.playerType))
					printedGrid += " "+p1.yourGrid[row][col];
				
				else if(p2.yourGrid[row][col].equals(p2.playerType))
				printedGrid += " "+p2.yourGrid[row][col];
				
				else if(p1.yourGrid[row][col].equals(".")) 
					printedGrid += " "+p1.yourGrid[row][col];
				//grid components
			}
			printedGrid += "\n";
		}

		
		System.out.println(printedGrid);


	}
	

}
