/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  IanCarlosAfonsodaSil
 * Created: 31 de ago de 2021
 */

-- Server version	5.7.32-log

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
-- Table structure for table `cliente`
--

/*
 ****************************************************************************
    IMPORTANTE:
        - Triggers não estão nesse arquivo SQL
        - Acesse com.TPBD.DataBase.ConnectionDatabase.java para configurar a conexão
            com seu DB!


 ****************************************************************************
*/


DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cliente` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) NOT NULL,
  `cpf` varchar(15) NOT NULL,
  `email` varchar(30) NOT NULL,
  `telefone` varchar(16) NOT NULL,
  `cidade` varchar(50) NOT NULL,
  `endereco` varchar(50) NOT NULL,
  `cep` varchar(20) NOT NULL,
  `id_empresa` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `cliente_empresa_fk` (`id_empresa`),
  CONSTRAINT `cliente_empresa_fk` FOREIGN KEY (`id_empresa`) REFERENCES `empresa` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT  IGNORE INTO `cliente` (`id`, `nome`, `cpf`, `email`, `telefone`, `cidade`, `endereco`, `cep`, `id_empresa`) VALUES (1,'gabriel','11111111111','gabriel@gmail.com','3199999-9999','Cidade1','EndereÃ§o1','666666666',1),(2,'gabriel barbosa','22222222222','gabrielb@gmail.com','3198888-8888','Cidade2','EndereÃ§o2','555555555',1),(3,'Lara','33333333333','lara@gmail.com','3197777-7777','Cidade3','EndereÃ§o3','444444444',2),(4,'Ian','44444444444','ian@gmail.com','3196666-6666','Cidade4','EndereÃ§o4','333333333',3),(5,'Joao','55555555555','joao@gmail.com','3196666-1111','Cidade5','EndereÃ§o5','222222222',NULL);
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empresa`
--

DROP TABLE IF EXISTS `empresa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `empresa` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cnpj` varchar(14) NOT NULL,
  `razao_social` varchar(20) NOT NULL,
  `telefone` varchar(16) NOT NULL,
  `desconto` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empresa`
--

LOCK TABLES `empresa` WRITE;
/*!40000 ALTER TABLE `empresa` DISABLE KEYS */;
INSERT  IGNORE INTO `empresa` (`id`, `cnpj`, `razao_social`, `telefone`, `desconto`) VALUES (1,'00111111111','Empresa1','3195555-9559',10),(2,'00222222222','Empresa2','3193335-6666',15),(3,'00333333333','Empresa3','3193335-5555',8),(4,'00444444444','Empresa4','3193335-2222',5),(5,'00555555555','Empresa5','3194564-4564',1);
/*!40000 ALTER TABLE `empresa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estacionamento`
--

DROP TABLE IF EXISTS `estacionamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `estacionamento` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `valor_hora` double NOT NULL,
  `vagas_disponiveis` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estacionamento`
--

LOCK TABLES `estacionamento` WRITE;
/*!40000 ALTER TABLE `estacionamento` DISABLE KEYS */;
INSERT  IGNORE INTO `estacionamento` (`id`, `valor_hora`, `vagas_disponiveis`) VALUES (1,10,7);
/*!40000 ALTER TABLE `estacionamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fluxo_de_veiculos`
--

DROP TABLE IF EXISTS `fluxo_de_veiculos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fluxo_de_veiculos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_veiculo` int(11) NOT NULL,
  `id_vaga` int(11) NOT NULL,
  `id_estacionamento` int(11) NOT NULL,
  `entrada` datetime DEFAULT NULL,
  `saida` datetime DEFAULT NULL,
  `gerar_recibo` char(1) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `estacionamento_cliente_fk` (`id_vaga`),
  KEY `estacionamento_veiculo_fk` (`id_veiculo`),
  KEY `fluxo_estacionamento_fk` (`id_estacionamento`),
  CONSTRAINT `estacionamento_cliente_fk` FOREIGN KEY (`id_vaga`) REFERENCES `vagas` (`id`),
  CONSTRAINT `estacionamento_veiculo_fk` FOREIGN KEY (`id_veiculo`) REFERENCES `veiculo` (`id`),
  CONSTRAINT `fluxo_estacionamento_fk` FOREIGN KEY (`id_estacionamento`) REFERENCES `estacionamento` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fluxo_de_veiculos`
--

LOCK TABLES `fluxo_de_veiculos` WRITE;
/*!40000 ALTER TABLE `fluxo_de_veiculos` DISABLE KEYS */;
INSERT  IGNORE INTO `fluxo_de_veiculos` (`id`, `id_veiculo`, `id_vaga`, `id_estacionamento`, `entrada`, `saida`, `gerar_recibo`) VALUES (1,1,1,1,'2021-08-31 15:09:19','2021-08-31 18:05:42',1),(2,2,2,1,'2021-08-31 18:00:05',NULL,0),(3,3,3,1,'2021-08-31 18:00:05',NULL,0),(4,4,4,1,'2021-08-31 18:00:05','2021-08-31 18:06:03',1),(5,5,5,1,'2021-08-31 18:00:05',NULL,0);
/*!40000 ALTER TABLE `fluxo_de_veiculos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recibo`
--

DROP TABLE IF EXISTS `recibo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `recibo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_veiculo` int(11) NOT NULL,
  `entrada` datetime NOT NULL,
  `saida` datetime NOT NULL,
  `valor` double NOT NULL,
  `nome_cliente` varchar(50) NOT NULL,
  `pago` tinyint(4) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_veiculo_idx` (`id_veiculo`),
  CONSTRAINT `fk_veiculo` FOREIGN KEY (`id_veiculo`) REFERENCES `veiculo` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recibo`
--

LOCK TABLES `recibo` WRITE;
/*!40000 ALTER TABLE `recibo` DISABLE KEYS */;
INSERT  IGNORE INTO `recibo` (`id`, `id_veiculo`, `entrada`, `saida`, `valor`, `nome_cliente`, `pago`) VALUES (1,1,'2021-08-31 15:09:19','2021-08-31 18:05:42',27,'gabriel',0),(2,4,'2021-08-31 18:00:05','2021-08-31 18:06:03',8.5,'Lara',0);
/*!40000 ALTER TABLE `recibo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vagas`
--

DROP TABLE IF EXISTS `vagas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vagas` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_estacionamento` int(11) NOT NULL,
  `identificacao` varchar(10) DEFAULT NULL,
  `ocupado` char(1) NOT NULL,
  `tipo` varchar(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `vagas_estacionamento_fk_idx` (`id_estacionamento`),
  CONSTRAINT `vagas_estacionamento_fk` FOREIGN KEY (`id_estacionamento`) REFERENCES `estacionamento` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vagas`
--

LOCK TABLES `vagas` WRITE;
/*!40000 ALTER TABLE `vagas` DISABLE KEYS */;
INSERT  IGNORE INTO `vagas` (`id`, `id_estacionamento`, `identificacao`, `ocupado`, `tipo`) VALUES (1,1,'a1','0','carro'),(2,1,'a2','1','carro'),(3,1,'a3','1','carro'),(4,1,'a4','0','carro'),(5,1,'a5','1','carro');
/*!40000 ALTER TABLE `vagas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `veiculo`
--

DROP TABLE IF EXISTS `veiculo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `veiculo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_cliente` int(11) NOT NULL,
  `placa` varchar(7) NOT NULL,
  `marca` varchar(20) NOT NULL,
  `modelo` varchar(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `veiculo_cliente_fk` (`id_cliente`),
  CONSTRAINT `veiculo_cliente_fk` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `veiculo`
--

LOCK TABLES `veiculo` WRITE;
/*!40000 ALTER TABLE `veiculo` DISABLE KEYS */;
INSERT  IGNORE INTO `veiculo` (`id`, `id_cliente`, `placa`, `marca`, `modelo`) VALUES (1,1,'123','123','123'),(2,1,'456','465','456'),(3,2,'963','963','963'),(4,3,'485','485','485'),(5,4,'452','452','452');
/*!40000 ALTER TABLE `veiculo` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-08-31 18:52:12
