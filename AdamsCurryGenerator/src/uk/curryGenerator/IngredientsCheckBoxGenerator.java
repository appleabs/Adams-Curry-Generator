/**
 * 
 */
package uk.curryGenerator;

import java.awt.GridBagConstraints;
import java.util.ArrayList;

import javax.swing.JCheckBox;
import javax.swing.JPanel;
import java.awt.GridBagLayout;

/**
 * Creates the list of ingredients as a checkbox taken from the database
 * @author thirdratecyberpunk
 *
 */
public class IngredientsCheckBoxGenerator {
	public static JPanel ingredientsCheckBox(){
		// creates a JPanel object and returns it
		MongoConnector mc = new MongoConnector();
		//dynamically create check boxes for ingredients
		JPanel ingredientsPanel = new JPanel(new GridBagLayout());
		int i = 0;
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.gridx = 0;
		ArrayList<String> ingredients = mc.getIngredients();
		while(i < ingredients.size()){
			JCheckBox individualCheckBox = new JCheckBox(ingredients.get(i));
			constraints.gridy = i;
			ingredientsPanel.add(individualCheckBox, constraints);
			//checkBox.add(individualCheckBox);
			i++;
		}
		return ingredientsPanel;
	}
}
