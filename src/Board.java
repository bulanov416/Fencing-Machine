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
		int h = mainUI.screenHeight;
		int w = mainUI.screenWidth;
		g2d.setFont(score);
		
		//Draws Red Box
		g2d.setColor(Color.RED);
		
		g2d.fillRect((int)(0.02*w),(int)(0.02*h),(int)(0.3*w),(int)(0.3*h));
		g2d.fillRect((int)(0.10*w),(int)(0.45*h),(int)(0.05*w),(int)(0.05*h));
		g2d.fillRect((int)(0.85*w),(int)(0.45*h),(int)(0.05*w),(int)(0.05*h));
		
		//Draws Green Box
		g2d.setColor(Color.GREEN);
		g2d.fillRect((int)(0.68*w),(int)(0.02*h),(int)(0.3*w),(int)(0.3*h));
		
		// Draws Yellow Boxes
		g2d.setColor(Color.YELLOW);
		g2d.fillRect((int)(0.02*w),(int)(0.33*h),(int)(0.3*w), (int)(0.1*h));
		g2d.fillRect((int)(0.68*w),(int)(0.33*h),(int)(0.3*w), (int)(0.1*h));
		g2d.fillRect((int)(0.19*w),(int)(0.45*h),(int)(0.05*w),(int)(0.05*h));
		g2d.fillRect((int)(0.76*w),(int)(0.45*h),(int)(0.05*w),(int)(0.05*h));

	
		//Text
		g2d.setColor(Color.WHITE);
		int a = g2d.getFontMetrics().stringWidth("00");
	
		g2d.drawString("00", (int)(0.17*w-a/2), (int)(0.8*h));
		g2d.drawString("99", (int)(0.83*w-a/2), (int)(0.8*h));
		
		g2d.draw3DRect((int)(0.02*w),(int)(0.02*h),(int)(0.3*w),(int)(0.3*h),true);
		g2d.draw3DRect((int)(0.10*w),(int)(0.45*h),(int)(0.05*w),(int)(0.05*h),true);
		g2d.draw3DRect((int)(0.85*w),(int)(0.45*h),(int)(0.05*w),(int)(0.05*h),true);
		g2d.draw3DRect((int)(0.68*w),(int)(0.02*h),(int)(0.3*w),(int)(0.3*h),true);
		g2d.draw3DRect((int)(0.02*w),(int)(0.33*h),(int)(0.3*w), (int)(0.1*h),true);
		g2d.draw3DRect((int)(0.68*w),(int)(0.33*h),(int)(0.3*w), (int)(0.1*h),true);
		g2d.draw3DRect((int)(0.19*w),(int)(0.45*h),(int)(0.05*w),(int)(0.05*h),true);
		g2d.draw3DRect((int)(0.76*w),(int)(0.45*h),(int)(0.05*w),(int)(0.05*h),true);
		
		repaint();
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