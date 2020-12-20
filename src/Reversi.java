import java.io.File;

/**
 * This class represents a reversi game.
 *
 * @author Christina Jeong 
 * cj89164@uga.edu 
 * 811406
 * 
 * Royce Harley
 * rnh76959@uga.edu
 * 811778401
 */
public class Reversi {

	private boolean gameEnd = false;
	private boolean turnOver = false;
	private boolean noMoves = true;
	private boolean inBetween = false;
	private int p1Counter, p2Counter = 0;

	/**
	 * Takes in two player involving human
	 * runs game and sets whose p1 and p2
	 */
	public Reversi(Player p1, Player p2){

		p1.playerType = "X";
		p2.playerType = "O";

		run(p1,p2);
	}
	/**
	 * Takes in cpu types and runs
	 */
	public Reversi(ComputerPlayer p1, ComputerPlayer p2){

		p1.playerType = "X";
		p2.playerType = "O";

		runAI(p1,p2);
	}

	/**
	 *Checks all directions
	 *After enemy's chip/chips puts an _ to mark possible moves
	 *
	 * @return A grid with viable moves
	 */
	public void viableMove(Player p1, Player p2){

		p1.emptyGrid();
		p2.emptyGrid();

		for(int row = 0; row<p1.viableGrid.length;row++){

			for(int col = 0;col<p1.viableGrid[row].length;col++){

				if(p1.yourGrid[row][col].equals(p1.playerType)){ //find p1 chip

					for(int inc = 1; inc<8;inc++)
						if(row-inc >= 0 && row-inc < p1.yourGrid.length )
							if(col-inc >= 0 && col-inc < p1.yourGrid[0].length){
								if(p2.yourGrid[row-inc][col-inc].equals(p2.playerType)){//make sure its inbetween p1 chip and an empty space
									inBetween = true;
								}
								if(p1.yourGrid[row-inc][col-inc].equals(p1.playerType))
									inBetween = false;
								if(!inBetween)
									break;

								if(inBetween)
									if(row-inc >= 0 && row-inc < p1.yourGrid.length )
										if(col-inc >= 0 && col-inc < p1.yourGrid[0].length)
											if(p2.yourGrid[row-inc][col-inc].equals(".")&&!p1.yourGrid[row-inc][col-inc].equals(p1.playerType)){
												p1.viableGrid[row-inc][col-inc] = "_";
												inBetween=false; // reset for next loop. 
												break;//only need one underscore
											}
							}
					

					for(int inc = 1; inc<8;inc++)
						if(row-inc >= 0 && row-inc < p1.yourGrid.length )
							if(col >= 0 && col < p1.yourGrid[0].length){
								if(p2.yourGrid[row-inc][col].equals(p2.playerType)){
									inBetween = true;
								}
								if(p1.yourGrid[row-inc][col].equals(p1.playerType))
									inBetween = false;
								if(!inBetween)
									break;

								if(inBetween)
									if(row-inc >= 0 && row-inc < p1.yourGrid.length )
										if(col >= 0 && col < p1.yourGrid[0].length)
											if(p2.yourGrid[row-inc][col].equals(".")&&!p1.yourGrid[row-inc][col].equals(p1.playerType)){
												p1.viableGrid[row-inc][col] = "_";
												break;
											}
							}
					
					for(int inc = 1; inc<8;inc++)
						if(row-inc >= 0 && row-inc < p1.yourGrid.length )
							if(col+inc >= 0 && col+inc < p1.yourGrid[0].length){
								if(p2.yourGrid[row-inc][col+inc].equals(p2.playerType)){
									inBetween = true;
								}
								if(p1.yourGrid[row-inc][col+inc].equals(p1.playerType))
									inBetween = false;
								if(!inBetween)
									break;

								if(inBetween)
									if(row-inc >= 0 && row-inc < p1.yourGrid.length )
										if(col+inc >= 0 && col+inc < p1.yourGrid[0].length)
											if(p2.yourGrid[row-inc][col+inc].equals(".")&&!p1.yourGrid[row-inc][col+inc].equals(p1.playerType)){
												p1.viableGrid[row-inc][col+inc] = "_";
												inBetween=false;
												break;
											}
							}
					
					for(int inc = 1; inc<8;inc++)
						if(row >= 0 && row < p1.yourGrid.length )
							if(col-inc >= 0 && col-inc < p1.yourGrid[0].length){
								if(p2.yourGrid[row][col-inc].equals(p2.playerType)){
									inBetween = true;
								}
								if(p1.yourGrid[row][col-inc].equals(p1.playerType))
									inBetween = false;
								if(!inBetween)
									break;

								if(inBetween)
									if(row >= 0 && row < p1.yourGrid.length )
										if(col-inc >= 0 && col-inc < p1.yourGrid[0].length)
											if(p2.yourGrid[row][col-inc].equals(".")&&!p1.yourGrid[row][col-inc].equals(p1.playerType)){
												p1.viableGrid[row][col-inc] = "_";
												inBetween=false;
												break;
											}
							}
					
					for(int inc = 1; inc<8;inc++)
						if(row >= 0 && row < p1.yourGrid.length )
							if(col+inc >= 0 && col+inc < p1.yourGrid[0].length){
								if(p2.yourGrid[row][col+inc].equals(p2.playerType)){
									inBetween = true;
								}
								if(p1.yourGrid[row][col+inc].equals(p1.playerType))
									inBetween = false;
								if(!inBetween)
									break;

								if(inBetween)
									if(row >= 0 && row < p1.yourGrid.length )
										if(col+inc >= 0 && col+inc < p1.yourGrid[0].length)
											if(p2.yourGrid[row][col+inc].equals(".")&&!p1.yourGrid[row][col+inc].equals(p1.playerType)){
												p1.viableGrid[row][col+inc] = "_";
												inBetween=false;
												break;
											}
							}
					
					for(int inc = 1; inc<8;inc++)
						if(row+inc >= 0 && row+inc < p1.yourGrid.length )
							if(col-inc >= 0 && col-inc < p1.yourGrid[0].length){
								if(p2.yourGrid[row+inc][col-inc].equals(p2.playerType)){
									inBetween = true;
								}
								if(p1.yourGrid[row+inc][col-inc].equals(p1.playerType))
									inBetween = false;
								if(!inBetween)
									break;

								if(inBetween)
									if(row+inc >= 0 && row+inc < p1.yourGrid.length )
										if(col-inc >= 0 && col-inc < p1.yourGrid[0].length)
											if(p2.yourGrid[row+inc][col-inc].equals(".")&&!p1.yourGrid[row+inc][col-inc].equals(p1.playerType)){
												p1.viableGrid[row+inc][col-inc] = "_";
												inBetween=false;
												break;
											}
							}

					for(int inc = 1; inc<8;inc++)
						if(row+inc >= 0 && row+inc < p1.yourGrid.length )
							if(col >= 0 && col < p1.yourGrid[0].length){
								if(p2.yourGrid[row+inc][col].equals(p2.playerType)){
									inBetween = true;
								}
								if(p1.yourGrid[row+inc][col].equals(p1.playerType))
									inBetween = false;
								if(!inBetween)
									break;

								if(inBetween)
									if(row+inc >= 0 && row+inc < p1.yourGrid.length )
										if(col >= 0 && col < p1.yourGrid[0].length)
											if(p2.yourGrid[row+inc][col].equals(".")&&!p1.yourGrid[row+inc][col].equals(p1.playerType)){
												p1.viableGrid[row+inc][col] = "_";
												inBetween=false;
												break;
											}
							}
					for(int inc = 1; inc<8;inc++)
						if(row+inc >= 0 && row+inc < p1.yourGrid.length )
							if(col+inc >= 0 && col+inc < p1.yourGrid[0].length){
								if(p2.yourGrid[row+inc][col+inc].equals(p2.playerType)){
									inBetween = true;
								}
								if(p1.yourGrid[row+inc][col+inc].equals(p1.playerType))
									inBetween = false;
								if(!inBetween)
									break;

								if(inBetween)
									if(row+inc >= 0 && row+inc < p1.yourGrid.length )
										if(col+inc >= 0 && col+inc < p1.yourGrid[0].length)
											if(p2.yourGrid[row+inc][col+inc].equals(".")&&!p1.yourGrid[row+inc][col+inc].equals(p1.playerType)){
												p1.viableGrid[row+inc][col+inc] = "_";
												inBetween=false;
												break;
											}
							}
				}

			}

		}
	}

	/**
	 * Checks for possible moves in all directions 
	 * 
	 * @param p1
	 * @param p2
	 * @param multiX
	 * @param multiY
	 */
	public void pathFinder(Player p1, Player p2, int multiX, int multiY){
		
		for(int inc = 1; inc<8;inc++)
			if(p1.playerX+(inc*multiX) >= 0 && p1.playerX+(inc*multiX) < p1.yourGrid.length )
				if(p1.playerY+(inc*multiY) >= 0 && p1.playerY+(inc*multiY) < p1.yourGrid[0].length){
					if(p1.yourGrid[p1.playerX+(inc*multiX)][p1.playerY+(inc*multiY)].equals(p1.playerType))
						break;
					if(p2.yourGrid[p1.playerX+(inc*multiX)][p1.playerY+(inc*multiY)].equals(p2.playerType))
						inBetween = true;
					if(p2.yourGrid[p1.playerX+(inc*multiX)][p1.playerY+(inc*multiY)].equals(".")){
						inBetween = false;
						break;
					} // checks if any interruptions between the current move and the X that
						//had the viable move
				}
	
		if(inBetween)
			for(int inc2 = 1; inc2 < 8; inc2++){
				if(p1.playerX+(inc2*multiX) >= 0 && p1.playerX+(inc2*multiX) < p1.yourGrid.length ){
					if(p1.playerY+(inc2*multiY) >= 0 && p1.playerY+(inc2*multiY) < p1.yourGrid[0].length){
						if(p2.yourGrid[p1.playerX+(inc2*multiX)][p1.playerY+(inc2*multiY)].equals(p2.playerType)){
							p1.yourGrid[p1.playerX+(inc2*multiX)][p1.playerY+(inc2*multiY)] = p1.playerType;
							p2.yourGrid[p1.playerX+(inc2*multiX)][p1.playerY+(inc2*multiY)] = ".";
						}	//flips the chip
					}
	
				}
			}
	
	}
	
	/**
	 * changes enemey pieces
	 * 
	 * @param p1
	 * @param p2
	 */
	public void flip(Player p1, Player p2){
		
		p1.yourGrid[p1.playerX][p1.playerY]= p1.playerType;
		inBetween = false;
		
			pathFinder(p1,p2,-1,-1);
			pathFinder(p1,p2,-1,0);
			pathFinder(p1,p2,-1,1);
			pathFinder(p1,p2,0,-1);
			pathFinder(p1,p2,0,1);
			pathFinder(p1,p2,1,-1);
			pathFinder(p1,p2,1,0);
			pathFinder(p1,p2,1,1);
	}
	/**
	 * Takes over other player's chips.
	 */
	/**
	 * Runs the game for two computer opponents in a loop.
	 */
	public void runAI(ComputerPlayer p1, ComputerPlayer p2){

		//setup grids
		System.out.println("Welcome to Reversi!  Moves should be entered in "
				+ "\"[row] [column] \" format.");

		ReversiBoard gameBoard = new ReversiBoard(p1, p2);

		viableMove(p1,p2);

		gameBoard.boardPrint(p1,p2); 

		noMoves = false; //there are moves

		while(!gameEnd){

			turnOver = false;

			while(!turnOver){

				while(!p1.conditions){
					if(p1.nameTag.equals("AI"))//for intelligent player
						p1.move(p2);
					else p1.move();
				}

				flip(p1,p2);
				turnOver = true;
			}

			try {
				Thread.sleep(1);
			} catch(InterruptedException ex) {
				Thread.currentThread().interrupt();
			}

			viableMove(p2,p1);
			gameBoard.boardPrint(p2,p1);

			p1.conditions = false;

			turnOver = false;

			while(!turnOver){

				while(!p2.conditions){
					if(p2.nameTag.equals("AI"))
						p2.move(p2);
					else p2.move();
				}
				flip(p2,p1);		
				turnOver = true;
			}

			viableMove(p1,p2);
			gameBoard.boardPrint(p1,p2);

			p2.conditions = false;

			//game ending conditions
			for(int x = 0; x<p1.viableGrid.length;x++)
				for(int y = 0; y<p1.viableGrid[x].length;y++){
					if(p1.viableGrid[x][y].equals("_")||p2.viableGrid[x][y].equals("_")){
						noMoves = false;
				}
					if(p1.yourGrid[x][y].equals(p1.playerType))
						p1Counter++;
					if(p2.yourGrid[x][y].equals(p2.playerType))
						p2Counter++;
				}

			if(noMoves){
				System.out.println("No more moves! That's the game!");
				System.out.println("Player 1 has "+p1Counter+" pieces, while Player 2 has "+p2Counter+" pieces.");
				if(p1Counter>p2Counter)
					System.out.println("Player 1 wins!");
				else if(p2Counter>p1Counter)
					System.out.println("Player 2 wins!");
				else if(p1Counter==p2Counter)
					System.out.println("Both players have equal amounts of pieces! Tie!");
				gameEnd = true;
			}
			
			noMoves = true;
			p1Counter = 0;
			p2Counter = 0;
			
			try {
				Thread.sleep(1);
			} catch(InterruptedException ex) {
				Thread.currentThread().interrupt();
			}
		}
	}
	public void run(Player p1, Player p2){

		//same as above but just no sleeper
		
		System.out.println("Welcome to Reversi!  Moves should be entered in "
				+ "\"[row] [column] \" format.");

		p1Counter = p2Counter = 0;

		ReversiBoard gameBoard = new ReversiBoard(p1, p2);

		viableMove(p1,p2);

		gameBoard.boardPrint(p1,p2);

		noMoves = false;

		while(!gameEnd){

			turnOver = false;

			while(!turnOver){

				while(!p1.conditions){
					if(p1.nameTag.equals("AI"))
						p1.move(p2);
					else p1.move();
				}

				flip(p1,p2);
				turnOver = true;
			}

			viableMove(p2,p1);
			gameBoard.boardPrint(p2,p1);

			p1.conditions = false;

			turnOver = false;


			while(!turnOver){

				while(!p2.conditions){
					if(p2.nameTag.equals("AI"))
						p2.move(p2);
					else p2.move();

				}
				flip(p2,p1);		
				turnOver = true;
			}

			viableMove(p1,p2);
			gameBoard.boardPrint(p1,p2);

			p2.conditions = false;

			for(int x = 0; x<p1.viableGrid.length;x++)
				for(int y = 0; y<p1.viableGrid[x].length;y++){
					if(p1.viableGrid[x][y].equals("_")||p2.viableGrid[x][y].equals("_")){
						noMoves = false;
					}
					if(p1.yourGrid[x][y].equals(p1.playerType))
						p1Counter++;
					if(p2.yourGrid[x][y].equals(p2.playerType))
						p2Counter++;
				}

			if(noMoves){
				System.out.println("No more moves! That's the game!");
				System.out.println("Player 1 has "+p1Counter+" pieces, while Player 2 has "+p2Counter+" pieces!");
				if(p1Counter>p2Counter)
					System.out.println("Player 1 wins!");
				else if(p2Counter>p1Counter)
					System.out.println("Player 2 wins!");
				else if(p1Counter==p2Counter)
					System.out.println("Both players have equal amounts of pieces! Tie!");
				gameEnd = true;
			}
			
			noMoves = true;
			p1Counter = 0;
			p2Counter = 0;
		}


	}

	public static void main(String[] args) {

		Reversi reversi = null;

		switch (args.length) {

		//two arguments
		case 2:

			Player p1 = null;
			Player p2 = null;
			ComputerPlayer ai1 = null;
			ComputerPlayer ai2 = null;


			String player1 = args[0];
			String player2 = args[1];

			if(player1.equals("Human")&&player2.equals("Human")){
				p1 = new HumanPlayer();
				p2 = new HumanPlayer();
				reversi = new Reversi(p1,p2);
			}

			if(player1.equals("Human")&&player2.equals("RandomComputerPlayer")){
				p1 = new HumanPlayer();
				p2 = new RandomComputerPlayer();
				reversi = new Reversi(p1,p2);
			}

			if(player2.equals("Human")&&player1.equals("RandomComputerPlayer")){
				p2 = new HumanPlayer();
				p1 = new RandomComputerPlayer();
				reversi = new Reversi(p1,p2);
			}


			if(player1.equals("Human")&&player2.equals("IntelligentComputerPlayer")){
				p1 = new HumanPlayer();
				p2 = new IntelligentComputerPlayer();
				reversi = new Reversi(p1,p2);
			}


			if(player2.equals("Human")&&player1.equals("RandomComputerPlayer")){
				p2 = new HumanPlayer();
				p1 = new RandomComputerPlayer();
				reversi = new Reversi(p1,p2);
			}

			if(player1.equals("RandomComputerPlayer")&&player2.equals("RandomComputerPlayer")){
				ai1 = new RandomComputerPlayer();
				ai2 = new RandomComputerPlayer();
				reversi = new Reversi(ai1,ai2);
			}

			if(player1.equals("RandomComputerPlayer")&&player2.equals("IntelligentComputerPlayer")){
				ai1 = new RandomComputerPlayer();
				ai2 = new IntelligentComputerPlayer();
				reversi = new Reversi(ai1,ai2);
			}

			if(player1.equals("IntelligentComputerPlayer")&&player2.equals("IntelligentComputerPlayer")){
				ai1 = new IntelligentComputerPlayer();
				ai2 = new IntelligentComputerPlayer();
				reversi = new Reversi(ai1,ai2);
			}

			if(player1.equals("IntelligentComputerPlayer")&&player2.equals("RandomComputerPlayer")){
				ai1 = new IntelligentComputerPlayer();
				ai2 = new RandomComputerPlayer();
				reversi = new Reversi(ai1,ai2);
			}
			
			break;
			
		default:
			System.out.println("Usage: java Reversi [Player1] [Player2]");
			System.exit(0);

		} 


	}

}
