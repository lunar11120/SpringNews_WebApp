CREATE TABLE `hibernatedb`.`employee` (
  `username` VARCHAR(45) CHARACTER SET 'utf8' NOT NULL,
  `password` VARCHAR(45) CHARACTER SET 'utf8' NOT NULL,
  `id` INT NOT NULL,
  `firstname` VARCHAR(60) CHARACTER SET 'utf8' NULL,
  `lastname` VARCHAR(60) NULL,
  `nickname` VARCHAR(45) CHARACTER SET 'utf8' NULL,
  `telephone` VARCHAR(25) CHARACTER SET 'utf8' NULL,
  `lineid` VARCHAR(60) CHARACTER SET 'utf8' NULL,
  `email` VARCHAR(60) CHARACTER SET 'utf8' NULL,
  `departmentid` INT NULL DEFAULT 2,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


--department table--

CREATE TABLE `hibernatedb`.`department` (
  `departmentid` INT NOT NULL,
  `deptname` VARCHAR(55) CHARACTER SET 'utf8' NULL,
  `deptname_thai` VARCHAR(55) CHARACTER SET 'utf8' NULL,
  PRIMARY KEY (`departmentid`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;