CREATE DATABASE  IF NOT EXISTS `bdsalas` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `bdsalas`;
-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: bdsalas
-- ------------------------------------------------------
-- Server version	8.0.22

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `tbl_clientecl3`
--

DROP TABLE IF EXISTS `tbl_clientecl3`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_clientecl3` (
  `idcodcl3` int NOT NULL AUTO_INCREMENT,
  `nomcl3` varchar(255) DEFAULT NULL,
  `apellcl3` varchar(255) DEFAULT NULL,
  `dnicl3` varchar(255) DEFAULT NULL,
  `correocl3` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idcodcl3`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_clientecl3`
--

LOCK TABLES `tbl_clientecl3` WRITE;
/*!40000 ALTER TABLE `tbl_clientecl3` DISABLE KEYS */;
INSERT INTO `tbl_clientecl3` VALUES (1,'Hugo','Salas','75486421','h.salas@gmail.com'),(3,'Donie','Luperdi','48561782','d.luperdi@gmail.com'),(4,'Carla','Castillo','47851425','c.castillo@gmail.com'),(7,'Cesar','Vega','00000000','sadohu26@yahoo.com'),(8,'Julio','Salas','88884444','sadohu26@yahoo.com');
/*!40000 ALTER TABLE `tbl_clientecl3` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'bdsalas'
--

--
-- Dumping routines for database 'bdsalas'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-12-16  2:27:46
