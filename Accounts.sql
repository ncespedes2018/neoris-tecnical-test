/* ---------------------------------------------------- */
/*  Generated by Enterprise Architect Version 13.5 		*/
/*  Created On : 01-sep.-2023 6:43:47 				*/
/*  DBMS       : PostgreSQL 						*/
/* ---------------------------------------------------- */

/* Drop Tables */

DROP TABLE IF EXISTS ACCOUNT CASCADE
;

DROP TABLE IF EXISTS TRANSACTION CASCADE
;

/* Create Tables */
CREATE TABLE ACCOUNT
(
    ID SERIAL,
    client_id_number varchar(50) NULL,
    password varchar(10) NULL,
    account_number varchar(20) NULL,
    account_type varchar(20) NULL,
    initial_balance double precision NULL,
    status bool NOT NULL,
    AUD_CREATED_AT timestamp without time zone NOT NULL,
    AUD_UPDATED_AT timestamp without time zone NULL
)
;

CREATE TABLE TRANSACTION
(
    ID SERIAL,
    client_id_number varchar(50) NULL,
    transaction_date timestamp without time zone NOT NULL,
    transaction_type varchar(20) NULL,
    value double precision NULL,
    balance double precision NULL,
    account_Id bigint NOT NULL,
    AUD_CREATED_AT timestamp without time zone NOT NULL,
    AUD_UPDATED_AT timestamp without time zone NULL
)
;

/* Create Primary Keys, Indexes, Uniques, Checks */

ALTER TABLE ACCOUNT ADD CONSTRAINT PK_ACCOUNT
	PRIMARY KEY (ID)
;

ALTER TABLE TRANSACTION ADD CONSTRAINT PK_TRANSACTION
	PRIMARY KEY (ID)
;

CREATE INDEX IXFK_ACCOUNT ON TRANSACTION (account_Id ASC)
;


/* Create Foreign Key Constraints */

ALTER TABLE TRANSACTION ADD CONSTRAINT FK_TRANSACTION_ID
	FOREIGN KEY (account_Id) REFERENCES ACCOUNT (ID)
;


COMMENT ON TABLE TRANSACTION
	IS 'TRANSACTION Table id and password must not be null'
;

COMMENT ON TABLE ACCOUNT
	IS 'ACCOUNT Table'
;
