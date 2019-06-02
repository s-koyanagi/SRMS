CREATE TABLE IF NOT EXISTS users(
    esq_id varchar(6) NOT NULL,
    name TEXT NOT NULL,
    password TEXT NOT NULL,
    role TEXT NOT NULL,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP ,
    deleted_at TIMESTAMP ,
    PRIMARY KEY(esq_id)
);
CREATE TABLE IF NOT EXISTS seminars(
    seminar_id identity NOT NULL,
    title TEXT NOT NULL,
    overview TEXT NOT NULL,
    started_at TIMESTAMP NOT NULL,
    closed_at TIMESTAMP NOT NULL,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP,
    deleted_at TIMESTAMP,
    accepting_flag integer NOT NULL,
    version integer NOT NULL,
    PRIMARY KEY(seminar_id)
);
CREATE TABLE IF NOT EXISTS guests(
    guest_id identity NOT NULL,
    seminar_id integer NOT NULL REFERENCES seminars (seminar_id),
    esq_id varchar(6) NOT NULL REFERENCES users (esq_id),
    prior_question Text ,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP,
    deleted_at TIMESTAMP,
    PRIMARY KEY(guest_id)
);
CREATE TABLE IF NOT EXISTS speakers(
    speaker_id identity NOT NULL,
    seminar_id integer NOT NULL REFERENCES seminars (seminar_id),
    name TEXT NOT NULL,
    theme TEXT NOT NULL,
    started_at TIME NOT NULL,
    closed_at TIME NOT NULL,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP,
    deleted_at TIMESTAMP,
    PRIMARY KEY(speaker_id)
);