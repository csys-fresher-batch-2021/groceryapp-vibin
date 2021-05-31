CREATE TABLE selling_history(mobilenumber BIGINT NOT NULL,
							 product_name VARCHAR(50) NOT NULL,
							 price_per_quantity REAL NOT NULL,
							 ordered_quantity INT NOT NULL,
							 amount REAL NOT NULL,
							 buy_date DATE DEFAULT CURRENT_DATE,
							 buy_time  TIME DEFAULT CURRENT_TIME);
SELECT * FROM selling_history;
INSERT INTO selling_history(mobilenumber,product_name,price_per_quantity,ordered_quantity,amount) VALUES(?,?,?,?,?);