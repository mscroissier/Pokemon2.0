-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: pokemon
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
-- Table structure for table `jugadores`
--

DROP TABLE IF EXISTS `jugadores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `jugadores` (
  `idJugadores` int NOT NULL AUTO_INCREMENT,
  `nombreJugador` varchar(45) COLLATE utf8mb4_spanish2_ci DEFAULT NULL,
  `idPokemonFK` int DEFAULT NULL,
  `n_partidasGanadas` int DEFAULT '0',
  PRIMARY KEY (`idJugadores`),
  KEY `idPokemonFK` (`idPokemonFK`),
  CONSTRAINT `jugadores_ibfk_1` FOREIGN KEY (`idPokemonFK`) REFERENCES `pokemons` (`idPokemon`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jugadores`
--

LOCK TABLES `jugadores` WRITE;
/*!40000 ALTER TABLE `jugadores` DISABLE KEYS */;
INSERT INTO `jugadores` VALUES (1,'Ana',1,0),(2,'Lidia',2,0),(3,'Juan',3,0),(4,'Alex',4,0),(5,'Fran',5,0);
/*!40000 ALTER TABLE `jugadores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pokemons`
--

DROP TABLE IF EXISTS `pokemons`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pokemons` (
  `idPokemon` int NOT NULL AUTO_INCREMENT,
  `nombrePokemon` varchar(45) COLLATE utf8mb4_spanish2_ci DEFAULT NULL,
  `tipoPokemon` varchar(45) COLLATE utf8mb4_spanish2_ci DEFAULT NULL,
  `ataque` int DEFAULT NULL,
  `ps` int NOT NULL,
  `img_url` varchar(70) COLLATE utf8mb4_spanish2_ci DEFAULT NULL,
  PRIMARY KEY (`idPokemon`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pokemons`
--

LOCK TABLES `pokemons` WRITE;
/*!40000 ALTER TABLE `pokemons` DISABLE KEYS */;
INSERT INTO `pokemons` VALUES (1,'Bulbasaur','planta',NULL,0,'\\bulbasaur.jpg'),(2,'Charmander','fuego',NULL,0,'\\Charmander.jpg'),(3,'Squirtle','agua',NULL,0,'\\Squirtle.jpg'),(4,'Pidgeotto','normal',NULL,0,'\\Pidgeotto.jpg'),(5,'Chansey','normal',NULL,0,'\\Chansey.jpg'),(6,'Cherubi','planta',NULL,0,NULL);
/*!40000 ALTER TABLE `pokemons` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-06-12  9:54:12