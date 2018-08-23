CREATE TABLE `demo_db`.`Student` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `age` INT NOT NULL,
  PRIMARY KEY (`id`));
  
INSERT INTO `demo_db`.`Student` (`name`, `age`) VALUES ('Raviraj', '32');
INSERT INTO `demo_db`.`Student` (`name`, `age`) VALUES ('Sachin', '40');
INSERT INTO `demo_db`.`Student` (`name`, `age`) VALUES ('Ramesh', '25');
INSERT INTO `demo_db`.`Student` (`name`, `age`) VALUES ('Suresh', '26');
  