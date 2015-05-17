CREATE DATABASE IF NOT EXISTS `bcbs`;
use bcbs;

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`(
`id` int(11) NOT NULL AUTO_INCREMENT, 
`first_name` varchar(255),
`last_name` varchar(255),
`initials` varchar(255),
`password` varchar(255),
`balance` double (10),
PRIMARY KEY (`id`)) AUTO_INCREMENT = 4;

INSERT INTO `users` VALUES ('1','Mathias', 'Højgaard', 'maho14am', '1234', 1.0), 
('2','Rasmus', 'Dyhr', 'rady13ac', '2345', 1.0), 
('3','Kristian', 'Koch', 'kran14ad', '3456', 1.0),
('4', 'Christine', 'Pelzer', 'homo', '4567', 1.0);

DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`(
`id` int(11) NOT NULL AUTO_INCREMENT, 
`name` varchar(255),
`initials` varchar(255),
`password` varchar(255),
`currency` double(10),
PRIMARY KEY (`id`)) AUTO_INCREMENT = 1;

INSERT INTO `admin` VALUES ('1', 'CBS_ADMIN', 'Adm', '1234', 150);