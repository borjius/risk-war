CREATE ROLE risk_admin LOGIN NOSUPERUSER INHERIT CREATEDB NOCREATEROLE NOREPLICATION;
DROP DATABASE IF EXISTS risk;
CREATE DATABASE risk WITH OWNER = risk_admin;
\connect risk;
CREATE SCHEMA risk_data AUTHORIZATION risk_admin;
CREATE TABLE risk_data."user"
(
  username text NOT NULL,
  password text NOT NULL,
  email text NOT NULL,
  CONSTRAINT user_pkey PRIMARY KEY (username)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE risk_data."user"
  OWNER TO risk_admin;
