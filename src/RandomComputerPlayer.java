import java.io.File;

/**
	 Selects a random possible move
	 */
public class RandomComputerPlayer extends ComputerPlayer{

	public RandomComputerPlayer(){
		super();
	}

	
	public void move(){

		playerX = 0;
		playerY = 0;

		conditions = false;

		while(true){

			playerX = coordinates.nextInt(8);
			playerY = coordinates.nextInt(8);

			if(viableGrid[playerX][playerY].equals("_")){
				conditions = true;
				break;
			}

			else conditions=false;

		}

		System.out.print("Enter your move, "+playerType+" player: "+
				(playerX+1)+" "+(playerY+1)+"\n");

	}
}
