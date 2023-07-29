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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `consultant`
--

LOCK TABLES `consultant` WRITE;
/*!40000 ALTER TABLE `consultant` DISABLE KEYS */;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jobseeker`
--

LOCK TABLES `jobseeker` WRITE;
/*!40000 ALTER TABLE `jobseeker` DISABLE KEYS */;
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
  `UserTypeId` int DEFAULT NULL,
  PRIMARY KEY (`UserId`),
  KEY `systemuser_usertype_UserTypeId_fk` (`UserTypeId`),
  CONSTRAINT `systemuser_usertype_UserTypeId_fk` FOREIGN KEY (`UserTypeId`) REFERENCES `usertype` (`UserTypeId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `systemuser`
--

LOCK TABLES `systemuser` WRITE;
/*!40000 ALTER TABLE `systemuser` DISABLE KEYS */;
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
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-07-29 13:30:39
