package in.vibin.service;

import java.sql.SQLException;
import in.vibin.dao.GroceryListDAO;
import in.vibin.model.Product;

public class UserService {
	private UserService() {
	}

	public static double orderProduct(Product product) {
		int availableQuantity = product.getQuantity();
		double price = product.getPrice();
		int orderedQuantity = product.getorderedQuantity();
		int id = product.getID();
		double price1 = 0.0;
		if (availableQuantity >= orderedQuantity) {
			int remainingQuantity = availableQuantity - orderedQuantity;
			price1 = price * orderedQuantity;
			try {
				GroceryListDAO.updateQuantity(id, remainingQuantity);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}
		return price1;
	}

}
