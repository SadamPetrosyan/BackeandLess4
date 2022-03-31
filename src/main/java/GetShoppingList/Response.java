package GetShoppingList;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Response{

	@JsonProperty("cost")
	private double cost;

	@JsonProperty("endDate")
	private int endDate;

	@JsonProperty("aisles")
	private List<AislesItem> aisles;

	@JsonProperty("startDate")
	private int startDate;

	public void setCost(double cost){
		this.cost = cost;
	}

	public double getCost(){
		return cost;
	}

	public void setEndDate(int endDate){
		this.endDate = endDate;
	}

	public int getEndDate(){
		return endDate;
	}

	public void setAisles(List<AislesItem> aisles){
		this.aisles = aisles;
	}

	public List<AislesItem> getAisles(){
		return aisles;
	}

	public void setStartDate(int startDate){
		this.startDate = startDate;
	}

	public int getStartDate(){
		return startDate;
	}
}