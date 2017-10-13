import java.awt.Graphics;

import javax.swing.JApplet;
/*
 * 
 * JUST WRITE EVERYTHING IN THE showBoard() method in BOARD
 * 
 */
public class Display extends JApplet{
	private final int X_GRID_OFFSET = 25; // 25 pixels from left
	private final int Y_GRID_OFFSET = 40; // 40 pixels from top
	private final int CELL_WIDTH = 10;
	private final int CELL_HEIGHT = 10;
	
	private final int DISPLAY_WIDTH;   
	private final int DISPLAY_HEIGHT;
	
	private Game Game;
	
	public Display (int width, int height, Game game) {
		DISPLAY_WIDTH = width;
		DISPLAY_HEIGHT = height;
		this.Game = game;
		init();
	}
	
	public void init() {
		setSize(DISPLAY_WIDTH, DISPLAY_HEIGHT);
	}
	
	public void drawGrid(Graphics g) {
		for (int row = 0; row <= 12; row++) {
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
	
	public void drawThings(Graphics g) {
		for (int row = 0; row < 12; row++) {
			for (int col = 0; col < 12; col++) {
				//draw picture with size Cell_Height, Cell_Width
				int type = Game.gameBoard.getGameBoard()[col][row];
				switch (type) {
					case 0:;
					case 1: //insert picture of player;
						//Player.draw(
					case 2: //insert picture of Mho;
					case 3: //insert picture of fence;
				}
				
				//
			}
		}
		
	}
	
	
	
}
