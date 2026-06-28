-- V1__create_games_table.sql

CREATE TABLE games(
  id BIGSERIAL PRIMARY KEY,
  white_player VARCHAR(255) NOT NULL,
  black_player VARCHAR(255) NOT NULL,
  result VARCHAR(20) NOT NULL CHECK(result IN ('1-0','0-1','1/2-1/2', '*')),
  event_name VARCHAR(255),
  site VARCHAR(255),
  game_date DATE,
  eco_code VARCHAR(10),
  pgn TEXT NOT NULL,
  user_id BIGINT, -- FK to users table (and later when auth is needed)
  created_at TIMESTAMP NOT NULL DEFAULT NOW(),
  updated_at TIMESTAMP NOT NULL DEFAULT NOW()
  );
