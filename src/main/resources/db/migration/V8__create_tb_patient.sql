DROP TABLE IF EXISTS `tb_patient`;
CREATE TABLE `tb_patient` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `age` INT NOT NULL,
  `email` varchar(255) NOT NULL,
  `phone` varchar(255) NOT NULL,
  `cpf` varchar(255) NOT NULL,
  `address_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `test` (`address_id`),
  CONSTRAINT `test` FOREIGN KEY (`address_id`) REFERENCES `tb_address` (`id`)
);
