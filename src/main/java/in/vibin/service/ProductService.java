package in.vibin.service;

import java.sql.SQLException;
import java.util.List;

import in.vibin.dao.GroceryListDAO;
import in.vibin.exception.ProuctExistException;
import in.vibin.model.Product;
import in.vibin.validator.NumberValidation;

public class ProductService {
	private ProductService() {
	}

	public static List<Product> getProduct() {

		List<Product> productList = null;

		try {
			productList = GroceryListDAO.getProduct();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return productList;
	}

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
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws ProuctExistException
	 */
	public static void addProduct(Product product) throws ClassNotFoundException, SQLException, ProuctExistException {
		try {
			isProductAvailable(product);
			GroceryListDAO.addProduct(product);
		} catch (Exception e) {
			throw new ProuctExistException(e.getMessage());
		}
	}

	public static void isProductAvailable(Product product) throws ProuctExistException {
		List<Product> productList = getProduct();
		String trimName = product.getName().toLowerCase().trim();

		for (Product products : productList) {
			if (products.getID() == product.getID() && products.getName().equals(trimName)) {
				throw new ProuctExistException("ID and Name already exist");
			} else if (products.getID() == product.getID()) {
				throw new ProuctExistException("ID already exist");
			} else if (products.getName().equals(trimName)) {
				throw new ProuctExistException("Name already exist");
			}
		}
	}

	/**
	 * To delete the product.
	 * 
	 * @param id
	 */
	public static void deleteProduct(int id) {
		try {
			GroceryListDAO.deleteProduct(id);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
		public static void addQuantity(Product product) {
			int id = product.getID();
			int availableQuantity = product.getQuantity();
			int addedQuantity = product.getorderedQuantity();
			boolean isValidQuantity = NumberValidation.checkInteger(addedQuantity);
			if (isValidQuantity) {
				int updatedQuantity = availableQuantity + addedQuantity;
				try {
					GroceryListDAO.updateQuantity(id, updatedQuantity);
				} catch (ClassNotFoundException | SQLException e) {
					e.printStackTrace();
				}
			}
		}
}
