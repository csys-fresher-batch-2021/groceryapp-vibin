package in.vibin.service;

import java.sql.SQLException;

import in.vibin.dao.DiscountDAO;

public class DiscountService {
private DiscountService() {
}
public static int getDiscount() {
	int discount = 0;
	try {
		discount = DiscountDAO.getDiscount();
	} catch (ClassNotFoundException | SQLException e) {
		e.printStackTrace();
	}
	return discount;
}
public static void updateDiscount(int discount) {
	try {
		DiscountDAO.updateDiscount(discount);
	} catch (ClassNotFoundException | SQLException e) {
		e.printStackTrace();
	}
}
}
