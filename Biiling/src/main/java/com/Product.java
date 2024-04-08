package com;

public class Product {
    private String item;
    private String itemCode;
    private double price;
    private int quantity;



    public Product(String item, String itemCode, double price, int quantity) {
		super();
		this.item = item;
		this.itemCode = itemCode;
		this.price = price;
		this.quantity = quantity;
	}

	public String getItem() {
        return item;
    }

    public String getItemCode() {
        return itemCode;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotalWithoutTaxes() {
        return price * quantity;
    }

    public double getTotalWithTaxes() {
        double totalWithoutTaxes = getTotalWithoutTaxes();
        double tax = totalWithoutTaxes * 0.18;
        return totalWithoutTaxes + tax;
    }
}
