DROP TABLE IF EXISTS "team_purchases";

create table team_purchases(
        p_id Integer PRIMARY KEY,
        p_name varchar(60),
        team_id integer,
        team_name varchar(60)
        );