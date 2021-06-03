CREATE TABLE order_liSt(ordered_id SERIAL PRIMARY KEY,name VARCHAR(50) NOT NULL,price_per_quantity REAL,ordered_quantity INT ,amount REAL)
SELECT * FROM order_list;
INSERT INTO order_list(name,price_per_quantity,ordered_quantity,amount) VALUES(?,?,?,?);
DELETE FROM order_list WHERE ordered_id=?;
DELETE FROM order_list;