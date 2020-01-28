DROP TABLE revenue IF EXISTS;
DROP TABLE revenue_time IF EXISTS;
DROP TABLE revenue_year IF EXISTS;

-- allow more dimensions, real DWH
CREATE TABLE revenue (
  id             INTEGER IDENTITY PRIMARY KEY,
  source_id      INTEGER,
  owner_city     VARCHAR(80),
  pet_type_name  VARCHAR(80),
  pet_birth_date DATE,
  visit_date     DATE,
  value          INTEGER NOT NULL
);
CREATE INDEX revenue_pet_name_idx ON revenue (pet_type_name);
CREATE INDEX revenue_date_idx ON revenue (visit_date);

-- allow for different date roll-ups in future
CREATE TABLE revenue_time (
  id             INTEGER IDENTITY PRIMARY KEY,
  source_id      INTEGER,
  visit_date     DATE,
  value          INTEGER NOT NULL
);
CREATE INDEX revenue_time_date_idx ON revenue_time (visit_date);

-- minimum for requirements
CREATE TABLE revenue_year (
  year     INTEGER IDENTITY PRIMARY KEY,
  revenue  INTEGER NOT NULL
);
