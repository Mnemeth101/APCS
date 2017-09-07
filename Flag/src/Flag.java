import java.awt.*;

import javax.swing.JFrame;

public class Flag extends JFrame{
	private static int Length = 190*3;
	private static int Height = 100*3;
	private int offsetx = 5;
	private int offsety = 30;
	
	public Flag() {
		init();
	}
	
	public void init() {
		setSize(Length + 2*offsetx, Height + offsety);
		repaint();
	}
	
	public void paint(Graphics g) {
		Height = this.getHeight();
		Length = this.getWidth() - 2*offsetx;
		int scaleL = (int) (0.0404858 * Length);
		int scaleC = (int) (7*scaleL);
		int scaleD = (int) (.4*Length);
		
		//paint over with white
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, Length + 2*offsetx, Height);
		
		//red stripes
		g.setColor(Color.RED);
		for (int i = 0; i < 7; i++) {
			int k = 2*i*scaleL;
			g.fillRect(offsetx, offsety + k, Length, scaleL);
		}
		g.setColor(Color.BLACK);
		g.drawRect(offsetx, offsety, Length, 13*scaleL);
		
		Union u = new Union(scaleD, scaleC);
		u.paint(g);
	}

	
}

