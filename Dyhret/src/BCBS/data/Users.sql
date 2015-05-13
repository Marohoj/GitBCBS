CREATE DATABASE IF NOT EXISTS `bcbs`;
use bcbs;

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`(
`id` int(11) NOT NULL AUTO_INCREMENT, 
`first_name` varchar(255),
`last_name` varchar(255),
`initials` varchar (255),
`password` varchar(255),
`balance` varchar (255),
PRIMARY KEY (`id`)) AUTO_INCREMENT = 4;

INSERT INTO `users` VALUES ('1','Mathias', 'Højgaard', 'maho14am', '1234', '100 BC'), 
('2','Rasmus', 'Dyhr', 'rady13ac', '2345', '100 BC'), 
('3','Kristian', 'Koch', 'kran14ad', '3456', '100 BC')
('4', 'Christine', 'Pelzer', 'homo', '4567', '100 BC');

DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`(
`id` int(11) NOT NULL AUTO_INCREMENT, 
`name` varchar(255),
`initials` varchar (255),
`password` varchar(255),
`balance` varchar (255),
PRIMARY KEY (`id`)) AUTO_INCREMENT = 1;

INSERT INTO `admin` VALUES ('1', 'Admin', 'adm', '88888888', '100 BC');