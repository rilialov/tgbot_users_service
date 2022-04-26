DROP TABLE IF EXISTS tgbot.teams;
CREATE TABLE IF NOT EXISTS tgbot.teams (
    id				bigserial NOT NULL PRIMARY KEY,
    team_name 		varchar(100) NOT NULL UNIQUE,
    color 			varchar(100) NOT NULL UNIQUE
);

DROP TABLE IF EXISTS tgbot.users;
CREATE TABLE IF NOT EXISTS tgbot.users (
    chat_id			bigserial NOT NULL PRIMARY KEY,
    nickname 		varchar(100) NOT NULL UNIQUE,
    first_name 		varchar(100) NOT NULL,
    last_name		varchar(100) NOT NULL,
    team			bigint NOT NULL,
    "role" 			varchar(100) NOT NULL,
    FOREIGN KEY (team) REFERENCES tgbot.teams(id)
);