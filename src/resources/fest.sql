-- MySQL Script generated by MySQL Workbench
-- Wed Oct 24 23:08:52 2018
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema db_example
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema db_example
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `db_example` DEFAULT CHARACTER SET utf8 ;
-- -----------------------------------------------------
-- Schema festival
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema festival
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `festival` DEFAULT CHARACTER SET utf8 ;
USE `db_example` ;

-- -----------------------------------------------------
-- Table `db_example`.`article`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_example`.`article` (
  `id` BIGINT(20) NOT NULL,
  `filename` VARCHAR(255) NULL DEFAULT NULL,
  `tag` VARCHAR(255) NULL DEFAULT NULL,
  `text` VARCHAR(255) NULL DEFAULT NULL,
  `user_id` BIGINT(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `FKrbg34i54mbw2twqxxof4hcmbl` (`user_id` ASC) VISIBLE)
ENGINE = MyISAM
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `db_example`.`hibernate_sequence`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_example`.`hibernate_sequence` (
  `next_val` BIGINT(20) NULL DEFAULT NULL)
ENGINE = MyISAM
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `db_example`.`message`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_example`.`message` (
  `id` BIGINT(20) NOT NULL,
  `category` VARCHAR(255) NULL DEFAULT NULL,
  `filename` VARCHAR(255) NULL DEFAULT NULL,
  `tag` VARCHAR(255) NULL DEFAULT NULL,
  `text` VARCHAR(255) NULL DEFAULT NULL,
  `title` VARCHAR(255) NULL DEFAULT NULL,
  `user_id` BIGINT(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `FK70bv6o4exfe3fbrho7nuotopf` (`user_id` ASC) VISIBLE)
ENGINE = MyISAM
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `db_example`.`user_role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_example`.`user_role` (
  `user_id` BIGINT(20) NOT NULL,
  `roles` VARCHAR(255) NULL DEFAULT NULL,
  INDEX `FKfpm8swft53ulq2hl11yplpr5` (`user_id` ASC) VISIBLE)
ENGINE = MyISAM
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `db_example`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_example`.`user` (
  `id` BIGINT(20) NOT NULL,
  `activation_code` VARCHAR(255) NULL DEFAULT NULL,
  `active` BIT(1) NOT NULL,
  `email` VARCHAR(255) NULL DEFAULT NULL,
  `password` VARCHAR(255) NULL DEFAULT NULL,
  `username` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = MyISAM
DEFAULT CHARACTER SET = utf8;

USE `festival` ;

-- -----------------------------------------------------
-- Table `festival`.`fest`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `festival`.`fest` (
  `id` BIGINT(20) NOT NULL,
  `name` VARCHAR(255) NOT NULL,
  `description` VARCHAR(255) NOT NULL,
  `countPlace` INT(11) NULL DEFAULT NULL,
  `price` FLOAT NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `festival`.`fest_type`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `festival`.`fest_type` (
  `type` VARCHAR(255) NULL DEFAULT NULL,
  `fest_id` BIGINT(20) NOT NULL,
  INDEX `fest_id` (`fest_id` ASC) VISIBLE,
  CONSTRAINT `fest_type_ibfk_1`
    FOREIGN KEY (`fest_id`)
    REFERENCES `festival`.`fest` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `festival`.`performer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `festival`.`performer` (
  `id` BIGINT(20) NOT NULL,
  `firstName` VARCHAR(255) NOT NULL,
  `lastName` VARCHAR(255) NOT NULL,
  `username` VARCHAR(255) NOT NULL,
  `password` VARCHAR(255) NOT NULL,
  `email` VARCHAR(255) NULL DEFAULT NULL,
  `activationCode` VARCHAR(255) NULL DEFAULT NULL,
  `phoneNumber` VARCHAR(255) NULL DEFAULT NULL,
  `age` INT(11) NULL DEFAULT NULL,
  `duration` VARCHAR(255) NULL DEFAULT NULL,
  `genre` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `festival`.`listofperformer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `festival`.`listofperformer` (
  `id` BIGINT(20) NOT NULL,
  `list` VARCHAR(255) NULL DEFAULT NULL,
  `p_id` BIGINT(20) NOT NULL,
  `fest_id` BIGINT(20) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `p_id` (`p_id` ASC) VISIBLE,
  INDEX `fest_id` (`fest_id` ASC) VISIBLE,
  CONSTRAINT `listofperformer_ibfk_1`
    FOREIGN KEY (`p_id`)
    REFERENCES `festival`.`performer` (`id`),
  CONSTRAINT `listofperformer_ibfk_2`
    FOREIGN KEY (`fest_id`)
    REFERENCES `festival`.`fest` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `festival`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `festival`.`user` (
  `id` BIGINT(20) NOT NULL,
  `firstName` VARCHAR(255) NOT NULL,
  `lastName` VARCHAR(255) NOT NULL,
  `username` VARCHAR(255) NOT NULL,
  `password` VARCHAR(255) NOT NULL,
  `email` VARCHAR(255) NULL DEFAULT NULL,
  `activationCode` VARCHAR(255) NULL DEFAULT NULL,
  `phoneNumber` VARCHAR(255) NULL DEFAULT NULL,
  `age` INT(11) NULL DEFAULT NULL,
  `cardNumber` INT(16) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `festival`.`listofusers`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `festival`.`listofusers` (
  `id` BIGINT(20) NOT NULL,
  `list` VARCHAR(255) NULL DEFAULT NULL,
  `user_id` BIGINT(20) NOT NULL,
  `fest_id` BIGINT(20) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `user_id` (`user_id` ASC) VISIBLE,
  INDEX `fest_id` (`fest_id` ASC) VISIBLE,
  CONSTRAINT `listofusers_ibfk_1`
    FOREIGN KEY (`user_id`)
    REFERENCES `festival`.`user` (`id`),
  CONSTRAINT `listofusers_ibfk_2`
    FOREIGN KEY (`fest_id`)
    REFERENCES `festival`.`fest` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `festival`.`user_role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `festival`.`user_role` (
  `role` VARCHAR(255) NULL DEFAULT NULL,
  `user_id` BIGINT(20) NOT NULL,
  INDEX `user_id` (`user_id` ASC) VISIBLE,
  CONSTRAINT `user_role_ibfk_1`
    FOREIGN KEY (`user_id`)
    REFERENCES `festival`.`user` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
