CREATE TABLE `sensor_type` (
  `sensor_type_id` int unsigned NOT NULL,
  `type` varchar(11) COLLATE utf8mb4_unicode_ci NOT NULL,
  `unit` varchar(7) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`sensor_type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

CREATE TABLE `sensor` (
  `sensor_id` int unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL,
  `model` varchar(15) COLLATE utf8mb4_unicode_ci NOT NULL,
  `range_from` int NOT NULL,
  `range_to` int NOT NULL,
  `sensor_type_id` int unsigned NOT NULL,
  `location` varchar(40) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `description` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`sensor_id`),
  KEY `sensor_ibfk_1_idx` (`sensor_type_id`),
  CONSTRAINT `sensor_ibfk_1` FOREIGN KEY (`sensor_type_id`) REFERENCES `sensor_type` (`sensor_type_id`),
  CONSTRAINT `chk_name` CHECK ((length(`name`) >= 3)),
  CONSTRAINT `chk_range` CHECK ((`range_from` < `range_to`))
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;