package uk.curryGenerator;
/**
 * Class responsible for generating the GUI.
 * @author Jenny
 */

import java.awt.*;
import javax.swing.*;

public class GUI {
	//Initialise the GUI for Adams Curry Generator
	private static void createAndShowGUI() {
		//Create and set up the window.
		JFrame frame = new JFrame("Adams Curry Generator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//Create the menu bar.  Make it have a red background.
		JMenuBar redMenuBar = new JMenuBar();
		redMenuBar.setOpaque(true);
		redMenuBar.setBackground(new Color(150, 0, 0));
		redMenuBar.setPreferredSize(new Dimension(600, 20));

		//Create a label to put in the content pane.
		JLabel Label = new JLabel();
		Label.setOpaque(true);
		Label.setPreferredSize(new Dimension(600, 600));

		//Set the menu bar and add the label to the content pane.
		frame.setJMenuBar(redMenuBar);
		frame.getContentPane().add(Label, BorderLayout.CENTER);

		//Display the window.
		frame.pack();
		frame.setVisible(true);
	}


	public static void main(String[] args) {
		//Schedule a job for the event-dispatching thread:
		//creating and showing this application's GUI.
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}
}

