CREATE TABLE grocery_list(name VARCHAR(50) NOT NULL,price_per_quantity REAL NOT NULL,ordered_quantity INT NOT NULL,amount REAL NOT NULL,ordered_id INT PRIMARY KEY);
SELECT * FROM order_list;
INSERT INTO order_list(name,price_per_quantity,ordered_quantity,amount) VALUES(?,?,?,?);
DELETE FROM order_list WHERE ordered_id=?;
DELETE FROM order_list;