CREATE DATABASE IF NOT EXISTS `bcbs`;
use bcbs;

DROP TABLE IF EXISTS users;
CREATE TABLE users(
id` int(11) NOT NULL AUTO_INCREMENT, 
first_name varchar(20) NOT NULL,
last_name varchar(50) NOT NULL,
initials varchar(50) NOT NULL UNIQUE,
password varchar(20) NOT NULL,
balance double,
PRIMARY KEY (id)) AUTO_INCREMENT = 4;

INSERT INTO `users` VALUES ('1','Mathias', 'Højgaard', 'maho14am@student.cbs.dk', '1234aaaa', 1.0), 
('2','Rasmus', 'Dyhr', 'rady13ac@student.cbs.dk', '1234bbbb', 1.0), 
('3','Kristian', 'Koch', 'kran14ad@student.cbs.dk', '1234cccc', 1.0),
('4', 'Christine', 'Pelzer', 'chpe14ar@student.cbs.dk', '1234dddd', 1.0);

DROP TABLE IF EXISTS admin;
CREATE TABLE admin(
id int(11) NOT NULL AUTO_INCREMENT, 
name varchar(20),
initials varchar(20),
password varchar(20),
currency double,
PRIMARY KEY (id)) AUTO_INCREMENT = 1;

INSERT INTO admin VALUES ('1', 'CBS_ADMIN', '88888888', '1234abcd', 150);