import java.awt.*;

import javax.swing.JFrame;

public class Star extends JFrame {
	private int numpts = 10;
	private Double[] dxpts = new Double[10];
	private Double[] dypts = new Double[10];
	private int[] xpts = new int[10];
	private int[] ypts = new int[10];
	
	public void fillsets() {
		for (int k = 0; k < 5; k++) {
			dxpts[2*k] = .5 + .5*Math.cos(2*k*Math.PI/5+Math.PI/2);
			dxpts[2*k+1] = .5 + .20*Math.cos(2*k*Math.PI/5+7*Math.PI/10);
	
			dypts[2*k]= .5 - .5*Math.sin(2*k*Math.PI/5 + Math.PI/2);
			dypts[2*k+1] = .5 - .19*Math.sin(2*k*Math.PI/5 + 7*Math.PI/10);
		}
	}

	public Star(int topleftx, int toplefty, int size) {
		fillsets();
		for (int k = 0; k < 10; k++) {
			Double newx = dxpts[k]*size;
			int newerx = newx.intValue();
			Double newy = dypts[k]*size;
			int newery = newy.intValue();
			xpts[k] = topleftx + newerx;
			ypts[k] = toplefty + newery;
		}
		init();
	}
	
	public void init() {
		setSize(700, 700);
		repaint();
	}
	
	public void paint(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillPolygon(xpts, ypts, numpts);
	}
}