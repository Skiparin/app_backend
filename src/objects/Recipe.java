package objects;

import java.util.List;

import org.bson.Document;

import com.mongodb.client.FindIterable;

import interfaces.RecipeInterface;

public class Recipe implements RecipeInterface{
	
	String name;
	String link;
	List<String> desc;
	List<String> ingredients;
	
	public Recipe() {
		
	}
	
	public Recipe(String link) {
		this.link = link;
	}

	public Recipe(String name, String link, List<String> desc, List<String> ingredients) {
		this.name = name;
		this.link = link;
		this.desc = desc;
		this.ingredients = ingredients;
	}
	/*
	public Recipe(Document r) {
		this.name = r.getString("name");
		this.link = r.getString("link");
		this.desc = r.getList("desc", String);
		this.ingredients = ingredients;
	}
*/
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	
	public String getLink() {
		return this.link;
	}


	public List<String> getDesc() {
		return desc;
	}


	public void setDesc(List<String> desc) {
		this.desc = desc;
	}


	public List<String> getIngredients() {
		return ingredients;
	}


	public void setIngredients(List<String> ingredients) {
		this.ingredients = ingredients;
	}
	
	
}
