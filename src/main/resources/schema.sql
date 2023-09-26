create table faction (
    faction_id  integer AUTO_INCREMENT NOT NULL,
    title       varchar(80) NOT NULL, --Faction Title
    description varchar(500) NOT NULL, --Faction Description
    units       varchar(500) NOT NULL, --Faction units
    constraint pk_faction_faction_id primary key (faction_id)
);

