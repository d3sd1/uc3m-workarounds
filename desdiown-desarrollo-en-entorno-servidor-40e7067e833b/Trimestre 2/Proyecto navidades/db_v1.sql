/*
SQLyog Ultimate v12.4.3 (64 bit)
MySQL - 5.7.20 : Database - proyecto_navidades
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`proyecto_navidades` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `proyecto_navidades`;

/*Table structure for table `alumnos_asignaturas` */

DROP TABLE IF EXISTS `alumnos_asignaturas`;

CREATE TABLE `alumnos_asignaturas` (
  `id_alumno` int(11) NOT NULL,
  `id_asignatura` int(11) NOT NULL,
  PRIMARY KEY (`id_alumno`,`id_asignatura`),
  KEY `fk2_alumnos_asignaturas` (`id_asignatura`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `alumnos_asignaturas` */

/*Table structure for table `asignaturas` */

DROP TABLE IF EXISTS `asignaturas`;

CREATE TABLE `asignaturas` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(200) DEFAULT NULL,
  `id_curso` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_asignaturas` (`id_curso`),
  CONSTRAINT `fk_asignaturas` FOREIGN KEY (`id_curso`) REFERENCES `cursos` (`id`) ON DELETE SET NULL ON UPDATE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `asignaturas` */

/*Table structure for table `cursos` */

DROP TABLE IF EXISTS `cursos`;

CREATE TABLE `cursos` (
  `id` int(11) NOT NULL,
  `nombre` varchar(150) DEFAULT NULL,
  `descripcion` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `cursos` */

/*Table structure for table `profesores_asignaturas` */

DROP TABLE IF EXISTS `profesores_asignaturas`;

CREATE TABLE `profesores_asignaturas` (
  `id_profesor` int(11) DEFAULT NULL,
  `id_asignatura` int(11) DEFAULT NULL,
  KEY `fk1_profesores_asignaturas` (`id_profesor`),
  KEY `fk2_profesores_asignaturas` (`id_asignatura`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `profesores_asignaturas` */

/*Table structure for table `users` */

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(200) DEFAULT NULL,
  `clave` varchar(200) DEFAULT NULL,
  `activo` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `users` */

/*Table structure for table `users_alumnos` */

DROP TABLE IF EXISTS `users_alumnos`;

CREATE TABLE `users_alumnos` (
  `id_user` int(11) NOT NULL,
  `nombre` varchar(200) NOT NULL,
  PRIMARY KEY (`id_user`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `users_alumnos` */

/*Table structure for table `users_profesores` */

DROP TABLE IF EXISTS `users_profesores`;

CREATE TABLE `users_profesores` (
  `id_user` int(11) NOT NULL,
  `nombre` varchar(200) NOT NULL,
  PRIMARY KEY (`id_user`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `users_profesores` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
