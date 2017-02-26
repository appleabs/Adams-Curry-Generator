package uk.curryGenerator;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

import javax.swing. *;

/**
 * popup window which asks the user to enter ingredients to narrow down the curry they receive
 * TODO: make this window have priority and hide the main window when it appears
 * TODO: improve documentation
 * TODO: implement search bar so user can find specific ingredients if there's a lot to add
 * @author Jenny
 *
 */
public class IngredientsCheckForm {

	private JFrame frame;
	private JLabel instructions;
	private ArrayList<JCheckBox> checkBox;
	private JButton addIngredient;
	private JButton cancel;
	private JPanel middle;

	//Set up components for the frame
	public IngredientsCheckForm(){

		instructions = new JLabel("Tick the ingredients you want to include in your recipe!", SwingConstants.CENTER);
		addIngredient = new JButton("Add Ingredient");
		cancel = new JButton("Cancel");

		//Set up the frame
		frame = new JFrame("Add Ingredients");

		//Initialise the panels
		JPanel top = new JPanel(new BorderLayout());
		JPanel middle = IngredientsCheckBoxGenerator.ingredientsCheckBox();
		JPanel buttons = new JPanel(new BorderLayout());

		//Initialise the frames layout
		frame.setLayout(new BorderLayout());

		//Add the components to the top
		top.add(instructions);

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

	//Adds the ingredients to the search, then passes the frame 
	class addIngredientsActionListener implements ActionListener{

		/**
		 * passes the selected checkboxes to the GUI to send the new
		 */
		public ArrayList<String> actionPerformed(ActionEvent e) {
			ArrayList<String> ingredients = new ArrayList<String>();
			// checks if any checkboxes are ticked
			for (Component checkbox : middle.getComponents()) {
				// this check might be unneeded as the middle should only be checkboxes, but safety 
				if (checkbox instanceof JCheckBox){
					if (((AbstractButton) checkbox).isSelected()){
						ingredients.add( ((AbstractButton) checkbox).getText());
					}
				}
			}
			frame.dispose();	
			return ingredients;
		}
	}
}