/*
SQLyog Ultimate v10.00 Beta1
MySQL - 5.5.5-10.4.14-MariaDB : Database - getaway
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`getaway` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `getaway`;

/*Table structure for table `logging` */

DROP TABLE IF EXISTS `logging`;

CREATE TABLE `logging` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Logs` varchar(100) DEFAULT NULL,
  `Stamp` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;

/*Data for the table `logging` */

insert  into `logging`(`ID`,`Logs`,`Stamp`) values (1,'ginotoralba0031@gmail.com has logged in.','2020-12-20 17:14:58'),(2,'ginotoralba0031@gmail.com has logged in.','2020-12-20 17:20:52'),(3,'ginotoralba0031@gmail.com Added a Product with Product Name of: Jordan 5 Red, Type: JORDAN','2020-12-20 17:21:36'),(4,'ginotoralba0031@gmail.com Deleted a Product with Product ID of: 2, Named: Vans Checkered','2020-12-20 17:21:51'),(5,'ginotoralba0031@gmail.com has logged out.','2020-12-20 17:22:02');

/*Table structure for table `products` */

DROP TABLE IF EXISTS `products`;

CREATE TABLE `products` (
  `Product_ID` int(11) NOT NULL AUTO_INCREMENT,
  `Product_Name` varchar(100) DEFAULT NULL,
  `Product_Type` varchar(100) DEFAULT NULL,
  `Product_Price` int(20) DEFAULT NULL,
  `Remaining` int(20) DEFAULT NULL,
  `Incoming` int(20) DEFAULT NULL,
  `Outgoing` int(20) DEFAULT NULL,
  PRIMARY KEY (`Product_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

/*Data for the table `products` */

insert  into `products`(`Product_ID`,`Product_Name`,`Product_Type`,`Product_Price`,`Remaining`,`Incoming`,`Outgoing`) values (1,'Jordan 1 Glow Green','JORDAN',5000,50,50,50),(3,'Jordan 5 Red','JORDAN',5000,100,0,0);

/*Table structure for table `users` */

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Pincode` int(20) DEFAULT NULL,
  `Contact_No` int(20) DEFAULT NULL,
  `Email` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

/*Data for the table `users` */

insert  into `users`(`ID`,`Pincode`,`Contact_No`,`Email`) values (1,1234,2147483647,'ginotoralba0031@gmail.com');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
