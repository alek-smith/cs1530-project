import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;

import java.util.*;

public class App {
	
    
	
	
	
	
    public static void main(String[] args) throws Exception {
        
        JFrame frame = new JFrame("App");
        gui.MainMenu panel = new gui.MainMenu();
        String username = JOptionPane.showInputDialog("Enter username");
        if (username == null) return;

        FileInputStream fileIn = null;
        try {
            fileIn = new FileInputStream(username);
            Scanner input = new Scanner(fileIn);
            panel.load(input);
            fileIn.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        frame.setSize(400, 300);
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
		
		frame.addWindowListener(new WindowListener() {

            @Override
            public void windowClosing(WindowEvent e) {
                FileOutputStream fileOut = null;
                try {
                    fileOut = new FileOutputStream(username);
                } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                    return;
                }
                PrintWriter output = new PrintWriter(fileOut);
                panel.save(output);
                output.close();
                try {
                    fileOut.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }

            public void windowOpened(WindowEvent e) {}
            public void windowClosed(WindowEvent e) {}
            public void windowIconified(WindowEvent e) {}
            public void windowDeiconified(WindowEvent e) {}
            public void windowActivated(WindowEvent e) {}
            public void windowDeactivated(WindowEvent e) {}
            
        });

    }

}