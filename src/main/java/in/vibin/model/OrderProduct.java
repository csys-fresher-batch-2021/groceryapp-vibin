package in.vibin.model;

public class OrderProduct {
	private String name;
	private double price;
	private int orderedQuantity;
	private double amount;

	public OrderProduct() {
		super();
	}

	public OrderProduct(String name, double price, int orderedQuantity, double amount) {
		super();
		this.name = name;
		this.price = price;
		this.orderedQuantity = orderedQuantity;
		this.amount = amount;
	}

	// getter
	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	public int getOrderedQuantity() {
		return orderedQuantity;
	}

	public double getAmount() {
		return amount;
	}

	// setter
	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setOrderedQuantity(int orderedQuantity) {
		this.orderedQuantity = orderedQuantity;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Order Product [ name=" + name + ", price=" + price + ", ordered quantity=" + orderedQuantity + "amount="
				+ amount + "]";
	}

}
