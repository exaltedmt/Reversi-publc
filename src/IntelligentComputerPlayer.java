import java.io.File;

/**
	 Chooses best move according to the amount of possible pieces flipped
 */
public class IntelligentComputerPlayer extends ComputerPlayer{

	private boolean[][] inBetween;
	private boolean[][] thisDaOne;
	private int[][] counters;
	private int greed = 0;
	private boolean inBounds = false;
	private int checkedX = 0;
	private int checkedY = 0;

	public IntelligentComputerPlayer(){
		super();
		nameTag = "AI";
		inBetween = new boolean[yourGrid.length][yourGrid[0].length];
		counters = new int[yourGrid.length][yourGrid[0].length];
		thisDaOne = new boolean[yourGrid.length][yourGrid[0].length];
	}

	/**
	 More specific grid emptier for AI
	 */
	public void resetter(){

		for(int x=0; x<counters.length; x++)
			for(int y=0; y<counters[x].length; y++){
				inBetween[x][y] = false;
			}
			
	}

	/**
	 * Counts the amount of enemy chips in a direction
	 * @param p2
	 * @param multiX
	 * @param multiY
	 */
	
	public void counter(Player p2, int multiX, int multiY){

		resetter();

		for(int row = 0; row<viableGrid.length;row++)
			for(int col = 0;col<viableGrid[row].length;col++){
				if(viableGrid[row][col].equals("_")){
//multiples will determine direction
					for(int inc = 1; inc<8;inc++)
						if(row+(inc*multiX) >= 0 && row+(inc*multiX) < yourGrid.length )
							if(col+(inc*multiY) >= 0 && col+(inc*multiY) < yourGrid[0].length){
								if(yourGrid[row+(inc*multiX)][col+(inc*multiY)].equals(playerType))
									break;
								if(p2.yourGrid[row+(inc*multiX)][col+(inc*multiY)].equals(p2.playerType)){
									inBetween[row][col] = true;
								}
								if(p2.yourGrid[row+(inc*multiX)][col+(inc*multiY)].equals(".")){
									inBetween[row][col] = false;
									break;
								}
								
								if(inBetween[row][col])
									counters[row][col]++;//increment when u find an p2chip in that direction
							}
				}
			}
		

	}

	/**
	 * checks for greatest counter and sets a boolean if its true
	 */
	public void greater(){

		for(int x=0; x< counters.length; x++)
			for(int y=0; y< counters[x].length; y++)//largest counter set linked to boolean
				if(counters[x][y] > greed){
					greed = counters[x][y];
					thisDaOne[x][y] = true;
				}else thisDaOne[x][y] = false;

	}

	public void move(Player p2){
		
		conditions = false;
		//each direction
		counter(p2, -1,-1);
		counter(p2, -1,0);
		counter(p2, -1,1);
		counter(p2, 0,-1);
		counter(p2, 0,1);
		counter(p2, +1,-1);
		counter(p2, +1,0);
		counter(p2, +1,+1);
		
		greater();	
		//pair counter if statement to boolean

		for(int x = 0; x<thisDaOne.length;x++)
			for(int y = 0;y<thisDaOne[x].length;y++){

				if(thisDaOne[x][y]){
					playerX = x;
					playerY = y;
					conditions = true;
				}

			}
		System.out.print("Enter your move, "+playerType+" player: "+
				(playerX+1)+" "+(playerY+1)+"\n");
	}


}
