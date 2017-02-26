package uk.curryGenerator;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing. *;

public class IngredientsCheckForm {
	
	private JFrame frame;
	private JLabel instructions;
	private JLabel checkBox;
	private JButton addIngredient;
	private JButton cancel;
	
	//Set up components for the frame
	public IngredientsCheckForm(){
		
		instructions = new JLabel("Tick the ingredients you want to search for!", SwingConstants.CENTER);
		checkBox = new JLabel();
		addIngredient = new JButton("Add Ingredient");
		cancel = new JButton("Cancel");
		
		//Set up the frame
		frame = new JFrame("Add Ingredients");
		
		//Initialise the panels
		JPanel top = new JPanel(new BorderLayout());
		JPanel middle = new JPanel(new BorderLayout());
		JPanel buttons = new JPanel(new BorderLayout());
		
		//Initialise the frames layout
		frame.setLayout(new BorderLayout());
		
		//Add the components to the panels
		top.add(instructions);
		middle.add(checkBox);
		buttons.add(addIngredient, BorderLayout.WEST);
		buttons.add(cancel, BorderLayout.EAST);
		
		//Add the Panels to the frame
		frame.add(top, BorderLayout.NORTH);
		frame.add(middle, BorderLayout.CENTER);
		frame.add(buttons, BorderLayout.SOUTH);
		
		cancel.addActionListener(new CloseActionListener());
		
		//Initialising the frame
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.pack();
		frame.setSize(500, 500);
		frame.setVisible(true);
		
	}
	
	class CloseActionListener implements ActionListener{
		
	public void actionPerformed(ActionEvent e) {
		frame.dispose();
	}
}
}
