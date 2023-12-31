/* ---------------------------------------------------- */
/*  Generated by Enterprise Architect Version 13.5 		*/
/*  Created On : 01-sep.-2023 6:43:47 				*/
/*  DBMS       : PostgreSQL 						*/
/* ---------------------------------------------------- */

/* Drop Sequences for Autonumber Columns */

DROP SEQUENCE IF EXISTS person_id_seq
;

DROP SEQUENCE IF EXISTS client_id_seq
;

/* Drop Tables */

DROP TABLE IF EXISTS PERSON CASCADE
;

DROP TABLE IF EXISTS CLIENT CASCADE
;

/* Create Tables */
CREATE TABLE PERSON
(
	ID SERIAL,
    FULL_NAME varchar(50) NULL,
    GENDER varchar(1) NULL,
    AGE INTEGER NULL,
    ID_NUMBER varchar(20) NULL,
    ADDRESS varchar(50) NULL,
    PHONE varchar(50) NULL,
    AUD_CREATED_AT timestamp without time zone NOT NULL,
    AUD_UPDATED_AT timestamp without time zone NULL
)
;

CREATE TABLE CLIENT
(
    ID SERIAL,
	PASSWORD varchar(20) NULL,
	STATUS bool NOT NULL,
	PERSON_ID bigint NOT NULL,
    AUD_CREATED_AT timestamp without time zone NOT NULL,
    AUD_UPDATED_AT timestamp without time zone NULL
)
;

/* Create Primary Keys, Indexes, Uniques, Checks */

ALTER TABLE PERSON ADD CONSTRAINT PK_PERSON
	PRIMARY KEY (ID)
;

ALTER TABLE CLIENT ADD CONSTRAINT PK_CLIENT
	PRIMARY KEY (ID)
;

CREATE INDEX IXFK_PERSON ON CLIENT (PERSON_ID ASC)
;


/* Create Foreign Key Constraints */

ALTER TABLE CLIENT ADD CONSTRAINT FK_CLIENT_ID
	FOREIGN KEY (PERSON_ID) REFERENCES PERSON (ID)
;


COMMENT ON TABLE CLIENT
	IS 'Client Table id and password must not be null'
;

COMMENT ON TABLE PERSON
	IS 'person Table'
;
