/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Stephan
 * Created: 19-03-2018
 */

CREATE DATABASE  IF NOT EXISTS `legoWebshop`;

USE `legoWebshop`;

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(90) NOT NULL,
  `password` varchar(45) NOT NULL,
  `role` varchar(20) NOT NULL DEFAULT 'customer',
  PRIMARY KEY (`id`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

LOCK TABLES `users` WRITE;
INSERT INTO `users` VALUES 
(1,'user','password','customer'),
(2,'admin','admin','employee');
UNLOCK TABLES;

DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `length` int(11) NOT NULL,
  `width` int(11) NOT NULL,
  `heigth` int(11) NOT NULL,
  `status` boolean DEFAULT FALSE,
  `userId` int(11),
  FOREIGN KEY (userId) REFERENCES users(id),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

DROP USER IF EXISTS 'lego_crud'@'46.101.114.190';
CREATE USER 'lego_crud'@'localhost' IDENTIFIED BY 'myPassword';
GRANT SELECT, INSERT, UPDATE, DELETE ON legoWebshop.* TO 'lego_crud'@'46.101.114.190';

COMMIT;
