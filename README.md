March 4, 2016

To run the game, type in this format 
	java Reversi [player1] [player2]
	
	for example 
	Java Reversi Human RandomComputerPlayer
	
	Player types: Human RandomComputerPlayer and IntelligentComputerPlayer


Reversi is a strategy game designed for two players and consists of 64 two colored disks and a divided 8x8 board. The objective of the game is to take turns placing their colored disks on the board and change the opponents piece to their own color, thus having the majority of the disks show their own color until the board is filled and no moves can be made.

INSTRUCTIONS:

1.) Instead of using two colored disks, this game will make use of X and O. Player 1 will be assigned to X and Player 2 will be assigned to O. 
2.) Player 1 will go first and will type in coordinates (horizontal first then vertical)
3.) The game will repeat with the opponent making it’s move and going back to Player 1.
4.) The game will end when the board is filled or no moves can be made.

INTELLIGENT PLAYER:

We used a method that would count up the enemy chips in between a _ and the player's chip
and see what _ had the greatest potential. The one with the greatest potential would have a matching boolean set to true and that would determine what intelligent player's playerX and playerY variables
would be to move.

