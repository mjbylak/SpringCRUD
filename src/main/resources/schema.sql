create table faction (
    faction_id  int NOT NULL,
    title       varchar(80) NOT NULL, --Faction Title
    description varchar(500) NOT NULL, --Faction Description
    units       varchar(500) NOT NULL, --Faction units
    constraint faction_pk_faction_id primary key (faction_id)
);

