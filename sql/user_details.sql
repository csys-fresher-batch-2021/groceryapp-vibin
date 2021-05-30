CREATE TABLE user_details(mobilenumber BIGINT PRIMARY KEY,password VAR CHAR(50) NOT NULL);
SELECT (mobilenumber,password) FROM user_details WHERE mobilenumber=? AND password=?;