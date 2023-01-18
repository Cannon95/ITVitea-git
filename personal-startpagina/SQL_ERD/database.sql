DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS tasks;
DROP TABLE IF EXISTS websites;

CREATE TABLE users (
	userid INTEGER NOT NULL
	name VARCHAR NOT NULL,
	email VARCHAR NOT NULL,
	password VARCHAR NOT NULL,
	avatar BLOB,
	PRIMARY KEY(userid),
	UNIQUE (name),
	UNIQUE (email)
);

CREATE TABLE tasks (
	taskno INTEGER NOT NULL,
	userid INTEGER NOT NULL,
	name VARCHAR NOT NULL,
	category VARCHAR NOT NULL,
	description VARCHAR,
	deadline_date DATE,
	deadline_time TIME,
	status VARCHAR NOT NULL,
	PRIMARY KEY(taskno),
	FOREIGN KEY (userid) REFERENCES users(userid)
);

CREATE TABLE websites (
	websiteno INTEGER NOT NULL,
	userid INTEGER NOT NULL,
	name VARCHAR NOT NULL,
	url VARCHAR NOT NULL,
	description VARCHAR,
	clicks INTEGER NOT NULL DEFAULT 0,
	icon BLOB,
	PRIMARY KEY(websiteno),
	FOREIGN KEY (userid) REFERENCES users(userid)
);

