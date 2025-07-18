-- Drop tables if they already exist (respecting FK constraints)
DROP TABLE IF EXISTS all_rounders, batsmen, bowlers, teams,purchases CASCADE;

-- Create teams table
CREATE TABLE teams (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    balance NUMERIC(15, 2)
);

-- Create all_rounders table
CREATE TABLE all_rounders (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255),
    association VARCHAR(255),
    price NUMERIC(15, 2),
    image_links TEXT,
    status VARCHAR(20),
    sold_price NUMERIC(15, 2),
    team_id INTEGER REFERENCES teams(id),
    runs INTEGER,
    wickets INTEGER,
    economy NUMERIC(6, 2),
    matches INTEGER,
    strike_rate NUMERIC(6, 2)
);

-- Create batsmen table
CREATE TABLE batsmen (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255),
    association VARCHAR(255),
    price NUMERIC(15, 2),
    image_links TEXT,
    status VARCHAR(20),
    sold_price NUMERIC(15, 2),
    team_id INTEGER REFERENCES teams(id),
    runs INTEGER,
    matches INTEGER,
    batting_avg NUMERIC(6, 2),
    strike_rate NUMERIC(6, 2)
);

-- Create bowlers table
CREATE TABLE bowlers (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255),
    association VARCHAR(255),
    price NUMERIC(15, 2),
    image_links TEXT,
    status VARCHAR(20),
    sold_price NUMERIC(15, 2),
    team_id INTEGER REFERENCES teams(id),
    wickets INTEGER,
    matches INTEGER,
    economy NUMERIC(6, 2),
    best_figure VARCHAR(50)
);
CREATE TABLE purchases (
    id SERIAL PRIMARY KEY,
    team_id INTEGER NOT NULL,
    player_id INTEGER NOT NULL,
    sold_price NUMERIC(15, 2),
    player_type VARCHAR(50)
);
