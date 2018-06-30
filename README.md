`
docker run --name jee-mysql -p 3306:3306 -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE_NAME=java mysql:5.6
`

```
create table type
(
  id   int          not null
    primary key,
  name varchar(255) null
);

create table user
(
  id       int auto_increment
    primary key,
  username varchar(255)        null,
  password varchar(255)        null,
  email    varchar(255)        null,
  verified tinyint default '0' null,
  type_id  int                 null,
  constraint user_type_id_fk
  foreign key (type_id) references type (id)
);

create table url
(
  id           int                                     not null
    primary key,
  url_long     varchar(255)                            null,
  url_short    varchar(255)                            null,
  user_id      int                                     null,
  available_at timestamp default CURRENT_TIMESTAMP     not null
  on update CURRENT_TIMESTAMP,
  expired_at   timestamp default '0000-00-00 00:00:00' not null,
  constraint url_user_id_fk
  foreign key (user_id) references user (id)
);

create table history
(
  id            int                                 not null
    primary key,
  url_id        int                                 null,
  downloaded_at timestamp default CURRENT_TIMESTAMP not null
  on update CURRENT_TIMESTAMP,
  ip_address    varchar(255)                        null,
  country       varchar(255)                        null,
  constraint history_url_id_fk
  foreign key (url_id) references url (id)
);

create index history_url_id_fk
  on history (url_id);

create table password
(
  id       int          not null
    primary key,
  url_id   int          null,
  password varchar(255) null,
  constraint password_url_id_fk
  foreign key (url_id) references url (id)
);

create index password_url_id_fk
  on password (url_id);

create index url_user_id_fk
  on url (user_id);

create index user_type_id_fk
  on user (type_id);
```