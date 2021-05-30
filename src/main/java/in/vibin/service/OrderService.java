package in.vibin.service;

import java.sql.SQLException;
import java.util.List;

import in.vibin.dao.GroceryListDAO;
import in.vibin.dao.OrderListDAO;
import in.vibin.model.OrderProduct;

public class OrderService {
	private OrderService() {
	}

	public static List<OrderProduct> getProduct() {

		List<OrderProduct> orderProductList = null;

		try {
			orderProductList = OrderListDAO.getOrderedProduct();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return orderProductList;
	}

	public static void addOrderProduct(OrderProduct orderProduct) {
		try {
			OrderListDAO.addOrderedProduct(orderProduct);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	public static void deleteOrderProductTable() {
		try {
			OrderListDAO.deleteOrderedProductTable();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	public static void removeOrderedProduct(OrderProduct product) {
		int id=product.getID();
		String name=product.getName();
		int quantity=product.getOrderedQuantity();
		try {
			OrderListDAO.deleteOrderedProduct(id);
			GroceryListDAO.addRemovedProductQuantity(name, quantity);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
