// test UI

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class UI {
	public static void main(String[] args) {

		// Create frame, set size, and exit criteria
        JFrame frame = new JFrame("FrameDemo");   
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);         
        frame.setSize(500, 500);
        
        // Create a text label and put on the panel
        JLabel l = new JLabel("Hello world!");
        JPanel p = new JPanel();
        p.add(l);
 
        // add event listener for button press
        ActionHandler handler = new ActionHandler();
        JButton button = new JButton("Start");
        button.setSize(80, 80);
        button.addActionListener(handler);
        JPanel p2 = new JPanel();
        p2.add(button);

        // add panels to fram
        frame.add(p);
        frame.add(p2);

        // setup frame layout and 
        FlowLayout layout = new FlowLayout();
        frame.setLayout(layout);
        frame.setVisible(true);
	}
}