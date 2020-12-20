import java.io.File;
import java.util.Scanner;

/**
 * Gives input for the game
 */
public class HumanPlayer extends Player{

	public String nameTag = "Human";
	private boolean[] validity = {false,false,true};
	
	
	public HumanPlayer(){
		super();
	}
	
	public void move(){
		
		System.out.print("Enter your move, "+playerType+" player: ");
		
		//the move coords 
		playerX = 0;
		playerY = 0;
		
		//booleans to check input
		conditions = false;
		validity[0] = false;
		validity[1] = false;
		validity[2] = true;
		
		Scanner coordinates = new Scanner(System.in);
		String xAndY = coordinates.nextLine();
		coordinates = new Scanner(xAndY);
		
		//reads strings as input to get numbers
		if(coordinates.hasNextInt()){
			playerX = coordinates.nextInt()-1;
			validity[0] = true;

			if(coordinates.hasNextInt()){
				playerY= coordinates.nextInt()-1;
				validity[1] = true;

				if(coordinates.hasNext()){
					validity[2] = false;
				}
			}
			else System.out.println("\nInput not recognized. Follow [x] [y] format.\n");

		}
		else System.out.println("\nInput not recognized. Follow [x] [y] format.\n");

			
			if((playerX>=0 && playerY>=0) && //if all true
			   (playerX<yourGrid.length && playerY<yourGrid[0].length)) 
				
				if(validity[0] && validity[1] && validity[2])
					if(viableGrid[playerX][playerY].equals("_")){
					 	conditions = true;
				}
			
			else {System.out.println("\nCheck the bounds of the grid. Make sure its a valid move!\n");	
					conditions=false;
			}
			
	}
	
	
}
