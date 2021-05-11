package in.vibin.service;

import java.util.HashMap;
import java.util.Map;

public class ProductService {
	private ProductService() {
		
	}
	private static final Map<Integer, String> product = new HashMap<>();
	static {
		product.put(31, "Milk");
		product.put(45, "Bread");
		product.put(50, "Wheat");
	}
	private static final Map<Integer, Double> productPrice = new HashMap<>();
	static {
		productPrice.put(31, (double) 15);
		productPrice.put(45, (double) 30);
		productPrice.put(50, (double) 40);
	}
	private static final Map<Integer, Integer> productQuantity = new HashMap<>();
	static {
		productQuantity.put(31, 50);
		productQuantity.put(45, 50);
		productQuantity.put(50, 50);
	}

	/**
	 * It will return the products available in the inventory.
	 * 
	 * @return
	 */
	public static Map<Integer, String> getProducts() {
		return product;
	}

	public static Map<Integer, Double> getProductsPrice() {
		return productPrice;
	}

	public static Map<Integer, Integer> getProductsQuantity() {
		return productQuantity;
	}

}
