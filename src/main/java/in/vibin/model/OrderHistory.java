package in.vibin.model;

public class OrderHistory {
	private long mobileNumber;
	private String productName;
	private double pricePerQuantity;
	private int orderedQuantity;
	private double amount;
	private String orderDate;
	private String orderTime;

	public OrderHistory() {
		super();
	}

	// getter
	public String getName() {
		return productName;
	}

	public long getMobileNumber() {
		return mobileNumber;
	}

	public double getPrice() {
		return pricePerQuantity;
	}

	public int getOrderedQuantity() {
		return orderedQuantity;
	}

	public double getAmount() {
		return amount;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public String getOrderTime() {
		return orderTime;
	}

	// setter
	public void setName(String name) {
		this.productName = name;
	}

	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public void setPrice(double price) {
		this.pricePerQuantity = price;
	}

	public void setOrderedQuantity(int orderedQuantity) {
		this.orderedQuantity = orderedQuantity;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public void setOrderTime(String orderTime) {
		this.orderTime = orderTime;
	}
}
