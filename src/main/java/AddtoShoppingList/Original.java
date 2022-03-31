package AddtoShoppingList;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Original{

	@JsonProperty("amount")
	private double amount;

	@JsonProperty("unit")
	private String unit;

	public void setAmount(double amount){
		this.amount = amount;
	}

	public double getAmount(){
		return amount;
	}

	public void setUnit(String unit){
		this.unit = unit;
	}

	public String getUnit(){
		return unit;
	}
}