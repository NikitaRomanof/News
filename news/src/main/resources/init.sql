 drop table if exists news CASCADE;

 create table if not exists news
 (
    id serial primary key,
 	title varchar not null,
 	dt date not null,
 	body varchar not null,
 	image bytea
 );