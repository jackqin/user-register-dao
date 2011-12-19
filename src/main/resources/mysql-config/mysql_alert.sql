ALTER TABLE `colorcc`.`user` CHANGE COLUMN `status` `status` ENUM('ONLINE', 'OFFLINE', 'HIDDEN') NOT NULL  ;


INSERT INTO USER VALUES(1, 'jack@colorcc.com', 'passwd', 'salt', now(), 'online');
INSERT INTO USER VALUES(2, 'jack2@colorcc.com', 'passwd', 'salt', now(), 'online');
