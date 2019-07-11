package backend;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import interfaces.DatabaseInterface;
import interfaces.RecipeInterface;
import interfaces.UserInterface;

@Component("MongoDB")
public class MongoDB implements DatabaseInterface {

	MongoClient mongoClient;
	MongoDatabase database;
	MongoCollection<Document> collection;
	
	public MongoDB() {
		MongoClientURI uri = new MongoClientURI("mongodb://46.101.130.46:27017");

		this.mongoClient = new MongoClient(uri);
		
		this.database = mongoClient.getDatabase("recipe");
		this.collection = database.getCollection("recipe");
	}

	@Override
	public List<Document> findAllRecipes() {
		List<Document> l = new ArrayList<>();
		l = (List<Document>) this.collection.find().into(new ArrayList<Document>());
		return l;
	}

	@Override
	public RecipeInterface saveRecipe(RecipeInterface newRecipe) {
		Document d = new Document();
		d.append("name", newRecipe.getName());
		d.append("link", newRecipe.getLink());
		d.append("desc", newRecipe.getDesc());
		d.append("ingredients", newRecipe.getIngredients());
		this.collection.replaceOne(new Document("link", newRecipe.getLink()), d);
		return newRecipe;
	}

	@Override
	public List<Document> findRecipeByLink(String link) {
		Document d = new Document("name", link);
		return this.collection.find(d).into(new ArrayList<Document>());
	}

	@Override
	public List<RecipeInterface> findAllRecipesForUser(UserInterface user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Document> findAllRecipesForUser(long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
}