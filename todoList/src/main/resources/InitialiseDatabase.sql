CREATE TABLE IF NOT EXIST List (
	ID serial primary key,
	NAME text
);

CREATE TABLE IF NOT EXIST Task (
	ID serial primary key,
	LIST integer,
	NAME text,
	DESCRIPTION text,
	CREATION_DATE date,
	CONSTRAINT fk_List FOREIGN KEY LIST REFERENCES List(ID) ON DELETE CASADE
)