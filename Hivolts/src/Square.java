import javax.swing.JApplet;
import java.awt.*;

public class Square extends JApplet{
	
	public static int size;
	private static int offset;
	private int coordx;
	private int coordy;
	private int UpLeftx;
	private int UpLefty;
	
	public Square(int coordx, int coordy) {
		this.coordx = coordx;
		this.coordy = coordy;
	}
	
	public void draw(Graphics g) {
		g.drawRect(UpperLeft, , width, height);
	}
	
}
