package uk.curryGenerator;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

import javax.swing. *;

public class IngredientsCheckForm {
	
	private JFrame frame;
	private JLabel instructions;
	private ArrayList<JCheckBox> checkBox;
	private JButton addIngredient;
	private JButton cancel;
	
	//Set up components for the frame
	public IngredientsCheckForm(){
		
		instructions = new JLabel("Tick the ingredients you want to search for!", SwingConstants.CENTER);
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
		
		//Add the components to the top
		top.add(instructions);
		
		//Dynamicaly create check boxes for ingredients
		/**
		 * i=0;
		 * while(i < ingredients.size()){
		 * Checkbox individualCheckBox = new Checkbox(ingredients[0]);
		 * middle.add(individualCheckBox);
		 * checkBox.add(individualCheckBox);
		 * i ++;
		 * }
		*/
		
		//Adding the components to the buttons
		buttons.add(addIngredient, BorderLayout.WEST);
		buttons.add(cancel, BorderLayout.EAST);
		
		//Add the Panels to the frame
		frame.add(top, BorderLayout.NORTH);
		frame.add(middle, BorderLayout.CENTER);
		frame.add(buttons, BorderLayout.SOUTH);
		
		//Add actions for the buttons
		cancel.addActionListener(new CloseActionListener());
		addIngredient.addActionListener(new addIngredientsActionListener());
		
		//Initialising the frame
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.pack();
		frame.setSize(500, 500);
		frame.setVisible(true);
		
	}
	
	//Closes the frame when the close button is pressed
	class CloseActionListener implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
		frame.dispose();
	}
	}
	
	//Adds the ingredients to the search, then disposes the frame
	class addIngredientsActionListener implements ActionListener{
	
	public void actionPerformed(ActionEvent e) {
		for(JCheckBox element : checkBox){
		if(element.isSelected()){
			//Add to search
		}
		}
		frame.dispose();		
	}
	}
}