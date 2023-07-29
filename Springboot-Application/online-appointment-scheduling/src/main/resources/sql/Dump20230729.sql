-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: localhost    Database: onlineappointmentschedule
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
-- Table structure for table `appointment`
--

DROP TABLE IF EXISTS `appointment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `appointment` (
  `AppointmentId` int NOT NULL AUTO_INCREMENT,
  `AppointmentDate` datetime NOT NULL,
  `AppointmentStatus` varchar(10) NOT NULL,
  `ConsultantId` int NOT NULL,
  `JobSeekerId` int NOT NULL,
  PRIMARY KEY (`AppointmentId`),
  KEY `Appointment_consultant_ConsultantId_fk` (`ConsultantId`),
  KEY `appointment_jobseeker_JobSeekerId_fk` (`JobSeekerId`),
  CONSTRAINT `Appointment_consultant_ConsultantId_fk` FOREIGN KEY (`ConsultantId`) REFERENCES `consultant` (`ConsultantId`),
  CONSTRAINT `appointment_jobseeker_JobSeekerId_fk` FOREIGN KEY (`JobSeekerId`) REFERENCES `jobseeker` (`JobSeekerId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `appointment`
--

LOCK TABLES `appointment` WRITE;
/*!40000 ALTER TABLE `appointment` DISABLE KEYS */;
/*!40000 ALTER TABLE `appointment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `consultant`
--

DROP TABLE IF EXISTS `consultant`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `consultant` (
  `ConsultantId` int NOT NULL AUTO_INCREMENT,
  `SpecializationId` int DEFAULT NULL,
  `UserId` int NOT NULL,
  PRIMARY KEY (`ConsultantId`),
  KEY `consultant_specialization_fk` (`SpecializationId`),
  KEY `consultant_systemuser_UserId_fk` (`UserId`),
  CONSTRAINT `consultant_specialization_fk` FOREIGN KEY (`SpecializationId`) REFERENCES `specialization` (`SpecializationId`),
  CONSTRAINT `consultant_systemuser_UserId_fk` FOREIGN KEY (`UserId`) REFERENCES `systemuser` (`UserId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `consultant`
--

LOCK TABLES `consultant` WRITE;
/*!40000 ALTER TABLE `consultant` DISABLE KEYS */;
INSERT INTO `consultant` VALUES (1,1,3);
/*!40000 ALTER TABLE `consultant` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `consultantavailability`
--

DROP TABLE IF EXISTS `consultantavailability`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `consultantavailability` (
  `AvailabilityId` int NOT NULL AUTO_INCREMENT,
  `Day` int NOT NULL,
  `From` datetime NOT NULL,
  `To` datetime NOT NULL,
  `ConsultantId` int NOT NULL,
  PRIMARY KEY (`AvailabilityId`),
  KEY `ConsultantAvailability_consultant_ConsultantId_fk` (`ConsultantId`),
  CONSTRAINT `ConsultantAvailability_consultant_ConsultantId_fk` FOREIGN KEY (`ConsultantId`) REFERENCES `consultant` (`ConsultantId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `consultantavailability`
--

LOCK TABLES `consultantavailability` WRITE;
/*!40000 ALTER TABLE `consultantavailability` DISABLE KEYS */;
/*!40000 ALTER TABLE `consultantavailability` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `consultantdeviation`
--

DROP TABLE IF EXISTS `consultantdeviation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `consultantdeviation` (
  `DeviationId` int NOT NULL AUTO_INCREMENT,
  `From` datetime NOT NULL,
  `To` datetime NOT NULL,
  `ConsultantId` int NOT NULL,
  PRIMARY KEY (`DeviationId`),
  KEY `ConsultantDeviation_consultant_ConsultantId_fk` (`ConsultantId`),
  CONSTRAINT `ConsultantDeviation_consultant_ConsultantId_fk` FOREIGN KEY (`ConsultantId`) REFERENCES `consultant` (`ConsultantId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `consultantdeviation`
--

LOCK TABLES `consultantdeviation` WRITE;
/*!40000 ALTER TABLE `consultantdeviation` DISABLE KEYS */;
/*!40000 ALTER TABLE `consultantdeviation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jobseeker`
--

DROP TABLE IF EXISTS `jobseeker`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `jobseeker` (
  `JobSeekerId` int NOT NULL AUTO_INCREMENT,
  `UserId` int NOT NULL,
  PRIMARY KEY (`JobSeekerId`),
  KEY `jobseeker_systemuser_UserId_fk` (`UserId`),
  CONSTRAINT `jobseeker_systemuser_UserId_fk` FOREIGN KEY (`UserId`) REFERENCES `systemuser` (`UserId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jobseeker`
--

LOCK TABLES `jobseeker` WRITE;
/*!40000 ALTER TABLE `jobseeker` DISABLE KEYS */;
INSERT INTO `jobseeker` VALUES (1,2);
/*!40000 ALTER TABLE `jobseeker` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `specialization`
--

DROP TABLE IF EXISTS `specialization`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `specialization` (
  `SpecializationId` int NOT NULL AUTO_INCREMENT,
  `Country` varchar(50) NOT NULL,
  `JobType` varchar(50) NOT NULL,
  PRIMARY KEY (`SpecializationId`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `specialization`
--

LOCK TABLES `specialization` WRITE;
/*!40000 ALTER TABLE `specialization` DISABLE KEYS */;
INSERT INTO `specialization` VALUES (1,'Canada','IT'),(2,'Canada','Labour'),(3,'Singapore','IT'),(4,'America','Painter'),(5,'Singapore','Cook');
/*!40000 ALTER TABLE `specialization` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `systemuser`
--

DROP TABLE IF EXISTS `systemuser`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `systemuser` (
  `UserId` int NOT NULL AUTO_INCREMENT,
  `FirstName` varchar(50) NOT NULL,
  `LastName` varchar(50) NOT NULL,
  `EmailAddress` varchar(30) NOT NULL,
  `MobileNumber` varchar(10) NOT NULL,
  `SUPassword` varchar(50) NOT NULL,
  `UserTypeId` int NOT NULL,
  PRIMARY KEY (`UserId`),
  KEY `systemuser_usertype_UserTypeId_fk` (`UserTypeId`),
  CONSTRAINT `systemuser_usertype_UserTypeId_fk` FOREIGN KEY (`UserTypeId`) REFERENCES `usertype` (`UserTypeId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `systemuser`
--

LOCK TABLES `systemuser` WRITE;
/*!40000 ALTER TABLE `systemuser` DISABLE KEYS */;
INSERT INTO `systemuser` VALUES (1,'Prem','Prem','pk@test.com','12345678','11223344',1),(2,'Kada','Kada','kada@test.com','12345678','11223344',3),(3,'Siva','Siva','siva@test.com','12345678','11223344',2);
/*!40000 ALTER TABLE `systemuser` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usertype`
--

DROP TABLE IF EXISTS `usertype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usertype` (
  `UserTypeId` int NOT NULL AUTO_INCREMENT,
  `UserTypeName` varchar(10) NOT NULL,
  PRIMARY KEY (`UserTypeId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usertype`
--

LOCK TABLES `usertype` WRITE;
/*!40000 ALTER TABLE `usertype` DISABLE KEYS */;
INSERT INTO `usertype` VALUES (1,'Admin'),(2,'Consultant'),(3,'JobSeeker');
/*!40000 ALTER TABLE `usertype` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'onlineappointmentschedule'
--

--
-- Dumping routines for database 'onlineappointmentschedule'
--
/*!50003 DROP PROCEDURE IF EXISTS `insert_update_user_detail` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `insert_update_user_detail`(IN pUserId int, IN pFirstName varchar(45),
                                                                 IN pLastName varchar(45), IN pEmailAddress varchar(45),
                                                                 IN pMobileNo varchar(45), IN pSUPassword varchar(500),
                                                                 IN pUserTypeId int, IN pSpecializedId int,
                                                                 OUT rRes tinyint(1), OUT rStatusCode int,
                                                                 OUT rMsg varchar(100))
BEGIN
	DECLARE lCount INTEGER default 0;
    DECLARE lEmailCount INTEGER default 0;
     DECLARE lUserId integer default 0;
	SET rRes := true;
    SET rStatusCode  := 0;
    SET rMsg := 'Success';
    
    select count(*) 
	    into lEmailCount 
	from systemuser
	where lower(EmailAddress) = lower(pEmailAddress);
    
     IF lEmailCount > 0 and pUserId = 0 then
        SET rRes := false;
        SET rStatusCode := 1002;
        SET rMsg := 'User EmailAddress already exists, please try a different Email Address...!';
    ELSE
        IF pUserId = 0 and lCount = 0 and lEmailCount = 0 THEN
           INSERT INTO systemuser
						(
						FirstName,
						LastName,
						EmailAddress,
						MobileNumber,
						SUPassword,
						UserTypeId)
						VALUES
							(pFirstName,pLastName,pEmailAddress,pMobileNo,pSUPassword,pUserTypeId); 
                            
			select LAST_INSERT_ID() into lUserId;
			IF pUserTypeId = 3 THEN
				INSERT INTO jobseeker(UserId) VALUES (lUserId);
            END IF;
            IF pUserTypeId = 2 THEN
				INSERT INTO consultant(SpecializationId,UserId) VALUES(pSpecializedId,lUserId);
            END IF;
        ELSE 
            Update systemuser
			    set SUPassword = pSUPassword
            where UserId = pUserId;
        END IF;
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

-- Dump completed on 2023-07-29 13:58:16
