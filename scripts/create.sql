DROP DATABASE EMDSdb

CREATE DATABASE EMDSdb
	WITH OWNER=postgres ENCODING='UTF-8'

CREATE TABLE "public"."person"  ( 
	"id"  	SERIAL,
	"name"	varchar(25) NULL,
	"age" 	int NULL,
	PRIMARY KEY("id")
) 
