package AddtoShoppingList;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AislesItem{

	@JsonProperty("aisle")
	private String aisle;

	@JsonProperty("items")
	private List<ItemsItem> items;

	public void setAisle(String aisle){
		this.aisle = aisle;
	}

	public String getAisle(){
		return aisle;
	}

	public void setItems(List<ItemsItem> items){
		this.items = items;
	}

	public List<ItemsItem> getItems(){
		return items;
	}
}