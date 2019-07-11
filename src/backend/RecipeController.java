package backend;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mongodb.client.FindIterable;

import interfaces.DatabaseInterface;
import interfaces.RecipeInterface;
import objects.Recipe;

@RestController
public class RecipeController {

  @Autowired
  private final DatabaseInterface db;

  
  public RecipeController() {
    this.db = new MongoDB();
  }

  // Aggregate root
  
  @RequestMapping("/")
  public String index() {
      return "Congratulations from BlogController.java";
  }
  
  
  @GetMapping("/test")
  public String test() {
    return "test";
  }

  @GetMapping("/recipes")
  List<Document> all() {
    return db.findAllRecipes();
  }
  
  @GetMapping("/users/{id}/recipes")
  List<Document> allForUser(@PathVariable Long id) {
    return db.findAllRecipesForUser(id);
  }

  @PostMapping("/recipes")
  RecipeInterface newRecipe(@RequestBody Recipe newRecipe) {
    return db.saveRecipe(newRecipe);
  }

  // Single item

  @GetMapping("/recipes/{link}")
  List<Document> one(@PathVariable String link) {
	  return db.findRecipeByLink(link);
  }

}
