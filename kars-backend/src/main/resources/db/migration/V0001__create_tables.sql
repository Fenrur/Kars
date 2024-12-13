CREATE TYPE gender AS ENUM ('male', 'female');

CREATE TYPE party_event_type AS ENUM ('public', 'private');

CREATE TABLE city
(
    city_id         SERIAL,
    department      VARCHAR(3)   DEFAULT NULL,
    slug            VARCHAR(255) DEFAULT NULL UNIQUE,
    name            VARCHAR(45)  DEFAULT NULL,
    simple_name     VARCHAR(45)  DEFAULT NULL,
    official_name   VARCHAR(45)  DEFAULT NULL,
    soundex_name    VARCHAR(20)  DEFAULT NULL,
    metaphone_name  VARCHAR(22)  DEFAULT NULL,
    postal_code     VARCHAR(255) DEFAULT NULL,
    commune         VARCHAR(3)   DEFAULT NULL,
    commune_code    VARCHAR(5) NOT NULL UNIQUE,
    arrondissement  SMALLINT     DEFAULT NULL,
    canton          VARCHAR(4)   DEFAULT NULL,
    amdi            INTEGER      DEFAULT NULL,
    population_2010 INTEGER      DEFAULT NULL,
    population_1999 INTEGER      DEFAULT NULL,
    population_2012 INTEGER      DEFAULT NULL,
    density_2010    INTEGER      DEFAULT NULL,
    area            REAL         DEFAULT NULL,
    longitude_deg   REAL         DEFAULT NULL,
    latitude_deg    REAL         DEFAULT NULL,
    longitude_grd   VARCHAR(9)   DEFAULT NULL,
    latitude_grd    VARCHAR(8)   DEFAULT NULL,
    longitude_dms   VARCHAR(9)   DEFAULT NULL,
    latitude_dms    VARCHAR(8)   DEFAULT NULL,
    min_altitude    INTEGER      DEFAULT NULL,
    max_altitude    INTEGER      DEFAULT NULL,
    PRIMARY KEY (city_id),
    UNIQUE (slug)
);

CREATE TABLE party_subtype
(
    party_subtype_id SERIAL,
    name             VARCHAR(250) NOT NULL,
    type             VARCHAR(50)  NOT NULL,
    PRIMARY KEY (party_subtype_id)
);

CREATE TABLE profile
(
    profile_id SERIAL,
    born_at    DATE    NOT NULL,
    gender     gender  NOT NULL,
    user_id    uuid    NOT NULL,
    city_id    INTEGER NOT NULL,
    PRIMARY KEY (profile_id),
    UNIQUE (user_id),
    FOREIGN KEY (city_id) REFERENCES city (city_id)
);

CREATE TABLE party
(
    party_id         SERIAL,
    type             VARCHAR(50)                    NOT NULL,
    price            DOUBLE PRECISION,
    name             VARCHAR(250)                   NOT NULL,
    start_at         TIMESTAMP(3) WITHOUT TIME ZONE NOT NULL,
    end_at           TIMESTAMP(3) WITHOUT TIME ZONE,
    maximum_place    INTEGER                        NOT NULL,
    city_id          INTEGER                        NOT NULL,
    owner_profile_id INTEGER                        NOT NULL,
    description      VARCHAR(1000),
    party_event_type party_event_type               NOT NULL,
    PRIMARY KEY (party_id),
    FOREIGN KEY (city_id) REFERENCES city (city_id),
    FOREIGN KEY (owner_profile_id) REFERENCES profile (profile_id)
);

CREATE TABLE party_subtype_list
(
    id               SERIAL,
    party_subtype_id INTEGER NOT NULL,
    party_id         INTEGER NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (party_subtype_id) REFERENCES party_subtype (party_subtype_id),
    FOREIGN KEY (party_id) REFERENCES party (party_id)
);

CREATE TABLE profile_evaluate_party
(
    evaluated_profile_id INTEGER,
    evaluator_profile_id INTEGER,
    party_id             INTEGER,
    rate                 SMALLINT NOT NULL,
    comment              VARCHAR(1000),
    PRIMARY KEY (evaluated_profile_id, evaluator_profile_id, party_id),
    FOREIGN KEY (evaluated_profile_id) REFERENCES profile (profile_id),
    FOREIGN KEY (evaluator_profile_id) REFERENCES profile (profile_id),
    FOREIGN KEY (party_id) REFERENCES party (party_id)
);

CREATE TABLE attend_party
(
    attend_profile_id INTEGER,
    party_id          INTEGER,
    PRIMARY KEY (attend_profile_id, party_id),
    FOREIGN KEY (attend_profile_id) REFERENCES profile (profile_id),
    FOREIGN KEY (party_id) REFERENCES party (party_id)
);

CREATE TABLE request_party
(
    profile_id INTEGER,
    party_id   INTEGER,
    comment    VARCHAR(250),
    request_at TIMESTAMP(3) WITHOUT TIME ZONE NOT NULL,
    PRIMARY KEY (profile_id, party_id),
    FOREIGN KEY (profile_id) REFERENCES profile (profile_id),
    FOREIGN KEY (party_id) REFERENCES party (party_id)
);

CREATE TABLE invitation_party
(
    invited_profile_id INTEGER,
    party_id           INTEGER,
    comment            VARCHAR(250),
    invitation_at      TIMESTAMP(3) WITHOUT TIME ZONE NOT NULL,
    PRIMARY KEY (invited_profile_id, party_id),
    FOREIGN KEY (invited_profile_id) REFERENCES profile (profile_id),
    FOREIGN KEY (party_id) REFERENCES party (party_id)
);