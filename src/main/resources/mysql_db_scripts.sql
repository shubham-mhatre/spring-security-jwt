-- --------------------------------------------------------
-- Host:                         127.0.0.1

DROP DATABASE IF EXISTS `pract_db`;
CREATE DATABASE IF NOT EXISTS `pract_db` 
USE `pract_db`;


DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `pass` varchar(50) DEFAULT NULL,
  `role` varchar(50) DEFAULT NULL,
  `is_active` int(1) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;


INSERT INTO `user` (`id`, `name`, `pass`, `role`, `is_active`) VALUES
	(1, 'user', 'pass', 'ROLE_USER', 1),
	(2, 'Admin', 'admin', 'ROLE_ADMIN', 1);
