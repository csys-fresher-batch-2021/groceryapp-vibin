CREATE TABLE grocery_list(id INT PRIMARY KEY,name VARCHAR(50) NOT NULL,price DECIMAL(5,2) NOT NULL,quantity INT);
SELECT * FROM grocery_list;
INSERT INTO grocery_list(id,name,price,quantity) VALUES(?,?,?,?);
DELETE FROM grocery_list WHERE id=?;
UPDATE grocery_list SET quantity =?WHERE id =?;
UPDATE grocery_list SET quantity=quantity+? WHERE name =?;