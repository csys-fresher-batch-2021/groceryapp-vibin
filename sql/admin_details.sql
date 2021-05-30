CREATE TABLE admin_details(mobilenumber BIGINT PRIMARY KEY,password VAR CHAR(50) NOT NULL);
SELECT (mobilenumber,password) FROM admin_details WHERE mobilenumber=? AND password=?;