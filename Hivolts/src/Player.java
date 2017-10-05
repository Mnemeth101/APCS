import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Player{
	int posX;
	int posY;
	boolean dead = false;
	BufferedImage img;

	public boolean isDead() {
		return dead;
	}

	public Player() {

	}
	
	public void setPos(int Y, int X) {
		this.posX = X;
		this.posY = Y;
	}
	
	public void checkMove() {
		
	}

	public void death() {
		System.out.println("You died!");
		System.out.println("Press 'space' to play again");
		dead = true;
		//System.exit(0);
	}
	
	public void setImage() {
		try {
		    img = ImageIO.read(new File("res/fence.png"));
		} catch (IOException e) {
		}
	}
		
	public void draw(int x_offset, int y_offset, int width, int height, Graphics g) {
		// I leave this understanding to the reader
		int x = x_offset + 1 + (posX * (width + 1));
		int y = y_offset + 1 + (posY * (height + 1));
		
		g.drawImage(img, x, y, width, height, null);
	}
	
}