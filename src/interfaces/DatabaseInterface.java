package interfaces;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.springframework.stereotype.Component;

import com.mongodb.client.FindIterable;

@Component("DatabaseInterface")
public interface DatabaseInterface {
	public List<Document> findAllRecipes();
	public List<RecipeInterface> findAllRecipesForUser(UserInterface user);
	public List<Document> findAllRecipesForUser(long id);
	public RecipeInterface saveRecipe(RecipeInterface newRecipe);
	public List<Document> findRecipeByLink(String link);
}
