package uk.curryGenerator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
/**
 * class responsible for connecting to an instance of a mongo database
 * @author purple
 *
 */
public class MongoConnector{
	// client used to access mongo databases
	MongoClient mongo;
	// database of recipes
	DB recipes;
	// collection of curry recipes
	DBCollection curries;
	/**
	 * constructor
	 */
	public MongoConnector(){
		mongo = new MongoClient( "localhost");
		// creates or connects to the recipes database
		recipes = mongo.getDB("recipes");
		// defines a collection of curry recipes
		curries = recipes.getCollection("curries");
	}


	/**
	 * retrieves a random recipe from the database
	 */
	public void getRandomRecipe(){
		System.out.println("Hi!");
	}

	/**
	 * adds a given recipe to the database
	 * @param name
	 * @param ingredients
	 * @param steps
	 * @param strength
	 */
	public void addNewRecipe(String name, HashMap<String, Integer> ingredients, ArrayList<String> steps, int strength){
		BasicDBObject newRecipe = new BasicDBObject();
		newRecipe.put("name", name);
		newRecipe.put("ingredients", ingredients);
		newRecipe.put("steps", steps);
		newRecipe.put("strength", strength);
		curries.insert(newRecipe);
		System.out.println("Should have written new recipe to database");
	}
}
