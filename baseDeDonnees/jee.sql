
REM ********************************************************
REM Fichier SQL de création de la base de donnée JEE
REM Auteur : DEDIEU Antoine 
REM ********************************************************
CLEAR SCREEN;
SET LINESIZE 150
SET FEEDBACK OFF

REM ********************************************************************
REM CREATION DE document
REM ********************************************************************
PROMPT ***CREATION DE LA TABLE document***

DROP TABLE document CASCADE CONSTRAINT PURGE;
CREATE TABLE document (
  IdDocument INTEGER NOT NULL,
  NomDocument VARCHAR(30) NOT NULL,
  AuteurDocument VARCHAR(30) NOT NULL,
  IdUtilisateurEmprunteur INTEGER DEFAULT NULL,
  TypeDocument VARCHAR(30) NOT NULL,
  CONSTRAINT PK_document PRIMARY KEY (IdDocument)
);
--DISPONIBLE = 1, INDISPONIBLE = 0


REM ********************************************************************
REM CREATION DE utilisateur
REM ********************************************************************
PROMPT ***CREATION DE LA TABLE UTILISATEUR***
DROP TABLE utilisateur CASCADE CONSTRAINT PURGE;
CREATE TABLE utilisateur(
  IdUtilisateur INTEGER NOT NULL,
  LoginUtilisateur VARCHAR(20) NOT NULL,
  PasswordUtilisateur VARCHAR(20) NOT NULL,
  Bibliothequaire INTEGER NOT NULL,
  CONSTRAINT PK_utilisateur PRIMARY KEY (IdUtilisateur)
);
-- BIBLIOTHEQUAIRE = 1, PAS BIBLIOTHEQUAIRE = 0

REM ********************************************************************
REM AJOUT DES CONTRAINTES SUR LA TABLE document
REM ********************************************************************
PROMPT ***Ajout des contraintes sur document ***

ALTER TABLE document ADD CONSTRAINT FK_RefUtilisateur FOREIGN KEY (IdUtilisateurEmprunteur) REFERENCES utilisateur(IdUtilisateur) ON DELETE CASCADE;


REM ********************************************************************
REM CREATION SEQUENCE POUR Utilisateur POUR TRIGGER AUTO INCREMENT
REM ********************************************************************
PROMPT ***CREATION DE LA SEQUENCE SQ_USER***
DROP SEQUENCE SQ_USER;
CREATE SEQUENCE SQ_USER START WITH 001;

REM ********************************************************************
REM CREATION TRIGGER POUR AUTO_INCREMENT DE IdUtilisateur
REM ********************************************************************
PROMPT ***CREATION DU TRIGGER AUTO_INCREMENT_USER***
DROP TRIGGER AUTO_INCREMENT_USER;
CREATE OR REPLACE TRIGGER AUTO_INCREMENT_USER
BEFORE INSERT ON utilisateur
FOR EACH ROW
BEGIN
  SELECT SQ_USER.NEXTVAL
  INTO   :new.IdUtilisateur
  FROM   dual;
END;
/

REM ********************************************************************
REM CREATION SEQUENCE POUR DOcument POUR TRIGGER AUTO INCREMENT
REM ********************************************************************
PROMPT ***CREATION DE LA SEQUENCE SQ_DOC***
DROP SEQUENCE SQ_DOC;
CREATE SEQUENCE SQ_DOC START WITH 001;

REM ********************************************************************
REM CREATION TRIGGER POUR AUTO_INCREMENT DE IdDocument
REM ********************************************************************
PROMPT ***CREATION DU TRIGGER AUTO_INCREMENT_DOC***
DROP TRIGGER AUTO_INCREMENT_DOC;
CREATE OR REPLACE TRIGGER AUTO_INCREMENT_DOC
BEFORE INSERT ON document
FOR EACH ROW
BEGIN
  SELECT SQ_DOC.NEXTVAL
  INTO   :new.IdDocument
  FROM   dual;
END;
/


REM ********************************************************************
REM JEU DE TEST
REM ********************************************************************
PROMPT ***JEU DE TEST***
PROMPT *** INSERT INTO UTILISATEUR***
INSERT INTO utilisateur(LoginUtilisateur,PasswordUtilisateur,Bibliothequaire) VALUES ('Ursula','Ursula',0);
INSERT INTO utilisateur(LoginUtilisateur,PasswordUtilisateur,Bibliothequaire) VALUES ('Grimhilde','ApplePassword',0);
INSERT INTO utilisateur(LoginUtilisateur,PasswordUtilisateur,Bibliothequaire) VALUES ('Maleficent','GreenFirePassword',1);
INSERT INTO utilisateur(LoginUtilisateur,PasswordUtilisateur,Bibliothequaire) VALUES ('Cruella','FurPassword',0);
INSERT INTO utilisateur(LoginUtilisateur,PasswordUtilisateur,Bibliothequaire) VALUES ('Beast','RosePassword',0);
INSERT INTO utilisateur(LoginUtilisateur,PasswordUtilisateur,Bibliothequaire) VALUES ('Gothel','FlowerPassword',0);
INSERT INTO utilisateur(LoginUtilisateur,PasswordUtilisateur,Bibliothequaire) VALUES ('Lucinda','SisterPassword',0);
SELECT * FROM utilisateur;

PROMPT *** INSERT INTO DOCUMENT***
INSERT INTO document(NomDocument,AuteurDocument,TypeDocument) VALUES ('Fairest of ALL','Serena Valentino', 'Livre');
INSERT INTO document(NomDocument,AuteurDocument,TypeDocument) VALUES ('The Beast Within','Serena Valentino', 'Livre');
INSERT INTO document(NomDocument,AuteurDocument,TypeDocument) VALUES ('Poor Unfortunate Soul','Serena Valentino', 'Livre');
INSERT INTO document(NomDocument,AuteurDocument,TypeDocument) VALUES ('Mistress of All Evil','Serena Valentino', 'Livre');
INSERT INTO document(NomDocument,AuteurDocument,TypeDocument) VALUES ('Mother Knows Best','Serena Valentino', 'Livre');
INSERT INTO document(NomDocument,AuteurDocument,TypeDocument) VALUES ('The Odd Sisters','Serena Valentino', 'Livre');
INSERT INTO document(NomDocument,AuteurDocument,TypeDocument) VALUES ('Evil Thing','Serena Valentino', 'Livre');
INSERT INTO document(NomDocument,AuteurDocument,TypeDocument) VALUES ('Avatar','James Cameron', 'DVD');
INSERT INTO document(NomDocument,AuteurDocument,TypeDocument) VALUES ('Random Access Memories','Daft Punk', 'CD');
SELECT * FROM document;

PROMPT *** AJOUT D UN EMPRUNT***
UPDATE document SET IdUtilisateurEmprunteur = 3 WHERE IdDocument = 4;


COMMIT;
/