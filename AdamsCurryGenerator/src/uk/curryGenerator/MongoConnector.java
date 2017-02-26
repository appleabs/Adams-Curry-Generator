package uk.curryGenerator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.mongodb.AggregationOutput;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
/**
 * class responsible for connecting to an instance of a mongo database
 * @author thirdratecyberpunk
 *
 */
public class MongoConnector{
	// client used to access mongo databases
	MongoClient mongo;
	// database of recipes
	DB recipes;
	// collection of curry recipes
	DBCollection curries;
	// collection of ingredients
	DBCollection ingredients;

	/**
	 * constructor
	 */
	public MongoConnector(){
		mongo = new MongoClient( "localhost");
		// creates or connects to the recipes database
		recipes = mongo.getDB("recipes");
		// defines a collection of curry recipes
		curries = recipes.getCollection("curries");
		// defines a collection of ingredients
		ingredients = recipes.getCollection("ingredients");
	}

	/**
	 * returns the contents of the ingredients document as an arraylist
	 * @return
	 */
	public ArrayList<String> getIngredients(){
		// perform query on database
		DBCursor cursor = ingredients.find();
		List<DBObject> docs = cursor.toArray();
		ArrayList<String> ingredientNames = new ArrayList<String>();
		for (DBObject ingredient: docs){
			ingredientNames.add((String) ingredient.get("name"));
		}
		return ingredientNames;
	}

	/**
	 * gets a random recipe from the database and returns it to the interface as a map
	 */
	public Map getRandomRecipe(){
		// TODO: implement aggregation method, but this requires MongoDB 3.6 apparently
		// https://docs.mongodb.com/manual/aggregation/
		// create pipeline $sample operation
		// BasicDBObject sample = new BasicDBObject("$sample", new BasicDBObject("size", "1"));
		// get a single recipe from the database
		// AggregationOutput result = curries.aggregate(sample);

		// current implementation is far less clean but >hackathons >clean code
		// perform query on database to pull item in this range
		DBCursor cursor = curries.find();
		// generate random number within range of length of database contents
		Random random = new Random();
		// this is a disgusting idea and if this somehow has a billion curries will be regrettable
		// but yeah, no mongo 3.6
		List<DBObject> docs = cursor.toArray();
		int recipe = random.nextInt(docs.size());
		DBObject recipeObject = docs.get(recipe);
		Map recipeMap = recipeObject.toMap();
		return recipeMap;
	}

	/*
	 * gets recipes which contain the specified ingredients and returns a random one
	 * TODO: implement this behaviour
	 */
	public void getIngredientRecipe(){

	}

	/**
	 * adds a given recipe to the recipe collection
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
	}

	/**
	 * adds a given ingredient to the ingredients collection
	 * @param name
	 */
	public void addNewIngredient(String name){
		BasicDBObject newIngredient = new BasicDBObject();
		newIngredient.put("name", name);
		ingredients.insert(newIngredient);
	}
}
