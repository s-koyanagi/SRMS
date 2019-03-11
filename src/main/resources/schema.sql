CREATE TABLE IF NOT EXISTS users(
    id varchar(255) NOT NULL,
    name TEXT NOT NULL,
    password TEXT NOT NULL,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP ,
    deleted_at TIMESTAMP ,
    PRIMARY KEY(id)
);
CREATE TABLE IF NOT EXISTS seminars(
    seminar_id identity NOT NULL,
    title TEXT NOT NULL,
    overview TEXT NOT NULL,
    started_at TIMESTAMP NOT NULL,
    closed_at TIMESTAMP NOT NULL,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP ,
    deleted_at TIMESTAMP ,
    PRIMARY KEY(seminar_id)
);
CREATE TABLE IF NOT EXISTS applicants(
    applicant_id identity NOT NULL,
    seminar_id integer NOT NULL,
    name TEXT NOT NULL,
    mail_address TEXT NOT NULL,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP ,
    deleted_at TIMESTAMP ,
    PRIMARY KEY(applicant_id)
);
CREATE TABLE IF NOT EXISTS speakers(
    speaker_id identity NOT NULL,
    seminar_id integer NOT NULL,
    name TEXT NOT NULL,
    theme TEXT NOT NULL,
    started_at TIME NOT NULL,
    closed_at TIME NOT NULL,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP ,
    deleted_at TIMESTAMP ,
    PRIMARY KEY(speaker_id)
);