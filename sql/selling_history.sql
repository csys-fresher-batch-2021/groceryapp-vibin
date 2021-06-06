CREATE TABLE selling_history(mobilenumber BIGINT NOT NULL,
							 product_name VARCHAR(50) NOT NULL,
							 price_per_quantity DECIMAL(5,2) NOT NULL,
							 ordered_quantity INT NOT NULL,
							 amount DECIMAL(5,2) NOT NULL,
							 buy_date DATE DEFAULT CURRENT_DATE,
							 buy_time  TIME DEFAULT CURRENT_TIME);
SELECT * FROM selling_history;
INSERT INTO selling_history(mobilenumber,product_name,price_per_quantity,ordered_quantity,amount) VALUES(?,?,?,?,?);