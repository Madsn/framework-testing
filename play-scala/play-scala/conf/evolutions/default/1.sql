# --- Created by Slick DDL
# To stop Slick DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table "MEMBER" ("name" VARCHAR NOT NULL PRIMARY KEY,"initials" VARCHAR NOT NULL);

# --- !Downs

drop table "MEMBER";

