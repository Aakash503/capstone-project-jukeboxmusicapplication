-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: localhost    Database: jukebox
-- ------------------------------------------------------
-- Server version	8.0.30

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
-- Table structure for table `songs`
--

DROP TABLE IF EXISTS `songs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `songs` (
  `songId` int NOT NULL AUTO_INCREMENT,
  `songName` varchar(100) DEFAULT NULL,
  `albumNAme` varchar(100) DEFAULT NULL,
  `genre` varchar(100) DEFAULT NULL,
  `artistName` varchar(100) DEFAULT NULL,
  `songPath` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`songId`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `songs`
--

LOCK TABLES `songs` WRITE;
/*!40000 ALTER TABLE `songs` DISABLE KEYS */;
INSERT INTO `songs` VALUES (1,'kesaria','brahmastra','pop','arijitsingh','src/main/resources/songs/Kesariya.wav'),(2,'cookisien','naruto','rock','tyler bates','src/main/resources/songs/Cookiesan_Sombre_Naruto.wav'),(3,'yashuharu','nauto','rock','recardo silva','src/main/resources/songs/Yasuharu_Takanashi_Scene_of_a_Disaster.wav'),(4,'supergerointro','avengers','jazz','jack piters','src/main/resources/songs/superhero-intro-111393.wav'),(5,'zuchu-fire','zuchufire','pop','julius','src/main/resources/songs/Zuchu-Fire-New-Song-Download-Mp3_SongsZilla.Net_.wav'),(6,'celtic','the whistle','pop','julius','src/main/resources/songs/celtic-irish-scottish-tin-whistle-background-music-10455.wav'),(7,'we wish you','christmus','jazz','julius','src/main/resources/songs/we-wish-you-a-merry-christmas-english-carol-sheppard-flute-8848.wav'),(8,'xyz','xyz','kjh','abc','asdd'),(9,'yxz','yxz','rock','bca','aggg'),(10,'zxy','zxy','pop','cab','angd');
/*!40000 ALTER TABLE `songs` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-09-26 10:39:51
