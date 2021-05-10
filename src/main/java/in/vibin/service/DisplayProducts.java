package in.vibin.service;

import java.util.HashMap;
import java.util.Map;

public class DisplayProducts {
	private static Map<Integer, String> products = new HashMap<Integer, String>();
	static {
		products.put(1,"milk");
		products.put(2,"bread");
		products.put(3,"wheat");
	}
	/**
	 * It will return the products available in the inventory.
	 * @return
	 */
	public static Map<Integer, String> getProducts(){
		return products;
		}
		
	}
