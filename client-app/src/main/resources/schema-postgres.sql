DROP SCHEMA IF EXISTS test CASCADE;

CREATE SCHEMA test;

drop table if exists test.city;

create table test.city (name varchar, state varchar, country varchar);