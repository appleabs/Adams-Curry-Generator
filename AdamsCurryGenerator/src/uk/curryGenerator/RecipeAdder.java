package uk.curryGenerator;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

/**
 * screen for adding a new recipe to the mongo database
 * @author Jenny
 * @author thirdratecyberpunk
 *
 */
public class RecipeAdder {

	// frame TODO: improve this documentation
	private JFrame frame;
	// label explaining purpose of screen
	private JLabel title;
	// label explaining name input
	private JLabel curryName;
	// input for name of recipe being entered
	private JTextArea userCurry;
	// label explaining checkboxes
	private JLabel ingredients;
	// label explaining recipe input
	private JLabel recipe;
	// input for steps in making curry
	private JTextArea userRecipe;
	// label explaining strength rating
	private JLabel strength;
	// input for strength of curry
	private JTextArea userStrength;
	// submits given recipe to database
	private JButton submit;
	// returns user to the main menu
	private JButton cancel;
	
	public RecipeAdder(){
		
		//Set up components for the frame
		title = new JLabel();
		curryName = new JLabel("Curry Name:");
		userCurry = new JTextArea();
		ingredients = new JLabel("Ingredients:");
		recipe = new JLabel("Recipe:");
		userRecipe = new JTextArea();
		//TODO: replace this with a slider or 5 star rating
		strength = new JLabel("Strength 1-5");
		submit = new JButton("Submit");
		cancel = new JButton("Cancel");
		
		//Set up initial frame
		frame = new JFrame("Recipe Adder");
		
		//Set up the panels from the components
		JPanel top = new JPanel(new BorderLayout());
		JPanel middle = new JPanel(new BorderLayout());
		JPanel bottom = new JPanel(new BorderLayout());
		
		//Initialise the frames layout
		frame.setLayout(new BorderLayout());
		
		//Add components to the top
		top.add(title, BorderLayout.NORTH);
		top.add(curryName, BorderLayout.CENTER);
		top.add(userCurry, BorderLayout.SOUTH);
		
		//Add components to the middle
		middle.add(ingredients, BorderLayout.NORTH);
		//middle.add(CheckBox, BorderLayout.CENTER);
		middle.add(recipe, BorderLayout.SOUTH);
		
		//Add components to the bottom
		bottom.add(userRecipe, BorderLayout.NORTH);
		bottom.add(submit, BorderLayout.WEST);
		bottom.add(cancel, BorderLayout.EAST);
		
		//Add the panels to the frame
		frame.add(top, BorderLayout.NORTH);
		frame.add(middle, BorderLayout.CENTER);
		frame.add(bottom, BorderLayout.SOUTH);
		
		//Set the buttons
		cancel.addActionListener(new CancelActionListener());
		submit.addActionListener(new SubmitActionListener());
		
		//Initialising the frame
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.pack();
		frame.setSize(500, 500);
		frame.setVisible(true);
	}
	
	class CancelActionListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			frame.dispose();
		
	}
	}
		
	class SubmitActionListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			String name = userCurry.getText();
			System.out.println(name);
			ArrayList<String> ingredients = new ArrayList<String>();
			ingredients.add("Chicken");
			ingredients.add("Saffron");
			ingredients.add("Tomatoes");
			System.out.print(ingredients);
			ArrayList<String> steps = new ArrayList<String>();
			steps.add(userRecipe.getText());
			System.out.println(steps);
			int strength = Integer.parseInt(userStrength.getText());
			System.out.println(strength);
			//submit the recipe to the database
			MongoConnector mc = new MongoConnector();
			mc.addNewRecipe(name, ingredients, steps, strength);
			frame.dispose();
		}
	}
}
