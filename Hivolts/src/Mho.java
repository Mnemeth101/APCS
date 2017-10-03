
public class Mho {
	static int mhoNum = 2;
	int mhoX;
	int mhoY;

	public Mho(int xcoord, int ycoord) {
		this.mhoX = xcoord;
		this.mhoY = ycoord;
	}

	public void move (Board b) {
		//get coordinates of player
		int playerX = b.getPlayerX();
		int playerY = b.getPlayerY();

		int distX = Math.abs(playerX-mhoX);
		int distY = Math.abs(playerY-mhoY);

		//first move vertical/horizontal if directly above/to the side
		if (distX == 0) {
			mhoX = 0;
			if (Math.abs(playerY-(mhoY + 1)) < distY) {
				mhoY++;
			}
			else {
				mhoY--;
			}
		}
		
		else if (distY == 0) {
			mhoY = 0;
			if (Math.abs(playerX-(mhoX + 1)) < distX) {
				mhoX++;
			}
			else {
				mhoX--;
			}
		}
		//move based on conditions
		else {
			for (int i = -1; i < 1; i++) {
				for (int k = -1; k < 1; k++) {
					int distX1 = Math.abs(playerX-(mhoX+i));
					int distY1 = Math.abs(playerY-(mhoY+k));
					boolean smallerX = distX1 < distX;
					boolean smallerY = distY1 < distY;
					boolean emptyspace = b.gameBoard[mhoX+i][mhoY+k] == 2;
					boolean elecfence = b.gameBoard[mhoX+i][mhoY+k] == 3;
					
					//if diagonal, and moving decreases the distance to player, then more onto empty square
					if ((distX1 == distY1) && (smallerX) && (smallerY) && (emptyspace)){
						distX = distX1;
						distY = distY1;
						mhoX += i;
						mhoY += k;
					}
					//if horizontal distance is greater than vertical distance and decreases distance to player, then move onto empty square
					else if ((distX1 > distY1) && (smallerX) && (emptyspace)) {
						distX = distX1;
						mhoX += i;
						mhoY += k;
					}
					//if vertical distance is greater than horizontal distance and decreases distance to player, then move onto empty square
					else if ((distY1 > distX1) && (smallerY) && (emptyspace)) {
						distY = distY1;
						mhoX += i;
						mhoY += k;
					}
					else {
							//if diagonal, and moving decreases the distance to player, then move onto fence
							if ((distX1 == distY1) && (smallerX) && (smallerY) && (elecfence)){
								distX = distX1;
								distY = distY1;
								mhoX += i;
								mhoY += k;
							}
							//if horizontal distance is greater than vertical distance and decreases distance to player, then move onto fence
							else if ((distX1 > distY1) && (smallerX) && (elecfence)) {
								distX = distX1;
								mhoX += i;
								mhoY += k;
							}
							//if vertical distance is greater than horizontal distance and decreases distance to player, then move onto fence
							else if ((distY1 > distX1) && (smallerY) && (elecfence)) {
								distY = distY1;
								mhoX += i;
								mhoY += k;
							}
							//otherwise don't move
							else {
							}
					}
				}
			}
		}		
	}

}
