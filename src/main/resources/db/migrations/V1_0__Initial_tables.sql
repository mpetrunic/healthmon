-- -----------------------------------------------------
-- Table `location`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `location` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `city_name` VARCHAR(45) NULL,
  `lat` DOUBLE NULL,
  `long` DOUBLE NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `ID_UNIQUE` (`id` ASC),
  UNIQUE INDEX `CITY_NAME_UNIQUE` (`city_name` ASC))
  ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `surname` VARCHAR(45) NOT NULL,
  `password` VARCHAR(60) NOT NULL,
  `insert_date` DATETIME NOT NULL,
  `email` VARCHAR(60) NOT NULL,
  `location_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `ID_UNIQUE` (`id` ASC),
  UNIQUE INDEX `USERNAME_UNIQUE` (`username` ASC),
  UNIQUE INDEX `EMAIL_UNIQUE` (`email` ASC),
  INDEX `fk_user_LOCATION1_idx` (`location_id` ASC),
  CONSTRAINT `fk_user_LOCATION1`
  FOREIGN KEY (`location_id`)
  REFERENCES `location` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
  ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `environment_statistic`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `environment_statistic` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `temperature` FLOAT NULL,
  `humidity` FLOAT NULL,
  `air_pressure` INT NULL,
  `insert_date` DATETIME NULL,
  `location_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `ID_UNIQUE` (`id` ASC),
  INDEX `fk_ENVIROMENT_STATISTIC_LOCATION1_idx` (`location_id` ASC),
  CONSTRAINT `fk_ENVIROMENT_STATISTIC_LOCATION1`
  FOREIGN KEY (`location_id`)
  REFERENCES `location` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
  ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `meal_type`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `meal_type` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `ID_UNIQUE` (`id` ASC),
  UNIQUE INDEX `NAME_UNIQUE` (`name` ASC))
  ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `meal`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `meal` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `calories` INT NOT NULL,
  `fat` FLOAT NOT NULL,
  `proteins` FLOAT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC))
  ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `user_meal`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `user_meal` (
  `user_meal_id` INT NOT NULL AUTO_INCREMENT,
  `user_id` INT NOT NULL,
  `meal_type_id` INT NOT NULL,
  `insert_date` DATE NOT NULL,
  `meal_id` INT NOT NULL,
  PRIMARY KEY (`user_meal_id`),
  UNIQUE INDEX `ID_UNIQUE` (`user_meal_id` ASC),
  INDEX `fk_USER_MEAL_USER1_idx` (`user_id` ASC),
  INDEX `fk_USER_MEAL_MEAL_TYPE1_idx` (`meal_type_id` ASC),
  INDEX `fk_USER_MEAL_meal1_idx` (`meal_id` ASC),
  CONSTRAINT `fk_USER_MEAL_USER1`
  FOREIGN KEY (`user_id`)
  REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_USER_MEAL_MEAL_TYPE1`
  FOREIGN KEY (`meal_type_id`)
  REFERENCES `meal_type` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_USER_MEAL_meal1`
  FOREIGN KEY (`meal_id`)
  REFERENCES `meal` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
  ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `activity`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `activity` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `average_calories_per_min` FLOAT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC))
  ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `user_activity`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `user_activity` (
  `user_activity_id` INT NOT NULL AUTO_INCREMENT,
  `calories_burned` INT NOT NULL,
  `activity_lenght` DOUBLE NOT NULL,
  `insert_date` DATETIME NOT NULL,
  `user_id` INT NOT NULL,
  `activity_id` INT NOT NULL,
  PRIMARY KEY (`user_activity_id`),
  UNIQUE INDEX `ID_UNIQUE` (`user_activity_id` ASC),
  INDEX `fk_USER_ACTIVITY_USER1_idx` (`user_id` ASC),
  INDEX `fk_user_activity_activity1_idx` (`activity_id` ASC),
  CONSTRAINT `fk_USER_ACTIVITY_USER1`
  FOREIGN KEY (`user_id`)
  REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_activity_activity1`
  FOREIGN KEY (`activity_id`)
  REFERENCES `activity` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
  ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `user_weight`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `user_weight` (
  `user_weight_id` INT NOT NULL AUTO_INCREMENT,
  `weight` INT NOT NULL,
  `insert_date` DATETIME NOT NULL,
  `user_id` INT NOT NULL,
  PRIMARY KEY (`user_weight_id`),
  UNIQUE INDEX `USER_WEIGHT_ID_UNIQUE` (`user_weight_id` ASC),
  INDEX `fk_user_weight_USER1_idx` (`user_id` ASC),
  CONSTRAINT `fk_user_weight_USER1`
  FOREIGN KEY (`user_id`)
  REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
  ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `user_temperature`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `user_temperature` (
  `user_temperature_id` INT NOT NULL AUTO_INCREMENT,
  `temperature` FLOAT NOT NULL,
  `insert_date` DATETIME NOT NULL,
  `user_id` INT NOT NULL,
  PRIMARY KEY (`user_temperature_id`),
  UNIQUE INDEX `user_temperature_id_UNIQUE` (`user_temperature_id` ASC),
  INDEX `fk_user_temperature_user1_idx` (`user_id` ASC),
  CONSTRAINT `fk_user_temperature_user1`
  FOREIGN KEY (`user_id`)
  REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
  ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `user_heart_rate`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `user_heart_rate` (
  `user_heart_rate_id` INT NOT NULL AUTO_INCREMENT,
  `heart_rate` INT NOT NULL,
  `insert_date` DATETIME NOT NULL,
  `user_id` INT NOT NULL,
  PRIMARY KEY (`user_heart_rate_id`),
  UNIQUE INDEX `user_heart_rate_id_UNIQUE` (`user_heart_rate_id` ASC),
  INDEX `fk_user_heart_rate_user1_idx` (`user_id` ASC),
  CONSTRAINT `fk_user_heart_rate_user1`
  FOREIGN KEY (`user_id`)
  REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
  ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `user_blood_pressure`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `user_blood_pressure` (
  `user_blood_pressure_id` INT NOT NULL AUTO_INCREMENT,
  `diastolic` INT NOT NULL,
  `systolic` INT NOT NULL,
  `insert_date` DATETIME NOT NULL,
  `user_id` INT NOT NULL,
  PRIMARY KEY (`user_blood_pressure_id`),
  UNIQUE INDEX `user_heart_pressure_id_UNIQUE` (`user_blood_pressure_id` ASC),
  INDEX `fk_user_blood_pressure_user1_idx` (`user_id` ASC),
  CONSTRAINT `fk_user_blood_pressure_user1`
  FOREIGN KEY (`user_id`)
  REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
  ENGINE = InnoDB;