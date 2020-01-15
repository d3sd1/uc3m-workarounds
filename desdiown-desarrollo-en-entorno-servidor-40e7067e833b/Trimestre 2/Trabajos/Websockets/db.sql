/*
SQLyog Ultimate v12.4.3 (64 bit)
MySQL - 5.5.58-0ubuntu0.14.04.1 : Database - sql11222787
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`sql11222787` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `sql11222787`;

/*Table structure for table `channels` */

DROP TABLE IF EXISTS `channels`;

CREATE TABLE `channels` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `admin_id` int(11) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `channels` */

insert  into `channels`(`id`,`name`,`admin_id`,`password`) values 
(1,'Palmeras en la nieve',1,'chocolate');

/*Table structure for table `login` */

DROP TABLE IF EXISTS `login`;

CREATE TABLE `login` (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `pass` varchar(255) DEFAULT NULL,
  `online` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `login` */

insert  into `login`(`id`,`email`,`pass`,`online`) values 
(1,'andreigarciacuadra@gmail.com','google',1);

/*Table structure for table `messages` */

DROP TABLE IF EXISTS `messages`;

CREATE TABLE `messages` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sender_id` int(11) NOT NULL,
  `message` text,
  `date_sent` timestamp NULL DEFAULT NULL,
  `channel_id` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`,`sender_id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table `messages` */

insert  into `messages`(`id`,`sender_id`,`message`,`date_sent`,`channel_id`) values 
(1,1,'ea28e31179719e9630b2663e02f7ca71:5d3db6edb3a4f4b19f18847b7f917960:LL6NG1VPna3hwgXHRhn3sgvmPhR0TvJI9SWbK98Hihc=','2018-02-26 16:46:35',0),
(2,1,'03ce25590d2c41a74c9d78b86ac54f69:ba7d00c483e14a8d70f21ad04e8b1ac0:mFS4ETT75knc4asTvZtq8Ejvo9n7RGLIrmPf8zbS4qc=','2018-02-26 16:47:34',1);

/*Table structure for table `users_channels` */

DROP TABLE IF EXISTS `users_channels`;

CREATE TABLE `users_channels` (
  `user_id` int(11) NOT NULL,
  `channel_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`,`channel_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `users_channels` */

insert  into `users_channels`(`user_id`,`channel_id`) values 
(1,1);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
