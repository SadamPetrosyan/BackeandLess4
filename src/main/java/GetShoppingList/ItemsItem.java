package GetShoppingList;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ItemsItem{

	@JsonProperty("ingredientId")
	private int ingredientId;

	@JsonProperty("measures")
	private Measures measures;

	@JsonProperty("cost")
	private double cost;

	@JsonProperty("name")
	private String name;

	@JsonProperty("pantryItem")
	private boolean pantryItem;

	@JsonProperty("id")
	private int id;

	@JsonProperty("aisle")
	private String aisle;

	public void setIngredientId(int ingredientId){
		this.ingredientId = ingredientId;
	}

	public int getIngredientId(){
		return ingredientId;
	}

	public void setMeasures(Measures measures){
		this.measures = measures;
	}

	public Measures getMeasures(){
		return measures;
	}

	public void setCost(double cost){
		this.cost = cost;
	}

	public double getCost(){
		return cost;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setPantryItem(boolean pantryItem){
		this.pantryItem = pantryItem;
	}

	public boolean isPantryItem(){
		return pantryItem;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setAisle(String aisle){
		this.aisle = aisle;
	}

	public String getAisle(){
		return aisle;
	}
}