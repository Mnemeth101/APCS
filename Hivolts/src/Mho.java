import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Mho {
	static int mhoNum = 2;
	int mhoX;
	int mhoY;
	BufferedImage img;
	
	public Mho(int xcoord, int ycoord) {
		this.mhoX = xcoord;
		this.mhoY = ycoord;
	}

	public void setImage() {
		try {
		    img = ImageIO.read(new File("res/mho.png"));
		} catch (IOException e) {
		}
	}
		
	public void draw(int x_offset, int y_offset, int width, int height, Graphics g) {
		// I leave this understanding to the reader
		int x = x_offset + 1 + (mhoX * (width + 1));
		int y = y_offset + 1 + (mhoY * (height + 1));
		
		g.drawImage(img, x, y, width, height, null);
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
					boolean emptyspace = b.getGameBoard()[mhoY+k][mhoX+i] == 2;
					boolean elecfence = b.getGameBoard()[mhoY+k][mhoX+i] == 3;
					/*
					 * 
					 * THERE ARE STILL ERRORS IN THE CODE
					 * 1) CHECK IF THE MOVEMENT IS DIAGONAL
					 * 2) DISTANCE SHOULD BE BEFORE MOVEMENT (distX) NOT AFTER MOVEMENT (distX1)
					 * 
					 * 
					 */
					//if diagonal, and moving decreases the distance to player, then more onto empty square
					if ((smallerX) && (smallerY) && (emptyspace)){
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
