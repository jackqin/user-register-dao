ALTER TABLE `colorcc`.`user` CHANGE COLUMN `status` `status` ENUM('ONLINE', 'OFFLINE', 'HIDDEN') NOT NULL  ;


INSERT INTO USER VALUES(1, 'jack@colorcc.com', 'passwd', 'salt', now(), 'online');
