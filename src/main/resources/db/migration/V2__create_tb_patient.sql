DROP TABLE IF EXISTS `tb_patient`;
CREATE TABLE `tb_patient` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `active` bit(1) DEFAULT NULL,
  `age` int DEFAULT NULL,
  `cpf` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `address_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKl39cerrtnpg31im364cj3rytq` (`address_id`),
  CONSTRAINT `FKl39cerrtnpg31im364cj3rytq` FOREIGN KEY (`address_id`) REFERENCES `tb_address` (`id`)
);