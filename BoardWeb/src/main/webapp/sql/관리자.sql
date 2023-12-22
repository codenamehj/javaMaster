CREATE USER dev IDENTIFIED BY dev

DEFAULT TABLESPACE users;

GRANT connect, resource to dev;

create user dev identified by dev;

grant connect, resource to dev;

grant create session to dev;