package com.po;

public class SearchProd {
	private String name;
	private Double maxPrice;
	private Double minPrice;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "SearchProd [name=" + name + ", maxPrice=" + maxPrice
				+ ", minPrice=" + minPrice + ", category=" + category + "]";
	}
	public Double getMaxPrice() {
		return maxPrice;
	}
	public void setMaxPrice(Double maxPrice) {
		this.maxPrice = maxPrice;
	}
	public Double getMinPrice() {
		return minPrice;
	}
	public void setMinPrice(Double minPrice) {
		this.minPrice = minPrice;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	private String category;
}
