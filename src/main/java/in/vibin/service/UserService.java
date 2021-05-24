package in.vibin.service;

import java.sql.SQLException;

import java.util.Map;

import in.vibin.dao.GroceryListDAO;
import in.vibin.validator.NumberValidation;

public class UserService {
	private UserService() {
	}
public static double orderProduct(int id,int orderedQuantity) {
	Map<Integer, Integer>productQuantity=GroceryListDAO.getProductsQuantity();
	Map<Integer, Double>productPrice=GroceryListDAO.getProductsPrice();
	int availableQuantity=productQuantity.get(id);
	double price=productPrice.get(id);
	double price1=0.0;
	if(availableQuantity>=orderedQuantity) {
		int remainingQuantity=availableQuantity-orderedQuantity;
		price1=price*orderedQuantity;
		try {
			GroceryListDAO.updateQuantity(id, remainingQuantity);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	return price1;	
}

//test purpose only
public static void addQuantity(int id,int quantity) {
	Map<Integer, Integer>productQuantity=GroceryListDAO.getProductsQuantity();
	int availableQuantity=productQuantity.get(id);
	boolean isValidQuantity=NumberValidation.checkInteger(quantity);
	if(isValidQuantity) {
		int updatedQuantity=availableQuantity+quantity;
		try {
			GroceryListDAO.updateQuantity(id, updatedQuantity);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
}
