-- DROP SCHEMA skilltracker;

CREATE SCHEMA skilltracker AUTHORIZATION postgres;

-- skilltracker."user" definition

-- Drop table

-- DROP TABLE skilltracker."user";

CREATE TABLE skilltracker."user" (
	id int4 NOT NULL,
	"name" bpchar(30) NOT NULL,
	associate_id varchar(50) NOT NULL,
	email varchar(50) NOT NULL,
	mobile varchar(10) NOT NULL,
	create_ts timestamptz NOT NULL,
	update_ts timestamptz NULL,
	CONSTRAINT user_pkey PRIMARY KEY (id)
);

-- skilltracker.skill definition

-- Drop table

-- DROP TABLE skilltracker.skill;

CREATE TABLE skilltracker.skill (
	id int4 NOT NULL,
	skill_name varchar(50) NOT NULL,
	skill_type bpchar(1) NOT NULL,
	expertise_level int4 NOT NULL,
	user_id int4 NOT NULL,
	CONSTRAINT userskill_pkey PRIMARY KEY (id)
);
CREATE INDEX fki_user_id ON skilltracker.skill USING btree (user_id);


-- skilltracker.skill foreign keys

ALTER TABLE skilltracker.skill ADD CONSTRAINT user_id FOREIGN KEY (user_id) REFERENCES skilltracker."user"(id);

CREATE TABLE skilltracker.user_info (
  user_info_id INT8 NOT null PRIMARY KEY,
  user_name VARCHAR(30) NOT NULL,
  password VARCHAR(500) NOT NULL,
  user_email varchar(150) not null,
  user_role varchar(25) NOT NULL DEFAULT 'FSE',
  token varchar(500) null,
  created_date TIMESTAMP not null default current_timestamp,
  updated_date TIMESTAMP NULL
  --CONSTRAINT "primary" PRIMARY KEY (user_info_id ASC)
)
CREATE SEQUENCE skilltracker.user_info_id_seq START 10000 INCREMENT 1;
CREATE SEQUENCE hibernate_sequence START 1;