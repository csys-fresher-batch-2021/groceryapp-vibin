package in.vibin.service;

import java.sql.SQLException;
import java.util.Map;

import in.vibin.dao.GroceryListDAO;
import in.vibin.validator.*;

public class ProductService {

	private ProductService() {
	}

//Call the Util package to get the values.
	static Map<Integer, String> product = GroceryListDAO.getProducts();
	static Map<Integer, Double> productPrice = GroceryListDAO.getProductsPrice();
	static Map<Integer, Integer> productQuantity = GroceryListDAO.getProductsQuantity();

	/**
	 * This method is used to add the new product to the list. By getting
	 * id,name,price,quantity as a input from the admin. The method is in the format
	 * of addProduct(int id, String name, double price, int quantity). This method
	 * is process with 3 Hashmaps, Map<Intgr,String>product; =>product(id,nmae)
	 * Map<Intgr,Double>productPrice; =>produtPrice(id,price)
	 * Map<Intgr,Integer>productQuantity; =>productQuantity(id,quantity) This method
	 * return int value, return 0=>If the inputs are invalid. return 1=>If the id
	 * and name already exist in the list. return 2=>If the id is already exist in
	 * the list. return 3=>If the Name is already exist in the list.
	 * 
	 * @param id
	 * @param name
	 * @param price
	 * @param quantity
	 * @return
	 */
	public static int addProduct(int id, String name, double price, int quantity) {
		boolean isValidid = NumberValidation.checkInteger(id);
		boolean isValidQuantity = NumberValidation.checkInteger(quantity);
		boolean isValidName = StringValidation.checkString(name);
		boolean isValidPrice = NumberValidation.checkDecimal(price);
		int isAdded = 0;
		if (isValidid && isValidQuantity && isValidName && isValidPrice) {
			String trimName = name.toLowerCase().trim();
			if (product.containsKey(id) && (product.containsValue(trimName))) {
				isAdded = 1;
			} else if (product.containsKey(id)) {
				isAdded = 2;
			} else if (product.containsValue((trimName))) {
				isAdded = 3;
			} else {
				try {
					GroceryListDAO.addProduct(id, trimName, price, quantity);
				} catch (ClassNotFoundException | SQLException e) {
					e.printStackTrace();
				}
				isAdded = 4;
			}
		}
		return isAdded;
	}

	/**
	 * To delete the product.
	 * 
	 * @param id
	 */
	public static void deleteProduct(int id) {
		try {
			GroceryListDAO.deleteTask(id);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
