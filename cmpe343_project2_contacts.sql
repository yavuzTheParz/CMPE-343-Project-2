-- MySQL dump 10.13  Distrib 8.0.44, for Win64 (x86_64)
--
-- Host: localhost    Database: cmpe343_project2
-- ------------------------------------------------------
-- Server version	8.0.44

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
-- Table structure for table `contacts`
--

DROP TABLE IF EXISTS `contacts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `contacts` (
  `contact_id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(50) NOT NULL,
  `middle_name` varchar(50) DEFAULT NULL,
  `last_name` varchar(50) NOT NULL,
  `nickname` varchar(50) NOT NULL,
  `phone_primary` varchar(20) NOT NULL,
  `phone_secondary` varchar(20) DEFAULT NULL,
  `email` varchar(100) NOT NULL,
  `linkedin_url` varchar(255) DEFAULT NULL,
  `birth_date` date NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`contact_id`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contacts`
--

LOCK TABLES `contacts` WRITE;
/*!40000 ALTER TABLE `contacts` DISABLE KEYS */;
INSERT INTO `contacts` VALUES (1,'Aragorn',NULL,'Elessar','Strider','5301112233',NULL,'aragorn@middleearth.me',NULL,'1980-03-01','2025-11-26 19:58:20','2025-11-26 19:58:20'),(2,'Legolas',NULL,'Greenleaf','PrinceLeg','5301112234',NULL,'legolas@middleearth.me',NULL,'1985-06-12','2025-11-26 19:58:20','2025-11-26 19:58:20'),(3,'Gimli',NULL,'Gloinsson','AxeMaster','5301112235',NULL,'gimli@middleearth.me',NULL,'1978-02-20','2025-11-26 19:58:20','2025-11-26 19:58:20'),(4,'Frodo',NULL,'Baggins','RingBearer','5301112236',NULL,'frodo@shire.me',NULL,'1990-09-22','2025-11-26 19:58:20','2025-11-26 19:58:20'),(5,'Samwise',NULL,'Gamgee','Sam','5301112237',NULL,'sam@shire.me',NULL,'1989-04-07','2025-11-26 19:58:20','2025-11-26 19:58:20'),(6,'Boromir',NULL,'Denethorson','CaptainGondor','5301112238',NULL,'boromir@gondor.me',NULL,'1982-10-10','2025-11-26 19:58:20','2025-11-26 19:58:20'),(7,'Gandalf',NULL,'The Grey','Mithrandir','5301112239',NULL,'gandalf@istari.me',NULL,'1945-01-05','2025-11-26 19:58:20','2025-11-26 19:58:20'),(8,'Galadriel',NULL,'Lightborn','Nenya','5301112241',NULL,'galadriel@lorien.me',NULL,'1975-11-03','2025-11-26 19:58:20','2025-11-26 19:58:20'),(9,'Elrond',NULL,'Halfelven','LordRivendell','5301112242',NULL,'elrond@rivendell.me',NULL,'1972-08-15','2025-11-26 19:58:20','2025-11-26 19:58:20'),(10,'Arwen',NULL,'Undomiel','Evenstar','5301112243',NULL,'arwen@rivendell.me',NULL,'1992-11-30','2025-11-26 19:58:20','2025-11-26 19:58:20'),(11,'Eowyn',NULL,'Rohirrim','Shieldmaiden','5301112244',NULL,'eowyn@rohan.me',NULL,'1991-03-18','2025-11-26 19:58:20','2025-11-26 19:58:20'),(12,'Éomer',NULL,'Rohirrim','HorseLord','5301112245',NULL,'eomer@rohan.me',NULL,'1987-12-02','2025-11-26 19:58:20','2025-11-26 19:58:20'),(13,'Faramir',NULL,'Gondorian','Steward','5301112246',NULL,'faramir@gondor.me',NULL,'1984-05-29','2025-11-26 19:58:20','2025-11-26 19:58:20'),(14,'Bilbo',NULL,'Baggins','Burglar','5301112247',NULL,'bilbo@shire.me',NULL,'1950-09-12','2025-11-26 19:58:20','2025-11-26 19:58:20'),(15,'Thorin',NULL,'Oakenshield','KingUnderMountain','5301112248',NULL,'thorin@erebor.me',NULL,'1970-01-15','2025-11-26 19:58:20','2025-11-26 19:58:20'),(16,'Balin',NULL,'Fundinson','BalinDwarf','5301112249',NULL,'balin@erebor.me',NULL,'1965-04-22','2025-11-26 19:58:20','2025-11-26 19:58:20'),(17,'Bard',NULL,'Bowman','DragonSlayer','5301112250',NULL,'bard@laketown.me',NULL,'1983-10-09','2025-11-26 19:58:20','2025-11-26 19:58:20'),(18,'Tauriel',NULL,'Mirkwood','CaptainGuard','5301112251',NULL,'tauriel@mirkwood.me',NULL,'1993-07-17','2025-11-26 19:58:20','2025-11-26 19:58:20'),(19,'Isildur',NULL,'Elendilson','KingsHeir','5301112253',NULL,'isildur@gondor.me',NULL,'1960-06-06','2025-11-26 19:58:20','2025-11-26 19:58:20'),(20,'Sauron',NULL,'The Deceiver','DarkLord','5301112252',NULL,'sauron@mordor.me',NULL,'1930-12-12','2025-11-26 19:58:20','2025-11-26 19:58:20'),(21,'Joseph',NULL,'Cooper','Coop','5304001001',NULL,'joseph.cooper@mail.com',NULL,'1999-04-12','2025-11-26 19:58:20','2025-11-26 19:58:20'),(22,'Eren',NULL,'Yeager','FounderTitan','5304001002',NULL,'eren.yeager@mail.com',NULL,'2002-11-03','2025-11-26 19:58:20','2025-11-26 19:58:20'),(23,'Charles',NULL,'Darwin','GOAT','5304001003',NULL,'charles.darwin@mail.com',NULL,'1809-02-12','2025-11-26 19:58:20','2025-11-26 19:58:20'),(24,'Zeynep',NULL,'Aksoy','Zee','5304001004',NULL,'zeynep.aksoy@mail.com',NULL,'2001-01-25','2025-11-26 19:58:20','2025-11-26 19:58:20'),(25,'Kerem',NULL,'Ateş','Kero','5304001005',NULL,'kerem.ates@mail.com',NULL,'1995-06-08','2025-11-26 19:58:20','2025-11-26 19:58:20'),(26,'Selin',NULL,'Kara','Sel','5304001006',NULL,'selin.kara@mail.com',NULL,'1998-09-14','2025-11-26 19:58:20','2025-11-26 19:58:20'),(27,'Onur',NULL,'Şahin','Nuri','5304001007',NULL,'onur.sahin@mail.com',NULL,'1993-02-28','2025-11-26 19:58:20','2025-11-26 19:58:20'),(28,'Elif',NULL,'Üstün','Ella','5304001008',NULL,'elif.ustun@mail.com',NULL,'2000-12-05','2025-11-26 19:58:20','2025-11-26 19:58:20'),(29,'Can',NULL,'Demir','Cano','5304001009',NULL,'can.demir@mail.com',NULL,'1997-10-11','2025-11-26 19:58:20','2025-11-26 19:58:20'),(30,'Mert',NULL,'Kuzey','Merto','5304001010',NULL,'mert.kuzey@mail.com',NULL,'1994-01-03','2025-11-26 19:58:20','2025-11-26 19:58:20'),(31,'Aslı',NULL,'Özdemir','Asso','5304001011',NULL,'asli.ozdemir@mail.com',NULL,'1999-04-22','2025-11-26 19:58:20','2025-11-26 19:58:20'),(32,'Cem',NULL,'Güner','Jay','5304001012',NULL,'cem.guner@mail.com',NULL,'1996-03-19','2025-11-26 19:58:20','2025-11-26 19:58:20'),(33,'Ece',NULL,'Duman','Ecey','5304001013',NULL,'ece.duman@mail.com',NULL,'1998-08-27','2025-11-26 19:58:20','2025-11-26 19:58:20'),(34,'Deniz',NULL,'Arslan','Dnz','5304001014',NULL,'deniz.arslan@mail.com',NULL,'1995-11-30','2025-11-26 19:58:20','2025-11-26 19:58:20'),(35,'Okan',NULL,'Yalçın','Okie','5304001015',NULL,'okan.yalcin@mail.com',NULL,'1993-07-09','2025-11-26 19:58:20','2025-11-26 19:58:20'),(36,'Melisa',NULL,'Türkmen','Meli','5304001016',NULL,'melisa.turkmen@mail.com',NULL,'2001-02-17','2025-11-26 19:58:20','2025-11-26 19:58:20'),(37,'Hakan',NULL,'Ergin','Hako','5304001017',NULL,'hakan.ergin@mail.com',NULL,'1992-05-25','2025-11-26 19:58:20','2025-11-26 19:58:20'),(38,'Buse',NULL,'Çetin','Boo','5304001018',NULL,'buse.cetin@mail.com',NULL,'1997-12-01','2025-11-26 19:58:20','2025-11-26 19:58:20'),(39,'Yusuf',NULL,'Koç','Yus','5304001019',NULL,'yusuf.koc@mail.com',NULL,'1994-03-11','2025-11-26 19:58:20','2025-11-26 19:58:20'),(40,'Seda',NULL,'Polat','Sed','5304001020',NULL,'seda.polat@mail.com',NULL,'1998-09-02','2025-11-26 19:58:20','2025-11-26 19:58:20'),(41,'Arda',NULL,'Gündüz','Ardee','5304001021',NULL,'arda.gunduz@mail.com',NULL,'2001-04-14','2025-11-26 19:58:20','2025-11-26 19:58:20'),(42,'Naz',NULL,'Uçar','Nazo','5304001022',NULL,'naz.ucar@mail.com',NULL,'1999-06-30','2025-11-26 19:58:20','2025-11-26 19:58:20'),(43,'Oğuz',NULL,'Bal','Ozi','5304001023',NULL,'oguz.bal@mail.com',NULL,'1993-01-19','2025-11-26 19:58:20','2025-11-26 19:58:20'),(44,'Gizem',NULL,'Özer','Giz','5304001024',NULL,'gizem.ozer@mail.com',NULL,'1997-11-07','2025-11-26 19:58:20','2025-11-26 19:58:20'),(45,'Serkan',NULL,'Okur','Serko','5304001025',NULL,'serkan.okur@mail.com',NULL,'1995-05-06','2025-11-26 19:58:20','2025-11-26 19:58:20'),(46,'İlayda',NULL,'Kurt','Lai','5304001026',NULL,'ilayda.kurt@mail.com',NULL,'2000-10-13','2025-11-26 19:58:20','2025-11-26 19:58:20'),(47,'Baran',NULL,'Aydın','Baro','5304001027',NULL,'baran.aydin@mail.com',NULL,'1998-03-28','2025-11-26 19:58:20','2025-11-26 19:58:20'),(48,'Tuğçe',NULL,'Erbay','Tugi','5304001028',NULL,'tugce.erbay@mail.com',NULL,'1996-07-22','2025-11-26 19:58:20','2025-11-26 19:58:20'),(49,'Sarp',NULL,'Göl','Sarpo','5304001029',NULL,'sarp.gol@mail.com',NULL,'1997-08-15','2025-11-26 19:58:20','2025-11-26 19:58:20'),(50,'Defne',NULL,'Toprak','Def','5304001030',NULL,'defne.toprak@mail.com',NULL,'2002-01-09','2025-11-26 19:58:20','2025-11-26 19:58:20');
/*!40000 ALTER TABLE `contacts` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-11-26 23:09:07
