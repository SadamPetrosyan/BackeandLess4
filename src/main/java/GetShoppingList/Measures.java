package GetShoppingList;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Measures{

	@JsonProperty("original")
	private Original original;

	@JsonProperty("metric")
	private Metric metric;

	@JsonProperty("us")
	private Us us;

	public void setOriginal(Original original){
		this.original = original;
	}

	public Original getOriginal(){
		return original;
	}

	public void setMetric(Metric metric){
		this.metric = metric;
	}

	public Metric getMetric(){
		return metric;
	}

	public void setUs(Us us){
		this.us = us;
	}

	public Us getUs(){
		return us;
	}
}