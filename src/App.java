import javax.swing.JFrame;
import javax.swing.JPanel;

import java.util.*;

public class App {
	
    
    public static void main(String[] args) throws Exception {
        
        JFrame frame = new JFrame("App");
        JPanel panel = new gui.MainMenu();

        frame.setSize(400, 300);
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
		
		

    }

}