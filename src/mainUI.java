import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;

//Main UI class that contains most of the technical stuff and no UI
@SuppressWarnings("serial")
public class mainUI extends JFrame {
	
	// Creates a new frame and panel
	static JFrame frame = new JFrame ();
	static JPanel panel = (JPanel) frame.getContentPane();
	
	// Creates the toolkit that allows screen dimension and other info
	static Toolkit tk = Toolkit.getDefaultToolkit();
    static Dimension screenSize = tk.getScreenSize();
    
    //Sets screen size as static variable to be used for rest of UI
    static int screenHeight = screenSize.height;
    static int screenWidth = screenSize.width;
    
	//UI Constructor, pretty much everything specific to our window.
    public mainUI() {
    	
    	//Links the JFrame to the JPanel
        add(new Board());
        
        // Windows size can't be changed while open.
        setResizable(false);
        
        // Sets screen size and title
        setSize(screenWidth, screenHeight);
        setTitle("Scoring System");
        
        // Sets starting location in top left corner
        setLocationRelativeTo(null);
        
        //Stops the window from crashing when its closed.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    //Main function which runs the program.
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                
                mainUI ex = new mainUI();
                ex.setVisible(true);
            }
        });
    }
}