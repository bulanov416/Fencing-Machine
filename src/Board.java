import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.ImageObserver;

import javax.swing.JPanel;
import javax.swing.Timer;


//Main User Interface Graphics Class
@SuppressWarnings("serial")
public class Board extends JPanel implements ActionListener {
	
	//Creates a timer and a screen refresh delay variable.
	private Timer timer;
	private final int DELAY = 10;
	int h = mainUI.screenHeight;
	int w = mainUI.screenWidth;

	protected static Font score = new Font("Monospaced", Font.BOLD, (int)(0.3*mainUI.screenHeight));
	
	//Board Class Constructor, used for the graphics part of the UI.
	public Board() {
		
		//Opens the key listener
		addKeyListener(new TAdapter());
		setFocusable(true);
		
		//Sets background color to black
		setBackground(Color.BLACK);
		
		//Starts the refresh timer?
		timer = new Timer(DELAY, this);
		timer.start();
	}

	//Shows all of the painted graphics
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		doDrawing(g);
	}
	
	//Updates all of the graphics
	private void doDrawing(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;

		Color red = Color.RED;
		Color yellow = Color.YELLOW;
		Color green = Color.GREEN;
		
		g2d.setFont(score);
		
		drawRect(02, 02, 30, 30, g2d, red); 	//Fencer Red "Touch"
		drawRect(10, 45, 05, 05, g2d, red); 	//Fencer Red "Red Card"
		drawRect(19, 45, 05, 05, g2d, yellow);	//Fencer Red "Yellow Card"
		drawRect(02, 33, 30, 10, g2d, yellow);	//Fencer Red "Off Target"
		
		drawRect(68, 02, 30, 30, g2d, green);	//Fencer Green "Touch"
		drawRect(85, 45, 05, 05, g2d, red); 	//Fencer Green "Red Card"
		drawRect(76, 45, 05, 05, g2d, yellow);	//Fencer Green "Yellow Card"
		drawRect(68, 33, 30, 10, g2d, yellow);	//Fencer Green Off Target
		
		drawCircle(40, 24, 02, 02, g2d, red);	//Epee Light Indicator
		drawCircle(49, 24, 02, 02, g2d, red);	//Foil Light Indicator
		drawCircle(58, 24, 02, 02, g2d, red);	//Saber Light Indicator
		drawCircle(49, 10, 02, 02, g2d, red);	//Sound Indicator

		//Text
		g2d.setColor(Color.WHITE);
		int a = g2d.getFontMetrics().stringWidth("00");
		g2d.drawString("00", (int)(0.17*w-a/2), (int)(0.8*h));
		g2d.drawString("99", (int)(0.83*w-a/2), (int)(0.8*h));
		
		repaint();
	}
	
	public void drawRect(double x, double y, double width, double height, Graphics2D g2d, Color color) {
		g2d.setColor(color);
		g2d.fillRect((int)(x*w*0.01),(int)(y*h*0.01),(int)(width*w*0.01),(int)(height*h*0.01));
		g2d.setColor(Color.WHITE);
		g2d.draw3DRect((int)(x*w*0.01),(int)(y*h*0.01),(int)(width*w*0.01),(int)(height*h*0.01), true);
		g2d.setColor(color);
	}
	
	public void drawCircle(double x, double y, double width, double height, Graphics2D g2d, Color color) {
		g2d.setColor(color);
		g2d.fillOval((int)(x*w*0.01),(int)(y*h*0.01),(int)(width*w*0.01),(int)(height*w*0.01));
		g2d.setColor(Color.WHITE);
		g2d.drawOval((int)(x*w*0.01),(int)(y*h*0.01),(int)(width*w*0.01),(int)(height*w*0.01));
		g2d.setColor(color);
	}
	
	// Action event listener, not sure if it still serves practical purpose but still gonna leave it
	public void actionPerformed(ActionEvent e) {
	}
	
	//Key Adapter for testing
	private class TAdapter extends KeyAdapter {

		@Override
		public void keyReleased(KeyEvent e) {
			
		}

		@Override
		public void keyPressed(KeyEvent e) {
			
		}
	}
}