DROP DATABASE IF EXISTS ecare;
CREATE DATABASE ecare;
USE ecare;

CREATE TABLE user
(
    user_id      INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    name         VARCHAR(42)         NOT NULL,
    surname      VARCHAR(42)         NOT NULL,
    birthdate    DATE,
    passport     VARCHAR(42)         NOT NULL,
    address      VARCHAR(255),
    email        VARCHAR(100)        NOT NULL,
    password     VARCHAR(100)        NOT NULL,
    balance      DECIMAL(10, 2)      NOT NULL,
    access_level VARCHAR(42)         NOT NULL
);
CREATE UNIQUE INDEX user_email_index
    ON user (email);
CREATE UNIQUE INDEX user_passport_index
    ON user (passport);

INSERT INTO user (name, surname, birthdate, passport, address, email, password, balance, access_level)
VALUES ('Ilon', 'Musk', '1971-08-26', '1002 211345',
        'Corporate Secretary, Tesla, Inc. 3500 Deer Creek Road, Palo Alto, CA 94304 United States', 'NAsales@tesla.com',
        'tesla', 1000, 'manager'),
       ('Leonard', 'Nimoy', '1931-03-26', '1987 001994', NULL, 'lnimoy@gmail.com', 'LiveLongAndProsper', 2000,
        'userA'),
       ('William', 'Gates', '1955-10-28', '2009 002016', '500 Fifth Avenue North, Seattle, WA 98109',
        'bill.gates@microsoft.com', 'p@ssw0rd', 1000000, 'userB');


CREATE TABLE tariff
(
    tariff_id   INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    name        VARCHAR(45)         NOT NULL,
    price       DECIMAL(10, 2)      NOT NULL,
    description VARCHAR(255)
);
CREATE UNIQUE INDEX tariff_name_index
    ON tariff (name);

INSERT INTO tariff(name, price, description)
VALUES ('Basic',300,'Basic tariff with 3gb internet and 300 minutes'),
       ('Pro',600,'Tariff for active users'),
       ('Unlimited Power',1000,'Unlimited internet and calls'),
       ('InternetOnly',200,'Basic internet only tariff'),
       ('CallsOnly',200,'Basic calls only tariff'),
       ('InternetOnlyPro',750,'Unlimited internet'),
       ('CallsOnlyPro',750,'Unlimited calls');

CREATE TABLE contract
(
    contract_id  INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    phone_number VARCHAR(20)         NOT NULL,
    tariff_id    INT(11)             NOT NULL,
    user_id      INT(11)             NOT NULL,
    status       VARCHAR(42)         NOT NULL,
    CONSTRAINT contract_tariff_fk
        FOREIGN KEY (tariff_id) REFERENCES tariff (tariff_id)
            ON DELETE NO ACTION ON UPDATE NO ACTION,
    CONSTRAINT contract_user_fk
        FOREIGN KEY (user_id) REFERENCES user (user_id)
            ON DELETE NO ACTION ON UPDATE NO ACTION
);
CREATE INDEX contract_tariff_fk_index
    ON contract (tariff_id);
CREATE INDEX contract_user_fk_index
    ON contract (user_id);
CREATE UNIQUE INDEX number_unique
    ON contract (phone_number);

INSERT INTO contract(phone_number, tariff_id, user_id, status)
VALUES ('6761230323',3,1,'unblocked'),
       ('6760001001',1,2,'unblocked'),
       ('676111111',1,1,'blocked'),
       ('6764952211',6,3,'blockedAdmin');

CREATE TABLE options
(
    option_id        INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    name             VARCHAR(42)         NOT NULL,
    description      VARCHAR(255),
    price            DECIMAL(10, 2),
    connection_price DECIMAL(10, 2)

);

INSERT INTO options(name, description, price, connection_price)
VALUES ('gb1','1gb internet',100,10),
       ('gb5','5gb internet',500,300),
       ('100min','100 minutes calls',100,10),
       ('500min','500 minutes calls',500,300);

CREATE TABLE exclusive_options
(
    option_id_1 INT(11) NOT NULL,
    option_id_2 INT(11) NOT NULL,
    CONSTRAINT exclusive_options_fk_1
        FOREIGN KEY (option_id_1) REFERENCES options (option_id)
            ON DELETE NO ACTION ON UPDATE NO ACTION,
    CONSTRAINT exclusive_options_fk_2
        FOREIGN KEY (option_id_2) REFERENCES options (option_id)
            ON DELETE NO ACTION ON UPDATE NO ACTION
);
CREATE INDEX exclusive_options_fk_1_index
    ON exclusive_options (option_id_1);
CREATE INDEX exclusive_options_fk_2_index
    ON exclusive_options (option_id_2);

INSERT INTO exclusive_options
VALUES (1,2),
       (3,4);

CREATE TABLE required_options
(
    option_id_1 INT(11) NOT NULL,
    option_id_2 INT(11) NOT NULL,
    CONSTRAINT required_options_fk_1
        FOREIGN KEY (option_id_1) REFERENCES options (option_id)
            ON DELETE NO ACTION ON UPDATE NO ACTION,
    CONSTRAINT required_options_fk_2
        FOREIGN KEY (option_id_2) REFERENCES options (option_id)
            ON DELETE NO ACTION ON UPDATE NO ACTION
);
CREATE INDEX required_options_fk_1_index
    ON required_options (option_id_1);
CREATE INDEX required_options_fk_2_index
    ON required_options (option_id_2);

CREATE TABLE tariff_related_options
(
    tariff_id INT(11) NOT NULL,
    option_id INT(11) NOT NULL,
    CONSTRAINT tariff_related_options_fk
        FOREIGN KEY (option_id) REFERENCES options (option_id)
            ON DELETE NO ACTION ON UPDATE NO ACTION,
    CONSTRAINT tariff_related_tariff_fk
        FOREIGN KEY (tariff_id) REFERENCES tariff (tariff_id)
            ON DELETE NO ACTION ON UPDATE NO ACTION
);
CREATE INDEX tariff_related_options_fk_index
    ON tariff_related_options (option_id);
CREATE INDEX tariff_related_tariff_fk_index
    ON tariff_related_options (tariff_id);

CREATE TABLE contract_used_options
(
    contract_id INT(11) NOT NULL,
    option_id   INT(11) NOT NULL,
    CONSTRAINT contract_used_options_option_fk
        FOREIGN KEY (option_id) REFERENCES options (option_id)
            ON DELETE NO ACTION ON UPDATE NO ACTION,
    CONSTRAINT contract_used_options_contract_fk
        FOREIGN KEY (contract_id) REFERENCES contract (contract_id)
            ON DELETE NO ACTION ON UPDATE NO ACTION
);
CREATE INDEX contract_used_options_option_fk_index
    ON contract_used_options (option_id);
CREATE INDEX contract_used_options_contract_fk_index
    ON contract_used_options (contract_id);

INSERT INTO contract_used_options
VALUES (2,1),
       (2,3),
       (3,2),
       (3,4);