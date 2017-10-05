import java.awt.Graphics;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.*;

public class Fence {
	static int fenceNum = 3;
	private int myX;
	private int myY;
	private BufferedImage img;
	
	public Fence (int x, int y) {
		this.myX = x;
		this.myY = y;
	}
	
	public void setImage() {
		try {
		    img = ImageIO.read(new File("res/fence.png"));
		} catch (IOException e) {
		}
	}
		
	public void draw(int x_offset, int y_offset, int width, int height, Graphics g) {
		// I leave this understanding to the reader
		int x = x_offset + 1 + (myX * (width + 1));
		int y = y_offset + 1 + (myY * (height + 1));
		
		g.drawImage(img, x, y, width, height, null);
	}
}
