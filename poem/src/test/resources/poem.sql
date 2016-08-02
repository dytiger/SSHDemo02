DROP TABLE IF EXISTS `poem`;
CREATE TABLE `poem` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) DEFAULT NULL,
  `author` varchar(50) DEFAULT NULL,
  `poem_text` varchar(5000) DEFAULT NULL,
  `dynasty` varchar(50) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
