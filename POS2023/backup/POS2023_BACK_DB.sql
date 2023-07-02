-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: localhost    Database: pos2023
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
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category` (
  `CATEGORY_ID` int NOT NULL AUTO_INCREMENT,
  `CATEGORY_NAME` varchar(45) NOT NULL,
  `CATEGORY_DESC` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`CATEGORY_ID`),
  UNIQUE KEY `CATEGORY_NAME_UNIQUE` (`CATEGORY_NAME`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'Drink',NULL),(2,'Soft Drink','');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item`
--

DROP TABLE IF EXISTS `item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `item` (
  `ITEM_ID` int NOT NULL AUTO_INCREMENT,
  `ITEM_NAME` varchar(45) NOT NULL,
  `ITEM_DESC` varchar(45) DEFAULT NULL,
  `ITEM_SPCIFY_CODE` varchar(45) NOT NULL,
  `CREATED_ON` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `CREATED_BY` int NOT NULL,
  `CATEGORY_ID` int NOT NULL,
  PRIMARY KEY (`ITEM_ID`),
  UNIQUE KEY `ITEM_SPCIFY_CODE_UNIQUE` (`ITEM_SPCIFY_CODE`),
  KEY `item_category_CATEGORY_ID_fk` (`CATEGORY_ID`),
  KEY `item_system_user_USER_ID_fk` (`CREATED_BY`),
  CONSTRAINT `item_category_CATEGORY_ID_fk` FOREIGN KEY (`CATEGORY_ID`) REFERENCES `category` (`CATEGORY_ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `item_system_user_USER_ID_fk` FOREIGN KEY (`CREATED_BY`) REFERENCES `system_user` (`USER_ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item`
--

LOCK TABLES `item` WRITE;
/*!40000 ALTER TABLE `item` DISABLE KEYS */;
INSERT INTO `item` VALUES (1,'pepsi','','PP1','2023-06-25 09:55:27',1,1),(2,'Orange Soda','','ORGSDA','2023-06-25 10:34:20',1,1),(3,'Orange Soda','','ORGSDAD','2023-06-25 10:36:50',1,1),(4,'Milo','desc','MILO','2023-07-02 06:37:23',1,1);
/*!40000 ALTER TABLE `item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item_rate`
--

DROP TABLE IF EXISTS `item_rate`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `item_rate` (
  `ITEM_RATE_ID` int NOT NULL AUTO_INCREMENT,
  `ITEM_RATE` double NOT NULL,
  `CREATED_ON` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `CREATED_BY` int NOT NULL,
  `ITEM_ID` int NOT NULL,
  PRIMARY KEY (`ITEM_RATE_ID`),
  KEY `item_rate_item_ITEM_ID_fk` (`ITEM_ID`),
  KEY `item_rate_system_user_USER_ID_fk` (`CREATED_BY`),
  CONSTRAINT `item_rate_item_ITEM_ID_fk` FOREIGN KEY (`ITEM_ID`) REFERENCES `item` (`ITEM_ID`),
  CONSTRAINT `item_rate_system_user_USER_ID_fk` FOREIGN KEY (`CREATED_BY`) REFERENCES `system_user` (`USER_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item_rate`
--

LOCK TABLES `item_rate` WRITE;
/*!40000 ALTER TABLE `item_rate` DISABLE KEYS */;
INSERT INTO `item_rate` VALUES (1,25,'2023-06-25 09:55:27',1,1),(2,20.56,'2023-06-25 10:34:20',1,2),(3,20.56,'2023-06-25 10:36:50',1,3),(4,29,'2023-07-02 06:35:03',1,1),(5,234,'2023-07-02 06:37:23',1,4),(6,45,'2023-07-02 06:38:33',1,2);
/*!40000 ALTER TABLE `item_rate` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `system_user`
--

DROP TABLE IF EXISTS `system_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `system_user` (
  `USER_ID` int NOT NULL AUTO_INCREMENT,
  `FIRST_NAME` varchar(45) NOT NULL,
  `LAST_NAME` varchar(45) NOT NULL,
  `EMAIL_ID` varchar(45) NOT NULL,
  `MOBILE_NUMBER` varchar(45) NOT NULL,
  `USERNAME` varchar(45) NOT NULL,
  `PASSWORD` varchar(100) NOT NULL,
  PRIMARY KEY (`USER_ID`),
  UNIQUE KEY `EMAIL_ID_UNIQUE` (`EMAIL_ID`),
  UNIQUE KEY `USERNAME_UNIQUE` (`USERNAME`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `system_user`
--

LOCK TABLES `system_user` WRITE;
/*!40000 ALTER TABLE `system_user` DISABLE KEYS */;
INSERT INTO `system_user` VALUES (1,'prem','prem','rex@test.com','0777728630','prem','112233');
/*!40000 ALTER TABLE `system_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'pos2023'
--

--
-- Dumping routines for database 'pos2023'
--
/*!50003 DROP PROCEDURE IF EXISTS `getItemRateByItemId` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getItemRateByItemId`(IN pItemId int, OUT rItemRate double)
BEGIN
	SELECT ITEM_RATE into rItemRate FROM item_rate where ITEM_ID = pItemId order by ITEM_RATE_ID desc limit 1;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `insert_update_category_detail` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `insert_update_category_detail`(
IN pCategoryId int, 
IN pCategoryName varchar(45),
IN pCategoryDesc varchar(45),
OUT rRes tinyint(1),
OUT rMsg varchar(100)
                                                                 )
BEGIN
	DECLARE lCategoryCount integer default 0;
    
    SET rRes := true;
    SET rMsg := 'Success';
    
    SELECT count(*)
        into lCategoryCount
    FROM category
    WHERE UPPER(CATEGORY_NAME) = UPPER(pCategoryName);
    
    IF pCategoryId = 0 and lCategoryCount = 0 THEN
		INSERT INTO category(CATEGORY_NAME,CATEGORY_DESC)VALUES(pCategoryName,pCategoryDesc);
	ELSE
		 SET rRes := false;
         SET rMsg := 'Category Name already exists...!';
    END IF;
    
    IF pCategoryId > 0 then
		UPDATE category
		SET
		CATEGORY_NAME = pCategoryName,
		CATEGORY_DESC = pCategoryDesc
		WHERE CATEGORY_ID = pCategoryId;
    END IF;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `insert_update_item_detail` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `insert_update_item_detail`(IN pItemId int, IN pItemName varchar(45),
                                                                 IN pItemDesc varchar(45), IN pItemCode varchar(45),
                                                                 IN pUserId int, IN pCategoryId int,
                                                                 IN pItemRate double, OUT rRes tinyint(1),
                                                                 OUT rMsg varchar(100))
BEGIN
    DECLARE lItemCount integer default 0;
    DECLARE lItemId integer default 0;
    
    SET rRes := true;
    SET rMsg := 'Success';


    SELECT count(*)
        into lItemCount
    FROM item
    WHERE UPPER(ITEM_SPCIFY_CODE) = UPPER(pItemCode);
    
    IF lItemCount > 0 and pItemId = 0 then
        SET rRes := false;
        SET rMsg := 'Item Code already exists...!';
    ELSE
        IF pItemId = 0 then
            insert into item(ITEM_NAME, ITEM_DESC, ITEM_SPCIFY_CODE, CREATED_ON, CREATED_BY, CATEGORY_ID) 
            VALUES (pItemName,pItemDesc,pItemCode,now(),pUserId,pCategoryId);
            
            select LAST_INSERT_ID() into lItemId;
            
            insert into item_rate(ITEM_RATE, CREATED_ON, CREATED_BY, ITEM_ID) VALUES 
            (pItemRate,now(),pUserId,lItemId);
        else
            update item
                set ITEM_NAME = pItemName
            where ITEM_ID = pItemId;
        end if;
    END IF;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `insert_update_item_rate_detail` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `insert_update_item_rate_detail`(
IN pItemId int,
IN pItemRate double, 
IN pUserId int,
OUT rRes tinyint(1),
OUT rMsg varchar(100))
BEGIN
	SET rRes := true;
    SET rMsg := 'Success';
	insert into item_rate(
				ITEM_RATE, 
				CREATED_ON, 
				CREATED_BY, 
				ITEM_ID) 
			VALUES(
				pItemRate,
				now(),
				pUserId,
				pItemId);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
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
CREATE DEFINER=`root`@`localhost` PROCEDURE `insert_update_user_detail`(
IN pUserId int,
pFirstName VARCHAR(45),
pLastName VARCHAR(45),
pEmailAddress VARCHAR(45),
pMobileNo VARCHAR(45),
pUsername VARCHAR(45),
pPassword VARCHAR(45),
OUT rRes tinyint(1),
OUT rMsg varchar(100)
)
BEGIN
	SET rRes := true;
    SET rMsg := 'Success';
	IF pUserId = 0 THEN
		INSERT INTO system_user
		(
		FIRST_NAME,
		LAST_NAME,
		EMAIL_ID,
		MOBILE_NUMBER,
		USERNAME,
		PASSWORD)
		VALUES
		(pFirstName,pLastName,pEmailAddress,pMobileNo,pUsername,pPassword);
	ELSE
		Update system_user
			set PASSWORD = pPassword
        where USER_ID = pUserId;
        
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

-- Dump completed on 2023-07-02 12:15:58
