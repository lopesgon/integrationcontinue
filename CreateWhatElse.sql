-- Script de création pour MySQL de la base WhatElse
--
-- Peter DAEHNE - 12.04.2016
-- Encodage UTF-8

--
-- Base de données: WhatElse
--
DROP DATABASE IF EXISTS WhatElse;
CREATE DATABASE WhatElse;
USE WhatElse;

--
-- Table TypeCafe
--
CREATE TABLE IF NOT EXISTS TypeCafe (
  Id INT NOT NULL AUTO_INCREMENT,
  Nom VARCHAR(30) NOT NULL,
  PRIMARY KEY (Id)
);

INSERT INTO TypeCafe (Id, Nom) VALUES
(1, 'Intenso'),
(2, 'Espresso'),
(3, 'Pure origin'),
(4, 'Lungo'),
(5, 'Decaffeinato'),
(6, 'Variations');

--
-- Table Capsule
--
CREATE TABLE IF NOT EXISTS Capsule (
  Id INT NOT NULL AUTO_INCREMENT,
  Nom VARCHAR(30) NOT NULL,
  Prix DOUBLE NOT NULL,
  Intensite INT NOT NULL,
  Tasse INT NOT NULL,
  IdTypeCafe INT NOT NULL,
  PRIMARY KEY (Id),
  FOREIGN KEY (IdTypeCafe) REFERENCES TypeCafe (Id)
);

INSERT INTO Capsule (Id, Nom, Prix, Intensite, Tasse, IdTypeCafe) VALUES
(1, 'Kazaar', 0.57, 12, 25, 1),
(2, 'Dharkan', 0.57, 11, 25, 1),
(3, 'Ristretto', 0.5, 10, 25, 1),
(4, 'Arpegio', 0.5, 9, 25, 1),
(5, 'Roma', 0.5, 8, 25, 1),
(6, 'Livanto', 0.5, 6, 40, 2),
(7, 'Capriccio', 0.5, 5, 40, 2),
(8, 'Volluto', 0.5, 4, 40, 2),
(9, 'Cosi', 0.5, 4, 40, 2),
(10, 'Indriya', 0.57, 10, 25, 3),
(11, 'Rosabaya', 0.57, 6, 40, 3),
(12, 'Dulsão', 0.57, 4, 40, 3),
(13, 'Bukeela Ka', 0.57, 3, 110, 3),
(14, 'Fortissio', 0.52, 8, 110, 4),
(15, 'Vivalto', 0.52, 4, 110, 4),
(16, 'Linizio', 0.52, 4, 110, 4),
(17, 'Arpeggio Dec.', 0.52, 9, 25, 5),
(18, 'Volluto Dec.', 0.52, 4, 40, 5),
(19, 'Vivalto Dec.', 0.54, 4, 110, 5),
(20, 'Intenso Dec.', 0.5, 7, 40, 5),
(21, 'Carmelito', 0.57, 6, 40, 6),
(22, 'Ciocattino', 0.57, 6, 40, 6),
(23, 'Vanilio', 0.57, 6, 40, 6);

--
-- Table Employe
--
CREATE TABLE IF NOT EXISTS Employe (
  Id INT NOT NULL AUTO_INCREMENT,
  Nom VARCHAR(50) NOT NULL,
  Prenom VARCHAR(50) NOT NULL,
  PRIMARY KEY (Id)
);

INSERT INTO Employe (Id, Nom, Prenom) VALUES
(1, 'Dupont', 'Sam'),
(2, 'Santschi', 'Naomi'),
(3, 'Mechi', 'Cyril'),
(4, 'Godel', 'Emilie'),
(5, 'Schaffter', 'Cédric'),
(6, 'Simeon', 'Thibault'),
(7, 'Amruthalingam', 'Cécilia'),
(8, 'Vasquez', 'Marie'),
(9, 'Gillard', 'Martin'),
(10, 'Uzan', 'Matteo'),
(11, 'Borgeaud', 'Nathan'),
(12, 'Antenen', 'Sébastien'),
(13, 'Uhde', 'Sarah'),
(14, 'Lueber', 'Nelson'),
(15, 'Fleury', 'Keziah'),
(16, 'Kreis', 'Tanguy'),
(17, 'Weyrich', 'Flavien'),
(18, 'Pinto', 'Camille'),
(19, 'Ding', 'Sylvain'),
(20, 'Kistler', 'Laura');

--
-- Table Commande
--
CREATE TABLE IF NOT EXISTS Commande (
  Id INT NOT NULL AUTO_INCREMENT,
  IdEmploye INT NOT NULL,
  IdCapsule INT NOT NULL,
  Nombre INT NOT NULL,
  Date DATE NOT NULL,
  PRIMARY KEY (Id),
  FOREIGN KEY (IdEmploye) REFERENCES Employe (Id),
  FOREIGN KEY (IdCapsule) REFERENCES Capsule (Id)
);

INSERT INTO Commande (Id, IdEmploye, IdCapsule, Nombre, Date) VALUES
(1, 19, 3, 3, '2016-04-10'),
(2, 19, 9, 9, '2016-04-10'),
(3, 12, 1, 1, '2016-04-10'),
(4, 19, 5, 5, '2016-04-10'),
(5, 19, 8, 8, '2016-04-10'),
(6, 19, 4, 4, '2016-04-10'),
(7, 11, 11, 21, '2016-04-10'),
(8, 19, 2, 2, '2016-04-10'),
(9, 7, 7, 10, '2016-04-10'),
(10, 1, 3, 10, '2016-04-10'),
(11, 1, 5, 20, '2016-04-10'),
(12, 19, 6, 6, '2016-04-10'),
(13, 19, 1, 1, '2016-04-10'),
(14, 11, 8, 13, '2016-04-10'),
(15, 19, 7, 7, '2016-04-10'),
(16, 1, 5, 15, '2016-04-10'),
(17, 7, 14, 10, '2016-04-10'),
(18, 7, 17, 10, '2016-04-10'),
(19, 11, 5, 15, '2016-04-10'),
(20, 11, 3, 10, '2016-04-10'),
(21, 11, 6, 12, '2016-04-10'),
(22, 11, 15, 11, '2016-04-11'),
(23, 1, 3, 12, '2016-04-11'),
(24, 11, 8, 12, '2016-04-11'),
(25, 1, 23, 8, '2016-04-11'),
(26, 11, 7, 17, '2016-04-11'),
(27, 11, 6, 7, '2016-04-11'),
(28, 1, 5, 5, '2016-04-11'),
(29, 11, 4, 33, '2016-04-11'),
(30, 7, 7, 5, '2016-04-11');
