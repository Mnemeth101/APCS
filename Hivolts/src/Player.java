import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Player{
	int posX;
	int posY;
	static boolean dead = false;
	boolean turn = true;
	static BufferedImage img;

	public boolean isDead() {
		return dead;
	}
	
	public static void setAlive() {
		dead = false;
	}

	public Player() {
		setImage();
	}
	
	public void setPos(int Y, int X) {
		this.posX = X;
		this.posY = Y;
	}
	
	public void death() {
		System.out.println("You died!");
		System.out.println("Press 'space' to play again");
		turn = false;
		dead = true;
		//System.exit(0);
	}
	
	public static void setImage() {
		try {
		    img = ImageIO.read(new File("res/player.png"));
		} catch (IOException e) {
		}
	}
	
	public static void setImageDead() {
		try {
		    img = ImageIO.read(new File("res/deadplayer.png"));
		} catch (IOException e) {
		}
	}
	
	public static BufferedImage getImage() {
		return img;
	}	
	
}