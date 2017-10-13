import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.io.File;
import java.io.IOException;

import javax.imageio.*;
import java.awt.image.*;

public class Board extends JComponent{
	private int[][] gameBoard = new int[12][12];
	Mho[] mhos = new Mho[12];
	
	private final int X_GRID_OFFSET = 25; // 25 pixels from left
	private final int Y_GRID_OFFSET = 40; // 40 pixels from top
	private final int CELL_WIDTH = 30;
	private final int CELL_HEIGHT = 30;
	
	private int DISPLAY_WIDTH = 500;   
	private int DISPLAY_HEIGHT = 500;
	
	public Board() {
		createBorder();
		createFence();
		createMho();
		//createPlayer();
		setSize(500, 500);
	}
	
	public void createPlayer(Player player) {
		int cord1=0;
		int cord2=0;
		
		while((gameBoard[cord1][cord2]==3)||(gameBoard[cord1][cord2]==2)) {
			cord1 = getRand(1,12);
			//System.out.println(cord1);				
			cord2 = getRand(1,12);
			//System.out.println(cord2);
		}
		
		player.setPos(cord1, cord2);	
		gameBoard[cord1][cord2] = 1;
	}


	public void createMho() {
		int cord1=0;
		int cord2=0;
		
		for (int i = 0; i<12; i++) {
			//System.out.print(i);
			while((gameBoard[cord1][cord2]==3)||(gameBoard[cord1][cord2]==2)) {
				cord1 = getRand(1,12);
				//System.out.println(cord1);
				cord2 = getRand(1,12);
				//System.out.println(cord2);
			}
			
			mhos[i] = new Mho(cord1, cord2);
			gameBoard[cord1][cord2] = 2;
			
		}
		
	}

	public void createBorder() {
		for (int i = 0; i<12; i++) {
			gameBoard[0][i] = 3;
			gameBoard[11][i] = 3;
			gameBoard[i][0] = 3;
			gameBoard[i][11] = 3;
		}
		Fence justafence = new Fence();
	}
	
	public void createFence() {
		//Random FC = new Random();
		int cord1=0;
		int cord2=0;
		
		for (int i = 0; i<20; i++) {
			//System.out.print(i);
			while(gameBoard[cord1][cord2]==3) {
				cord1 = getRand(1,12);
				//System.out.println(cord1);
				cord2 = getRand(1,12);
				//System.out.println(cord2);
			}
			
			gameBoard[cord1][cord2] = 3;
		}
		
	}
	
	/**
	 * 
	 * @param start
	 * @param end
	 * @return random # between given min and max
	 */
	public static int getRand(int min, int max) {
		int retVal = -1;
		
		while(retVal<min) {
			retVal = (int) Math.ceil((Math.random()*(max-1)));
			//System.out.println("rand:"+retVal);
		}
		
		return retVal;
	}
	
	public void showBoard() {
		repaint();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (true) {
			drawThings(g);
			drawGrid(g);
		}
	}

	void drawThings(Graphics g) {
		for (int row = 0; row < 12; row++) {
			for (int col = 0; col < 12; col++) {
				//draw picture with size Cell_Height, Cell_Width
				int type = gameBoard[col][row];
				int x = X_GRID_OFFSET + 1 + (row * (CELL_WIDTH + 1));
				int y = Y_GRID_OFFSET + 1 + (col * (CELL_HEIGHT + 1));

				switch (type) {
					case 0: break;
					case 1: if (Player.dead) {Player.setImageDead();}
							g.drawImage(Player.getImage(), x, y, CELL_WIDTH, CELL_HEIGHT, null);
							break;
					case 2: for (Mho m : mhos) {
								if (((m.getX() == row) && (m.getY() == col))) {
									g.drawImage(m.getImage(), x, y, CELL_WIDTH, CELL_HEIGHT, null);
								}
							}
							break;
					case 3: g.drawImage(Fence.getImage(), x, y, CELL_WIDTH, CELL_HEIGHT, null);
							break;
							
				}
			}
		}
	}

	void drawGrid(Graphics g) {
		for (int row = 0; row <= 12; row++) {
			g.setColor(Color.BLACK);
			g.drawLine(X_GRID_OFFSET,
					Y_GRID_OFFSET + (row * (CELL_HEIGHT + 1)), X_GRID_OFFSET
					+ 12 * (CELL_WIDTH + 1), Y_GRID_OFFSET
					+ (row * (CELL_HEIGHT + 1)));
		}
		for (int col = 0; col <= 12; col++) {
			g.drawLine(X_GRID_OFFSET + (col * (CELL_WIDTH + 1)), Y_GRID_OFFSET,
					X_GRID_OFFSET + (col * (CELL_WIDTH + 1)), Y_GRID_OFFSET
					+ 12 * (CELL_HEIGHT + 1));
		}
	}

	public int[][] getGameBoard() {
		return gameBoard;
	}
	
	public Mho[] getMhoList() {
		return mhos;
	}
	
	
}