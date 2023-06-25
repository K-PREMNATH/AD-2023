-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: localhost    Database: practice_db
-- ------------------------------------------------------
-- Server version	8.0.29

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
-- Table structure for table `customerdetail`
--

DROP TABLE IF EXISTS `customerdetail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customerdetail` (
  `CustomerDetailId` int NOT NULL AUTO_INCREMENT,
  `UserDetailId` int NOT NULL,
  `CreatedOn` timestamp NOT NULL,
  PRIMARY KEY (`CustomerDetailId`),
  KEY `fkey_idx` (`UserDetailId`),
  CONSTRAINT `fkey` FOREIGN KEY (`UserDetailId`) REFERENCES `userdetail` (`UserDetailId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customerdetail`
--

LOCK TABLES `customerdetail` WRITE;
/*!40000 ALTER TABLE `customerdetail` DISABLE KEYS */;
INSERT INTO `customerdetail` VALUES (1,7,'2023-06-24 04:40:42'),(2,8,'2023-06-24 05:16:08');
/*!40000 ALTER TABLE `customerdetail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userdetail`
--

DROP TABLE IF EXISTS `userdetail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `userdetail` (
  `UserDetailId` int NOT NULL AUTO_INCREMENT,
  `FirstName` varchar(45) NOT NULL,
  `LastName` varchar(45) NOT NULL,
  `EmailAddress` varchar(45) NOT NULL,
  `UserPassword` varchar(100) NOT NULL,
  `MobileNumber` varchar(10) NOT NULL,
  `UserType` int NOT NULL,
  PRIMARY KEY (`UserDetailId`),
  UNIQUE KEY `EmailAddress_UNIQUE` (`EmailAddress`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userdetail`
--

LOCK TABLES `userdetail` WRITE;
/*!40000 ALTER TABLE `userdetail` DISABLE KEYS */;
INSERT INTO `userdetail` VALUES (7,'Lakshi','Lakshi','Lakshi@test.com','12345689','3465879',1),(8,'TestUser','TestUser','testuser@test.com','se43256','23456',1);
/*!40000 ALTER TABLE `userdetail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'practice_db'
--
/*!50003 DROP PROCEDURE IF EXISTS `insert_update_customer` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `insert_update_customer`(
IN pFirstName varchar(50),
IN pLastName varchar(50),
IN pEmailAddress varchar(50),
IN pUserPassword varchar(50),
IN pMobileNumber varchar(50),
IN pUserType int,
OUT rCustomerDetailId int,
OUT rRes tinyint(1), 
OUT rStatusCode int,
OUT rMsg varchar(100)
)
BEGIN
DECLARE lCount INTEGER DEFAULT 0;
DECLARE lUserDetailId INTEGER DEFAULT 0;

SET rRes := true;
SET rMsg := 'Success';
SET rStatusCode := 0;

select 
	count(*) 
	into lCount
from userdetail 
where emailaddress = pEmailAddress;

IF lCount = 0 then 
	INSERT INTO userdetail
		(FirstName,LastName,EmailAddress,UserPassword,MobileNumber,UserType)
	VALUES (pFirstName,pLastName,pEmailAddress,pUserPassword,pMobileNumber,pUserType);
    
    SELECT LAST_INSERT_ID() into lUserDetailId;
    IF lUserDetailId > 0 then
			INSERT INTO customerdetail
				(UserDetailId,CreatedOn)
				VALUES(lUserDetailId, now());
                
			SELECT LAST_INSERT_ID() into rCustomerDetailId;
		ELSE
			SET rRes := false;
			SET rStatusCode := 5002;
			SET rMsg := 'Failed to register the user...!';
    END IF;
else
	SET rRes := false;
    SET rStatusCode := 5001;
	SET rMsg := 'User Email Already Exists...!';
END IF;



END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-06-24 10:50:17
