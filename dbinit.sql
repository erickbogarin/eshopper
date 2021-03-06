-- MySQL dump 10.13  Distrib 5.6.27, for Win64 (x86_64)
--
-- Host: localhost    Database: eshopper
-- ------------------------------------------------------
-- Server version	5.6.27-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `brand`
--

DROP TABLE IF EXISTS `brand`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `brand` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `brandType` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `brand`
--

LOCK TABLES `brand` WRITE;
/*!40000 ALTER TABLE `brand` DISABLE KEYS */;
INSERT INTO `brand` VALUES (1,'ADIDAS'),(2,'CALVIN_KLEIN'),(3,'LACOSTE'),(4,'NIKE'),(5,'PUMA'),(6,'TOMMY_HILFIGER');
/*!40000 ALTER TABLE `brand` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `category` (
  `id` int(11) NOT NULL,
  `categoryType` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'ROUPAS'),(2,'CALCADOS'),(3,'ACESSORIOS');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `person`
--

DROP TABLE IF EXISTS `person`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `person` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `personType` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `person`
--

LOCK TABLES `person` WRITE;
/*!40000 ALTER TABLE `person` DISABLE KEYS */;
INSERT INTO `person` VALUES (1,'Masculino'),(2,'Feminino'),(3,'Infantil');
/*!40000 ALTER TABLE `person` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` longtext NOT NULL,
  `brand_id` int(11) DEFAULT NULL,
  `category_id` int(11) DEFAULT NULL,
  `person_id` int(11) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `price` decimal(19,2) DEFAULT NULL,
  `largePhotoPath` varchar(255) DEFAULT NULL,
  `mediumPhotoPath` varchar(255) DEFAULT NULL,
  `smallPhotoPath` varchar(255) DEFAULT NULL,
  `nameId` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_e170op5kedic2jolyiimwqfaj` (`brand_id`),
  KEY `FK_b7afq93qsn7aoydaftixggf14` (`category_id`),
  KEY `FK_srns398qnwcahpcrxajqo8yug` (`person_id`),
  CONSTRAINT `FK_b7afq93qsn7aoydaftixggf14` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`),
  CONSTRAINT `FK_e170op5kedic2jolyiimwqfaj` FOREIGN KEY (`brand_id`) REFERENCES `brand` (`id`),
  CONSTRAINT `FK_srns398qnwcahpcrxajqo8yug` FOREIGN KEY (`person_id`) REFERENCES `person` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (5,'Demonstre o orgulho pelo seu time com o NFL New Orleans Saints Game Jersey, inspirado no uniforme usado pelos jogadores em campo e desenvolvido para garantir conforto máximo.',4,1,1,'CAMISA NIKE NEW ORLEANS SAINTS MASCULINA',269.90,'https://s3-sa-east-1.amazonaws.com/erickbogarin.com.br/uploaded-images/large.png','https://s3-sa-east-1.amazonaws.com/erickbogarin.com.br/uploaded-images/medium.png','https://s3-sa-east-1.amazonaws.com/erickbogarin.com.br/uploaded-images/small.png','camisa-nike-new-orleans-saints-masculina'),(6,'O Boné Nike F.C. True Block Adjustable feito com tecido durável, que absorve o suor e fechamento por pressão para um ajuste confortável e personalizado.',4,3,1,'BONÉ NIKE F.C. BLOCK TRUE',119.90,'https://s3-sa-east-1.amazonaws.com/erickbogarin.com.br/uploaded-images/nike-fc-large.png','https://s3-sa-east-1.amazonaws.com/erickbogarin.com.br/uploaded-images/nike-fc-medium.png','https://s3-sa-east-1.amazonaws.com/erickbogarin.com.br/uploaded-images/nike-fc-small.png','bone-nike-fc-block-true'),(7,'O Tênis Masculino para Skate Nike SB Portmore   possui cabedal em suede que oferece um visual desconstruído, proporcionando ótima durabilidade e suporte.',4,2,1,'TÊNIS NIKE SB PORTMORE MASCULINO',279.90,'https://s3-sa-east-1.amazonaws.com/erickbogarin.com.br/uploaded-images/nikesb-portmore-large.png','https://s3-sa-east-1.amazonaws.com/erickbogarin.com.br/uploaded-images/nikesb-portmore-medium.png','https://s3-sa-east-1.amazonaws.com/erickbogarin.com.br/uploaded-images/nikesb-portmore-small.png','tenis-nike-sb-portmore-masculino'),(8,'Mais flexível que o 5.0 e com mais amortecimento que o 3.0, o Tênis de Corrida Feminino Nike Free 4.0 Flyknit permite uma passada natural um cabedal Flyknit leve e protetor, e um solado de baixo perfil altamente flexível.\r\n',4,2,2,'TÊNIS NIKE FREE 4.0 FLYKNIT FEMININO',499.00,'https://s3-sa-east-1.amazonaws.com/erickbogarin.com.br/uploaded-images/652763-large.png','https://s3-sa-east-1.amazonaws.com/erickbogarin.com.br/uploaded-images/652763-medium.png','https://s3-sa-east-1.amazonaws.com/erickbogarin.com.br/uploaded-images/652763-small.png','tenis-nike-free-40-flyknit-feminino'),(9,'A Bolsa Nike Graphic Reversible Tote possui alça que pode ser utilizada no ombro de duas formas diferentes para opções versáteis de transporte. Com estampa sólida e forte em uma lado e estampa em toda a superfície no outro lado, essa bolsa oferece dois looks em um.',4,3,2,'BOLSA NIKE GRAPHIC REVERSIBLE TOTE',129.90,'https://s3-sa-east-1.amazonaws.com/erickbogarin.com.br/uploaded-images/608811-large.png','https://s3-sa-east-1.amazonaws.com/erickbogarin.com.br/uploaded-images/608811-medium.png','https://s3-sa-east-1.amazonaws.com/erickbogarin.com.br/uploaded-images/608811-small.png','bolsa-nike-graphic-reversible-tote'),(10,'A Camiseta de Corrida Feminina Nike AeroReact Pullover apresenta um tecido revolucionário e respirável que reage ao seu suor para ajudar a manter a sua temperatura ideal durante toda a corrida.',4,1,2,'CAMISETA NIKE AEROREACT COWL FEMININA',389.90,'https://s3-sa-east-1.amazonaws.com/erickbogarin.com.br/uploaded-images/692353-large.png','https://s3-sa-east-1.amazonaws.com/erickbogarin.com.br/uploaded-images/692353-medium.png','https://s3-sa-east-1.amazonaws.com/erickbogarin.com.br/uploaded-images/692353-small.png','camiseta-nike-aeroreact-cowl-feminina'),(11,'Linhas de corte modernas e uma mistura esportiva de mélange cinza com mesh azul dão à Bolsa Running Shopping um visual feminino e urbano. Seu compartimento principal espaçoso conta com fecho em zíper e um organizador interno. Finalizado com alças de cinta com logotipo sintético e estampa refletiva preta em Trevo.',1,3,2,'BOLSA BEACH SHOPPER RUNNING',269.99,'https://s3-sa-east-1.amazonaws.com/erickbogarin.com.br/uploaded-images/AO4187-large.png','https://s3-sa-east-1.amazonaws.com/erickbogarin.com.br/uploaded-images/AO4187-medium.png','https://s3-sa-east-1.amazonaws.com/erickbogarin.com.br/uploaded-images/AO4187-small.png','bolsa-beach-shopper-running'),(12,'CAMISETA 3S POLIAMIDA FEMININA',1,1,2,'CAMISETA 3S POLIAMIDA FEMININA',89.90,'https://s3-sa-east-1.amazonaws.com/erickbogarin.com.br/uploaded-images/AK1687-large.png','https://s3-sa-east-1.amazonaws.com/erickbogarin.com.br/uploaded-images/AK1687-medium.png','https://s3-sa-east-1.amazonaws.com/erickbogarin.com.br/uploaded-images/AK1687-small.png','camiseta-3s-poliamida-feminina'),(14,'O Adria PS Slip-on conta com uma vívida estampa em toda a superfície na qual o futebol se encontra com o surfe. Finalizada com 3 Listras elásticas sintéticas e uma etiqueta costurada na lingueta.',1,2,2,'TÊNIS ADRIA PS FEMININO',219.90,'https://s3-sa-east-1.amazonaws.com/erickbogarin.com.br/uploaded-images/S78871-large.png','https://s3-sa-east-1.amazonaws.com/erickbogarin.com.br/uploaded-images/S78871-medium.png','https://s3-sa-east-1.amazonaws.com/erickbogarin.com.br/uploaded-images/S78871-small.png','tenis-adria-ps-feminino'),(15,'O resultado de uma colaboração contínua com o grande nome do skate, Dennis Busenitz, o Busenitz Pro aproveita a lendária chuteira Adidas Copa Mundial e a transforma em um tênis de skate para performance, feito para aguentar o tranco das manobras em qualquer terreno que fizeram Dennis Busenitz famoso. O cabedal durável resiste a impactos e concede controle de precisão para manobras de skate, uma construção com solado e gola acolchoada Geofit dão estabilidade, e ilhoses embutidos impedem que seu cadarço se rasgue. A lingueta personalizável permite que você dite seu conforto e estilo.',1,2,1,'TÊNIS BUSENITZ CLIMA',349.99,'https://s3-sa-east-1.amazonaws.com/erickbogarin.com.br/uploaded-images/F37346-large.png','https://s3-sa-east-1.amazonaws.com/erickbogarin.com.br/uploaded-images/F37346-medium.png','https://s3-sa-east-1.amazonaws.com/erickbogarin.com.br/uploaded-images/F37346-small.png','tenis-busenitz-clima'),(16,'Adidas sempre foi um campeão em campo. adidas Originals olha para trás a décadas de herança de futebol orgulhoso com um gráfico colagem remixed nossas fotografias do catálogo do vintage. Este t-shirt dos homens é terminado com um logotipo do Trevo grande na frente.',1,1,1,'CAMISETA CT AOP TEE',139.90,'https://s3-sa-east-1.amazonaws.com/erickbogarin.com.br/uploaded-images/B4897-large.png','https://s3-sa-east-1.amazonaws.com/erickbogarin.com.br/uploaded-images/B4897-medium.png','https://s3-sa-east-1.amazonaws.com/erickbogarin.com.br/uploaded-images/B4897-small.png','camiseta-ct-aop-tee'),(17,'A Suede Airliner é a velha bolsa repaginada feita de camurça sintética macia, com Três Listras serrilhadas e logomarca do Trevo em baixo relevo na frente. O visual vintage tem compartimento principal com zíper, bolso com zíper na frente e alça de ombro ajustável.',1,3,1,'BOLSA AIRLINER SUEDE ADICOLOR',189.99,'https://s3-sa-east-1.amazonaws.com/erickbogarin.com.br/uploaded-images/AJ8424-large.png','https://s3-sa-east-1.amazonaws.com/erickbogarin.com.br/uploaded-images/AJ8424-medium.png','https://s3-sa-east-1.amazonaws.com/erickbogarin.com.br/uploaded-images/AJ8424-small.png','bolsa-airliner-suede-adicolor');
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `purchase`
--

DROP TABLE IF EXISTS `purchase`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `purchase` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `price` decimal(19,2) NOT NULL,
  `purchaseDate` datetime NOT NULL,
  `productsQuantity` int(11) NOT NULL,
  `purchaseStatus` varchar(255) NOT NULL,
  `user_login` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_9xqfry98i1ylwv47l4mynb2pi` (`user_login`),
  CONSTRAINT `FK_9xqfry98i1ylwv47l4mynb2pi` FOREIGN KEY (`user_login`) REFERENCES `systemuser` (`login`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `purchase`
--

LOCK TABLES `purchase` WRITE;
/*!40000 ALTER TABLE `purchase` DISABLE KEYS */;
INSERT INTO `purchase` VALUES (1,399.80,'2016-03-12 20:42:25',2,'Pago',NULL),(2,279.90,'2016-04-12 20:43:29',1,'Pago',NULL),(3,269.90,'2016-04-12 20:43:48',1,'Pago',NULL),(4,389.80,'2016-04-12 20:44:32',2,'Pago',NULL),(5,306.20,'2016-04-12 21:05:43',1,'Pago',NULL),(6,449.60,'2016-04-14 18:41:07',4,'Pago',NULL),(7,119.90,'2016-04-19 11:12:38',1,'Pago',NULL),(8,269.90,'2016-04-19 11:18:36',1,'Pago',NULL),(9,239.80,'2016-04-21 08:12:52',2,'Pago',NULL),(10,269.90,'2016-04-21 08:17:40',1,'Pago',NULL),(11,129.90,'2016-04-21 08:19:08',1,'Pago',NULL),(12,269.90,'2016-04-24 11:48:55',1,'Pago',NULL),(13,119.90,'2016-04-24 12:26:53',1,'Pago',NULL),(14,389.90,'2016-04-24 12:33:38',1,'Pago',NULL),(15,499.00,'2016-04-24 13:15:48',1,'Pago',NULL),(16,479.60,'2016-04-25 12:07:27',4,'Pago',NULL),(17,359.70,'2016-04-25 12:14:14',3,'Pago',NULL),(18,359.70,'2016-04-26 11:13:19',3,'Pago',NULL),(19,119.90,'2016-04-28 16:00:21',1,'Pago',NULL),(20,119.90,'2016-04-30 17:42:40',1,'Pago',NULL),(21,349.99,'2016-04-30 22:40:42',1,'Pago',NULL),(22,279.90,'2016-05-01 16:48:35',1,'Pago','visitante@email.com'),(23,89.90,'2016-05-02 13:00:49',1,'Pago','visitante@email.com'),(24,269.90,'2016-05-02 16:20:05',1,'Pago','visitante@email.com'),(25,269.90,'2016-07-28 03:07:16',1,'Pago','visitante@email.com'),(26,269.90,'2016-07-28 03:14:53',1,'Pago','visitante@email.com'),(27,119.90,'2016-07-28 03:19:25',1,'Pago','visitante@email.com'),(28,148.60,'2016-07-28 03:22:22',1,'Pago','visitante@email.com'),(29,269.90,'2016-07-31 02:00:58',1,'Pago','visitante@email.com'),(30,119.90,'2016-07-31 02:05:52',1,'Pago','visitante@email.com'),(31,279.90,'2016-07-31 02:09:34',1,'Pago','visitante@email.com'),(32,279.90,'2016-07-31 02:12:54',1,'Pago','visitante@email.com'),(33,119.90,'2016-07-31 02:13:45',1,'Pago','visitante@email.com'),(34,269.90,'2016-07-31 02:14:48',1,'Pago','visitante@email.com'),(35,239.80,'2016-07-31 02:15:06',2,'Pago','visitante@email.com'),(36,389.70,'2016-07-31 02:16:05',3,'Pago','visitante@email.com'),(37,129.90,'2016-07-31 02:16:43',1,'Pago','visitante@email.com'),(38,158.60,'2016-07-31 02:18:27',1,'Pago','visitante@email.com'),(39,219.90,'2016-07-31 02:30:24',1,'Pago','visitante@email.com'),(40,269.90,'2016-07-31 02:34:08',1,'Pago','visitante@email.com'),(41,249.80,'2016-08-19 21:36:51',2,'Pago','visitante@email.com');
/*!40000 ALTER TABLE `purchase` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role` (
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES ('ROLE_ADMIN');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sale`
--

DROP TABLE IF EXISTS `sale`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sale` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `quantity` int(11) NOT NULL,
  `total` decimal(19,2) NOT NULL,
  `product_id` int(11) DEFAULT NULL,
  `purchase_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_2aiopfpkejtqjqgska2n3audc` (`product_id`),
  KEY `FK_cxnfee47cq2dr38awl2yo7xfd` (`purchase_id`),
  CONSTRAINT `FK_2aiopfpkejtqjqgska2n3audc` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`),
  CONSTRAINT `FK_cxnfee47cq2dr38awl2yo7xfd` FOREIGN KEY (`purchase_id`) REFERENCES `purchase` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sale`
--

LOCK TABLES `sale` WRITE;
/*!40000 ALTER TABLE `sale` DISABLE KEYS */;
INSERT INTO `sale` VALUES (1,1,279.90,7,1),(2,1,119.90,6,1),(3,1,279.90,7,2),(4,1,269.90,5,3),(5,1,269.90,5,4),(6,1,119.90,6,4),(7,1,279.90,7,5),(8,1,129.90,9,6),(9,1,139.90,16,6),(10,2,179.80,12,6),(11,1,119.90,6,7),(12,1,269.90,5,8),(13,2,239.80,6,9),(14,1,269.90,5,10),(15,1,129.90,9,11),(16,1,269.90,5,12),(17,1,119.90,6,13),(18,1,389.90,10,14),(19,1,499.00,8,15),(20,4,479.60,6,16),(21,3,359.70,6,17),(22,3,359.70,6,18),(23,1,119.90,6,19),(24,1,119.90,6,20),(25,1,349.99,15,21),(26,1,279.90,7,22),(27,1,89.90,12,23),(28,1,269.90,5,24),(29,1,269.90,5,25),(30,1,269.90,5,26),(31,1,119.90,6,27),(32,1,119.90,6,28),(33,1,269.90,5,29),(34,1,119.90,6,30),(35,1,279.90,7,31),(36,1,279.90,7,32),(37,1,119.90,6,33),(38,1,269.90,5,34),(39,2,239.80,6,35),(40,3,389.70,9,36),(41,1,129.90,9,37),(42,1,129.90,9,38),(43,1,219.90,14,39),(44,1,269.90,5,40),(45,1,119.90,6,41),(46,1,129.90,9,41);
/*!40000 ALTER TABLE `sale` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `systemuser`
--

DROP TABLE IF EXISTS `systemuser`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `systemuser` (
  `login` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `person_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`login`),
  KEY `FK_jsda5g5313hva5iau0bondkhs` (`person_id`),
  CONSTRAINT `FK_jsda5g5313hva5iau0bondkhs` FOREIGN KEY (`person_id`) REFERENCES `person` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `systemuser`
--

LOCK TABLES `systemuser` WRITE;
/*!40000 ALTER TABLE `systemuser` DISABLE KEYS */;
INSERT INTO `systemuser` VALUES ('erick.bogarin@gmail.com','Erick Bogarin','$2a$08$SuNleEbqBwhxYy1D7iCXYeelVpARga0ZMd8r9hYWDUG1JvoyaDnBq',1),('erick.bogarin@hotmail.com','Erick Bogarin','$2a$10$w.vzZPR22OFDBbXXqleKSuoKyIqofXtx0956JA22QrlxQRVOf0GsW',NULL),('erick.bogarin@yahoo.com','Erick Luan','$2a$10$lvc/XZBU.1ZsGaZrAwKhvONwHB0/CkhzHy6uI1Ptxtncu83oE0Knm',NULL),('teste@email.com','UsuÃ¡rio Teste','$2a$10$1YxRMfU9XeG7wK0X/E9SS.1ZGUMWV3dsoA2jhlez/MD7rk93oVqHC',NULL),('teste@teste.com','Outro Teste','$2a$10$dy7Pl0Z6Pr0SQtQJjBJZJ.7f1LKV0Vk4PED7bgFP71axnZ8KvutPq',NULL),('visitante@email.com','Visitante','$2a$04$HlAWdpbWE7NbgfJzNdY4MuIz8aOGrsrMWv9yPAh4UGzGp8kTm.Hfm',1);
/*!40000 ALTER TABLE `systemuser` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `systemuser_role`
--

DROP TABLE IF EXISTS `systemuser_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `systemuser_role` (
  `SystemUser_login` varchar(255) NOT NULL,
  `roles_name` varchar(255) NOT NULL,
  KEY `FK_myxcf03cqjm4dog5wf62pftll` (`roles_name`),
  KEY `FK_curn0vop0relbva9glsndjlrw` (`SystemUser_login`),
  CONSTRAINT `FK_curn0vop0relbva9glsndjlrw` FOREIGN KEY (`SystemUser_login`) REFERENCES `systemuser` (`login`),
  CONSTRAINT `FK_myxcf03cqjm4dog5wf62pftll` FOREIGN KEY (`roles_name`) REFERENCES `role` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `systemuser_role`
--

LOCK TABLES `systemuser_role` WRITE;
/*!40000 ALTER TABLE `systemuser_role` DISABLE KEYS */;
INSERT INTO `systemuser_role` VALUES ('erick.bogarin@gmail.com','ROLE_ADMIN');
/*!40000 ALTER TABLE `systemuser_role` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-09-19 18:18:02
