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
) ENGINE=InnoDB AUTO_INCREMENT=62 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contacts`
--

LOCK TABLES `contacts` WRITE;
/*!40000 ALTER TABLE `contacts` DISABLE KEYS */;
INSERT INTO `contacts` VALUES (1,'Aragorn',NULL,'Elessar','Strider','5301112233',NULL,'aragorn@middleearth.me',NULL,'1980-03-01','2025-11-26 19:58:20','2025-11-26 19:58:20'),(2,'Legolas',NULL,'Greenleaf','PrinceLeg','5301112234',NULL,'legolas@middleearth.me',NULL,'1985-06-12','2025-11-26 19:58:20','2025-11-26 19:58:20'),(3,'Gimli',NULL,'Gloinsson','AxeMaster','5301112235',NULL,'gimli@middleearth.me',NULL,'1978-02-20','2025-11-26 19:58:20','2025-11-26 19:58:20'),(4,'Frodo',NULL,'Baggins','RingBearer','5301112236',NULL,'frodo@shire.me',NULL,'1990-09-22','2025-11-26 19:58:20','2025-11-26 19:58:20'),(5,'Samwise',NULL,'Gamgee','Sam','5301112237',NULL,'sam@shire.me',NULL,'1989-04-07','2025-11-26 19:58:20','2025-11-26 19:58:20'),(6,'Boromir',NULL,'Denethorson','CaptainGondor','5301112238',NULL,'boromir@gondor.me',NULL,'1982-10-10','2025-11-26 19:58:20','2025-11-26 19:58:20'),(7,'Gandalf',NULL,'The Grey','Mithrandir','5301112239',NULL,'gandalf@istari.me',NULL,'1945-01-05','2025-11-26 19:58:20','2025-11-26 19:58:20'),(8,'Galadriel',NULL,'Lightborn','Nenya','5301112241',NULL,'galadriel@lorien.me',NULL,'1975-11-03','2025-11-26 19:58:20','2025-11-26 19:58:20'),(9,'Elrond',NULL,'Halfelven','LordRivendell','5301112242',NULL,'elrond@rivendell.me',NULL,'1972-08-15','2025-11-26 19:58:20','2025-11-26 19:58:20'),(10,'Arwen',NULL,'Undomiel','Evenstar','5301112243',NULL,'arwen@rivendell.me',NULL,'1992-11-30','2025-11-26 19:58:20','2025-11-26 19:58:20'),(11,'Eowyn',NULL,'Rohirrim','Shieldmaiden','5301112244',NULL,'eowyn@rohan.me',NULL,'1991-03-18','2025-11-26 19:58:20','2025-11-26 19:58:20'),(12,'Éomer',NULL,'Rohirrim','HorseLord','5301112245',NULL,'eomer@rohan.me',NULL,'1987-12-02','2025-11-26 19:58:20','2025-11-26 19:58:20'),(13,'Faramir',NULL,'Gondorian','Steward','5301112246',NULL,'faramir@gondor.me',NULL,'1984-05-29','2025-11-26 19:58:20','2025-11-26 19:58:20'),(14,'Bilbo',NULL,'Baggins','Burglar','5301112247',NULL,'bilbo@shire.me',NULL,'1950-09-12','2025-11-26 19:58:20','2025-11-26 19:58:20'),(15,'Thorin',NULL,'Oakenshield','KingUnderMountain','5301112248',NULL,'thorin@erebor.me',NULL,'1970-01-15','2025-11-26 19:58:20','2025-11-26 19:58:20'),(16,'Balin',NULL,'Fundinson','BalinDwarf','5301112249',NULL,'balin@erebor.me',NULL,'1965-04-22','2025-11-26 19:58:20','2025-11-26 19:58:20'),(17,'Bard',NULL,'Bowman','DragonSlayer','5301112250',NULL,'bard@laketown.me',NULL,'1983-10-09','2025-11-26 19:58:20','2025-11-26 19:58:20'),(18,'Tauriel',NULL,'Mirkwood','CaptainGuard','5301112251',NULL,'tauriel@mirkwood.me',NULL,'1993-07-17','2025-11-26 19:58:20','2025-11-26 19:58:20'),(19,'Isildur',NULL,'Elendilson','KingsHeir','5301112253',NULL,'isildur@gondor.me',NULL,'1960-06-06','2025-11-26 19:58:20','2025-11-26 19:58:20'),(20,'Sauron',NULL,'The Deceiver','DarkLord','5301112252',NULL,'sauron@mordor.me',NULL,'1930-12-12','2025-11-26 19:58:20','2025-11-26 19:58:20'),(21,'Joseph',NULL,'Cooper','Coop','5304001001',NULL,'joseph.cooper@mail.com',NULL,'1999-04-12','2025-11-26 19:58:20','2025-11-26 19:58:20'),(22,'Eren',NULL,'Yeager','FounderTitan','5304001002',NULL,'eren.yeager@mail.com',NULL,'2002-11-03','2025-11-26 19:58:20','2025-11-26 19:58:20'),(23,'Charles',NULL,'Darwin','GOAT','5304001003',NULL,'charles.darwin@mail.com',NULL,'1809-02-12','2025-11-26 19:58:20','2025-11-26 19:58:20'),(24,'Zeynep',NULL,'Aksoy','Zee','5304001004',NULL,'zeynep.aksoy@mail.com',NULL,'2001-01-25','2025-11-26 19:58:20','2025-11-26 19:58:20'),(25,'Kerem',NULL,'Ateş','Kero','5304001005',NULL,'kerem.ates@mail.com',NULL,'1995-06-08','2025-11-26 19:58:20','2025-11-26 19:58:20'),(26,'Selin',NULL,'Kara','Sel','5304001006',NULL,'selin.kara@mail.com',NULL,'1998-09-14','2025-11-26 19:58:20','2025-11-26 19:58:20'),(27,'Onur',NULL,'Şahin','Nuri','5304001007',NULL,'onur.sahin@mail.com',NULL,'1993-02-28','2025-11-26 19:58:20','2025-11-26 19:58:20'),(28,'Elif',NULL,'Üstün','Ella','5304001008',NULL,'elif.ustun@mail.com',NULL,'2000-12-05','2025-11-26 19:58:20','2025-11-26 19:58:20'),(29,'Can',NULL,'Demir','Cano','5304001009',NULL,'can.demir@mail.com',NULL,'1997-10-11','2025-11-26 19:58:20','2025-11-26 19:58:20'),(30,'Mert',NULL,'Kuzey','Merto','5304001010',NULL,'mert.kuzey@mail.com',NULL,'1994-01-03','2025-11-26 19:58:20','2025-11-26 19:58:20'),(31,'Aslı',NULL,'Özdemir','Asso','5304001011',NULL,'asli.ozdemir@mail.com',NULL,'1999-04-22','2025-11-26 19:58:20','2025-11-26 19:58:20'),(32,'Cem',NULL,'Güner','Jay','5304001012',NULL,'cem.guner@mail.com',NULL,'1996-03-19','2025-11-26 19:58:20','2025-11-26 19:58:20'),(33,'Ece',NULL,'Duman','Ecey','5304001013',NULL,'ece.duman@mail.com',NULL,'1998-08-27','2025-11-26 19:58:20','2025-11-26 19:58:20'),(34,'Deniz',NULL,'Arslan','Dnz','5304001014',NULL,'deniz.arslan@mail.com',NULL,'1995-11-30','2025-11-26 19:58:20','2025-11-26 19:58:20'),(35,'Okan',NULL,'Yalçın','Okie','5304001015',NULL,'okan.yalcin@mail.com',NULL,'1993-07-09','2025-11-26 19:58:20','2025-11-26 19:58:20'),(36,'Melisa',NULL,'Türkmen','Meli','5304001016',NULL,'melisa.turkmen@mail.com',NULL,'2001-02-17','2025-11-26 19:58:20','2025-11-26 19:58:20'),(37,'Hakan',NULL,'Ergin','Hako','5304001017',NULL,'hakan.ergin@mail.com',NULL,'1992-05-25','2025-11-26 19:58:20','2025-11-26 19:58:20'),(38,'Buse',NULL,'Çetin','Boo','5304001018',NULL,'buse.cetin@mail.com',NULL,'1997-12-01','2025-11-26 19:58:20','2025-11-26 19:58:20'),(39,'Yusuf',NULL,'Koç','Yus','5304001019',NULL,'yusuf.koc@mail.com',NULL,'1994-03-11','2025-11-26 19:58:20','2025-11-26 19:58:20'),(40,'Seda',NULL,'Polat','Sed','5304001020',NULL,'seda.polat@mail.com',NULL,'1998-09-02','2025-11-26 19:58:20','2025-11-26 19:58:20'),(41,'Arda',NULL,'Gündüz','Ardee','5304001021',NULL,'arda.gunduz@mail.com',NULL,'2001-04-14','2025-11-26 19:58:20','2025-11-26 19:58:20'),(42,'Naz',NULL,'Uçar','Nazo','5304001022',NULL,'naz.ucar@mail.com',NULL,'1999-06-30','2025-11-26 19:58:20','2025-11-26 19:58:20'),(43,'Oğuz',NULL,'Bal','Ozi','5304001023',NULL,'oguz.bal@mail.com',NULL,'1993-01-19','2025-12-02 12:01:03','2025-12-02 12:01:03'),(44,'Gizem',NULL,'Özer','Giz','5304001024',NULL,'gizem.ozer@mail.com',NULL,'1997-11-07','2025-11-26 19:58:20','2025-11-26 19:58:20'),(45,'Serkan',NULL,'Okur','Serko','5304001025',NULL,'serkan.okur@mail.com',NULL,'1995-05-06','2025-11-26 19:58:20','2025-11-26 19:58:20'),(46,'İlayda',NULL,'Kurt','Lai','5304001026',NULL,'ilayda.kurt@mail.com',NULL,'2000-10-13','2025-11-26 19:58:20','2025-11-26 19:58:20'),(47,'Baran',NULL,'Aydın','Baro','5304001027',NULL,'baran.aydin@mail.com',NULL,'1998-03-28','2025-11-26 19:58:20','2025-11-26 19:58:20'),(48,'Tuğçe',NULL,'Erbay','Tugi','5304001028',NULL,'tugce.erbay@mail.com',NULL,'1996-07-22','2025-11-26 19:58:20','2025-11-26 19:58:20'),(49,'Sarp',NULL,'Göl','Sarpo','5304001029',NULL,'sarp.gol@mail.com',NULL,'1997-08-15','2025-11-26 19:58:20','2025-11-26 19:58:20'),(50,'Defne',NULL,'Toprak','Def','5304001030',NULL,'defne.toprak@mail.com',NULL,'2002-01-09','2025-11-26 19:58:20','2025-11-26 19:58:20'),(51,'ysy',NULL,'ysy','Devasa Frontal Lobelu Lord','05445755415',NULL,'yavuzselim072004@gmail.com','https://www.linkedin.com/in/ysy','2004-05-28','2025-11-29 14:34:29','2025-12-05 19:19:57'),(52,'bü',NULL,'bü','büü','455454545',NULL,'bü@gmail.com',NULL,'2024-02-29','2025-12-01 11:37:00','2025-12-01 11:37:00'),(53,'arif','emre','kılıç','bacanak','+31 331 313 31 31',NULL,'bacanak@vefa.com',NULL,'2004-01-31','2025-11-29 16:06:07','2025-11-29 16:06:07'),(54,'burak','kadri yaşar','özevin','myburakoz','053131313131',NULL,'burak@zortmail.com','burak.com','2004-07-11','2025-12-02 09:46:59','2025-12-02 09:46:59'),(55,'ozan','noname','kutlar','ozi','05555454554',NULL,'ozi@gmail.com','https://linkedin.com/in/ozat','1899-11-23','2025-12-04 05:30:43','2025-12-05 19:39:03'),(57,'test','test','test','test','23432432432',NULL,'test@gmail.com',NULL,'2004-10-10','2025-12-04 14:11:49','2025-12-04 14:11:49'),(58,'birdem',NULL,'üstündağ','mi amor','0343243424',NULL,'birdem@gmail.com',NULL,'2025-12-05','2025-12-05 19:02:22','2025-12-05 19:02:22');
/*!40000 ALTER TABLE `contacts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `undo_log`
--

DROP TABLE IF EXISTS `undo_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `undo_log` (
  `undo_id` int NOT NULL AUTO_INCREMENT,
  `entity_type` enum('CONTACT','USER') NOT NULL,
  `operation_type` enum('INSERT','UPDATE','DELETE') NOT NULL,
  `entity_id` int NOT NULL,
  `old_data` text,
  `new_data` text,
  `created_by` varchar(100) DEFAULT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`undo_id`)
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `undo_log`
--

LOCK TABLES `undo_log` WRITE;
/*!40000 ALTER TABLE `undo_log` DISABLE KEYS */;
INSERT INTO `undo_log` VALUES (3,'USER','INSERT',10,NULL,'10|ysy|51f1dcec0d7ed6d9a770f41a8469eacded5b299d631adf9853808bdeffb47a65|ysy|ysy|MANAGER','man','2025-11-29 14:44:06'),(5,'CONTACT','INSERT',52,NULL,'52|bü||bü|büü|455454545||bü@gmail.com||2024-02-29','sd','2025-11-29 15:15:40'),(7,'CONTACT','INSERT',53,NULL,'53|arif|emre|kılıç|bacanak|+31 331 313 31 31||bacanak@vefa.com||2004-01-31','sd','2025-11-29 16:06:07'),(9,'CONTACT','INSERT',54,NULL,'54|burak|kadri yaşar|özevin|myburakoz|053131313131||burak@zortmail.com|burak.com|2004-07-11','sd','2025-12-02 09:46:59'),(10,'CONTACT','INSERT',55,NULL,'55|ozan|goat|kutlar|ozi|05555454554||ozi@gmail.com|f|1899-11-23','sd','2025-12-02 11:38:49'),(11,'CONTACT','UPDATE',51,'51|ysy||ysy|Devasa Frontal Lobelu Lord|05445755415||yavuzselim072004@gmail.com||2004-05-28','51|ysy||ysy|Devasa Frontal Lobelu Lord|05445755415||yavuzselim072004@gmail.com|zort.com|2004-05-28','sd','2025-12-02 11:53:01'),(14,'CONTACT','UPDATE',55,'55|ozan|goat|kutlar|ozi|05555454554||ozi@gmail.com|ozankutlar.com|1899-11-23','55|ozan|goat|kutlar|ozi|05555454554||ozi@gmail.com|f|1899-11-23','sd','2025-12-02 12:44:21'),(15,'USER','INSERT',12,'','12;zorttiri;4c626a942289b928a9c594c3acce1cb6aaeb26efe8393f36d50feb4c6ebe3316;zart;zort;TESTER','man','2025-12-04 05:21:49'),(16,'USER','DELETE',12,'12;zorttiri;4c626a942289b928a9c594c3acce1cb6aaeb26efe8393f36d50feb4c6ebe3316;zart;zort;TESTER','','man','2025-12-04 05:22:13'),(17,'USER','UPDATE',10,'10;ysy;51f1dcec0d7ed6d9a770f41a8469eacded5b299d631adf9853808bdeffb47a65;ysy;ysy;MANAGER','10;ysy;51f1dcec0d7ed6d9a770f41a8469eacded5b299d631adf9853808bdeffb47a65;ysy;ysy;MANAGER','man','2025-12-04 05:24:02'),(20,'CONTACT','DELETE',56,'56|asd|asd|asd|ad|24313432542||as@sda.com||2025-12-25',NULL,'sd','2025-12-04 05:33:16'),(21,'USER','INSERT',13,'','13;bü;a435c7e804d4548604f4fa69066cc7038819ce19158b11138201a26fd5602584;bü;bü;TESTER','man','2025-12-04 09:33:36'),(22,'USER','UPDATE',13,'13;bü;a435c7e804d4548604f4fa69066cc7038819ce19158b11138201a26fd5602584;bü;bü;TESTER','13;bü;c7de601100defdf352410e15c96c8b3ec9a5f119cb638711495ebce0027087b6;bü;bü;TESTER','bü','2025-12-04 09:34:18'),(27,'USER','INSERT',15,'','15;birdem;579077f8dd4d539fa306635d1bb46a134bfe3e7ec064be8a0381cde26894d78a;birdem;ustundag;SENIOR_DEV','man','2025-12-05 19:00:17'),(28,'CONTACT','INSERT',58,NULL,'58|birdem||üstündağ|mi amor|0343243424||birdem@gmail.com||2025-12-05','sd','2025-12-05 19:02:22'),(29,'CONTACT','INSERT',59,NULL,'59|eqw|eqweqw|eqw|eqwe|423532542542||qw@dasd.com||2004-12-12','sd','2025-12-05 19:04:01'),(30,'CONTACT','INSERT',60,NULL,'60|rerewrewrew||ewfewfew|342|32524524542||feafa@sd.com||2002-12-12','sd','2025-12-05 19:04:30'),(32,'CONTACT','DELETE',59,'59|eqw|eqweqw|eqw|eqwe|423532542542||qw@dasd.com||2004-12-12',NULL,'sd','2025-12-05 19:05:13'),(33,'CONTACT','DELETE',60,'60|rerewrewrew||ewfewfew|342|32524524542||feafa@sd.com||2002-12-12',NULL,'sd','2025-12-05 19:05:19'),(34,'CONTACT','UPDATE',51,'51|ysy||ysy|Devasa Frontal Lobelu Lord|05445755415||yavuzselim072004@gmail.com|zort.com|2004-05-28','51|ysy||ysy|Devasa Frontal Lobelu Lord|05445755415||yavuzselim072004@gmail.com|https://www.linkedin.com/in/ysy|2004-05-28','sd','2025-12-05 19:19:57'),(35,'CONTACT','UPDATE',55,'55|ozan|goat|kutlar|ozi|05555454554||ozi@gmail.com|f|1899-11-23','55|ozan|goat|kutlar|ozi|05555454554||ozi@gmail.com|https://linkedin.com/in/ozat|1899-11-23','sd','2025-12-05 19:23:23'),(36,'CONTACT','UPDATE',55,'55|ozan|goat|kutlar|ozi|05555454554||ozi@gmail.com|https://linkedin.com/in/ozat|1899-11-23','55|ozan|noname|kutlar|ozi|05555454554||ozi@gmail.com|https://linkedin.com/in/ozat|1899-11-23','jd','2025-12-05 19:35:59'),(37,'USER','UPDATE',6,'6;tt;0e07cf830957701d43c183f1515f63e6b68027e528f43ef52b1527a520ddec82;Test;Tester;TESTER','6;tt;0e07cf830957701d43c183f1515f63e6b68027e528f43ef52b1527a520ddec82;Test;Tester;TESTER','tt','2025-12-05 19:38:05'),(38,'CONTACT','UPDATE',55,'55|ozan|noname|kutlar|ozi|05555454554||ozi@gmail.com|https://linkedin.com/in/ozat|1899-11-23','55|ozan|noname|kutlar|ozi|05555454554||ozi@gmail.com|https://linkedin.com/in/ozat|1899-11-23','jd','2025-12-05 19:38:35'),(40,'CONTACT','UPDATE',55,'55|faef|fae|kutlar|ffaefaef|352354542642||ozi@gmail.com|https://linkedin.com/in/ozat|1000-10-10','55|ozan|noname|kutlar|ozi|05555454554||ozi@gmail.com|https://linkedin.com/in/ozat|1899-11-23','jd','2025-12-05 19:39:03'),(41,'USER','INSERT',16,'','16;yawuz;61e52bb1dfe7ca84ea10d6bd4ef35614d64e0681fb7e152cdbdb7fbd7058ac07;yavuz;yasar;MANAGER','man','2025-12-05 19:39:57'),(42,'USER','UPDATE',16,'16;yawuz;61e52bb1dfe7ca84ea10d6bd4ef35614d64e0681fb7e152cdbdb7fbd7058ac07;yavuz;yasar;MANAGER','16;yawuz;61e52bb1dfe7ca84ea10d6bd4ef35614d64e0681fb7e152cdbdb7fbd7058ac07;yavuz;yaşar;MANAGER','yawuz','2025-12-05 19:41:08'),(44,'USER','DELETE',13,'13;bü;c7de601100defdf352410e15c96c8b3ec9a5f119cb638711495ebce0027087b6;bü;bü;TESTER','','yawuz','2025-12-05 19:42:54'),(45,'CONTACT','INSERT',61,NULL,'61|fawef|af|aef|aef|2134124134||asf@casc.com|https://www.linkedin.com/in/your-name|2004-02-29','sd','2025-12-05 19:56:05'),(47,'CONTACT','DELETE',61,'61|fawef|af|aef|aef|2134124134||asf@casc.com|https://www.linkedin.com/in/your-name|2004-02-29',NULL,'sd','2025-12-05 19:57:04');
/*!40000 ALTER TABLE `undo_log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `password_hash` varchar(255) NOT NULL,
  `name` varchar(50) NOT NULL,
  `surname` varchar(50) NOT NULL,
  `role` enum('TESTER','JUNIOR_DEV','SENIOR_DEV','MANAGER') NOT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (6,'tt','0e07cf830957701d43c183f1515f63e6b68027e528f43ef52b1527a520ddec82','Test','Tester','TESTER','2025-11-29 12:05:38'),(7,'jd','ad3e69e9aa860657cc6476770fe253d08198746b9fcf9dc3186b47eb85c30335','Junior','Developer','JUNIOR_DEV','2025-11-29 12:05:38'),(8,'sd','03042cf8100db386818cee4ff0f2972431a62ed78edbd09ac08accfabbefd818','Senior','Developer','SENIOR_DEV','2025-11-29 12:05:38'),(9,'man','48b676e2b107da679512b793d5fd4cc4329f0c7c17a97cf6e0e3d1005b600b03','Mighty','Manager','MANAGER','2025-11-29 12:05:38'),(10,'ysy','51f1dcec0d7ed6d9a770f41a8469eacded5b299d631adf9853808bdeffb47a65','ysy','ysy','MANAGER','2025-11-29 14:44:58'),(15,'birdem','579077f8dd4d539fa306635d1bb46a134bfe3e7ec064be8a0381cde26894d78a','birdem','ustundag','SENIOR_DEV','2025-12-05 19:00:17'),(16,'yawuz','61e52bb1dfe7ca84ea10d6bd4ef35614d64e0681fb7e152cdbdb7fbd7058ac07','yavuz','yaşar','MANAGER','2025-12-05 19:39:57');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-12-05 23:01:34
