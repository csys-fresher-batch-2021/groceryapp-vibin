package in.vibin.util;

import java.util.HashMap;
import java.util.Map;

public class Util {
	private Util() {
	}

	// This Util class is used for store the static values.
	private static final Map<Integer, String> product = new HashMap<>();
	static {
		product.put(31, "milk");
		product.put(45, "bread");
		product.put(50, "wheat");
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
	private static final Map<Long, String> adminLogin = new HashMap<>();
	static{
		adminLogin.put(9659644868L,"Vibin#321");
		adminLogin.put(6380998915L, "Kumar@144");
	}

	/**
	 * This method is used to get the produts with id and name. It return the
	 * Map<Integer,String>
	 * 
	 * @return
	 */
	public static Map<Integer, String> getProducts() {
		return product;
	}

	/**
	 * This method is used to get the produts with id and price per quantity. It
	 * return the Map<Integer,Double>
	 * 
	 * @return
	 */
	public static Map<Integer, Double> getProductsPrice() {
		return productPrice;
	}

	/**
	 * This method is used to get the produts with id and quantity. It return the
	 * Map<Integer,Integer>
	 * 
	 * @return
	 */
	public static Map<Integer, Integer> getProductsQuantity() {
		return productQuantity;
	}
	/**
	 * This method is used to get the Admin details with mobilenumber and password. It return the
	 * Map<Long,String>
	 * 
	 * @return
	 */

public static Map<Long, String> getAdminLogin() {
		return adminLogin;
	}

}
