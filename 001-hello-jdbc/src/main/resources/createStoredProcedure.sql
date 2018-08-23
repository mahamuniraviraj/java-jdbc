USE `demo_db`;
DROP procedure IF EXISTS `getStudent`;

DELIMITER $$
USE `demo_db`$$
CREATE PROCEDURE `getStudent` (IN myId INT)
BEGIN

Select * from Student where id = myId;

END$$

DELIMITER ;