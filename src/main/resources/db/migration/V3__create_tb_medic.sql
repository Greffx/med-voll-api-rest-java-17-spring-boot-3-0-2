DROP TABLE IF EXISTS `tb_medic`;
CREATE TABLE `tb_medic` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `active` tinyint(1) NOT NULL,
  `age` int DEFAULT NULL,
  `crm` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `speciality` smallint DEFAULT NULL,
  `address_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK4p0y4hrqkq61p9xbsxd8ft4ap` (`address_id`),
  CONSTRAINT `FK4p0y4hrqkq61p9xbsxd8ft4ap` FOREIGN KEY (`address_id`) REFERENCES `tb_address` (`id`)
);