# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table complex (
  key                       bigint not null,
  string_field              varchar(255),
  long_string_field         varchar(256),
  integer_field             integer,
  double_field              double,
  boolean_field             boolean,
  date_field                timestamp,
  constraint pk_complex primary key (key))
;

create table member (
  key                       bigint not null,
  name                      varchar(255),
  initials                  varchar(255),
  constraint pk_member primary key (key))
;

create sequence complex_seq;

create sequence member_seq;




# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists complex;

drop table if exists member;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists complex_seq;

drop sequence if exists member_seq;

